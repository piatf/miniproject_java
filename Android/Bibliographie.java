/**
 * Created by Adeline Léger et François Piat on 07/12/2016.
 */

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;


public class Bibliographie extends InputSource {
    /**
     * Bibliography is a list of Collection
     */

    private List<Collection> collections;

    public Bibliographie(List<Collection> collections) {
        /** Bibliography builder*/
        super();
        this.collections = collections;
    }

    public List<Article> getArticles1(Collection c) {
        /**
         *  A reading accessor
         * @param c : a collection
         * @return a list of article
         */
        return c.getArticles();
    }

    public List<Collection> getCollections() {
        /** A reading accessor for the collection
         * @return a list of collections
         */
        return collections;
    }

    public void searchArticle(int id, int i, int j, Article a) {
        /**
         * Function which research an article on the bibliography.
         * @param id, the id of an article
         * @param i, j, the index on the list of collection and article
         * @param a, the article which is researched
         */
        i = 0;
        j = 0;
        while (collections.get(j).articles.get(i).getId() != id || i < collections.size()) {
            while (collections.get(j).articles.get(i).getId() != id || i < collections.get(j).articles.size()) {
                i = i++;
            }

            j = j++;
        }
        if (collections.get(j).articles.get(i).getId() == id) a = collections.get(j).articles.get(i);
        else i = -1;
    }

    public int searchCollection(String name) {
        /**
         * Function which research a collection on the bibliography.
         * @param name, the name of a collection
         * @return type int, index on the collection list
         */
        int i = 0;
        while (collections.get(i).name != name || i < collections.size()) {
            i = i++;
        }
        if (collections.get(i).name == name) return (i);
        else return (-1);
    }
}