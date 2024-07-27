package task3;

import java.util.Scanner;

class Library {
    Book[] books;

    Library() {
        this.books = new Book[5];
    }

    Scanner sc = new Scanner(System.in);

    int i = 0;
    public void addBook(Book book) {
        if ( i < books.length) {
           books[i] =  book;
           i += 1;
        }
        else {
            System.out.println("Library is Full cannot store the books");
        }
    }

    public void replaceBook(int bookID) {
        boolean found = false;
        for(int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].bookID == bookID) {
                System.out.println("Enter the new Book title ");
                books[i].title = sc.next();
                sc.nextLine();
                System.out.println("Enter the book Author name ");
                books[i].author = sc.nextLine();
                found  = true;
            }
        }
        if(!found) {
            System.out.println("Book ID: " + bookID + " not found in the library");
        }
    }

    public void displayBook() {
        for ( Book book : books) {
            if (book != null) {
                book.display();
                System.out.println("============================");
            }
        }
    }
}
