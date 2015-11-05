package Assignment11;

/**
 * Assignment 11 Question 3
 * <p>
 * Modify
 * {@link Assignment10.Book the Book class that you built in Assignment #8}. Add
 * to the pseudo-code that you wrote in Assignment #8. Add 2 Constructors to
 * this class. The first Constructor should be the “no args” constructor. This
 * constructor should take no arguments and initialize all the properties to 0
 * or “”(empty string). The second constructor should accept 5 arguments, one
 * for ISBN number, one for author, one for title, one for price and one for
 * number of pages. This data being passed in should be put into the properties
 * of this object.
 *
 * @author sseidel
 */
public class Book {

    private String isbn;
    private String author;
    private String title;
    private float price;
    private int pages;

    public Book() {
        this.isbn = "";
        this.author = "";
        this.title = "";
        this.price = 0;
        this.pages = 0;
    }

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
