package main;
import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		double USD;
		double conversionAmount;
		int menuSelection = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(menuSelection != 4) {
			
	        System.out.println("\nPlease select an option \n 1. USD to CAD \n 2. USD to EUR \n 3. USD to JPY \n 4. Quit");
	        menuSelection = scanner.nextInt();

			switch(menuSelection) {
			case 1: {
				System.out.println("\nPlease enter the amount of USD to convert to CAD: ");
				USD = scanner.nextDouble();
				conversionAmount = USD * 1.20;
					 
				System.out.println("Amount CAD after conversion = " + conversionAmount);
				break;
			}
			case 2:{
				System.out.println("\nPlease enter the amount of USD to convert to EUR: ");
				USD = scanner.nextDouble();
				conversionAmount = USD * 0.82;
					 
				System.out.println("Amount EUR after conversion = " + conversionAmount);
				break;
			}
			case 3:{
				System.out.println("\nPlease enter the amount of USD to convert to JPY: ");
				USD = scanner.nextDouble();
				conversionAmount = USD * 109;
					 
				System.out.println("Amount JPY after conversion = " + conversionAmount);
				break;
			}
			case 4:{
				System.out.println("\nThe program has been quit\n");
		        scanner.close();
				break;
			}
			default:{
				System.out.println("\nError: Please select a number 1 through 4\n");
				break;
			}
		}
	}
}
}
