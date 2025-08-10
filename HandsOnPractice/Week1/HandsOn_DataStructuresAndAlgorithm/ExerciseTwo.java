package Week1.HandsOn_DataStructuresAndAlgorimth;
import java.util.Arrays;
import java.util.Comparator;

public class ExerciseTwo {
    public static class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}
public class SearchUtil {

    // Linear Search by productId
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search by productId
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0, high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedProducts[mid].productId == targetId) {
                return sortedProducts[mid];
            } else if (sortedProducts[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Sort the array by productId
    public static void sortProductsById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
    }
}
    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Pen", "Stationery"),
            new Product(4, "Phone", "Electronics"),
            new Product(2, "Notebook", "Stationery")
        };

        // Linear Search
        Product result1 = SearchUtil.linearSearch(products, 4);
        System.out.println("Linear Search Result: " + result1);

        // Sort and Binary Search
        SearchUtil.sortProductsById(products);
        Product result2 = SearchUtil.binarySearch(products, 4);
        System.out.println("Binary Search Result: " + result2);
    }
}
