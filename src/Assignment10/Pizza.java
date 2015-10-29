package Assignment10;

/**
 * Assignment 10 Question 2<br/>
 * Design a class named Pizza. Data fields include a string field for toppings
 * (such as pepperoni) and num fields for diameter in inches (such as 12) and
 * price (such as 13.99). Include methods to get and set values for each of
 * these fields. Create the class diagram and write the pseudo-code that defines
 * the class.
 *
 * @author sseidel
 */
public class Pizza {

    private String toppings;
    private int diameter;
    private float price;

    public Pizza(String toppings, int diameter, float price) {
        this.toppings = toppings;
        this.diameter = diameter;
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public int getDiameter() {
        return diameter;
    }

    public float getPrice() {
        return price;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
