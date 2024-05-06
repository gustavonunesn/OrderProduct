package program;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthClient = sc.next();
		LocalDate birthDate = LocalDate.parse(birthClient, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Client client = new Client(nameClient, emailClient, birthDate);
		Order order = new Order(LocalDateTime.now(), status, client);
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.printf("Enter #%d data:\n", i);
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			Product product = new Product(nameProduct, priceProduct);
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			order.addItem(orderItem);
		}
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		System.out.println(order);
		}
		catch(RuntimeException e) {
			System.out.println("Error: Start the program again.");
		}
	}
}
