package bibliotheque;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

//initialisation done during the XML file parsing 
//(get all the tags related to each book/article)

public class tags{ 
	
	
	Hashtable<Integer, ArrayList<String>> tags; 
	
	tags() //constructor of tag list
	{
		tags = new Hashtable<Integer, ArrayList<String>>(); 
	}
	
	void addTag(String t, int id)
	{
		tags.get(id).add(t);
		// TODO: add the input in the XML file
	}
	
	void clear(int id)
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

	int[] Booksearch(String search)
	{
		int[] books_affected;
		int id, i = 0;
	    Set<Integer> IDs = tags.keySet();
	    //Obtaining iterator over set entries
	    Iterator<Integer> itr = IDs.iterator();
	    //Displaying Key and value pairs
	    while (itr.hasNext()) 
	    {
	       id = itr.next();
	       if(tags.get(id).contains(search))
	       {
	    	   books_affected[i]=id;
	    	   i++;
	       }
	    } 
		return books_affected;
	}
}
