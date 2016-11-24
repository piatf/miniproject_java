package test1;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import java.util.*; 

import test1.Collection;
import test1.Article;

public class BibliographieSource extends InputSource{
	private List<Collection> collections;
	
	public BibliographieSource(List<Collection> collections){
		super();
		this.collections = collections;	
	}
	
	public List<Article> getArticles1(Collection c){
		return c.getArticles();
	}
	public List<Collection> getCollections(){
		return collections;	
	}
}
