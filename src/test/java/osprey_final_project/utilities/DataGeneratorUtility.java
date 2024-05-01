package osprey_final_project.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGeneratorUtility {

    public static String randomEmail( String email){
        Random random = new Random();
        //samplexxx@gmail.com - > feature file email
        int num = random.nextInt(1000); //0 - 999
        //Find index of @ sign
        int indexOfSign = email.indexOf("@");
        //Find string starting form index 0 to index of @ sign
        String firstHalf = email.substring(0,indexOfSign);
        //Find the string of second starting after firstHalf
        String secondHalf = email.substring(indexOfSign);
        return firstHalf + num + secondHalf;

    }
    public String getCurrentDateInEST() {


        ZoneId estZone = ZoneId.of("America/New_York");
        ZonedDateTime estDateTime = ZonedDateTime.now(estZone);
        LocalDate todayInEST = estDateTime.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String currentDate = todayInEST.format(formatter);
        return currentDate;
    }
    public String getTomorrowDateInEST(){

        ZoneId estZone = ZoneId.of("America/New_York");
        ZonedDateTime estDateTime = ZonedDateTime.now(estZone).plusDays(1);
        LocalDate tomorrowInEST = estDateTime.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String tomorrow = tomorrowInEST.format(formatter);
        return tomorrow;
    }
}
