package recherche;

import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
*
* @author Clement Niot
*/
public class Requete {
		//Variables used to create the query URL
		String query=new String();
		//Number of article desired for each key words
		int nbResultat=0;
		//Contains all result from one request
		String resultat=new String();
		//List of title and date for each article from one request
		String[] ListeNomArticle=null;
		String[] ListeDate=null;
		//List of all final suggested articles get from the research (with all key words) : length=nbResutat*nbMotCles(for one title of article)
    	ArrayList<String> Articles = new ArrayList<String>();
    	ArrayList<String> Dates = new ArrayList<String>();
    	//Number of days reminding before the next authorization for requests
    	String jourLimite = new String();
    	/**
    	 * Open request needed to get information from the API
    	 * no parameters
    	 */
		void ouvertureAzure()
		{
			HttpClient httpclient = HttpClients.createDefault();
			try
	        {
	            URIBuilder builder = new URIBuilder("https://portal.azure.com/#create/Microsoft.CognitiveServices");
	            URI uri = builder.build();
	            HttpGet request = new HttpGet(uri);
	            StringEntity reqEntity = new StringEntity("{body}");
	        }
	        catch (Exception e)
	        {
	            //Show the error if there is one
	        	System.out.println(e.getMessage());
	        }
		}
		
		/**
    	 * Launch the research and get information from the API
    	 * no parameters
    	 */
		void getResultat(){
			//Call function needed to create a request
	    	this.ouvertureAzure();
			HttpClient httpclient = HttpClients.createDefault();
	        try
	        {
	            //Create URL to send request
	        	URIBuilder builder = new URIBuilder("https://api.cognitive.microsoft.com/bing/v5.0/news/search");
	            //Set parameters in the request
	            builder.setParameter("q", this.query);
	            builder.setParameter("count", String.valueOf(this.nbResultat));
	            builder.setParameter("offset", "0");
	            builder.setParameter("mkt", "en-us");
	            builder.setParameter("safeSearch", "Moderate");
	            //Add the subscription key needed to get answer
	            URI uri = builder.build();
	            HttpGet request = new HttpGet(uri);
	            request.setHeader("Ocp-Apim-Subscription-Key", "480e3c799b4942b387511f9f510e713c");


	            // Request body
	            StringEntity reqEntity = new StringEntity("{body}");

	            HttpResponse response = httpclient.execute(request);
	            HttpEntity entity = response.getEntity();
	            this.resultat=EntityUtils.toString(entity);
	            //Test if the subscription key is still working
	            if (this.resultat.toLowerCase().contains("Out of call volume quota".toLowerCase()))
	            {
	            	this.jourLimite = this.resultat.substring(this.resultat.indexOf("in ")+3,this.resultat.indexOf("in ")+5);
	            	this.resultat="Votre cle de souscription ne permet plus de requetes. Essayer de nouveau dans " + this.jourLimite + " jours.";
	            }
	            //use it for watch the answer from the API
	            /*if (entity != null) 
	            {
	                System.out.println(this.resultat);
	            }*/

	        }
	        catch (Exception e)
	        {
	            //show the error if there is one
	        	System.out.println(e.getMessage());
	        }
		}
		
		/**
		 * Get number of citation from an author
		 * @param author's name
		 * @return number of citation for the author 
		 */
		int getNbCitation(String auteur)
		{
			int nb=0;
			//Replace all capital letters by small letters
			auteur = auteur.toLowerCase();
			//Call function needed to create a request
			this.ouvertureAzure();
			HttpClient httpclient = HttpClients.createDefault();
			String reponse = new String();

	        try
	        {
	            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/academic/v1.0/evaluate");
	          //Set parameters in the request
	            builder.setParameter("expr", "Composite(AA.AuN='" + auteur + "')");
	            builder.setParameter("model", "latest");
	            builder.setParameter("count", "10");
	            builder.setParameter("offset", "0");
	            builder.setParameter("orderby", "");
	            //Get only number of citation for this author
	            builder.setParameter("attributes", "CC");
	          //Add the subscription key needed to get answer (not the same than the first one)
	            URI uri = builder.build();
	            HttpGet request = new HttpGet(uri);
	            request.setHeader("Ocp-Apim-Subscription-Key", "882b1425e9b740229e82628b08822c9a");


	            // Request body
	            StringEntity reqEntity = new StringEntity("{body}");

	            HttpResponse response = httpclient.execute(request);
	            HttpEntity entity = response.getEntity();
	            reponse = EntityUtils.toString(entity);
	            //Cut the response by the attribute we are looking for
	            String[] decoupe = null;
	            decoupe=reponse.split("CC");
	            //Get only the number of the citation
	            reponse=decoupe[1].substring(2, decoupe[1].indexOf('}'));

	          //use it for watch the answer from the API
	            /*if (entity != null) 
	            {
	                System.out.println(reponse);
	            }*/
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }      
	        try
	        {
	        	//convert string number into an integer
	        	nb = Integer.parseInt(reponse); 
	        }
	        catch(Exception e){
	        	System.out.println(e.getMessage());
	        }
			return nb;
		}
		
		
		/**
		 * Get title and date of each article of the answer from the API
		 * no parameters
		 */
		void getInfoArticle(){
			  //List of articles
			 String[] ListeArticle=null;
			 //used to split each article from the response
			 ListeArticle = this.resultat.split("datePublished");
			 this.ListeNomArticle = this.resultat.split("datePublished");
			 this.ListeDate = this.resultat.split("datePublished");
			 
			 for(int i = 0; i< ListeArticle.length-1;i++){
				   //Get each title of the article from the result 
				 this.ListeNomArticle[i]=ListeArticle[i].substring(ListeArticle[i].indexOf("name")+8, ListeArticle[i].indexOf("url")-4);
				 //Get each date of each previous article
				 if(ListeArticle[i].substring(4,5).compareTo("2")==0||ListeArticle[i].substring(4,5).compareTo("1")==0)
					 this.ListeDate[i]=ListeArticle[i].substring(4,14);
				 else
					 this.ListeDate[i]="Date not available";
				 //Use it for show the list of article and date associated with
				 //System.out.println("titre  " + (i+1) + "=[" + this.ListeNomArticle[i] + "  Date : " + ListeDate[i] +"]");
				  }
		 }
		/**List of all articles get from each key word
		 * 
		 * @param titreBase
		 * 		title of the article that we want suggestions from
		 */
		    void getEnsembleArticles(String titreBase){
		    	try
		    	{
		    		Requete myRequest = new Requete();
			    	StructureMotCle struct = new StructureMotCle();
			    	//Get forbidden word from the user list
			    	struct.ouvrirTxt();
					myRequest.nbResultat=3;
			    	String stringMotClePrincipale = new String();
			    	String[] ListeMotClePrincipale = null;
			    	stringMotClePrincipale=struct.decouperTitre(titreBase);
			    	ListeMotClePrincipale=struct.separationString(stringMotClePrincipale);
			    	for(int i=0;i<ListeMotClePrincipale.length;i++)
			    	{
			        	myRequest.query=ListeMotClePrincipale[i];
			        	//get response from the search API
			        	myRequest.getResultat();
			        	myRequest.getInfoArticle();
			        	for(int j=0;j<myRequest.nbResultat;j++)
			        	{
			        		//add articles and date suggested for each key words
			            	Articles.add(myRequest.ListeNomArticle[j]);
			            	Dates.add(myRequest.ListeDate[j]);
			        	}
			    	}
		    	}
		    	//In case of the subscription key is not up to date
		        catch(Exception e){
		        	this.jourLimite = this.resultat.substring(this.resultat.indexOf("in ")+3,this.resultat.indexOf("in ")+5);
	            	this.resultat="Votre cle de souscription ne permet plus de requetes. Essayer de nouveau dans " + this.jourLimite + " jours.";
		        	System.out.println(this.resultat);
		        }
	            	
		    }
		    /**
			 * Find the 3 most interesting articles from the previous list
			 * @param titreBase
			 * 		Title of the article that we want suggestions from
			 * @return A list of 3 articles with their dates that it is most interesting 
			 */
		public String[] finalResult(String titreBase)
		{
		    	try
		    	{
	            	//Array of 3 final suggested articles
					String result[]=new String[3];
					StructureMotCle struct = new StructureMotCle();
			    	Pertinence calcul = new Pertinence();
			    	Requete myRequest = new Requete();
			    	//Get all key words from the title in parameters
			    	String MotsClesDepart = struct.decouperTitre(titreBase);
			    	//Set all key words in a ArrayList
			    	ArrayList<String> ListeMotClesDepart = struct.separationListe(MotsClesDepart);
			    	//Get all articles from all key words
			    	myRequest.getEnsembleArticles(titreBase);
			    	ArrayList<String> ArticlesSuggeres = myRequest.Articles;
			    	ArrayList<String> DatesSuggeres = myRequest.Dates;
			    	ArrayList<String> MotsClesAssocies = new ArrayList<> ();
			    	//Create a list with all key words from all title of articles from the list of key word associated with the initial title
			    	for(int i=0;i<ArticlesSuggeres.size();i++)
			    	{
			    		MotsClesAssocies.add(struct.decouperTitre(ArticlesSuggeres.get(i)));
			    	}
			    	//Array of the 3 indices of most pertinent articles
			    	int indiceArticle[]=new int[3];
			    	//Get 3 indices 
			    	indiceArticle=calcul.getIndicePertinent(ListeMotClesDepart, MotsClesAssocies);
			    	//Get 3 most pertinent articles
			    	for(int i=0;i<3;i++){
			    		result[i]='"'+ArticlesSuggeres.get(indiceArticle[i])+'"' + "\tDate de publication : " + DatesSuggeres.get(indiceArticle[i]);
			    	}
			    	//return array of the 3 most pertinent articles 
			    	return result;
		    	}
		    	//In case of the subscription key is not up to date
		        catch(Exception e){
		        	String result[]=new String[1];
		        	result[0]=this.resultat;
	            	System.out.println(this.resultat);
	            	//return only a message with number of days the user have to wait before the next request
		        	return result;
		        }
		}
	}
