package assignment4;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MyPreprocessor {

   static PreProcessor preProcessor;

    public static void main(String [] args){
        boolean done = false;
        while (!done) {
            int choice = GetData.getInt("\n1. Open file to process\n2. Quit");

            switch (choice) {
                case 1: // Open the file and process it
                    preProcessor = new PreProcessor();

                if (preProcessor.isValid()) {
                    String s = preProcessor.getContents() + "\n Is a valid file!\nAll brackets, parentheses, curly braces, and comments are balanced.";
                    display(s, "Valid File", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String str = preProcessor.getContents() + "\n Is an invalid file!";

                    display(str, "Invalid File", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
                case 2:
                    done = true;
                break;
                }
            }
        }

    static void display(String s, String heading, int MESSAGE_TYPE){
        JTextArea text = new JTextArea(s,40,60);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane,heading,MESSAGE_TYPE);
    }

}
