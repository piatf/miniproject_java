package test1;

import test1.Article;

import java.util.ArrayList;
import java.util.List;

//import Article;

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
