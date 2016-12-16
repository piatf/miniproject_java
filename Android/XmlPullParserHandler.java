/**
 * @author Adeline Léger, François Piat
 *
 * this class allows to parse an XML file to extract data from it
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


public class XmlPullParserHandler {
    List<Collection> bibliography;
    private Collection c;
    private String text;
    private Article a;
    List<String>tags;

    public XmlPullParserHandler() {
        bibliography = new ArrayList<Collection>();
        tags = new ArrayList<String>();
    }

    public List<Collection> getBibliography() {
        return bibliography;
    }

    public List<Collection> parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("Collection")) {
                            // create a new instance of employee
                            c = new Collection();
                            c.setName(parser.getAttributeValue(null, "name"));
                        }
                        else if (tagname.equalsIgnoreCase("Article")) {
                            // create a new instance of employee
                            a = new Article();
                            a.setId(Integer.parseInt(parser.getAttributeValue(null, "id")));
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("Collection")) {
                            // add employee object to list
                            bibliography.add(c);
                        } else if (tagname.equalsIgnoreCase("Article")) {
                            a.setTags((String[]) tags.toArray(), a.getId());
                            c.articles.add(a);
                        } else if (tagname.equalsIgnoreCase("Author")) {

                            a.setAuthor(text);
                        } else if (tagname.equalsIgnoreCase("Title")) {
                            a.setTitle(text);
                        } else if (tagname.equalsIgnoreCase("Journal")) {
                            a.setJournal(text);
                        } else if (tagname.equalsIgnoreCase("Year")) {
                                a.setYear(text);
                        } else if (tagname.equalsIgnoreCase("Volume")) {
                            a.setVolume(text);
                        } else if (tagname.equalsIgnoreCase("Number")) {
                            a.setNumber(text);
                        } else if (tagname.equalsIgnoreCase("Pages")) {
                            a.setPages(text);
                        } else if (tagname.equalsIgnoreCase("Month")) {
                            a.setMonth(text);
                        } else if (tagname.equalsIgnoreCase("Doi")) {
                            a.setDoi(text);
                        } else if (tagname.equalsIgnoreCase("Url")) {
                            a.setUrl(text);
                        } else if (tagname.equalsIgnoreCase("Keywords")) {
                            a.setKeywords(text);
                        } else if (tagname.equalsIgnoreCase("Abstract")) {
                            a.setAbstracts(text);
                        } else if (tagname.equalsIgnoreCase("Tag")) {

                            tags.add(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bibliography;
    }
}