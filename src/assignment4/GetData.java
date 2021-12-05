package assignment4;

import javax.swing.*;

public class GetData {

    public static String getString(String s){
        return JOptionPane.showInputDialog(s);
    }

    public static int getInt(String s){
        int num = 0;
        try{
            num = Integer.parseInt(JOptionPane.showInputDialog(s));
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input, please enter an integer value", "Error" ,JOptionPane.ERROR_MESSAGE);
        }
        return num;
    }

    public static double getDouble(String s){
        double d = 0.0;
        try{
            d = Integer.parseInt(JOptionPane.showInputDialog(s));
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a decimal value", "Error" ,JOptionPane.ERROR_MESSAGE);
        }
        return d;
    }
}
