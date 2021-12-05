package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BasicFile {

    static File f;
    public static String contents;
    JFileChooser choose;

    BasicFile() {

        choose = new JFileChooser(".");
        int status = choose.showOpenDialog(null);
        contents = "";

        try {
            if (status != JFileChooser.APPROVE_OPTION)
                throw new IOException();

            f = choose.getSelectedFile();

            if(!f.exists())
                throw new FileNotFoundException();

            display(f.getName(), "File has been chosen", JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException e) {
            display("File was not found", e.toString(), JOptionPane.WARNING_MESSAGE);

        } catch (IOException e) {
            display("Approve option was not selected", e.toString(), JOptionPane.WARNING_MESSAGE);
        }
    }

    String readFile(){
        LineNumberReader lnr = null;
        String s = "", line = "";

        try{
            lnr = new LineNumberReader(new FileReader(getFile()));

            while ((line = lnr.readLine()) != null){
                s = s + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // try to close the LineNumber Reader
                lnr.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        return s;
    }


    public static void display (String msg, String s, int t){
        JOptionPane.showMessageDialog(null, msg, s, t);
    }

    public boolean isFile(){
        return f.isFile();
    }

    public static File getFile(){
        return f;
    }

}

