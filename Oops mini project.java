import java.util.*;
class Item {
    int id;
    String name;
    double price;
    Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class CafeteriaBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item[] menu = {
            new Item(1, "Coffee", 25.0),
            new Item(2, "Tea", 20.0),
            new Item(3, "Sandwich", 50.0),
            new Item(4, "Burger", 80.0),
            new Item(5, "Pasta", 100.0)
        };
        System.out.println("========== CAFETERIA MENU ==========");
        System.out.printf("%-5s %-15s %s\n", "ID", "Item", "Price (₹)");
        for (Item i : menu) {
            System.out.printf("%-5d %-15s %.2f\n", i.id, i.name, i.price);
        }
        Map<String, Integer> order = new LinkedHashMap<>();
        double total = 0;
        while (true) {
            System.out.print("\nEnter item ID to order (0 to finish): ");
            int id = sc.nextInt();
            if (id == 0) break;
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            if (id >= 1 && id <= menu.length) {
                Item item = menu[id - 1];
                order.put(item.name, order.getOrDefault(item.name, 0) + qty);
                total += item.price * qty;
                System.out.println(qty + " " + item.name + "(s) added to order.");
            } else {
                System.out.println("Invalid item ID! Try again.");
            }
        }

        System.out.println("\n========== BILL RECEIPT ==========");
        System.out.printf("%-15s %-10s %-10s\n", "Item", "Qty", "Amount");
        for (Map.Entry<String, Integer> e : order.entrySet()) {
            String itemName = e.getKey();
            int qty = e.getValue();
            double price = 0;
            for (Item i : menu) {
                if (i.name.equals(itemName)) {
                    price = i.price * qty;
                    break;
                }
            }
            System.out.printf("%-15s %-10d %-10.2f\n", itemName, qty, price);
        }
        double gst = total * 0.05;
        double finalTotal = total + gst;
        System.out.println("------------------------------------");
        System.out.printf("%-25s %.2f\n", "Total (Before GST):", total);
        System.out.printf("%-25s %.2f\n", "GST (5%):", gst);
        System.out.printf("%-25s %.2f\n", "Final Total:", finalTotal);       System.out.println("====================================");
        System.out.println("Thank you! Visit again 😊");
        sc.close();
    }
}


