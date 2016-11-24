package test1;



import test1.BibliographieSource;
import test1.Collection;
import test1.Article;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*; 

public class BibliographieReader implements XMLReader{
	private ContentHandler handler;
	private AttributesImpl atts = new AttributesImpl();
	
	//méthode qui vont être utilisées par le transformer
	public ContentHandler getContentHandler(){
		return handler;
	}
	
	public void setContentHandler(ContentHandler handler){
		this.handler = handler;
	}
	
	public void parse(InputSource input) throws IOException,SAXException{
		if(!(input instanceof BibliographieSource)){
			String m = "Le seul argument possible pour parse est une BibliographieSource";
			throw new SAXException(m);
		}
		if(handler == null){
			throw new SAXException("Pas de ContentHandler");
		}
		BibliographieSource source = (BibliographieSource)input;
		//Collection c = (Collection) ;
		List<Collection> collections = source.getCollections();
		
		handler.startDocument(); 
		handler.startElement("", "bibliography", "bibliography", atts);
		for(int i =0; i<collections.size(); i++){
			List<Article> articles = source.getArticles1(collections.get(i));
		
			atts.addAttribute("","name","name","",String.valueOf(collections.get(i).getName()));
			handler.startElement("", "collection", "collection", atts);
			atts.clear();
			for (int k=0;k < articles.size();k++){
				atts.addAttribute("","id","id","",String.valueOf(articles.get(k).getId()));
				handler.startElement("", "article", "article", atts);
				//System.out.println(articles.get(k).getId());
				atts.clear();
				
				handler.startElement("", "author", "author", atts);
				char[] author = articles.get(k).getAuthor().toCharArray();
				handler.characters(author,0,author.length);
				handler.endElement("", "author", "author");
				
				handler.startElement("", "title", "title", atts);
				char[] title = articles.get(k).getTitle().toCharArray();
				handler.characters(title,0,title.length);
				handler.endElement("", "title", "title");
			
				handler.startElement("", "journal", "journal", atts);
				char[] journal = articles.get(k).getJournal().toCharArray();
				handler.characters(journal,0,journal.length);
				handler.endElement("", "journal", "journal");
				
				handler.startElement("", "year", "year", atts);
				char[] year = articles.get(k).getYear().toCharArray();
				handler.characters(year,0,year.length);
				handler.endElement("", "year", "year");
			
				handler.startElement("", "number", "number", atts);
				char[] number = articles.get(k).getNumber().toCharArray();
				handler.characters(number,0,number.length);
				handler.endElement("", "number", "number");
			
				handler.startElement("", "pages", "pages", atts);
				char[] pages = articles.get(k).getPages().toCharArray();
				handler.characters(pages,0,pages.length);
				handler.endElement("", "pages", "pages");
			
				handler.startElement("", "month", "month", atts);
				char[] month = articles.get(k).getMonth().toCharArray();
				handler.characters(month,0,month.length);
				handler.endElement("", "month", "month");
			
				handler.startElement("", "doi", "doi", atts);
				char[] doi = articles.get(k).getDoi().toCharArray();
				handler.characters(doi,0,doi.length);
				handler.endElement("", "doi", "doi");
			
				handler.startElement("", "url", "url", atts);
				char[] url = articles.get(k).getUrl().toCharArray();
				handler.characters(url,0,url.length);
				handler.endElement("", "url", "url");
			
				handler.startElement("", "keywords", "keywords", atts);
				char[] keywords = articles.get(k).getKeywords().toCharArray();
				handler.characters(keywords,0,keywords.length);
				handler.endElement("", "keywords", "keywords");
			
				handler.startElement("", "abstracts", "abstracts", atts);
				char[] abstracts = articles.get(k).getAbstracts().toCharArray();
				handler.characters(abstracts,0,abstracts.length);
				handler.endElement("", "abstracts", "abstracts");
			
				handler.startElement("", "pdf", "pdf", atts);
				char[] pdf = articles.get(k).getPdf().toCharArray();
				handler.characters(pdf,0,pdf.length);
				handler.endElement("", "pdf", "pdf");
				
				char[] tag=null;
				int j=0;
				String[] tags=articles.get(k).getTag();
				for( j=0; j<tags.length; j++ ){
					handler.startElement("", "tag", "tag", atts);
					tag = tags[j].toCharArray();
					handler.characters(tag,0,tag.length);
					handler.endElement("", "tag", "tag");
				}
				handler.endElement("", "article", "article");
			}
			handler.endElement("", "collection", "collection");
		}
		handler.endElement("", "bibliographie", "bibliographie");
		handler.endDocument();
	}
	
	public void parse(String systemId) throws IOException,SAXException{
		String m = "Le seul argument possible pour parse est une BibliographieSource";
		throw new SAXException(m);
	}
	
	// autres méthodes à implémenter
	public DTDHandler getDTDHandler(){
		return null;
	}
	public EntityResolver getEntityResolver(){
		return null;
	}
	public ErrorHandler getErrorHandler(){
		return null;
	}
	public boolean getFeature(String name){
		return false;
	}
	public Object getProperty(String name){
		return null;
	}
	public void setDTDHandler(DTDHandler handler){
	}
	public void setEntityResolver(EntityResolver resolver){
	}
	public void setErrorHandler(ErrorHandler handler){
	}
	public void setFeature(String name, boolean value){
	}
	public void setProperty(String name, Object value){
	}
}