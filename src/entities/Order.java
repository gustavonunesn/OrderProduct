package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	List<OrderItem> items = new ArrayList<>();
	
	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	public LocalDateTime getMoment() {
		return moment;
	}
	public void setMoment(LocalDateTime moment) {
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
	public List<OrderItem> getOrderItem(){
		return items;
	}
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public Double total() {
		double sum = 0;
		for(OrderItem i : items) {
			sum += i.subTotal(); 
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Status: " + status + "\n"); 
		sb.append("Client: " + client + "\n");
		sb.append("Order items: \n");
		for(OrderItem i : items) {
			sb.append(i + ", \n");
		}
		sb.append("Total price: " + total());
		return sb.toString();
				
	}

}
