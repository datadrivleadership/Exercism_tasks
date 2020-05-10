import java.util.List;
import java.util.ArrayList;

class Allergies
{
private int allergyNum;

	Allergies(int allergyNum)
	{
		this.allergyNum = allergyNum;
		
	}
	
	boolean isAllergicTo(Allergen allergen)
	{
		
		if ((allergen.getScore() & allergyNum)>0)
			return true;
		else 
			return false;

	}


	List<Allergen> getList()
	{
		
		List<Allergen> foundAllergens = new ArrayList<Allergen>();
		Allergen allergens[] = Allergen.values();
		
		for (Allergen allItems : allergens)
		{			
			if ((allItems.getScore() & allergyNum)>0)
				foundAllergens.add(allItems);
		
		}
		
		return foundAllergens;
		

		
	}

	
}
