package Tools;

import javax.lang.model.util.ElementScanner6;
import javax.swing.*;

import java.awt.*;
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

        if (optionEntered == null) {
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
            showMessageError("¡EL VALOR INGRESADO DEBE SER UN NUMERO ENTERO!");
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
            if (aux != null) {
                number = Long.parseLong(aux);
            } else {
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


    public static String systemOptions(boolean userConected) {

        String chosenOption;

            if(userConected){
                chosenOption = (String) JOptionPane.showInputDialog(
                        null,
                        "SELECCIONE UNA OPCION\n\n",
                        "OPCIONES MENU PRINCIPAL",
                        JOptionPane.QUESTION_MESSAGE,
                        null,  // null para icono defecto
                        new Object[] { "VER MI PERFIL", "MIS COMPRAS", "FAVORITOS", "CARRITO", "VER UN PRODUCTO",
                                "VER MAS PRODUCTOS", "BUSCAR","VER CATEGORIAS","VER MI SALDO", "SALIR"},
                        "VER MI PERFIL");
            } else {

                chosenOption = (String) JOptionPane.showInputDialog(
                        null,
                        "SELECCIONE UNA OPCION\n\n",
                        "OPCIONES MENU PRINCIPAL",
                        JOptionPane.QUESTION_MESSAGE,
                        null,  // null para icono defecto
                        new Object[] {"CREAR CUENTA", "INGRESAR", "VER UN PRODUCTO",
                                "VER MAS PRODUCTOS", "VER CATEGORIAS", "SALIR"},
                        "CREAR CUENTA");
            }

            if(chosenOption == null)
                chosenOption = "SALIR";

            return chosenOption;
        }

    public static int systemOptionsCreateAccount(){ //verificado
        //si se presiona la cruz(X) se retorna -1
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

    public static String systemOptionsAdministrator() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                    null,
                    "SELECCIONE UNA OPCION\n\n",
                    "OPCIONES MENU ADMINISTRATOR",
                    JOptionPane.QUESTION_MESSAGE,
                    null,  // null para icono defecto
                    new Object[] { "VER MI PERFIL","ADMINISTRAR EMPRESAS", "ADMINISTRAR CLIENTES", "AGREGAR ADMINISTRADORES", "MOSTRAR ADMINISTRADORES", "DAR DE BAJA MI CUENTA", "SALIR"},
                    "VER MI PERFIL");

        if(chosenOption == null)
            chosenOption = "SALIR";

        return chosenOption;
    }

    public static String systemOptionsCategories() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                null,
                "SELECCIONE UNA CATEGORIA\n\n",
                "OPCIONES MENU CATEGORIAS",
                JOptionPane.QUESTION_MESSAGE,
                null,  // null para icono defecto
                new Object[] { "TECNOLOGIA","MODA", "VEHICULOS", "SUPERMECADO","VOLVER AL MENU PRINCIPAL"},
                "TECNOLOGIA");

        if(chosenOption == null)
            chosenOption = "VOLVER AL MENU PRINCIPAL";

        return chosenOption;
    }
    public static String systemOptionsABMLenterprise() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                null,
                "SELECCIONE UNA OPCION\n\n",
                "ADMINISTRAR EMPRESAS",
                JOptionPane.QUESTION_MESSAGE,
                null,  // null para icono defecto
                new Object[] { "AGREGAR NUEVA EMPRESA","BAJA DE EMPRESA", "MODIFICAR EMPRESA", "VER EMPRESAS",
                        "VOLVER AL MENU PRINCIPAL"},
                "AGREGAR NUEVA EMPRESA");


        if(chosenOption == null)
            chosenOption = "VOLVER AL MENU PRINCIPAL";

        return chosenOption;
    }
    public static String systemOptionsABMLbuyer() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                null,
                "SELECCIONE UNA OPCION\n\n",
                "ADMINISTRAR CUENTAS PERSONALES",
                JOptionPane.QUESTION_MESSAGE,
                null,  // null para icono defecto
                new Object[] { "AGREGAR NUEVA CUENTA PERSONAL","BAJA DE CUENTA PERSONAL", "MODIFICAR CUENTA PERSONAL",
                        "VER CUENTAS PERSONALES","VOLVER AL MENU PRINCIPAL"},
                "AGREGAR NUEVA CUENTA PERSONAL");


        if(chosenOption == null)
            chosenOption = "VOLVER AL MENU PRINCIPAL";

        return chosenOption;
    }
    public static String systemOptionsModifyAdministrator() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                    null,
                    "SELECCIONE UNA OPCION\n\n",
                    "OPCIONES MODIFICAR ADMINISTRADOR",
                    JOptionPane.QUESTION_MESSAGE,
                    null,  // null para icono defecto
                    new Object[] { "MODIFICAR NOMBRE DE USUARIO", "MODIFICAR EMAIL","MODIFICAR CONTRASEÑA",
                            "MODIFICAR APELLIDO", "MODIFICAR APELLIDO", "MODIFICAR FECHA DE NACIMIENTO", "MODIFICAR NUMERO DE TELEFONO",
                            "MODIFICAR TODO", "SALIR"},
                    "MODIFICAR NOMBRE DE USUARIO");


        if(chosenOption == null)
            chosenOption = "SALIR";

        return chosenOption;
    }

    public static int buttonsModifyAndReturn(){ //verificado
        return JOptionPane.showOptionDialog(
                null,
                "Elija una opcion:",
                "Opciones de mi cuenta",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { "MODIFICAR MI PERFIL", "VOLVER" },   // null para YES, NO y CANCEL
                "null");


    }

    public static int buttonsModifyGeneralAndReturn(){ //verificado
        return JOptionPane.showOptionDialog(
                null,
                "Elija una opcion:",
                "Opciones de mi cuenta",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { "MODIFICAR PERFIL", "VOLVER" },   // null para YES, NO y CANCEL
                "null");


    }


    public static int buttonsYesNo(){ //verificado
        return JOptionPane.showOptionDialog(
                null,
                "¿Está seguro de continuar?",
                "Elija una opcion:",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { "SI", "NO" },   // null para YES, NO y CANCEL
                "null");


    }


    public static String enterPassword(){
        String password;
        JPanel panel = new JPanel(new GridLayout(3,1));
        JLabel label = new JLabel("Contraseña:");
        JLabel label1 = new JLabel("Mínimo 8 carácteres");


        // Definimos el largo de la casilla para la contraseña
        JPasswordField passwordField = new JPasswordField(15);
        // Agregamos los componentes al panel
        panel.add(label);
        panel.add(passwordField);
        panel.add(label1);

        // Definimos el texto de las opciones para aceptar o cancelar
        String[] options = new String[]{"Aceptar", "Cancelar"};

        // Agregamos el panel y las opciones al dialogo
        int option = JOptionPane.showOptionDialog(null, panel, "Ingreso de Contraseña",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if(option == 0){
            password = new String(passwordField.getPassword());

        }else{
            password = "SALIR";
        }
        return password;
    }

    public static void cleanConsole() {
        for(int i=0; i<20; i++) {
            System.out.print("\n");
        }
    }

    public static String systemOptionsEnterprise() {

        String chosenOption= (String) JOptionPane.showInputDialog(
            null,
            "SELECCIONE UNA OPCION\n\n",
            "OPCIONES MENU PRINCIPAL ADMINISTRATOR",
            JOptionPane.QUESTION_MESSAGE,
            null,  // null para icono defecto
            new Object[] { "VER MI PERFIL","AGREGAR PRODUCTO", "MODIFICAR PRODUCTO", "SALIR"},
                    //"DAR DE BAJA UN PRODUCTO",
                    //"DAR DE BAJA MI CUENTA", "SALIR"},
            "VER MI PERFIL");

        if(chosenOption == null)
            chosenOption = "SALIR";

        return chosenOption;
    }

    public static String systemOptionsModifyEnterprise() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                null,
                "SELECCIONE UNA OPCION\n\n",
                "OPCIONES MODIFICAR USARIO-EMPRESA",
                JOptionPane.QUESTION_MESSAGE,
                null,  // null para icono defecto
                new Object[] { "MODIFICAR NOMBRE DE USUARIO", "MODIFICAR EMAIL","MODIFICAR CONTRASEÑA",
                        "MODIFICAR NOMBRE", "MODIFICAR APELLIDO", "MODIFICAR FECHA DE NACIMIENTO",
                        "MODIFICAR NUMERO DE TELEFONO", "MODIFICAR NOMBRE DE LA EMPRESA",
                        "MODIFICAR PROVINCIA", "MODIFICAR CIUDAD", "MODIFICAR  DIRECCION",
                        "MODIFICAR CODIGO POSTAL", "MODIFICAR TODO", "SALIR"},
                "MODIFICAR NOMBRE DE USUARIO");

        if(chosenOption == null)
            chosenOption = "SALIR";

        return chosenOption;
    }
    public static String systemOptionsModifyBuyer() {

        String chosenOption= (String) JOptionPane.showInputDialog(
                null,
                "SELECCIONE UNA OPCION\n\n",
                "OPCIONES MODIFICAR CUENTA PERSONAL",
                JOptionPane.QUESTION_MESSAGE,
                null,  // null para icono defecto
                new Object[] { "MODIFICAR NOMBRE DE USUARIO", "MODIFICAR EMAIL","MODIFICAR CONTRASEÑA",
                        "MODIFICAR APELLIDO", "MODIFICAR FECHA DE NACIMIENTO", "MODIFICAR NUMERO DE TELEFONO",
                         "MODIFICAR PROVINCIA", "MODIFICAR CIUDAD",
                        "MODIFICAR  DIRECCION", "MODIFICAR CODIGO POSTAL", "MODIFICAR TODO", "SALIR"},
                "MODIFICAR NOMBRE DE USUARIO");

        if(chosenOption == null)
            chosenOption = "SALIR";

        return chosenOption;

    }


    public static int systemOptionsDeleteFavorites() { //verificado
        return JOptionPane.showOptionDialog(
                null,
                "Elija una opcion:",
                "Favoritos",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[]{"ELIMINAR FAVORITOS", "VOLVER"},   // null para YES, NO y CANCEL
                "null");

    }

    public static int systemOptionsProductFromCart() { //verificado
        return JOptionPane.showOptionDialog(
                null,
                "Elija una opcion:",
                "Carrito",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[]{"COMPRAR CARRITO","ELIMINAR PRODUCTO", "VOLVER"},   // null para YES, NO y CANCEL
                "null");

    }

    public static int systemOptionsbuyProduct() { //verificado
        return JOptionPane.showOptionDialog(
                null,
                "Elija una opcion:",
                "Comprar",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[]{"COMPRAR","AGREGAR AL CARRITO","AGREGAR A FAVORITOS", "VOLVER"},   // null para YES, NO y CANCEL
                "null");

    }
    public static int systemOptionsBuyPayMethod() { //verificado
        return JOptionPane.showOptionDialog(
                null,
                "Elija una opcion:",
                "Método de pago",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[]{"DINERO DISPONIBLE","TARJETA"},   // null para YES, NO y CANCEL
                "null");

    }
}



