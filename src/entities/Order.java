package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList();
	
	public Order() {
	}

	public Order(Date moment,OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public double total() {
		double total = 0;
		for(OrderItem o : orderItem) {
			total += o.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder order = new StringBuilder();
		order.append("Order moment: " + sdf1.format(moment) + "\n");
		order.append("Order statud: " + status + "\n" );
		order.append("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		order.append("Order items: \n");
		for (OrderItem o: orderItem) {
			order.append(o.getProduct().getName() + 
					", " + " $" + o.getPrice() + 
					", " + "Quantity: " + o.getQuantity() +
					", " + "Subtotal: $" + o.subTotal() + "\n");
		}
		order.append("Total price: $" + total());
		return order.toString();
	}
}
