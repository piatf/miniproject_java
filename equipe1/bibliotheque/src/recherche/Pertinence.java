package recherche;
import java.util.ArrayList;

/**
*
* @author Mark Rode
*/

	public class Pertinence {
		/**
    	 * Copare two ArrayList of keywords
    	 * @param Two ArrayList of keywords
    	 * @return Number of keywords in common
    	 */
		int compare(ArrayList<String> motclefs1, ArrayList<String> motclefs2)
		{
			// Returned variables : number of keywords in common
			int motClefCommuns = 0;
			// Browse the whole ArrayList of the first parameter
			for(int i=0; i<motclefs1.size(); i++)
			{
				// Browse the whole ArrayList of the second parameter
				for(int j=0; j<motclefs2.size(); j++)
				{
					// Compare two keywords without taking care of the Case
					int comp = motclefs1.get(i).compareToIgnoreCase(motclefs2.get(j));
					// If those words are similar increase the number of keywords in common
					if (comp == 0)
						motClefCommuns++;
				}
			}
			// return the number of keywords in common
			return motClefCommuns;
		}
		
		/**
    	 * Compare two ArrayList of keywords
    	 * @param ArrayList of the research's keywords and ArrayList of all suggestion's keywords (one square per suggestion)
    	 * @return The 3 indexes of suggestions with the most keywords in common with the research
    	 */
		int[] getIndicePertinent(ArrayList<String> motclefsPrincipale, ArrayList<String> ListChaineMotClefsSuggestions)
		{
			// Returned table of the 3 pertinent indexes
			int indice[]=new int[3];
			// Variable used to search the maximum of words in common
			int max[] = new int[3];
			// Initialization of the two variables
	    	for(int i=0;i<3;i++){
	    		indice[i]=0;
	    		max[i]=0;
	    	}

			// Table containing the number of keywords in common for each suggestions
			int tabCorelation [] = new int[ListChaineMotClefsSuggestions.size()];
			
			//Declaration of the KeyWord structure to use the splitting method
			StructureMotCle MotClef = new StructureMotCle();
			
			/* Search of the number of keyword in common for each suggestion */
			for (int i=0; i<ListChaineMotClefsSuggestions.size(); i++)
			{
				// Split the string into a list of keywords
				ArrayList<String> motClefTraite = MotClef.separationListe(ListChaineMotClefsSuggestions.get(i));
				// Use the compare method to have the number of keywords in common of the index i suggestion and the research
				tabCorelation[i]=this.compare(motclefsPrincipale, motClefTraite);
			}
			
			/* Search of the index of the 3 most similar suggestions */
			// First one
			for (int i=0; i<tabCorelation.length; i++)
	    	{
	    			// Search of the index of the suggestion with the most keywords in common
	    			if (max[0]<tabCorelation[i])
	    			{
	    				indice[0] = i ;
	    				max[0]=tabCorelation[i];
	    			}
	    	}
			//Second one
			for (int i=0; i<tabCorelation.length; i++)
	    	{
	    			// Search of the index of the suggestion with the most keywords lower than the first one
	    			if (max[1]<tabCorelation[i]&&tabCorelation[i]<max[0])
	    			{
	    				indice[1] = i ;
	    				max[1]=tabCorelation[i];
	    			}
	    	}
			//Third one
			for (int i=0; i<tabCorelation.length; i++)
	    	{
	    			// Search of the index of the suggestion with the most keywords lower than the second one (so also than the first one)
	    			if (max[2]<tabCorelation[i]&&tabCorelation[i]<max[1])
	    			{
	    				indice[2] = i ;
	    				max[2]=tabCorelation[i];
	    			}
	    	}
			// return the 3 index of the most pertinent suggestions in a table
	    	return indice;
		}
	}