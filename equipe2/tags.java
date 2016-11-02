package bibliotheque;
import java.util.Hashtable;

//initialisation done during the XML file parsing 
//(get all the tags related to each book/article)

public class tags{ 
	
	String tag;
	Hashtable<Integer, String> tags; 
	
	tags() //constructor of tag list
	{
		tags= new Hashtable<Integer, String>(); 
	}
	
	boolean exists(String search, int id) //get the tag specified in the book ID n°id
	{
		if(tags.contains(search))
			return true;
		else
			return false;
	}
	
	void addTag(String in, int id)
	{
		// TODO: add the input in the XML file
		tags.put(id, in);
	}
	
}
