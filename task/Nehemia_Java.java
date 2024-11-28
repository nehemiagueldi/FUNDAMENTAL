package task;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Nehemia_Java {
  static String[][] books = {
    {"B-001", "Negeri 5 Menara", "1967", "10000", "50"},
    {"B-002", "Bumi Manusia", "2000", "35000", "30"},
    {"B-003", "Laskar Pelangi", "2006", "50000", "50"},
    {"B-004", "Sang Pemimpi", "2008", "75000", "70"},
    {"B-005", "Perahu Kertas", "2004", "45000", "60"},
    {"B-006", "5 cm", "2005", "85000", "70"},
    {"B-007", "Rindu", "2011", "45000", "90"},
    {"B-008", "Laut Bercerita", "1987", "25000", "80"},
    {"B-009", "Filosofi Kopi", "2006", "85000", "90"},
    {"B-010", "Filosofi Air", "2002", "55000", "0"},
    {"B-011", "Filosofi Tanah", "2001", "35000", "0"},
    {"B-012", "Filosofi Angin", "2000", "75000", "0"}
  };
  public static void main(String[] args) {
    viewMenu();
  }

  public static void viewMenu() {
    Scanner input = new Scanner(System.in);

    // String[][] books = listBooks();

    String invoiceDetails [][] = new String[10][4];
    int invoiceCount = 0;

    System.out.println("\n=== Book Store Menu ===");
    System.out.println("1. View Books");
    System.out.println("2. Place Order");
    System.out.println("3. Make a Payment");
    System.out.println("4. Exit");
    System.out.print("Choose an Option: ");
    int numMenu = input.nextInt();

    switch (numMenu) {
      case 1:
        viewBooks();
        break;
    
      case 2:
        invoiceCount = placeOrder(input, invoiceDetails, invoiceCount);
        break;
    
      case 3:
        makePayment(input, invoiceDetails, invoiceCount);
        break;
    
      case 4:
        System.out.println("Thankyou for visiting!");
        break;
    
      default:
        System.out.println("Invalid Menu");
        break;
    }
  }

  // public static String[][] listBooks () {
  //   return new String[][] {
  //     {"Negeri 5 Menara", "1967", "10000", "50"},
  //     {"Bumi Manusia", "2000", "35000", "30"},
  //     {"Laskar Pelangi", "2006", "50000", "50"},
  //     {"Sang Pemimpi", "2008", "75000", "70"},
  //     {"Perahu Kertas", "2004", "45000", "60"},
  //     {"5 cm", "2005", "85000", "70"},
  //     {"Rindu", "2011", "45000", "90"},
  //     {"Laut Bercerita", "1987", "25000", "80"},
  //     {"Filosofi Kopi", "2006", "85000", "90"}
  //   };
  // }

  public static void viewBooks() {
    System.out.println("\nList Books:");
    System.out.println("---------------------------------------------------------");
    System.out.printf("%-4s %-17s %-8s %-15s %-10s\n", "No", "Book Name", "Year", "Price", "Stock");
    System.out.println("---------------------------------------------------------");
    for (int i = 0; i < books.length; i++) {
      String name = books[i][1];
      String year = books[i][2];
      String price = formatCurrency(Integer.parseInt(books[i][3]));
      String stock = books[i][4];
      // System.out.println((i + 1) + ". " + name + " (" + year + ")" + " - " + price + " | Stock: " + stock);
      System.out.printf("%-4d %-17s %-8s %-15s %-10s\n", (i + 1), name, year, price, stock);
    }
  }

  public static void filterBooks (){
    System.out.println("\nAvailable Books:");
    System.out.println("---------------------------------------------------------");
    System.out.printf("%-4s %-17s %-8s %-15s %-10s\n", "No", "Book Name", "Year", "Price", "Stock");
    System.out.println("---------------------------------------------------------");

    // Tampilkan hanya buku dengan stok > 0
    for (int i = 0; i < books.length; i++) {
      int stock = Integer.parseInt(books[i][4]);
      if (stock > 0) {
        String name = books[i][1];
        String year = books[i][2];
        String price = formatCurrency(Integer.parseInt(books[i][3]));
        System.out.printf("%-4d %-17s %-8s %-15s %-10s\n", (i + 1), name, year, price, stock);
      }
    }
  }

  public static int placeOrder(Scanner input, String[][] invoiceDetails, int invoiceCount) {
    // viewBooks();

    filterBooks();

    System.out.print("\nSelect the number of the book you want to order: ");
    int bookNumber = input.nextInt();

    if (bookNumber >= 1 && bookNumber <= books.length) {
      int index = bookNumber - 1;
      String bookId = books[index][0];
      String selectedBook = books[index][1];
      int price = Integer.parseInt(books[index][3]);
      int availableStock = Integer.parseInt(books[index][4]);

      System.out.print("Enter the number of the books you want to order: ");
      int bookAmount = input.nextInt();

      if (bookAmount > 0) {
        int processedAmount = Math.min(bookAmount, availableStock);
        int totalPrice = calculateTotalPrice(price, bookAmount);
        books[index][4] = calculateStock(availableStock, bookAmount);
        String remainingStock = books[index][4];

        invoiceDetails[invoiceCount][0] = bookId;  // ID buku
        invoiceDetails[invoiceCount][1] = selectedBook;  // Nama buku
        invoiceDetails[invoiceCount][2] = String.valueOf(processedAmount); // Jumlah buku
        invoiceDetails[invoiceCount][3] = String.valueOf(totalPrice); // Total harga
        invoiceCount++;

        displayOrder(selectedBook, price, bookAmount, totalPrice, remainingStock, processedAmount);

        choiceOrder(input, invoiceDetails, invoiceCount);
      } else {
        displayOutofStock(selectedBook, availableStock);
      }
    } else {
        System.out.println("Invalid book number. Please try again.");
    }
    return invoiceCount;
  }

  public static int calculateTotalPrice(int price, int quantity) {
    return price * quantity;
  }

  public static String calculateStock(int availableStock, int bookAmount){
    return String.valueOf(availableStock - bookAmount);
  }

  public static void displayOrder(String selectedBook, int price, int bookAmount, int totalPrice, String remainingStock, int processedAmount) {
    System.out.println("\nYou have selected: " + selectedBook +
        " (" + formatCurrency(price) + ") with a total of " + bookAmount + " books");
    System.out.println("Total Price: " + formatCurrency(totalPrice));
    System.out.println("Remaining Stock: " + remainingStock);
    System.out.println("Please continue your purchase by making payment.");
    if (processedAmount < bookAmount) {
      System.out.println("Note: Your order exceeded available stock. Only " + processedAmount +
      " books have been processed.");
    }
  }

  public static void displayOutofStock(String selectedBook, int availableStock) {
    System.out.println("Insufficient stock!");
    System.out.println("Available stock of " + '"' + selectedBook + '"' + " books" + ": " + availableStock);
  }

  public static void choiceOrder(Scanner input, String[][] invoiceDetails, int invoiceCount) {
    System.out.println("\nWhat would you like to do next?");
    System.out.println("1. Make a Payment");
    System.out.println("2. Add Another Book");
    System.out.println("3. Back to Menu");
    System.out.print("Enter your choice: ");
    int nextChoice = input.nextInt();

    switch (nextChoice) {
      case 1:
        makePayment(input, invoiceDetails, invoiceCount);
        break;
      case 2:
        invoiceCount = placeOrder(input, invoiceDetails, invoiceCount);
        break;
      case 3:
        viewMenu();
        break;
      default:
        System.out.println("Invalid choice. Returning to menu.");
        viewMenu();
        break;
    }
  }

  public static void makePayment(Scanner input, String[][] invoiceDetails, int invoiceCount) {
    if (invoiceCount == 0) {
      System.out.println("\nNo order have been placed. Please place an order first.");
      System.out.println("1. Back to Menu");
      System.out.println("2. Exit");
      System.out.print("Enter your choice: ");
      int choice = input.nextInt();

      switch (choice) {
        case 1:
          viewMenu();
          break;

        case 2:
          System.out.println("Thankyou for visiting!");
          break;
      
        default:
          System.out.println("Invalid Menu");
          break;
      }
    } else {
      System.out.println("\n=== Invoice ===");
      System.out.println("------------------------------------------------------------------");
      System.out.printf("%-4s %-17s %-15s %-12s %-15s\n", "No", "Book Name", "Price", "Quantity", "Total Price");
      System.out.println("------------------------------------------------------------------");
      int grandTotal = 0;
      for (int i = 0; i < invoiceCount; i++) {
        String bookId = invoiceDetails[i][0];
        int bookIndex = findBookIndex(bookId);
        String bookName = invoiceDetails[i][1];
        int price = Integer.parseInt(books[bookIndex][3]);
        int quantity = Integer.parseInt(invoiceDetails[i][2]);
        int totalPrice = Integer.parseInt(invoiceDetails[i][3]);
  
        grandTotal += totalPrice;

        System.out.printf("%-4d %-17s %-15s %-12d %-15s\n", (i + 1), bookName, formatCurrency(price), quantity, formatCurrency(totalPrice));
      }
      System.out.println("\nGrand Total: " + formatCurrency(grandTotal));
  
      System.out.println("\nChoose Payment Method:");
      System.out.println("1. COD");
      System.out.println("2. Virtual Account");
      System.out.println("3. QRIS");
      System.out.println("4. Paylater");
      System.out.println("5. Cicilan");
      System.out.print("Enter your choice: ");
      int paymentChoice = input.nextInt();
  
      String paymentMethod = getPaymentMethod(paymentChoice);
  
      if (paymentChoice != 0 && paymentChoice <= 5) {
        System.out.println("Payment Successful using " + paymentMethod + " with Grand Total " + formatCurrency(grandTotal));
      } else {
        System.out.println("Invalid Payment Method. Please try again.");
      }
    }
  }

  public static int findBookIndex(String bookId) {
    int bookIdx = 0;
    for (int i = 0; i < books.length; i++) {
      if (books[i][0].equals(bookId)) {
        bookIdx = i;
      }
    }
    return bookIdx;
  }

  public static String getPaymentMethod(int choice) {
    switch (choice) {
      case 1:
        return "COD";
    
      case 2:
        return "Virtual Account";
    
      case 3:
        return "QRIS";
    
      case 4:
        return "Paylater";
    
      case 5:
        return "Cicilan";
    
      default:
        return "Invalid Payment Method";
    }
  }

  public static String formatCurrency(int price) {
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    return currencyFormat.format(price);
  }
}
