package bibliotheque;
/**
 * @author Adeline Leger
 */
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import bibliotheque.Collection;
import bibliotheque.MySaxHandler;
import bibliotheque.Article;

public class BibliographieSource extends InputSource{
	/**
	 * 	Bibliography is a list of Collection
	 */

	public List<Collection> collections;
	
	public BibliographieSource(List<Collection> collections){
		/** Bibliography builder*/
		super();
		this.collections = collections;	
	}
	
	public List<Article> getArticles1(Collection c){
		/**
		 *  A reading accessor
		 * @param c : a collection
		 * @return a list of article
		 */
		return c.getArticles();
	}
	public List<Collection> getCollections(){
		/** A reading accessor for the collection
		 * @return a list of collections
		 */
		return collections;	
	}
	
	public void searchArticle(int id, int i, int j, Article a){
		/**
		 * Function which research an article on the bibliography.
		 * @param id, the id of an article
		 * @param i, j, the index on the list of collection and article
		 * @param a, the article which is researched
		 */
		i = 0;
		j=0;
		while(collections.get(j).articles.get(i).id != id || i<collections.size()){
			while (collections.get(j).articles.get(i).id != id || i<collections.get(j).articles.size()){
				i = i++;
			}
				
			j = j++;
		}
		if (collections.get(j).articles.get(i).id == id) a = collections.get(j).articles.get(i);
		else i=-1;
	}
	
	public int searchCollection(String name){
		/**
		 * Function which research a collection on the bibliography.
		 * @param name, the name of a collection
		 * @return type int, index on the collection list
		 */
		 int i = 0;
		while(collections.get(i).name != name || i<collections.size()){
			i=i++;
		}
		if (collections.get(i).name == name) return(i);
		else return(-1);
	}
	
	public void XMLreader() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException{
		/**
		 * Parser XML
		 * 
		 */
			MySaxHandler handler = new MySaxHandler();
			 handler.parse("bibliographieSAX");
			 collections = handler.bibliographie;
			 System.out.println("-------------------------------------------------------" );
			 System.out.println("main" );
			 
		}
	
	public void XMLwriter() throws SAXException, IOException{
		try{
			/**
			 * Write on the XML file
			 */
			XMLReader bibliographieReader = new BibliographieReader();
            InputSource bibliographieSource = this; 
            Source source = new SAXSource(bibliographieReader, bibliographieSource);
    
            // Creation of XML file
            File file = new File("BibliographieSAX.xml");
            Result resultat = new StreamResult(file);
            
            //System.out.println("resultat " + resultat);
            // Configuration du transformer
            TransformerFactory fabrique = TransformerFactory.newInstance();
            Transformer transformer = fabrique.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            
            // Transformation
            transformer.transform(source, resultat);
            //System.out.println("bonkour3");
        }catch(Exception e){
        	e.printStackTrace();	
        }	
		
	}
	
}
