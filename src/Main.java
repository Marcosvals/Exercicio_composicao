import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Main {
	
	public static void main(String [] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthday = sdf.parse(sc.next());
		sc.nextLine();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		Date moment = new Date();		
		Order order = new Order(moment, OrderStatus.valueOf(status), new Client(name, email, birthday));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.printf("Enter #%d item data:\n", i);
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, price, new Product(productName, price));
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
	}
}
