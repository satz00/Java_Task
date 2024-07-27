package task3;


import java.util.Scanner;

public class BookManagementSystem {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int input;
        boolean loop = true;
        do {
            System.out.println("****************OPTIONS********************");
            System.out.println("***Press 1 for Add book********************");
            System.out.println("***Press 2 for Replace book****************");
            System.out.println("***Press 3 for Display books***************");
            System.out.println("***Press 4 for Exit************************");
            System.out.println("*******************************************");
            System.out.println();
            System.out.println("Enter your option");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter the book ID");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the book Name");
                    String bookName = sc.nextLine();
                    System.out.println("Enter the Author name");
                    String authorName = sc.nextLine();
                    library.addBook(new Book(id, bookName, authorName));
                    break;

                case 2:
                    System.out.println("Enter the ID of the book to replace");
                    int bookID = sc.nextInt();
                    library.replaceBook(bookID);
                    break;

                case 3:
                    library.displayBook();
                    break;

                case 4:
                    loop = false;
                    break;
            }
        }while (loop);

    }
}
