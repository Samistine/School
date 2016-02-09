/****************************************
 *      Lab 3                           *
 *      Samuel Seidel                   *
 *      February 7, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class Area {

    public static void main(String[] args) {
        
        float area = -1;
        
        String objectType = JOptionPane.showInputDialog(null,
            "Please enter C for circle, S for square, or R for rectangle"
        );
        
        if (objectType.equals("C")) {
            String radius_ = JOptionPane.showInputDialog(null,
                "Please enter the radius of your circle"
            );
            float radius = Float.parseFloat(radius_);
            area = 3.14f * radius * radius;
        }
            
        if (objectType.equals("S")) {
            String side_ = JOptionPane.showInputDialog(null,
                "Please enter the length of a side of your square"
            );
            float side = Float.parseFloat(side_);
            area = side * side;
        }
            
        if (objectType.equals("R")) {
            String height_ = JOptionPane.showInputDialog(null,
                "Please enter the height of your rectangle"
            );
            float height = Float.parseFloat(height_);
            
            String width_ = JOptionPane.showInputDialog(null,
                "Please enter the width of your rectangle"
            );
            float width = Float.parseFloat(width_);
            
            area = height * width;
        }
        
        JOptionPane.showMessageDialog(null, "Area = " + area);
        
    }
}
