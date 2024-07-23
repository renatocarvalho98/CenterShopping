
package CenterShopping;

import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingTrolley {
    private ArrayList<Fruit> items; // Store all items in the trolley

    // Constructor to initialize the items list
    public ShoppingTrolley() {
        items = new ArrayList<>();
    }

    // Add an item to the trolley
    public void buyItem(Fruit fruit) {
        items.add(fruit);
    }

    // View the contents of the trolley without emptying it
    public String viewTrolley() {
        if (items.isEmpty()) {
            return "";
        }

        StringBuilder itemList = new StringBuilder();
        double totalAmount = 0.0;

        // Use a map to store quantities and total prices for each item type
        Map<String, ItemEntry> summary = new HashMap<>();

        for (Fruit item : items) {
            String name = item.getName();
            if (summary.containsKey(name)) {
                ItemEntry entry = summary.get(name);
                entry.quantity++;
                entry.totalPrice += item.getPrice();
            } else {
                summary.put(name, new ItemEntry(1, item.getPrice()));
            }
        }

        // Build the item list string
        for (Map.Entry<String, ItemEntry> entry : summary.entrySet()) {
            String name = entry.getKey();
            ItemEntry itemEntry = entry.getValue();
            itemList.append(itemEntry.quantity).append(" ").append(name).append("(s) - $").append(String.format("%.2f", itemEntry.totalPrice)).append("\n");
            totalAmount += itemEntry.totalPrice;
        }

        itemList.append("Total - $").append(String.format("%.2f", totalAmount));

        return itemList.toString();
    }

    // Empty the trolley and return its contents as a string
    public String emptyTrolley() {
        String trolleyContents = viewTrolley();
        items.clear(); // the trolley is empty now
        return trolleyContents;
    }

    // Clear the trolley without returning its contents
    public void clearTrolley() {
        items.clear();
    }

    // Inner class to hold item quantity and total price
    private static class ItemEntry {
        int quantity;
        double totalPrice;

        ItemEntry(int quantity, double totalPrice) {
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }
    }
}

