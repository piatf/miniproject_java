package bibliotheque;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

//initialisation done outside this class

public class tags{ 
	
	Hashtable<Integer, ArrayList<String>> tags; 
	
	tags() //constructor of tag list
	{
		tags = new Hashtable<Integer, ArrayList<String>>(); 
	}
	
	private void addTag(String t, int id)
	{
		tags.get(id).add(t);
		// TODO: add the input in the XML file
	}
	
	private void clear(int id)
	{
		tags.get(id).clear();
		// TODO: remove the tags associated to the XML document
	}
	
	void refreshTags(String input, int id)
	{
		String[] alltags;
		
		alltags = input.split(";|\\s+"); //admits that tags is separated 
										//by either white spaces or ";"
		// split string input
		
		clear(id);
		// clear tags for the IDbook
		
		for (int i=0; i<alltags.length; i++)
			addTag(alltags[i],id);
		// for each : addtag
	}

	ArrayList<Integer> Booksearch(String search)
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
