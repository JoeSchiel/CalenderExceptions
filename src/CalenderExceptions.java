//Joe Schiel
//A program that asks for birth date year>month>day and checks if it is a valid birth date.
//Fix leap year logic.

import java.util.Scanner;

public class CalenderExceptions {
	
	public static void main(String[] args){
		
		Scanner console = new Scanner(System.in);
		
		//initialize variables
		int month = -1;
		int day = -1;
		int year = -1;
		String monthString;
	
		year = checkYear();
		month = checkMonth(month);
		//Need to check year and month before day because the leap year check is in checkDay()
		day = checkDay(month);
				
		monthString = monthToString(month);
		
		System.out.println("Date of birth: " + monthString + " " + day + ", " + year);				
	}
	
	public static int checkDay(int month){
		Scanner console = new Scanner(System.in);
		int day = 0;
		
		while(day < 1 || day > 31){
		try{
			System.out.println("What DAY were you born? (enter number)");
			day = console.nextInt();	
		
			//These months have 31 days
	        if(month == 1 || month == 3 || month == 5 || month == 7 ||
	           month == 8 || month == 10 || month == 12){
	        	//If day is not 1-31 throw exception
	        	if(day < 1 || day > 31){
	        		throw new InvalidDayException("" + monthToString(month) + " " + day + " is not valid.");
	        	}
	        }
	        //These months have 30 days
	        else if (month == 4 || month == 6 || month == 9 || month == 11){
	        	//If day is not 1-30 throw exception
	        	if(day < 1 || day > 30){
	        		throw new InvalidDayException(monthToString(month) + " " + day + " is not valid.");
	        	}
	        }
	        //If the month is February
	        else if (month == 2){
	        	//If it's a leap year, 1-29 are valid days
	        	if(isLeapYear(month) == true){
	        		if(day < 1 || day > 29){
		        		throw new InvalidDayException("" + monthToString(month) + " " + day + " is not valid.");
		        	}
	        	}
	        	//If it is not a leap year, 1-28 are valid days
	        	else if(isLeapYear(month) == false){
		        		if(day < 1 || day > 28){
			        		throw new InvalidDayException("" + monthToString(month) + " " + day + " is not valid.");
			        	}
	        	}
	        }

		}
		catch (InvalidDayException id){
			System.out.println("Error: " + id.getMessage());
		}
		catch (Exception ex){
			System.out.println("Catch block accessed, Error: " + ex.getMessage());
			//If the scanner is not cleared by calling next
			//the catch can cause an infinite loop
			console.next();
		}
		}
		
		return day;		
	}
	
	//Checks if month is 1-12 and if it is return that value.
	public static int checkMonth(int month){
		Scanner console = new Scanner(System.in);
		while(month < 1 || month > 12){
			try{
				System.out.println("In what MONTH were you born? (enter number)");
				month = console.nextInt();
			
				if(month < 1 || month > 12){
					throw new InvalidMonthException();
				}
			}
			catch (InvalidMonthException im){
				System.out.println("Error: " + im.getMessage());
			}
			catch (Exception ex){
				System.out.println("Error: " + ex.getMessage());
				console.next();
			}
		}
		
		return month;
	}
	
	//Checks to see if year is in range of 1895-2015 (oldest person in the world is 116).
	public static int checkYear(){
		Scanner console = new Scanner(System.in);
		int year = 0000;
		while(year < 1895 || year > 2015){
			try{
				System.out.println("In what YEAR were you born? (enter number)");
				year = console.nextInt();
				
				if(year < 1895 || year > 2015){
					throw new InvalidYearException();
				}
			}
			catch (InvalidYearException iy){
				System.out.println("Error: " + iy.getMessage());
			}
			catch (Exception ex){
				System.out.println("Error: " + ex.getMessage());				
				console.next();
			}
		}
		
		return year;
	}
	
	public static boolean isLeapYear(int yr){
		//if year can be divided by 4 return false
		if((yr % 4) == 0){
			return false;
		}
		//if year can be divided by 100 return true
		else if((yr % 100) != 0){
			return true;
		}
		//if year can be divided by 400 return false
		else if((yr % 400) != 0){
			return false;
		}
		//Otherwise it is a leap year, return true
		else{
			return true;
		}

	}
	
	//Converts int to string, 1 becomes January 2 becomes February
	public static String monthToString(int m){
		String monthString;
        switch (m) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
	}
}
