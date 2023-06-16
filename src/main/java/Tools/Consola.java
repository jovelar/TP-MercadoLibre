package Tools;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class Consola {

    private static Scanner scan = new Scanner(System.in);

    public static void write(Object x){
        JOptionPane.showMessageDialog(null, x);
    }
    public static String readString(String message){
        return JOptionPane.showInputDialog(message);
    }

    public static int readInt(String message){
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }

    public static float readFloat(String message){
        return Float.parseFloat(JOptionPane.showInputDialog(message));

    }
    public static long readLong(String message){
        return Long.parseLong(JOptionPane.showInputDialog(message));

    }

}
