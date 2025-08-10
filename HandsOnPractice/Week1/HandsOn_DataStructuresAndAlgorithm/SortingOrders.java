import java.util.Arrays;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order(" + orderId + ", " + customerName + ", ₹" + totalPrice + ")";
    }
}

public class SortingOrders {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Print array
    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] originalOrders = {
            new Order(1, "Alice", 2500),
            new Order(2, "Bob", 1000),
            new Order(3, "Charlie", 4000),
            new Order(4, "David", 1500)
        };

        // Clone array for sorting
        Order[] bubbleSorted = Arrays.copyOf(originalOrders, originalOrders.length);
        Order[] quickSorted = Arrays.copyOf(originalOrders, originalOrders.length);

        System.out.println("Original Orders:");
        printOrders(originalOrders);

        System.out.println("\nBubble Sorted Orders:");
        bubbleSort(bubbleSorted);
        printOrders(bubbleSorted);

        System.out.println("\nQuick Sorted Orders:");
        quickSort(quickSorted, 0, quickSorted.length - 1);
        printOrders(quickSorted);
    }
}
