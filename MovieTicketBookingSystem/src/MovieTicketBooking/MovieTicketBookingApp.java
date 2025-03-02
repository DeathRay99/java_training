package MovieTicketBooking;
import java.util.*;

public class MovieTicketBookingApp {
	
	
	public static void login(String username,String password) {
		 Scanner scanner = new Scanner(System.in);
         if(UserLogin.login(username,password)&&CheckAdmin.checkAdmin(username)==false) {
			
			System.out.println(" customer login successfull ");
			while (true) {
	            System.out.println("Press 1 : To see all avaliable movies and shows ");
	            System.out.println("Press 2 : To book a ticket ");
	            System.out.println("Press 3 : To show your booking ");
	            System.out.println("Press 4 : To cancel your booking ");
	            
	            int choice = scanner.nextInt();
	            
	                switch (choice) {
	                    case 1:
	                        ShowAvailableMovies.showMovies();
	                        break;
	                    case 2:
	                        TicketBooking.bookTicket();
	                        break;
	                    case 3:
	                        BookingConfirmation.confirmBooking();
	                        break;
	                    case 4:
	                        TicketCancellation.cancelTicket();
	                        break;
	                    case 5:
	                        StoredProCallable.proCall();
	                        break;
	                    default:
	                        System.out.println("Thank you, logging out...");
	                        scanner.close();
	                        return;

		                }

	               }
			
   }
		else if(UserLogin.login(username,password)&&CheckAdmin.checkAdmin(username)==true) {
			
			System.out.println(" Admin login successfull ");
			while (true) {
	            System.out.println("Press 1 : Enter new movies ");
	            System.out.println("Press 2 : Enter new shows ");
	            System.out.println("Press 3 : Create Tables ");
	            
	            int choice = scanner.nextInt();
	            
	                switch (choice) {
	                    case 1:
	                        InsertData.insertMovies();
	                        break;
	                    case 2:
	                        InsertData.insertShows();
	                        break;
	                    case 3:
	                        DatabseTables.createTables();
	                        break;
	           
	                    default:
	                        System.out.println("Thank you, logging out...");
	                        scanner.close();
	                        return;

		                }

	               }
			
		}
		else {
			System.out.println(" Invalid login credentials ");
			scanner.close();
            return;
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Ticket Booking Application ");
		while (true) {
            System.out.println("Press 1 : To login ");
            System.out.println("Press 2 : To sign up ");
            
            int choice = scanner.nextInt();
            
                switch (choice) {
                    case 1:
                    	System.out.println("Enter your Username: ");
                		String username = scanner.nextLine();
                		System.out.println("Enter your password: ");
                		String password = scanner.nextLine();
                        login(username, password);
                        break;
                    case 2:
                    	System.out.println("Enter your Username: ");
                		String username1 = scanner.nextLine();
                		System.out.println("Enter your password: ");
                		String password1 = scanner.nextLine();
                        System.out.println(RegisterUser.register(username1, password1)?"User registerd, successfully !!!!":"Error in adding new user");
                        
                        break;
        
                    default:
                        System.out.println("Thank you, exiting from system");
                        scanner.close();
                        return;

	                }

               }
		
		
		

//        while (true) {
//            System.out.println("Ticket Booking Application");
//            System.out.println("Press 1 : To see all avaliable movies and shows ");
//            System.out.println("Press 2 : To book a ticket ");
//            System.out.println("Press 3 : To show your booking ");
//            System.out.println("Press 4 : To cancel your booking ");
//            
//            int choice = scanner.nextInt();
//            
//                switch (choice) {
//                    case 1:
//                        ShowAvailableMovies.showMovies();
//                        break;
//                    case 2:
//                        TicketBooking.bookTicket();
//                        break;
//                    case 3:
//                        BookingConfirmation.confirmBooking();
//                        break;
//                    case 4:
//                        TicketCancellation.cancelTicket();
//                        break;
//                    case 5:
//                        StoredProCallable.proCall();
//                        break;
//                    default:
//                        System.out.println("Thank you, exiting from system");
//                        scanner.close();
//                        return;
//
//	                }
//
//               }

	}
	
	
}