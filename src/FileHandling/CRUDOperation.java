package FileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDOperation {
    private static final String FILE_PATH = "items.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = readItemsFromFile();

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add an item");
            System.out.println("2. View all items");
            System.out.println("3. Update an item");
            System.out.println("4. Delete an item");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter item name:");
                    String newItem = scanner.nextLine();
                    items.add(newItem);
                    writeItemsToFile(items);
                    System.out.println("Add successfully");
                    break;
                case 2:
                    System.out.println("Items:");
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + ". " + items.get(i));
                    }
                    System.out.println("Print all items....");
                    break;
                case 3:
                    System.out.println("Enter item number to update:");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new item name:");
                    String updatedItem = scanner.nextLine();
                    items.set(updateIndex, updatedItem);
                    writeItemsToFile(items);
                    System.out.println("Delete successfully item....");
                    break;
                case 4:
                    System.out.println("Enter item number to delete:");
                    int deleteIndex = scanner.nextInt() - 1;
                    items.remove(deleteIndex);
                    writeItemsToFile(items);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static List<String> readItemsFromFile() {
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return items;
    }

    private static void writeItemsToFile(List<String> items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String item : items) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
