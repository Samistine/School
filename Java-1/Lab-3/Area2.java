/****************************************
 *      Lab 3                           *
 *      Samuel Seidel                   *
 *      February 7, 2016                *
 ****************************************/

import javax.swing.JOptionPane;

public class Area2 {

    public static void main(String[] args) {
        
        String objectType = JOptionPane.showInputDialog(null,
            "Please enter C for circle, S for square, or R for rectangle"
        );
        
        float area;
        
        switch(objectType) {
            case "C":
                String radius_ = JOptionPane.showInputDialog(null,
                    "Please enter the radius of your circle"
                );
                float radius = Float.parseFloat(radius_);
                area = 3.14f * radius * radius;
                break;
            case "S":
                String side_ = JOptionPane.showInputDialog(null,
                    "Please enter the length of a side of your square"
                );
                float side = Float.parseFloat(side_);
                area = side * side;
                break;
            case "R":
                String height_ = JOptionPane.showInputDialog(null,
                    "Please enter the height of your rectangle"
                );
                float height = Float.parseFloat(height_);
                
                String width_ = JOptionPane.showInputDialog(null,
                    "Please enter the width of your rectangle"
                );
                float width = Float.parseFloat(width_);
                
                area = height * width;    
                break;                
            default:
                area = -1;
        }
        
        JOptionPane.showMessageDialog(null, "Area = " + area);
        
    }
}
