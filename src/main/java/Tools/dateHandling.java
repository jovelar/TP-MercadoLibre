package Tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class dateHandling {

    public static LocalDate calculateDeliveryDate(){
        Random random = new Random();
        int cantDiasRandom = random.nextInt(1, 11);

        return LocalDate.now().plusDays(cantDiasRandom);
    }
    public static String convertLocalDateToString(LocalDate deliveryDateLocalDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/u");
        return deliveryDateLocalDate.format(formatter);

    }

    public static LocalDate convertStringToLocalDate(String date){
        return LocalDate.parse(date);

    }


}
