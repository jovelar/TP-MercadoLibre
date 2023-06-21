package Tools;

import javax.lang.model.util.ElementScanner6;
import javax.swing.*;

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
            String optionEntered = JOptionPane.showInputDialog(message);
            if(optionEntered == null){
                optionEntered = "SALIR";
            }
            return optionEntered;
        }

        public static int readInt(String message) {
            int number = -1;
            try {
                String aux = JOptionPane.showInputDialog(message);
                if(aux != null){
                    number = Integer.parseInt(aux);
                }else{
                    number = 0; //cuando se oprime cancelar o la cruz(X), se retorna 0
                }

            } catch (NumberFormatException e) {
                showMessage("Numero invalido");
            }
            return number;
        }

        public static float readFloat(String message) {
            return Float.parseFloat(JOptionPane.showInputDialog(message));

        }

    public static long readLong(String message) {
        long number = -1;
        try {
            String aux = JOptionPane.showInputDialog(message);
            if(aux != null){
                number = Long.parseLong(aux);
            }else{
                number = 0; //cuando se oprime cancelar o la cruz(X), se retorna 0
            }

        } catch (NumberFormatException e) {
            showMessage("Numero invalido");
        }
        return number;
    }

        public static double readDouble(String message) {
            return Double.parseDouble(JOptionPane.showInputDialog(message));

        }

        public static String systemOptions() { //verificado
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

        public static int systemOptionsCreateAccount(){ //verificado
            return JOptionPane.showOptionDialog(
                    null,
                    "Elija una opcion:",
                    "Crear cuenta",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "CUENTA PERSONAL", "CUENTA EMPRESA" },   // null para YES, NO y CANCEL
                    "null");


        }
        public static String enterPassword(){
            String password;
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Contraseña:");
            // Definimos el largo de la casilla para la contraseña
            JPasswordField passwordField = new JPasswordField(15);
            // Agregamos los componentes al panel
            panel.add(label);
            panel.add(passwordField);

            // Definimos el texto de las opciones para aceptar o cancelar
            String[] options = new String[]{"Aceptar", "Cancelar"};

            // Agregamos el panel y las opciones al dialogo
            int option = JOptionPane.showOptionDialog(null, panel, "Ingreso de Contraseña",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if(option == 0){
                password = new String(passwordField.getPassword());
                if(password.equals("")){
                    password = "SALIR";
                }
            }else{
                password = "SALIR";
            }
            return password;
        }

        public static void cleanConsole() {
            for(int i=0; i<20; i++) {
                System.out.println("\n");
            }
        }

}



