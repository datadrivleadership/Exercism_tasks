class Scrabble {
private String word;

    Scrabble(String word) {
		this.word = word;
        
    }

    int getScore() {
		int totalscore = 0;
		
		for (int i=0; i<word.length(); i++)
		{
			switch (word.charAt(i))
			{
				case 'A':
				case 'a':
				case 'E':
				case 'e':
				case 'I':
				case 'i':
				case 'O':
				case 'o':
				case 'U':
				case 'u':
				case 'L':
				case 'l':
				case 'N':
				case 'n':
				case 'R':
				case 'r':
				case 'S':
				case 's':
				case 'T':
				case 't':
				totalscore++;
				break;
				
				case 'D':
				case 'd':
				case 'G':
				case 'g':
				totalscore = totalscore + 2;
				break;
				
				case 'B':
				case 'b':
				case 'C':
				case 'c':
				case 'M':
				case 'm':
				case 'P':
				case 'p':
				totalscore = totalscore + 3;
				break;
				
				case 'F':
				case 'f':
				case 'H':
				case 'h':
				case 'V':
				case 'v':
				case 'W':
				case 'w':
				case 'Y':
				case 'y':
				totalscore = totalscore + 4;
				break;

				case 'K':
				case 'k':
				totalscore = totalscore + 5;
				break;

				case 'J':
				case 'j':
				case 'X':
				case 'x':
				totalscore = totalscore + 8;
				break;

				case 'Q':
				case 'q':
				case 'Z':
				case 'z':
				totalscore = totalscore + 10;
				break;


				
			}
				
		}
		return totalscore;	
		
    }

}




