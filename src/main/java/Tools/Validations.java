package Tools;


import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import org.w3c.dom.Text;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public Validations(){}

    public boolean isNumber(){

        return true;
    }

    /**
     * Valida un email, desde una cadena de texto. Hace uso de la depdendecia Jakarta Mail
     * @param email String
     * @return True o False
     */
    public static boolean validateEmail(String email) {
        boolean isValid=true;
        if(!email.isBlank()){
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
            } catch (AddressException ex) {
                isValid = false;
            }
        }else{
            isValid=false;
        }
        return isValid;
    }

    /**
     * Fuerza a mantenerse dentro de un bucle hasta que el usuario ingrese un e-mail valido.
     * @param email String
     * @return String
     */
    public static String doUntilValidEmail(String email){
        boolean valid=false;
        do{
            valid=validateEmail(email);
            if(!valid){
                Console.showMessageError("Valor invalido!");
                email=Console.readString("Ingrese la direccion de email");
            }
        }while(!valid);
        return email;
    }
    /**
     * Valida el formato de la fecha y si es mayor de 13 anos
     * @param birthDate String
     * @return true si es valida, false si no lo es
     */
    public static boolean validateBirthDate(String birthDate){
        boolean isValid=true;
        LocalDate dateToCheck=null;
        LocalDate actualDate=LocalDate.now();
        try{
            dateToCheck = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("d/M/y"));
        }catch(DateTimeException e){
            Console.showMessageError("Formato invalido");
            isValid=false;
        }
        if(isValid){
            Period period=dateToCheck.until(actualDate);
            if(period.getYears()<13){
                Console.showMessageError("Debe ser mayor de 13 anos para poder registrarse");
                isValid=false;
            }
        }
        return isValid;
    }

    public static String doUntilValidBirthDate(String birthDate){
        boolean valid=false;
        if(!birthDate.isBlank()){
            do{
                valid=validateBirthDate(birthDate);
                if(!valid){
                    System.out.println("Valor invalido!");
                    birthDate=Console.readString("Ingrese una fecha con el formato dd/mm/aaaa");
                }
            }while(!valid);
        }
        return birthDate;
    }
    public boolean isProductAvailable(String idProduct){
        return true;
    }

    /**
     * Valida si el email se encuentre entre 1.000.000 y 100.000.000
     * (por debajo de un millon no deberia estar vivo o es una momia)
     * @param dni Integer
     * @return true si es valido, false si no lo es
     */
    public static boolean validateDNI(int dni){
        boolean status=false;
        if(dni>1000000 && dni>=100000000){
            status=true;
        }
        return status;
    }
    public static int doUntilValidDNI(int dni){
        boolean valid=false;
        do{
            valid=validateDNI(dni);
            if(!valid){
                Console.showMessageError("Dni invalido");
                dni=Console.readInt("Ingrese su dni");
            }
        }while(!valid);

        return dni;
    }

    /**
     * Valida nombres y apellidos, no permite numeros ni caracteres especiales mas alla de guion
     * @param name String
     * @return True o False
     */
    public static boolean validateName(String name){
        boolean valid=false;
        if(!name.isBlank()){
            String regex="^[\\p{L} .'-]+$";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(name);
            valid=matcher.matches();
        }
        return valid;
    }

    /**
     * Fuerza a que el usuario ingrese un nombre/apellido valido, devuelve un String una vez que sea valido
     * @param name String
     * @return String
     */
    public static String doUntilValidName(String name){
        boolean valid=false;
        do{
            valid=validateName(name);
            if(!valid){
                name=Console.readString("Ingrese un nombre/apellido valido");
            }

        }while(!valid);
        return name;
    }

    /**
     * Valida numeros de telefonos, deben tener mas de 6 digitos y menos de 15
     * @param phoneNumber long
     * @return true o false
     */
    public static boolean validatePhoneNumber(long phoneNumber){
        boolean valid=false;
        if(phoneNumber!=-1){
            if(String.valueOf(phoneNumber).length()>6 && String.valueOf(phoneNumber).length()<15){
                valid=true;
            }
        }
        return valid;
    }

    /**
     * Fuerza a que se ingrese un telefono valido
     * @param phoneNumber long
     * @return long
     */
    public static long doUntilValidPhoneNumber(long phoneNumber){
        boolean valid=false;
        do{
        valid=validatePhoneNumber(phoneNumber);
            if(!valid){
                phoneNumber=Console.readLong("Ingrese un telefono válido");
            }
        }while(!valid);
        return phoneNumber;
    }

    /**
     * Valida si el numero ingresado es 0 o mayor.
     * @param number
     * @return boolean
     */
    public static boolean validateInt(int number){
        boolean valid=false;
            if(number>=0){
                valid=true;
            }

        return valid;
    }

    /**
     * Fuerza a que el usuario ingrese un numero valido.
     * @param number Integer
     * @return Integer
     */
    public static int doUntilValidNumber(int number){
        boolean valid=false;
        do{
            valid=validateInt(number);
            if(!valid){
                Console.showMessageError("Valor invalido");
            }
        }while(!valid);

        return number;
    }

    public static boolean validatePostalCode(int postalCode){
        boolean valid=false;
        if(String.valueOf(postalCode).length()==4){
            valid=true;
        }
        return valid;
    }

    public static int doUntilValidPostalCode(int postalCode){
        boolean valid=false;
        do{
            valid=validatePostalCode(postalCode);
            if(!valid){
                Console.showMessageError("Codigo postal invalido!");
                postalCode=Console.readInt("Ingrese los 4 digitos del codigo postal: ");
            }
        }while(!valid);
        return postalCode;
    }

}
