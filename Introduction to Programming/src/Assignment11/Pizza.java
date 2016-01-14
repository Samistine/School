package Assignment11;

/**
 * Assignment 11 Question 2
 * <p>
 * Modify
 * {@link Assignment10.Pizza the Pizza class that you built in Pizza class that you built in Assignment #8}.
 * Add to the pseudo-code that you wrote in Assignment #8. Add 2 Constructors to
 * this class. The first Constructor should be the “no args” constructor. This
 * constructor should take no arguments and initialize all the properties to 0
 * or “”(empty string). The second constructor should accept 3 arguments, one
 * for toppings, one for diameter and one for price. This data being passed in
 * should be put into the properties of this object.
 *
 * @author sseidel
 */
public class Pizza {

    private String toppings;
    private int diameter;
    private float price;

    public Pizza() {
        this.toppings = "";
        this.diameter = 0;
        this.price = 0;
    }

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
