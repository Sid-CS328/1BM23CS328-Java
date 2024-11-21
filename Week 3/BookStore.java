// Program to display details of various books in a BookStore


import java.util.Scanner;


class Book{
    private String name;
    private String author;
    private double price;
    private int numPages;


    public Book(String name, String author, double price, int numPages){
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }


    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }

    public int getNumPages(){
        return numPages;
    }


    public String toString(){
        return ("Book Name: " + name + "\n" + "Author: " + author + "\n" + "Price: $" + price + "\n" + "Number of Pages: " + numPages);
    }
}



public class BookStore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Book[] books = new Book[n];

        for(int i = 0; i < n; i++){
            System.out.println("\nEnter details for book " + (i + 1) + ":");
            
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Number of Pages: ");
            int numPages = scanner.nextInt();

            scanner.nextLine();

            books[i] = new Book(name, author, price, numPages);
        }


        System.out.println("\n Book Details: ");

        for (Book book : books){
            System.out.println(book);
            System.out.println("-----------------------------");
        }


        scanner.close();
    }
    
}