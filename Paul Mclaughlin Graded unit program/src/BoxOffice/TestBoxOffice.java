 package BoxOffice;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class TestBoxOffice {

	
	public static void main(String[] args) throws IOException, DataFormatException {
	
		String CustomerName = "";
		String TelephoneNumber = "";
		String DateOfPayment = "";
		String FindArtistName = "";
		String creditcard = "";

		int PaymentMethod = 0;
		int writeback = 0;
		int AvailableTickets1 = 0;
		int NoOfTicketsBought = 0;
		int option = 0;
		
		double amount = 0.00;
		double Ticket1 = 0;
		double HandlingCharge = 1.50;
		double PostAndPackagingCharge = 1.75;
		
		
		Scanner sc = new Scanner(System.in);  // create scanner for input
		
		ArrayList<Events> Concert = new ArrayList<Events>();//array list for events 
		
		ArrayList<Booking> Book = new ArrayList<Booking>();//array list for booking, 
		
		BufferedReader buf = null;
		
		try {
			buf = new BufferedReader(new FileReader("concert.txt"));//file reader reads the concert.txt file to the array list
			String line;
			//file reader error handling
			while((line = buf.readLine()) !=null) {
				Events E = new Events();
				
				E.setArtist(line);
				line = buf.readLine();
				E.setConcertdate(line);
				line = buf.readLine();
				E.setvenue(line);
				line = buf.readLine();
				E.setTicketPrice(Double.parseDouble(line));
				line = buf.readLine();
				E.setAvailableTickets(Integer.parseInt(line));
				
				Concert.add(E);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		buf.close();

	do { //menu
		System.out.println(" 1. Add events ");
		System.out.println(" 2. Display added events  ");
		System.out.println(" 3. Save Added Events ");
	    System.out.println(" 4. Booking details  ");
	    System.out.println(" 5. Display booking details");
	    System.out.println(" 6. Save booking details");
		System.out.println(" 7. Exit program"); 
		System.out.println(" pick a number to proceed ");
		//menu error handling, you can only choose numbers which are in the menu
		   if (sc.hasNextInt())
		   {
		   option = sc.nextInt();
		   }
		   else
		   {
		    System.out.println("Please enter a number");
		    sc.nextLine();
		   }
	
		   switch (option){
	case 1:
		Events Ev  = new Events(); 
		sc.nextLine(); 
		System.out.println(" 1. Enter Artist/band's name "); //Operator is prompted to type the name of artist
		Ev.setArtist(sc.nextLine());//set Artist
	
		System.out.println(" 3. Enter date");//Operator is prompted to type the name of date of concert
		Ev.setConcertdate(sc.nextLine());//set Date
	
	
		System.out.println(" 4. Enter Venue " );//Operator is prompted to type the Venue
		Ev.setvenue(sc.nextLine());//set Venue
	
		System.out.println(" 5. Enter ticket price");//Operator is prompted to type the name of Ticket price
		//error handling, cannot type letters
		try{
			if(sc.hasNextDouble()){
				Ev.setTicketPrice(sc.nextDouble());
			}
			else
			{
				while(!sc.hasNextDouble()){
					System.out.println("anything other than numbers is invalid.");//error message
					Ev.setTicketPrice(sc.nextDouble());
				}
			}
		}
		catch(InputMismatchException ex){
			sc.nextLine();
			System.out.println("the system will close down if you enter another invalid input");//warning message after the first invalid input
			if(sc.hasNextDouble()){
				Ev.setTicketPrice(sc.nextDouble());
			}
			else
			{
				while(!sc.hasNextDouble()){
					System.out.println("shutting down");
					System.exit(0);//if the operator types another invalid input the system shuts down
				}
			}
		}
		
		
			
		
		
		
		System.out.println(" 6. Enter ticket availability");//Operator is prompted to type the ticket availability
		// error handling, cannot type letters
		try{
			if(sc.hasNextInt()){
				Ev.setAvailableTickets(sc.nextInt());
			}
			else
			{
				while(!sc.hasNextInt()){
					System.out.println("anything other than numbers is invalid.");//error message
					Ev.setAvailableTickets(sc.nextInt());
				}
			}
		}
		catch(InputMismatchException ex){
			sc.nextLine();
			System.out.println("the system will close down if you enter another invalid input");//warning message after the first invalid input
			if(sc.hasNextInt()){
				Ev.setAvailableTickets(sc.nextInt());
			}
			else
			{
				while(!sc.hasNextInt()){
					System.out.println("shutting down");
					System.exit(0);//if the operator types another invalid input the system shuts down
				}
			}
		}	
		Concert.add(Ev);
	
	
			
	break;
	case 2:
		//display added details
		for (Events E: Concert ) {
			System.out.println("Artist name: " + E.getArtist());
			System.out.println(" ");
			System.out.println("Date: " + E.getConcertdate());
			System.out.println(" ");
			System.out.println("Ticket price: £ " + E.getTicketPrice(amount));
			System.out.println(" ");
			System.out.println("Ticket availability: " + E.getAvailabileTickets(AvailableTickets1));
			System.out.println(" ");
			System.out.println("Venue: " +  E.getvenue());
		}
	
		break;
	case  3:	  
		//save added details to the file
		try {
		PrintWriter P = new PrintWriter(new FileOutputStream("concert.txt"));
	
    for(Events E: Concert){
    	
    	P.println(E.getArtist());
    	P.println(E.getConcertdate());
    	P.println(E.getvenue());
    	P.println(E.getTicketPrice(amount));
    	P.println(E.getAvailabileTickets(AvailableTickets1));
    	} 
    P.close();
	 } catch(FileNotFoundException fnfExcep)
	 { System.out.println("Error Occurred" + fnfExcep.getMessage());// error will appear if the file isn't found
	 }
	
		break;
		   
		   case 4:	Booking Bo = new Booking();
		   sc.nextLine();//clears scanner for input 

	System.out.println("Enter Customer's Name ");
	CustomerName = sc.nextLine();   // Operator is prompted to type the customer's name
	
	System.out.println("Enter Telephone Number  ");
	TelephoneNumber = sc.nextLine();// Operator is prompted to type the customer's telephone number
	
	
	
	System.out.println("Enter date of payment ");
	DateOfPayment = sc.nextLine();// Operator is prompted to type the date of payment
	
	
	
	while(true)
	{
		Booking B = new Booking();
	System.out.println("Credit Card: 1.Visa,  2.Master Card, 3. American Express, 4. Debit Card ");
		if (sc.hasNextInt()) //operator is prompted to type the menu option for the customers credit card type 
		{
		   PaymentMethod = sc.nextInt();
		//error handling, if operator types a number > 4, the program brings the user back to the question
		  if(PaymentMethod >= 1 && PaymentMethod <= 4)
		  {
			  
			 B.setPaymentMethod(PaymentMethod);// sets payment method
				creditcard =B.getPaymentMethod();// gets payment method
				break;
		} 
		  else {
			System.out.println("this is not a valid option, please choose a number from 1-4");
			
			
		}
	}
		  else {
			  System.out.println("Please enter a valid number");
			  sc.nextLine();
		 }
		
	} 
		   

	while (true)
	{
		Events ev = new Events ();
	System.out.println("How many tickts does the customer want to book?");  
			if (sc.hasNextInt()) //Operator is prompted to type in how many tickets the customer wants 
			{
			   NoOfTicketsBought = sc.nextInt();
			//error handling, if user types a number > 6, the program brings the user back to the question
			  if(NoOfTicketsBought >= 1 && NoOfTicketsBought <= 6)
			  {
				  
				 ev.setAvailableTickets(AvailableTickets1);// sets ticket price
					Ticket1 = ev.getAvailabileTickets(AvailableTickets1);// gets ticket price
					break;
			}
			  else {
				System.out.println("this is not a valid option, please choose a number from 1-6");
				
				
			}
		}
			  else {
				  System.out.println("Please enter a valid number");
				  sc.nextLine();
			 }
			
			
		} 
   
    
	
	int flag = 0;					//"flag = 0"  not found
    while(flag == 0)                //"flag = 1" found
    {
	System.out.println("please Enter what concert the customer wants to see");
	FindArtistName = sc.next();	
	
    
		for (Events E: Concert){
			if (E.getArtist().equals(FindArtistName))
			{		
				flag = 1;
		       System.out.println(FindArtistName + " found");
		       
			  AvailableTickets1 = E.getAvailabileTickets(AvailableTickets1) - NoOfTicketsBought;// an equation to update the ticket availability
			  E.setAvailableTickets(AvailableTickets1);//sets the availability 
				break;

			  
			}
		 
		
			}
    }
		
		if (flag == 0)// if artist is not found, the program will show "not found"
		{
			System.out.println(" not found");
		}
		else{
			sc.nextLine();
		}
	
	
    
	Book.add(Bo);
    System.out.println("Availability of artist's has been updated!");
		//shows up after the concert details have been updated
		

	
   	try {//write back to the concert file and displays the updated ticket availability
		PrintWriter fos = new PrintWriter(new FileOutputStream("concert.txt"));
		for (Events E1: Concert) {
			fos.println(E1.getArtist());
			fos.println(E1.getConcertdate());
			fos.println(E1.getvenue());
			fos.println(E1.getTicketPrice(amount));
			fos.println(Integer.toString(E1.getAvailabileTickets(writeback)));
		} fos.close();
		System.out.println("");
			} catch(FileNotFoundException fnfExcep){ // error if file is not found
				System.out.println("Error Occurred" + fnfExcep.getMessage() );//output to show that the file was not found
						
			}
	
    
	break;
	case 5:// displays booking information
		for(Booking B:Book){
			System.out.println("Customer's name: " + CustomerName);
			System.out.println(" ");
			System.out.println("Customer's telephone number: " + TelephoneNumber);
			System.out.println(" ");
			System.out.println("Date of Payment: " + DateOfPayment);
			System.out.println(" ");
			System.out.println("Concert:  " + FindArtistName);
			System.out.println(" ");
			System.out.println("Number of tickets:  " + NoOfTicketsBought);
			System.out.println(" ");
			System.out.println("Credit Card: " + B.getPaymentMethod());
			System.out.println(" ");
			System.out.println("Handling charge: £ " + HandlingCharge);
			System.out.println(" ");
			System.out.println("Post and Packaging charge: £ " + PostAndPackagingCharge);

		}
		
		break;
	case 6://writes booking information to file
		PrintWriter P = new PrintWriter(new FileOutputStream("Bookings.txt"));
		
		for (Booking B: Book){
			P.println("Customer's Name:  "+ CustomerName);
			P.println("Telephone Number: " + TelephoneNumber);
			P.println("Date: " + DateOfPayment);
			P.println("Number of tickets:  " + NoOfTicketsBought);
			P.println("Concert:  " + FindArtistName);
			P.println("Credit Card: " + B.getPaymentMethod());
			P.println("Handling charge: £ " + HandlingCharge);
			P.println("Post and Packaging charge: £ " + PostAndPackagingCharge);

		}
		System.out.println("Booking details have been saved");//output to tell the user that the booking details were saved
		P.close();
	
			break;	
	case 7 :
		System.out.println("Program Terminated");
		System.exit(0);// shut down system 
		   }
	  }while (option !=7);
	}
}


	
				
		
	

