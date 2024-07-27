package task3;

class Book {
    int bookID;
    String title;
    String author;

    Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book ID: " + this.bookID);
        System.out.println("Boot title: " + this.title);
        System.out.println("Author name: " + author);
    }

}
