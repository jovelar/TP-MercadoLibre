package Tools;
import javax.swing.JOptionPane;
import java.util.Scanner;


public final class Console {
    private static Scanner scan = new Scanner(System.in);

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
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
