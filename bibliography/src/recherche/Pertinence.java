package recherche;
import java.util.ArrayList;

/**
*
* @author Mark Rode
*/

	public class Pertinence {
		// Compare de ArrayList de mots clefs
		int compare(ArrayList<String> motclefs1, ArrayList<String> motclefs2)
		{
			int motClefCommuns = 0;
			// Compare les mots clefs des listes un a un
			for(int i=0; i<motclefs1.size(); i++)
			{
				for(int j=0; j<motclefs2.size(); j++)
				{
					//Compare un mot a un autre sans tenir compte des Maj
					int comp = motclefs1.get(i).compareToIgnoreCase(motclefs2.get(j));
					//Si il y a correspondance, on incremente le nombre de mots clefs en communs
					if (comp == 0)
						motClefCommuns++;
				}
			}
			return motClefCommuns;
		}
		
		int[] getIndicePertinent(ArrayList<String> motclefsPrincipale, ArrayList<String> ListChaineMotClefsSuggestions)
		{
			int indice[]=new int[3];
			int max[] = new int[3];
	    	for(int i=0;i<3;i++){
	    		indice[i]=0;
	    		max[i]=0;
	    	}

			//tableau a la taille du nombre de suggestions
			int tabCorelation [] = new int[ListChaineMotClefsSuggestions.size()];
			
			
			//La separation de chaineMotClefsSuggestions -->
			//MotClef.separation(ListChaineMotClefsSuggestions.get(i));
			//On obtient un Array ListMotClefSugest
			StructureMotCle MotClef = new StructureMotCle();
			//On repete pour tout les articles de la liste de suggestion (indice i)
			for (int i=0; i<ListChaineMotClefsSuggestions.size(); i++)
			{
				//On recupere le array correspondant a la chaine des mots clefs de l'article d'indice i
	/* Atention methode de JR ici */ ArrayList<String> motClefTraite = MotClef.separationListe(ListChaineMotClefsSuggestions.get(i));
				//On compare alors les mots clefs (en Array) de la suggestion d'indice i avec les mots clefs de la source (en Array)
				tabCorelation[i]=this.compare(motclefsPrincipale, motClefTraite);
			}
			
			/* Recherche de l'indice */
			for (int i=0; i<tabCorelation.length; i++)
	    	{
	    			//On cherche celui qui a la plus de mots clefs communs
	    			if (max[0]<tabCorelation[i])
	    			{
	    				indice[0] = i ;
	    				max[0]=tabCorelation[i];
	    			}
	    	}
			for (int i=0; i<tabCorelation.length; i++)
	    	{
	    			//On cherche celui qui a la plus de mots clefs communs
	    			if (max[1]<tabCorelation[i]&&tabCorelation[i]<max[0])
	    			{
	    				indice[1] = i ;
	    				max[1]=tabCorelation[i];
	    			}
	    	}
			for (int i=0; i<tabCorelation.length; i++)
	    	{
	    			//On cherche celui qui a la plus de mots clefs communs
	    			if (max[2]<tabCorelation[i]&&tabCorelation[i]<max[1])
	    			{
	    				indice[2] = i ;
	    				max[2]=tabCorelation[i];
	    			}
	    	}
	    	return indice;
		}
	}