import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
		List<String> returnList = new ArrayList<String>();
		
		String foundProtein;

		for(int i = 0; i < rnaSequence.length(); i += 3)
		{
			
			switch (rnaSequence.substring(i, (i+3)))
			{
			case "AUG":
				foundProtein = "Methionine";
				break;
			case "UUU":
				foundProtein = "Phenylalanine";
				break;
			case "UUC":
				foundProtein = "Phenylalanine";
				break;
			case "UUA":
				foundProtein = "Leucine";
				break;
			case "UUG":
				foundProtein = "Leucine";
				break;
			case "UCU":
				foundProtein = "Serine";
				break;
			case "UCC":
				foundProtein = "Serine";
				break;
			case "UCA":
				foundProtein = "Serine";
				break;
			case "UCG":
				foundProtein = "Serine";
				break;				
			case "UAU":
				foundProtein = "Tyrosine";
				break;
			case "UAC":
				foundProtein = "Tyrosine";
				break;
			case "UGU":
				foundProtein = "Cysteine";
				break;
			case "UGC":
				foundProtein = "Cysteine";
				break;
			case "UGG":
				foundProtein = "Tryptophan";
				break;
			case "UAA":
				foundProtein = "STOP";
				break;
			case "UAG":
				foundProtein = "STOP";
				break;
			case "UGA":
				foundProtein = "STOP";
				break;
			default:
				foundProtein = "STOP";
			}

			if (foundProtein=="STOP")
				return returnList;
			else
				returnList.add(foundProtein);
			
		}
		
		return returnList;
		
	
		
    }
}
