package Exceptions;

public class ExistingEmailException extends Exception{
    public ExistingEmailException(String message){
        super(message);
    }
}
