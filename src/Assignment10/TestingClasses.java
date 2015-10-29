package Assignment10;

import java.text.MessageFormat;
import java.util.UUID;

/**
 *
 * @author sseidel
 */
public class TestingClasses {

    public static void main(String[] args) {
        Student student = new Student(
                "Sam",
                "Seidel",
                "Somewhere over the Rainbow",
                "help@samistine.com",
                "Computer Programming", 3.5F);
        Account account = new Account(
                new UUID(2345, 34262346),
                student.getFirstName(),
                100F);
        Book book = new Book(
                "978-3-16-148410-0",
                "Albert Einstein",
                "Electronics",
                22.99F,
                145);
        Pizza pizza = new Pizza(
                "Tacos",
                10,
                25.45F);
        System.out.println(
                MessageFormat.format(
                        "Student, {0}, has purchased the following on account {1}\r\n"
                        + "Book: {2}(Author: {3}, Pages: {4} ISBN: {5}), at a cost of ${6}\r\n"
                        + "Pizza: Pizza(Toppings: {7}, Diameter: {8}), at a cost of ${9}\r\n",
                        student.getFirstName(), account.getAccountNumber(),
                        book.getTitle(), book.getAuthor(), book.getPages(), book.getISBN(), book.getPrice(),
                        pizza.getToppings(), pizza.getDiameter(), pizza.getPrice()));
        System.out.println("Starting balance was " + account.getBalance());
        account.setBalance(account.getBalance() - (book.getPrice() + pizza.getPrice()));
        System.out.println("Current balance is now " + account.getBalance());
    }

}
