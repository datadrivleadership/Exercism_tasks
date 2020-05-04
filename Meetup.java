

import java.time.LocalDate;
import java.time.DayOfWeek;

class Meetup {
	
private int mon;
private int yea;

    Meetup(int mon, int yea) {
		this.mon = mon;
		this.yea = yea;
    }

    LocalDate day(DayOfWeek daynam, MeetupSchedule sched)
	{
		String dateOfFirst;
		String dateOfNext;
		if (mon<10)
		{
			dateOfFirst = yea + "-0" + mon + "-01";
			if (mon==9)
				dateOfNext = yea + "-" + (mon+1) + "-01";			
			else
				dateOfNext = yea + "-0" + (mon+1) + "-01";							
		}
		else
		{
			dateOfFirst = yea + "-" + mon + "-01";
			if (mon == 12)
				dateOfNext = yea+1 + "-0" + (mon-11) + "-01";			
			else
				dateOfNext = yea + "-" + (mon+1) + "-01";			
			
		}
				
		LocalDate dt = LocalDate.parse(dateOfFirst); 
		DayOfWeek firstday = dt.getDayOfWeek();

		LocalDate nextdt = LocalDate.parse(dateOfNext);
		LocalDate lastdt = nextdt.withDayOfMonth(1).minusDays(1);	
		DayOfWeek lastday = lastdt.getDayOfWeek();		

		int firstDayOrdinal = 0;
		int checkedDayOrdinal = 0;
		int lastDayOrdinal = 0;		
		for (DayOfWeek d: DayOfWeek.values()) { 
			if (d.equals(firstday))
				firstDayOrdinal = d.ordinal();
			if (d.equals(daynam))
				checkedDayOrdinal = d.ordinal();		
			if (d.equals(lastday))
				lastDayOrdinal = d.ordinal();		
		}	

		LocalDate returnDate = dt;
		
		if (sched == MeetupSchedule.LAST)
		{
			if (checkedDayOrdinal<lastDayOrdinal)
				returnDate = lastdt.minusDays(lastDayOrdinal-checkedDayOrdinal);	
			else if (checkedDayOrdinal == lastDayOrdinal)
				returnDate = lastdt;
			else
				returnDate = lastdt.minusDays((7+lastDayOrdinal)-checkedDayOrdinal);					
		}
		else
		{
			if (firstDayOrdinal < checkedDayOrdinal)
			{
				int date1st = checkedDayOrdinal-firstDayOrdinal+1;

				switch (sched)
				{
				case FIRST:
					returnDate = LocalDate.of(yea,mon,date1st);	
					break;
				case SECOND:
					returnDate = LocalDate.of(yea,mon,date1st+7);				
					break;
				case THIRD:
					returnDate = LocalDate.of(yea,mon,date1st+14);				
					break;
				case FOURTH:
					returnDate = LocalDate.of(yea,mon,date1st+21);				
					break;
				case TEENTH:
					int totalSumma = date1st;
					while (totalSumma < 13)
					{
						totalSumma = totalSumma + 7;
					}
					returnDate = LocalDate.of(yea,mon,totalSumma);							
					break;
				}			
			}
			else if (firstDayOrdinal == checkedDayOrdinal)
			{
				switch (sched)
				{
				case FIRST:
					returnDate = LocalDate.of(yea,mon,1);	
					break;					
				case SECOND:
					returnDate = LocalDate.of(yea,mon,8);				
					break;					
				case THIRD:
					returnDate = LocalDate.of(yea,mon,15);				
					break;					
				case FOURTH:
					returnDate = LocalDate.of(yea,mon,22);				
					break;					
				case TEENTH:
					int totalSumma = 1;
					while (totalSumma < 13)
					{
						totalSumma = totalSumma + 7;
					}
					returnDate = LocalDate.of(yea,mon,totalSumma);							
					break;					
				}
			}
			else
			{
				int date1stb = (7-firstDayOrdinal)+checkedDayOrdinal+1;

				switch (sched)
				{
				case FIRST:
					returnDate = LocalDate.of(yea,mon,date1stb);	
					break;					
				case SECOND:
					returnDate = LocalDate.of(yea,mon,date1stb+7);	
					break;					
				case THIRD:
					returnDate = LocalDate.of(yea,mon,date1stb+14);				
					break;					
				case FOURTH:
					returnDate = LocalDate.of(yea,mon,date1stb+21);				
					break;					
				case TEENTH:
					int totalSumma = date1stb;
					while (totalSumma < 13)
					{
						totalSumma = totalSumma + 7;
					}
					returnDate = LocalDate.of(yea,mon,totalSumma);							
					break;					
					
				}
			}



		}
					return returnDate;					
	}
}


