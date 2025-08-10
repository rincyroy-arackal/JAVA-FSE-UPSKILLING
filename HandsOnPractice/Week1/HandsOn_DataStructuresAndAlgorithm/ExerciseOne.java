import java.util.HashMap;
import java.util.Scanner;

public class ExerciseOne {

    // Product class
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + productId + ", Name: " + productName +
                   ", Qty: " + quantity + ", Price: " + price;
        }
    }

    // Inventory data storage
    static HashMap<Integer, Product> inventory = new HashMap<>();

    // Add product
    public static void addProduct(Product p) {
        if (!inventory.containsKey(p.productId)) {
            inventory.put(p.productId, p);
            System.out.println("✅ Product added.");
        } else {
            System.out.println("❌ Product ID already exists.");
        }
    }

    // Update product
    public static void updateProduct(int id, int qty, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = qty;
            p.price = price;
            System.out.println("✅ Product updated.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // Delete product
    public static void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("✅ Product deleted.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // Show inventory
    public static void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("📦 Inventory is empty.");
        } else {
            System.out.println("📦 Current Inventory:");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Inventory Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextInt();
                    System.out.print("Enter new Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter new Price: ");
                    price = sc.nextDouble();
                    updateProduct(id, qty, price);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    deleteProduct(id);
                    break;
                case 4:
                    showInventory();
                    break;
                case 0:
                    System.out.println("👋 Exiting...");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
