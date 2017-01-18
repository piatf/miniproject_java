/**
 * Created by Adeline Léger et François Piat on 07/12/2016.
 */
import java.util.ArrayList;
import java.util.List;


public class Collection {
    public List<Article> articles;
    public String name;

    public Collection(List<Article> articles){
        //super();
        this.articles = articles;
    }
    public Collection(){
        this.articles=new ArrayList<Article>();
    }
    public void setName(String name) {this.name = name;}

    public String getName(){return name;}

    public List<Article> getArticles(){return articles;}

}
