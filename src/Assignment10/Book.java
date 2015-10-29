package Assignment10;

/**
 * Assignment 10 Question 3<br/>
 * Design a class named Book that holds a ISBN number, author, title, price, and
 * number of pages for the book. Include methods to get and set the values for
 * each data field. Write the pseudo-code that defines the class.
 *
 * @author sseidel
 */
public class Book {

    private String isbn;
    private String author;
    private String title;
    private float price;
    private int pages;

    public Book(String isbn, String author, String title, float price, int pages) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
        this.pages = pages;
    }

    public String getISBN() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
