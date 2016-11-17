package bibliotheque;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class title_id {
private static Hashtable<Integer, String> title_id; 
	
	/**
	 * Constructor. It will be called during the initialisation, in the main class.
	 */
	title_id() //constructor of tag list
	{
		title_id = new Hashtable<Integer, String>(); 
	}
	
	/**
	 * Associates the tag to the article.
	 * @param t 
	 * 		The input tag. Added to the list.
	 * @param id
	 * 		ID of the article.
	 */
	public static void addTag(String t, int id)
	{
		title_id.put(id, t);
		// TODO: add the input in the XML file
	}
	
	/**
	 * Clears every single tag associated to the   article.
	 * @param id
	 * 		ID of the article.
	 */
	public void clear(int id)
	{
		title_id.remove(id);
		// TODO: remove the tags associated to the XML document
	}
	
	/**
	 * Refreshes the list of tags associated to the   article.
	 * @param input
	 * 		Input raw string, which contains every tag, separated by white spaces or semi-colons.
	 * @param id
	 * 		ID of the article.
	 * @see tags#addTag(String, int)
	 * @see tags#clear(int)
	 * 
	 */
	public void refreshTags(String input, int id)
	{
		String[] alltags;
		
		// split string input
		alltags = input.split(";|\\s+"); //admits that tags is separated 
										 //by either white spaces or ";"
	
		// clear tags for the IDbook
		clear(id);
		
		// Adds each tag to the list
		for (int i=0; i<alltags.length; i++)
			addTag(alltags[i],id);
		
	}

	/**
	 * Research function using a tag.
	 * @param search
	 * 		Tag written in the research bar to get one (or more) specific article.
	 * @return A list of IDs referencing articles associated to the tag searched.
	 */
	public int Booksearch(String search)
	{
		int books_affected = 0;
		int id;
	    Set<Integer> IDs = title_id.keySet();
	    //Obtaining iterator over set entries
	    Iterator<Integer> itr = IDs.iterator();
	    //Displaying Key and value pairs
	    while (itr.hasNext()) 
	    {
	       id = itr.next();
	       if(title_id.get(id) == search)
	    	   books_affected = id;
	    } 
		return books_affected;
	}
}
