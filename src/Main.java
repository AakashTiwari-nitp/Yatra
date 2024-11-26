package src;
import src.TourismManagementSystem;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        TourismManagementSystem system = new TourismManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Tourism Management System ---");
            System.out.println("1. Add Tour");
            System.out.println("2. View Tours");
            System.out.println("3. Book Tour");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter tour name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter available seats: ");
                    int seats = scanner.nextInt();
                    system.addTour(name, location, price, seats);
                    break;

                case 2:
                    system.viewTours();
                    break;

                case 3:
                    System.out.print("Enter tour ID to book: ");
                    int tourId = scanner.nextInt();
                    system.bookTour(tourId);
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
