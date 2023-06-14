package Tools;

import java.util.Scanner;

public class Consola {
    private static Scanner scan = new Scanner(System.in);

    public static void write(Object x){
        System.out.println(x);
    }
    public static String readString(String message){
        Consola.write(message);
        return scan.nextLine();
    }

    public static int readInt(String message){
        Consola.write(message);
        return scan.nextInt();
    }

    public static float readFloat(String message){
        Consola.write(message);
        return scan.nextFloat();
    }
    public static long readLong(String message){
        Consola.write(message);
        return scan.nextLong();
    }
}
