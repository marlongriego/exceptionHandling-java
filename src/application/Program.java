package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExcpetion;

public class Program {

	public static void main(String[] args)  {
		Scanner scan =  new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		try {
		System.out.print("Room number: ");
		int number = scan.nextInt();
		
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		
		System.out.print("Check-Out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
			
			Reservation resevation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + resevation);
			
			System.out.println();
			System.out.println(" enter date to update the reservation");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.next());
			
			System.out.print("Check-Out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.next());
									
			resevation.updateDates(checkIn, checkOut);		
			System.out.println("resevation " + resevation);
				
		}
		catch (ParseException e) {
			
			System.out.println("Invalid date format");
		}
		catch (DomainExcpetion e) {
		System.out.println("Error in reservation " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Unexpected error ");
		}
		
		scan.close();
	}
}

