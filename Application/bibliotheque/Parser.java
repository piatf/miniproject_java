package bibliotheque;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamza
 */
import java.io.*;
import java.util.Scanner;


public class Parser {
                          String[] info = new String [12]; 

    
   
    
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
        try {
            s = new Scanner(new BufferedReader(new FileReader(path)));

            while (s.hasNext()) {
                //System.out.println(s.next());
                //s.useDelimiter("\\s*,\\s*");
                 String nextToken = s.next();
                 cont =cont +","+ nextToken;
           /*        tokens = nextToken.split(delims);
           for (int i = 0; i < tokens.length; i++){ 
     System.out.println(tokens.length);      
              */
}     

    tokens = cont.split(delims);
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
               
                   
                   
                  /* if (nextToken.equalsIgnoreCase("title"))  
            {  s.useDelimiter("\\s*= \\s*");
                System.out.println(s.next());}  */

            }
                             
           // System.out.println(author);

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
    
     public  String[] getinfo(){
        return info;
    }
    
    public static void main(String[] args) throws IOException {
         //   String path;
          //   Bibliotheque bib = new Bibliotheque.jMenuItem2ActionPerformed();
    //    path = "book\\BIBTeX (2).bib";
      //String g = new String getinfo();
                 
      //path=getinfo();

         //    Parser parser = new Parser(path);



 
}
   
}
