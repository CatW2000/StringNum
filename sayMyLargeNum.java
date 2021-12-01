//sayMyLargeNum.java
//CSCI1302
//Project 3
//12/01/2021
import java.util.Scanner;
public class sayMyLargeNum
{
	
		final public static String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				 "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		final public static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		final public static String[] BigNum = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};
		public static boolean output;
		
//quintillion = 1000000000000000000
//quadrillion = 1000000000000000		
//trillion = 1000000000000		
//billion = 1000000000
//million = 1000000
//thousand = 1000
		public static void main(String[] args)
		{
			Scanner scan = new Scanner(System.in);
			long input;
			
			//try statement:
			try {
			System.out.print("Enter a positive number between 1 and 9.2 Quintillion: ");
			input = scan.nextLong();
			output = false;
			testNumber(input, 0);
			
			//first exception
			if(input < 1 || input > 9200000000000000L)  //9,223,372,036,854,775,808 (what google says but is out of range)
			{
			throw new Exception ("Your input is too small or too large. Please try again.");
			}
		}
			catch (Exception problem) {
				System.out.println("Error: Your input is numerically incorrect. Please try again.");
			}
			scan.close();
		}

		public static void testNumber(long n, int iterate)
		{
			//recursion statement:
			if(n/1000 > 0)
			{
				testNumber(n/1000, iterate + 1);
			}
			
			//sections out large numbers
			int firstN = (int) (n%1000);
			int middleN = firstN/100;
			int lastN = firstN%100;
			
			if (firstN > 0 && output)
			{
				System.out.print(" ");
			}
			
			boolean flag = false; //identifies commas and will replace with " "
			
			if(middleN > 0)
			{
				System.out.print(ones[middleN] + " hundred");
				flag = true;
			}
			
			if (lastN < 20 && lastN > 0)
			{
				if(flag)
				{
					System.out.print(" ");
				}
				System.out.print(ones[lastN]);
			}
			else if(lastN >= 20)
			{
				if(flag)
				{
					System.out.print(" ");
				}
				System.out.print(tens[lastN/10]);
				if(lastN%10 > 0)
				{
					System.out.print(" " + ones[lastN%10]);
				}
			}
			
			if(iterate > 0 && firstN > 0)
			{
				System.out.print(" " + BigNum[iterate]);
			}
			
			if(firstN > 0)
			{
				output = true;
			}
		}
	}


