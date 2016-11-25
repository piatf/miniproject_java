package bibliotheque;
/**
 * @author Adeline Leger
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import bibliotheque.BibliographieSource;
import bibliotheque.BibliographieReader;
import bibliotheque.Collection;
public class MySaxHandler extends DefaultHandler {

   /**
    * An array which contains the current hierarchy of beacons
    * Allows to manage the imbricated beacons
    **/
	public List<Collection> bibliographie; 
	Collection c;
	Article a;
	List<String> tag;
	boolean bauthor = false, btitle = false, bjournal=false, byear=false, bvolume=false, bnumber=false, bpages=false,
			bmonth=false, bdoi=false, burl=false, bkeywords=false, babstracts=false, bpdf=false, btag=false;
	
   public void parse(InputStream input) throws
           ParserConfigurationException,
           SAXException,
           IOException{
        // creation du parser SAX
	   System.out.println("-------------Debut Parsing-----------");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        SAXParser parser = factory.newSAXParser();
        // lancement du parsing en precisant le flux et le "handler"
        // l'instance qui implemente les methodes appelees par le parser
        // dans notre cas: this
        parser.parse(input, this);
        System.out.println("-------------Fin Parsing-----------");
    }

   public void parse(String filename) throws
           FileNotFoundException,
           ParserConfigurationException,
           SAXException,
           IOException{
	   System.out.println("-------------Debut Parsing-----------");
        parse(new FileInputStream(filename));
        System.out.println("-------------Fin Parsing-----------");
    }

   public void startDocument() throws SAXException{
      // initialisation
	   bibliographie = new ArrayList<Collection>();
	   tag = new ArrayList<String>();
      System.out.println("------start document------");
   }

   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	   //System.out.println("start ele");
	   /**
	    * Check all start nodes on the XML file 
	    */
        if (localName.equals("bibliography")) {
        	
        }
        if (localName.equals("collection")) {
        	c = new Collection();
            c.setName(attributes.getValue("name"));
        }
        if (localName.equals("article")) {
        	a = new Article();
            // balise imbriquee: ajoute un niveau de profondeur
            a.setId(Integer.parseInt(attributes.getValue("id")));
        }
        if (localName.equals("author")) {
            // balise imbriquee: ajoute un niveau de profondeur
            bauthor = true;
        }
        if (localName.equals("title")) {
        	btitle = true;
        }
        if (localName.equals("journal")) {
        	bjournal = true;
        }
        if (localName.equals("year")) {
        	byear = true;
        }
        if (localName.equals("number")) {
            bnumber = true;
        }
        if (localName.equals("pages")) {
            bpages = true;
        }
        if (localName.equals("month")) {
        	bmonth = true;
        }
        if (localName.equals("doi")) {
        	bdoi = true;
        }
        if (localName.equals("url")) {
        	burl = true;
        }
        if (localName.equals("keywords")) {
            bkeywords = true;
        }
        if (localName.equals("abstracts")) {
        	babstracts = true;
        }
        if (localName.equals("pdf")) {
        	bpdf = true;
        }
        if (localName.equals("tag")) {
            btag = true;
        }    
   }
   
   public void characters(char ch[], int start, int length) throws SAXException {
/**+
 * Take the infonmation between beacons
 */
		if (bauthor) {
			a.setAuthor(new String(ch, start, length));
			bauthor = false;
		}
		if (btitle) {
			a.setTitle(new String(ch, start, length));
			btitle = false;
		}
		if (bjournal) {
			a.setJournal(new String(ch, start, length));
			bjournal = false;
		}
		if (byear) {
			a.setYear(new String(ch, start, length));
			byear = false;
		}
		if (bvolume) {
			a.setVolume(new String(ch, start, length));
			bvolume = false;
		}
		if (bnumber) {
			a.setNumber(new String(ch, start, length));
			bnumber = false;
		}
		if (bpages) {
			a.setPages(new String(ch, start, length));
			bpages = false;
		}
		if (bmonth) {
			a.setMonth(new String(ch, start, length));
			bmonth = false;
		}
		if (bdoi) {
			a.setDoi(new String(ch, start, length));
			bdoi = false;
		}
		if (burl) {
			a.setUrl(new String(ch, start, length));
			burl = false;
		}
		if (bkeywords) {
			a.setKeywords(new String(ch, start, length));
			bkeywords = false;
		}
		if (babstracts) {
			a.setAbstracts(new String(ch, start, length));
			babstracts = false;
		}
		if (bpdf) {
			a.setPdf(new String(ch, start, length));
			bpdf = false;
		}
		if (btag) {
			tag.add(new String(ch, start, length));
			btag = false;
		}
   }

   public void endElement(String uri, String localName, String qName) throws SAXException {
       if (localName.equals("collection")) {
    	   bibliographie.add(c); 
       }
       if (localName.equals("article")) {
    	   a.setTags((String[]) tag.toArray(), a.id);
    	   c.articles.add(a);
    	   tag = new ArrayList<String>();
       } 
   }
}
