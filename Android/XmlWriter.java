import android.os.Environment;
import android.util.Log;
import android.util.Xml;

import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author Adeline Léger et François Piat
 *
 * This class allows to create an xml file and write in it the bibliography
 */

public class XmlWriter {

    void writer(InputSource input) throws XmlPullParserException {

        /**
         * @param : InputSource => Bibliographie
         * generate Xml file and complete it
         */
        Bibliographie b = (Bibliographie)input;
        List<Collection> collections = b.getCollections();
        File newxmlfile	=	new File(Environment.getExternalStorageDirectory()+"/bibliography.xml"); // Allocation Xml file
        FileOutputStream fileos	=	null;           //Initialisation output stream
        try{
            newxmlfile.createNewFile();             // Creation XML file
            fileos	=	new	FileOutputStream(newxmlfile); //Generation Output Stream
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
            XmlSerializer serializer = factory.newSerializer();     // Initialise Serialiser : allow to write on the XML file
            serializer.setOutput(fileos,	"UTF-8");

            // Write in XML file
            serializer.startTag(null, "Bibliography");          // Open tag Bibliography
            for (int i=0; i<collections.size(); i++){           // For each collection on the Bibliography
                serializer.startTag(null, "Collection");        // Open tag Collection
                serializer.attribute(null, "name",collections.get(i).getName()) ; // Attribute name of the collection
                List<Article> articles = collections.get(i).getArticles();
                for(int j=0; j<articles.size(); j++){           // For each article on a collection
                    serializer.startTag(null, "Article");
                    serializer.attribute(null, "id",String.valueOf(articles.get(j).getId())) ;
                    serializer.startTag(null, "Author");
                    serializer.text(articles.get(j).getAuthor());
                    serializer.endTag(null, "Author");
                    serializer.startTag(null, "Title");
                    serializer.text(articles.get(j).getTitle());
                    serializer.endTag(null, "Title");
                    serializer.startTag(null, "Journal");
                    serializer.text(articles.get(j).getJournal());
                    serializer.endTag(null, "Journal");
                    serializer.startTag(null, "Year");
                    serializer.text(articles.get(j).getYear());
                    serializer.endTag(null, "Year");
                    serializer.startTag(null, "Volume");
                    serializer.text(articles.get(j).getVolume());
                    serializer.endTag(null, "Volume");
                    serializer.startTag(null, "Number");
                    serializer.text(articles.get(j).getNumber());
                    serializer.endTag(null, "Number");
                    serializer.startTag(null, "Pages");
                    serializer.text(articles.get(j).getPages());
                    serializer.endTag(null, "Pages");
                    serializer.startTag(null, "Month");
                    serializer.text(articles.get(j).getMonth());
                    serializer.endTag(null, "Month");
                    serializer.startTag(null, "Doi");
                    serializer.text(articles.get(j).getDoi());
                    serializer.endTag(null, "Doi");
                    serializer.startTag(null, "Url");
                    serializer.text(articles.get(j).getUrl());
                    serializer.endTag(null, "Url");
                    serializer.startTag(null, "Keywords");
                    serializer.text(articles.get(j).getKeywords());
                    serializer.endTag(null, "Keywords");
                    serializer.startTag(null, "Abstract");
                    serializer.text(articles.get(j).getAbstracts());
                    serializer.endTag(null, "Abstract");
                    serializer.startTag(null, "Pdf");
                    serializer.text(articles.get(j).getPdf());
                    serializer.endTag(null, "Pdf");
                    String [] tags = articles.get(j).getTag();
                    for(int k=0; k<tags.length; k++){               // For all tags on an article
                        serializer.startTag(null, "Tag");
                        serializer.text(tags[k]);
                        serializer.endTag(null, "Tag");
                    }
                    serializer.endTag(null, "Article");             // Article end tag
                }
                serializer.endTag(null, "Collection");              // Collection end tag
            }
            serializer.endTag(null, "Bibliography");                // Bibliography end tag
            serializer.endDocument();                               // end of the document
            serializer.flush();
            fileos.close();                                         // close XML file
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("IOException",	"exception	in	createNewFile()	method");
        }
    }

}
