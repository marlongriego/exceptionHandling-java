package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan =  new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		
		System.out.print("Room number: ");
		int number = scan.nextInt();
		
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		
		System.out.print("Check-Out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
		if(!checkOut.after(checkIn))
			System.out.println("ERROR in reservation: check-out date must be after check-in date");
		
		else {
			
			Reservation resevation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + resevation);
			
			System.out.println();
			System.out.println(" enter date to update the reservation");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.next());
			
			System.out.print("Check-Out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.next());
			
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("error in resevation: reservation dates for updates must be future dates");
			}
			
			else if (!checkOut.after(checkIn)){
				System.out.println("ERROR in reservation: check-out date must be after check-in date");	
			}	
			
			else {
			resevation.updateDates(checkIn, checkOut);
			System.out.println("resevation " + resevation);
		}
		}
		scan.close();
	}

}
