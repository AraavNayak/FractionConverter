// 18 July 2022 6:30pm
//Araav Nayak

package mathUtil;

import java.util.Scanner;

public class fractionConverter {

	private static Scanner s;
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		String query = "";
		
		System.out.println("This program converts decimals to fractions reduced to simplest form.\nPress 'exit' to exit. Enter a decimal below to begin:");
		
		while(!query.equals("exit")) {
			query = s.next();
			if(!query.equals("exit")) System.out.println(deciToFrac(query) + "\n");
		}
		
		System.out.println("--> Exited succesfully.");
		s.close();
	}
	
	
	
	public static String deciToFrac(String d) {
		
		//handle exception cases
		if(d.indexOf("/") != -1) return "already a fraction";
		if(d.indexOf(".") == -1 || d.indexOf(".") >= d.length()-1) return d + "/1";
		
		int deciPlace = d.substring(d.indexOf(".")+1).length(); //1
		
		
		//make the fraction
		int numerator = (int)(Double.parseDouble(d)*Math.pow(10, deciPlace));
		int denominator = (int)Math.pow(10, deciPlace);
		
		
		//find gcf of the numerator and denominator		
		int min = numerator;
		if(denominator < numerator) min = denominator;
		int gcf = 1;		
		
		for(int i = 1; i < min; i++) {
			if(numerator % i == 0 && denominator % i == 0) {
				if(i > gcf) gcf = i;
			}
		}
		
		//output result
		return "--> " + numerator/gcf + "/" + denominator/gcf;
	}
	
	
	
	
	
}
