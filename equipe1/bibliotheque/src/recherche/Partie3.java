/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recherche;
import java.io.IOException;


/**
 *
 * @author Clément Niot
 */
public class Partie3 {
	
	/**Show 3 articles from one title and get number of citation from an author
	 * 
	 * @see 3 articles suggested from the one selected on the software and the number of citation
	 */
	public static void main(String[] args) throws IOException{
    	//Title of the article desired
    	String titreBase = new String("rabbits love to eat some carrots");
    	//Create a Requete class to access all functions needed
    	Requete myRequest = new Requete();
    	//3 strings array used to get each title and date of suggested articles
    	String afficheResult[]=new String[3];
    	//Get suggested articles
    	afficheResult=myRequest.finalResult(titreBase);
    	//Show these 3 articles
    	for(int i=0;i<3;i++){
        	System.out.println(afficheResult[i]);
    	}
    	//Get number of citation from the following author
    	String auteur = "Jennifer Lopez";
    	int nbCitation = myRequest.getNbCitation(auteur);
    	System.out.println("nb citations pour l'auteur " + auteur +" : " + nbCitation);
    }
}
