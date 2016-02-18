/****************************************
 *      Lab 5                           *
 *      Samuel Seidel                   *
 *      February 18, 2016               *
 ****************************************/

import javax.swing.JOptionPane;

public class Area {

    public static void main(String[] args) {

        do {
            String objectType = JOptionPane.showInputDialog(null,
                "Please enter C for circle, S for square, or R for rectangle"
            );

            switch(objectType) {
                case "C":
                    circle();
                    break;
                case "S":
                    square();
                    break;
                case "R":
                    rectangle();
                    break;
                default:
                    //do nothing
                    continue;
            }

        } while (
            !"X".equals(
                JOptionPane.showInputDialog(null,
                    "Do you want to continue? Enter \"X\" to stop"
                )
            )
        );

    }

    static void circle() {
        String radius_ = JOptionPane.showInputDialog(null,
            "Please enter the radius of your circle"
        );
        float radius = Float.parseFloat(radius_);
        float area = 3.14f * radius * radius;
        JOptionPane.showMessageDialog(null, "Area = " + area);
    }

    static void square() {
        String side_ = JOptionPane.showInputDialog(null,
            "Please enter the length of a side of your square"
        );
        float side = Float.parseFloat(side_);
        float area = side * side;
        JOptionPane.showMessageDialog(null, "Area = " + area);
    }

    static void rectangle() {
        String height_ = JOptionPane.showInputDialog(null,
            "Please enter the height of your rectangle"
        );
        float height = Float.parseFloat(height_);

        String width_ = JOptionPane.showInputDialog(null,
            "Please enter the width of your rectangle"
        );
        float width = Float.parseFloat(width_);

        float area = height * width;
        JOptionPane.showMessageDialog(null, "Area = " + area);
    }

}
