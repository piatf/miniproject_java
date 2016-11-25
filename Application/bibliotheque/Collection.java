package bibliotheque;
/**
 * @author Adeline Leger
 */
import bibliotheque.Article;

import java.util.ArrayList;
import java.util.List;

//import Article;

public class Collection {
	
	/**
	 * A collection is composed by a list of article and the name of the collection
	 */
	public List<Article> articles;
	public String name;
	
	public Collection(List<Article> articles){
		//super();
		/** 
		 * Collection builder
		 */
		this.articles = articles;
	}
	public Collection(){
		this.articles=new ArrayList<Article>();
	}
	/**
	 * 	Writing Accessor
	 */
	public void setName(String name) {this.name = name;}
	
	/** 
	 * 	Reading Accessor
	 */
	public String getName(){return name;}
	
	public List<Article> getArticles(){return articles;}
	 /** 
	  * Research an article by it id
	  * @return type of int : the index on the Collection
	  */
	public int searchArticle(int id){
		int i = 0;
		while(articles.get(i).id != id || i<articles.size()){
			i=i++;
		}
		if (articles.get(i).id == id) return i;
		else return(-1);
	}

}
