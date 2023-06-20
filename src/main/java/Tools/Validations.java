package Tools;


import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
    public boolean validateEmail(String email) {
        boolean isValid=true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            isValid = false;

        }
        return isValid;
    }

    /**
     * Fuerza a mantenerse dentro de un bucle hasta que el usuario ingrese un e-mail valido.
     * @param email String
     * @return String
     */
    public String doUntilValidEmail(String email){
        boolean valid=false;
        do{
            valid=validateEmail(email);
            if(!valid){
                System.out.println("Valor invalido!");
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
    public boolean validateBirthDate(String birthDate){
        boolean isValid=true;
        LocalDate dateToCheck=null;
        LocalDate actualDate=LocalDate.now();
        try{
            dateToCheck = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("d/M/y"));
        }catch(DateTimeException e){
            System.out.println("Formato invalido"+ e.getMessage());
            isValid=false;
        }
        if(isValid){
            Period period=dateToCheck.until(actualDate);
            if(period.getYears()<13){
                System.out.println("Debe ser mayor de 13 anos para poder registrarse");
                isValid=false;
            }
        }
        return isValid;
    }

    public String doUntilValidBirthDate(String birthDate){
        boolean valid=false;
        do{
            valid=validateBirthDate(birthDate);


        }while(!valid);
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
    public boolean validateDNI(int dni){
        boolean status=false;
        if(dni<1000000 && dni>=100000000){
            status=true;
        }
        return status;
    }

}