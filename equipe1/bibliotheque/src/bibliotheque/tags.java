package bibliotheque;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

/** This class gathers all the data related to the tags of one article.
 * 
 *  Every identifier (ID) is generated in the main class for each article.
 *  It is stored in the XML file.
 *  
 *  The tags are stored in a Hashtable<Integer, ArrayList<String>>, where the key 
 *  is the ID of the article, and the value is a list of all tags.
 *  
 *  @author Francois PIAT 
 *  */

public class tags{ 
	
	private static Hashtable<Integer, ArrayList<String>> tags; 
	
	/**
	 * Constructor. It will be called during the initialisation, in the main class.
	 */
	tags() //constructor of tag list
	{
		tags = new Hashtable<Integer, ArrayList<String>>(); 
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
		tags.get(id).add(t);
		// TODO: add the input in the XML file
	}
	
	/**
	 * Clears every single tag associated to the   article.
	 * @param id
	 * 		ID of the article.
	 */
	public void clear(int id)
	{
		tags.get(id).clear();
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
	public ArrayList<Integer> Booksearch(String search)
	{
		ArrayList<Integer> books_affected;
		books_affected = new ArrayList<Integer>();
		int id;
	    Set<Integer> IDs = tags.keySet();
	    //Obtaining iterator over set entries
	    Iterator<Integer> itr = IDs.iterator();
	    //Displaying Key and value pairs
	    while (itr.hasNext()) 
	    {
	       id = itr.next();
	       if(tags.get(id).contains(search))
	    	   books_affected.add(id);
	    } 
		return books_affected;
	}
}
