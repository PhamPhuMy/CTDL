package Task1_4;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public OrderItem[] BubbleSortbyPrice(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 1; j < items.length; j++) {
				if (items[j].getPrice() < items[j - 1].getPrice()) {
					OrderItem temp = items[j - 1];
					items[j - 1] = items[j];
					items[j] = temp;
				}
			}
		}
		return items;
	}

	public OrderItem[] SelectionSortbyPrice(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = i + 1; j < items.length; j++) {
				if (items[i].getPrice() > items[j].getPrice()) {
					OrderItem temp = items[i];
					items[i] = items[j];
					items[j] = temp;
				}
			}
		}
		return items;
	}

	public OrderItem[] InsertionSortbyPrice(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			double temp = items[i].getPrice();
			for (int j = i - 1; j >= 0; j--) {
				if (temp < items[j].getPrice()) {
					OrderItem tmp = items[j + 1];
					items[j + 1] = items[j];
					items[j] = tmp;
				}
			}
		}
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
		OrderItem oi9 = new OrderItem(p9, 40);
		OrderItem[] items1 = { oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8 };
		OrderItem[] items2 = { oi5, oi2, oi7, oi4, oi1, oi6, oi2, oi8 };
		OrderItem[] items3 = { oi3, oi5, oi1, oi6, oi2, oi4, oi8, oi7 };
		Order o1 = new Order(items1);
		// Bubble Sort
		System.out.println(Arrays.toString(o1.BubbleSortbyPrice(items1)));
		// Selection Sort
		System.out.println(Arrays.toString(o1.SelectionSortbyPrice(items2)));
		// Insertion Sort
		System.out.println(Arrays.toString(o1.InsertionSortbyPrice(items3)));
	}
}
