package LAB3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].getName() + ": " + items[i].getPrice());
		}
		return 0;
	}

	// using binary search approach
	public boolean contains(Product p) {
		sort(items);
		int mid = items.length / 2;
		int left = 0;
		int right = items.length - 1;
		while (left < right) {
			if (p.getPrice() > items[mid].getPrice()) {
				left = mid + 1;
				mid = items.length - 1 - ((right - left) / 2);
			}
			if (p.getPrice() < items[mid].getPrice()) {
				right = mid - 1;
				mid = (right - left) / 2;
			}
			if (p.getPrice() == items[mid].getPrice()) {
				return true;
			}
			if (right == left && p.getPrice() == items[mid].getPrice()) {
				return true;
			}
		}
		return false;
	}

	// get all products based on the given type using linear search
	public int getLength(OrderItem[] items, String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType() == type) {
				count++;
			}
		}
		return count;
	}

	public Product[] filter(String type) {
		Product[] correctOnType = new Product[getLength(items, type)];
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType() == type) {
				correctOnType[index++] = items[i].getProduct();
			}
		}
		return correctOnType;
	}

	public OrderItem[] sort(OrderItem[] items) {
		Arrays.sort(items, Comparator.comparing(item -> item.getProduct().getPrice()));
		return items;
	}

	public static void main(String[] args) {
		Product p1 = new Product("01", "Coca", 10000, "Drink");
		Product p2 = new Product("02", "Pepsi", 9000, "Drink");
		Product p3 = new Product("03", "Fanta", 8000, "Drink");
		Product p4 = new Product("04", "Aquafina", 5000, "Drink");
		Product p5 = new Product("05", "French Fries", 22000, "Food");
		Product p6 = new Product("06", "Chicken Fried", 29000, "Food");
		Product p7 = new Product("07", "Spagetti", 50000, "Food");
		Product p8 = new Product("08", "Hot Dog", 30000, "Food");
		Product p9 = new Product("09", "Cheese Burger", 35000, "Food");
		OrderItem oi1 = new OrderItem(p1, 50);
		OrderItem oi2 = new OrderItem(p2, 30);
		OrderItem oi3 = new OrderItem(p3, 20);
		OrderItem oi4 = new OrderItem(p4, 70);
		OrderItem oi5 = new OrderItem(p5, 100);
		OrderItem oi6 = new OrderItem(p6, 30);
		OrderItem oi7 = new OrderItem(p7, 70);
		OrderItem oi8 = new OrderItem(p8, 40);
		OrderItem[] items = { oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8 };
		Order o1 = new Order(items);
		System.out.println(o1.cost());
		System.out.println(Arrays.toString(o1.filter("Food")));
		System.out.println(Arrays.toString(o1.sort(items)));
		System.out.println(o1.contains(p1));
		System.out.println(o1.contains(p9));
	}
}