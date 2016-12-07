package bibliotheque;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * <b>Parser est la classe qui va s'occuper de traiter les fichiers BIBTEX pour en extraire les informations voulues.</b>
 * <p>
 * Un ficher BIBTEX contient les informations suivantes :
 * <ul>
 * <li>les auteurs.</li>
 * <li>Le titre.</li>
 * <li>Le journal.</li>
 * <li>l'ann\u00E9e.</li>
 * <li>Le volume.</li>
 * <li>Nombre.</li>
 * <li>les pages.</li>
 * <li>Mois.</li>
 * <li>URL.</li>
 * <li>mots cl\u00E9s.</li>
 * <li>R\u00E9sum\u00E9.</li>
 * </ul>
 * 
 * </p>
 * 
 *
 * @author hamza
 */



public class Parser {
	
                          String[] info = new String [12]; 

    
   
                          /**
                           * Constructeur parser.
                           * 
                           * @param path
                           * Un parametre qui contient le chemin vers le fichier BIBTEX  
                           * @throws FileNotFoundException  Si jamais y a un probl\u00E8me avec le path.
                           */
    public Parser( String path) throws FileNotFoundException{
    	
                 Scanner s = null;
             String delims = "[,{}=\\-\"]+";
           String[] tokens = new String [10000];

                      String author = new String (); 
                      String title = new String (); 
                      String journal = new String (); 
                      String year = new String (); 
                      String volume = new String (); 
                      String number = new String (); 
                      String pages = new String (); 
                      String month = new String (); 
                      String doi = new String (); 
                      String url = new String (); 
                      String keywords = new String (); 
                      String abstracts = new String (); 


                    
String cont = new String();
/**
 * Lecture du fichier BIBTEX.
 * On le met ensuite dans un une variable String.
 * On s\u00E9pare chaque deux mots avec une virgule
 * Car on va utiliser cette condition après dans le d\u00E9liminteur. 
 */
        try {
            s = new Scanner(new BufferedReader(new FileReader(path)));

            while (s.hasNext()) {
                //System.out.println(s.next());
                
                 String nextToken = s.next();
                 cont =cont +","+ nextToken;
          
}     
            /**
             * Utilisation du d\u00E9liminteur. 
             */
    tokens = cont.split(delims);
    
    /**
     * La boucle pour mettre chaque information(auteur,titre,..) dans sa place. 
     */
           for (int i = 0; i < tokens.length; i++){ 
               if (tokens[i].equals("author")){
                   
                   do{
                   i++;
                   author = author+" "+tokens[i];
                     //  System.out.println(author);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
                if (tokens[i].equals("title")){
                   
                   do{
                       i++;
                      title = title+" "+tokens[i];
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
                 if (tokens[i].equals("journal")){
                   
                   do{
                  i++;
                   journal = journal+" "+tokens[i];
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
                if (tokens[i].equals("year")){
                   
                   do{
                   i++;
                   year = year+" "+tokens[i];
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
                if (tokens[i].equals("volume")){
                   
                   do{
                   i++;
                                      volume = volume+" "+tokens[i];

                       //System.out.println(tokens[i]);
                   }while((!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("abstract"))));
                   }
               if (tokens[i].equals("number")){
                   
                   do{
                   i++;
                                      number = number+" "+tokens[i];
                     //  System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
               
                if (tokens[i].equals("pages")){
                   
                   do{
                   i++;
                                      pages = pages+" "+tokens[i]+"p";

                      // System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
                   
               
                if (tokens[i].equals("month")){
                   
                   do{
                   i++;
                                      month = month+" "+tokens[i];

                     //  System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
               if (tokens[i].equals("doi")){
                   
                   do{
                   i++;
                                      doi = doi+" "+tokens[i];

                   //    System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
               
                if (tokens[i].equals("url")){
                   
                   do{
                   i++;
                                      url = url+tokens[i];

                     //  System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("keywords")))&&(!(tokens[i+1].equals("abstract"))));
                   }
                if (tokens[i].equals("abstract")){
                   
                   do{
                   i++;
                                      abstracts = abstracts+" "+tokens[i];
   
                 //  System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("keywords"))));
                   }
                if (tokens[i].equals("keywords")){
                   
                   do{
                   i++;
                                      keywords = keywords+" "+tokens[i];

                     //  System.out.println(tokens[i]);
                   }while(((i+1)<tokens.length-1)&&(!(tokens[i+1].equals("author")))&&(!(tokens[i+1].equals("title")))&&(!(tokens[i+1].equals("journal")))&&(!(tokens[i+1].equals("year")))&&(!(tokens[i+1].equals("volume")))&&(!(tokens[i+1].equals("number")))&&(!(tokens[i+1].equals("pages")))&&(!(tokens[i+1].equals("month")))&&(!(tokens[i+1].equals("doi")))&&(!(tokens[i+1].equals("url")))&&(!(tokens[i+1].equals("abstract"))));
                   }
               
                /**
                 * Des lectures pour tester le bon fonctionnement du code.
                 */    
                   
                  /* if (nextToken.equalsIgnoreCase("title"))  
            {  s.useDelimiter("\\s*= \\s*");
                System.out.println(s.next());}  */

            }
                             
           // System.out.println(author);

           /**
            * Ce tableau info comme l'indique son nom contient les 12 informations essentielles
            * dont nous avons besoin.
            * à la fin de la boucle au-dessus, les infromations sont stock\u00E9es dans ce tableau.  
            */
info[0]=author;
                     info[1]= title ; 
                     info[2]= journal; 
                  info[3]=year ; 
                      info[4]= volume ; 
                     info[5]=number ; 
                      info[6]= pages ; 
                    info[7]= month; 
                      info[8]= doi; 
                    info[9]=url ; 
                    info[11]= keywords ; 
               info[10]=abstracts ; 
       
                                          //System.out.println(tokens.length);

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
    
    
    /**
     * Retourne le tableau info.
     * 
     * @return Retourne le tableau info.
     */
     public  String[] getinfo(){
        return info;
    }
    
     /**
      * Pour tester le fonctionnement de la classe.
      * Bien sur quand la classe a \u00E9t\u00E9 int\u00E9gr\u00E9 dans le projet avec la classe Bibliotheque
      * on avait plus besoin du main  
      * 
      *          
      * 
      */
    public static void main(String[] args) throws IOException {
         //   String path;
    //    path = "book\\BIBTeX (2).bib";
                 

         //    Parser parser = new Parser(path);



 
}
   
}
