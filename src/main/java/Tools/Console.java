package Tools;

import javax.lang.model.util.ElementScanner6;
import javax.swing.JOptionPane;

import java.util.Scanner;

public final class Console {

        private static Scanner scan = new Scanner(System.in);

        public static void showMessage(String message) {
            JOptionPane.showMessageDialog(null, message);
        }

        public static void showMessageError(String message) {
            JOptionPane.showMessageDialog(null, message, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }

        public static String readString(String message) {
            return JOptionPane.showInputDialog(message);
        }

        public static int readInt(String message) {
            return Integer.parseInt(JOptionPane.showInputDialog(message));
        }

        public static float readFloat(String message) {
            return Float.parseFloat(JOptionPane.showInputDialog(message));

        }

        public static long readLong(String message) {
            return Long.parseLong(JOptionPane.showInputDialog(message));

        }
        public static double readDouble(String message) {
            return Double.parseDouble(JOptionPane.showInputDialog(message));

        }

        public static String systemOptions() {
            String chosenOption;

            chosenOption = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione opcion",
                    "Selector de opciones",
                    JOptionPane.QUESTION_MESSAGE,
                    null,  // null para icono defecto
                    new Object[] { "CREAR CUENTA", "INGRESAR", "MIS COMPRAS", "CARRITO", "VER PRODUCTO",
                            "VER TODOS LOS PRODUCTOS", "VER CATEGORIAS", "SALIR"},
                    "CREAR CUENTA");

                if(chosenOption == null)
                    chosenOption = "SALIR";

            return chosenOption;
        }

        public static void cleanConsole() {
            for(int i=0; i<20; i++) {
                System.out.println("\n");
            }
        }
    }



