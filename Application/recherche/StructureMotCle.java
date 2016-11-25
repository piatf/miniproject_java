package recherche;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
*
* @author Jean Remy Da Costa
*/

public class StructureMotCle {
	//ArrayList of the forbidden words
	ArrayList<String> listeMotsInterdits  = new ArrayList<String>();
	//Array of string with the keywords of the article's title
	String[] ListeMotCle=null;

	int nbEspace = 0;
	int nbMotsCles = 0;
	
	/**
	 * Open file with forbidden words and put them in an ArrayList
	 * no parameters
	 */

	void ouvrirTxt(){
		
		try{
		//Open the file named 'MotsNonPertinents' where forbidden words are written	
		FileInputStream flux=new FileInputStream("MotsNonPertinents.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		//While the last line is not reach, the word is put in an ArrayList
		while ((ligne=buff.readLine())!=null){
			listeMotsInterdits.add(ligne);
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
	
	/**
	 * Cut the sentence and return the keywords in a string. Keywords are separate by ';'
	 * @param article's title
	 * @return sentence (string) without forbidden words, only keywords, separate by ';'
	 */
	String decouperTitre(String titre){
		String phrase = new String();
		//Force the title to be in lowercase (in case of a forbidden word is with a capital letter)
		titre = titre.toLowerCase();
		 //Split the article's title at each space
		 ListeMotCle = titre.split(" ");
		 //Browse the keyword list
			 for(int i = 0; i< ListeMotCle.length;i++){
				 for(int j=0; j<listeMotsInterdits.size();j++){
					 //If the keyword is a forbidden word, a space is put on the square of the array
					 if(ListeMotCle[i].compareTo(listeMotsInterdits.get(j))==0){
						 ListeMotCle[i]="";
						 //Count the number of space in the array
						 nbEspace++;
					 }
				 }	 
			 }
			 // "taille" is a variable with the value of the number of keywords
			 int taille = ListeMotCle.length - nbEspace;
			 //Initialize the number of space to 0
			 nbEspace = 0;
			 //Array (string) of keywords with the right size
			 String ListeMotCleOK[]=new String[taille];
			 for(int i = 0; i< ListeMotCle.length;i++){
				 //If the array of keywords is not a space, the keyword is put in the new array(string)
					if(ListeMotCle[i] != ""){
						 ListeMotCleOK[nbMotsCles] = ListeMotCle[i];
						 //Count the number of keywords
						 nbMotsCles++;
					 }
			 }
			 //Put the keywords in a string, separate by ';'
			 for(int i = 0; i < nbMotsCles; i++){
				 phrase = phrase + ListeMotCleOK[i] + ";";
			}
			 //Initialize the number of keywords to 0
			 nbMotsCles = 0;
			 //Return the string with the keywords separate by ';'
			 return phrase;
	}
	
 	
	/**
	 * Return an Array with one keyword in each square.
	 * @param String with keywords separate by ';'
	 * @return Array of string with keywords
	 */
	String[] separationString(String listeMC)
	 {
		//Put each keyword in a square of the Array(string), the keywords are separate by ';'
		String[] result = listeMC.split(";");
		//Return the array with keywords
		return result;
	 }

	/**
	 * Return an ArrayList with keys words.
	 * @param String with keys words separate by ';'
	 * @return ArrayList of string with keywords
	 */
	ArrayList<String> separationListe(String listeMC)
	{
		//Put each keyword in a square of the Array, the keys words are separate by ';'
		String[] tab = listeMC.split(";");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(tab));
		//Return the ArrayList with keywords
		return list;
	}
}
