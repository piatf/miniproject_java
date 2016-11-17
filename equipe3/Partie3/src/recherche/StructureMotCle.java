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
	
	ArrayList<String> listeMotsInterdits  = new ArrayList<String>();
	String[] ListeMotCle=null;
	int nbEspace = 0;
	int nbMotsCles = 0;
	
	
//Ouvre le fichier avec les mots interdits et les recupères dans un ArrayList
	void ouvrirTxt(){
		
		try{
		FileInputStream flux=new FileInputStream("MotsNonPertinents.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		while ((ligne=buff.readLine())!=null){
			listeMotsInterdits.add(ligne);
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	}
	
// Decoupe la phrase passe en paramètre
// Retourne un string avec les mots cles de cette phrase, les mots interdits sont enleves	
	String decouperTitre(String titre){
		String phrase = new String();
		  titre = titre.toLowerCase();
		  ListeMotCle = titre.split(" ");
			 for(int i = 0; i< ListeMotCle.length;i++){
				 for(int j=0; j<listeMotsInterdits.size();j++){
					 if(ListeMotCle[i].compareTo(listeMotsInterdits.get(j))==0){
						 ListeMotCle[i]="";
						 nbEspace++;
					 }
				 }	 
			 }
			 int taille = ListeMotCle.length - nbEspace;
			 nbEspace = 0;
			 String ListeMotCleOK[]=new String[taille];
			 for(int i = 0; i< ListeMotCle.length;i++){
					if(ListeMotCle[i] != ""){
						 ListeMotCleOK[nbMotsCles] = ListeMotCle[i];
						 nbMotsCles++;
					 }
			 }

			 for(int i = 0; i < nbMotsCles;i++){
				 //System.out.println("mot cle n° " + (i+1) + "=[" + ListeMotCleOK[i] + "]");
				 phrase = phrase + ListeMotCleOK[i] + ";";
			}
			 nbMotsCles = 0;
			 //System.out.println(phrase);
			 return phrase;
	}
	
 	
	
	String[] separationString(String listeMC)
	 {
		String[] result = listeMC.split(";");
		return result;
	 }


	ArrayList<String> separationListe(String listeMC)
	{
		String[] tab = listeMC.split(";");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(tab));
		return list;
	}
}
