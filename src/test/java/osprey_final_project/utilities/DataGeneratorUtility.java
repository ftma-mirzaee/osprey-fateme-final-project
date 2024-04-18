package osprey_final_project.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DataGeneratorUtility {
    public String getCurrentDateInEST() {


        ZoneId estZone = ZoneId.of("America/New_York");
        ZonedDateTime estDateTime = ZonedDateTime.now(estZone);
        LocalDate todayInEST = estDateTime.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String currentDate = todayInEST.format(formatter);
        return currentDate;
    }
    public String getTomorrowDateInEST(){

        ZoneId estZone = ZoneId.of("America/New_York");
        ZonedDateTime estDateTime = ZonedDateTime.now(estZone).plusDays(1);
        LocalDate tomorrowInEST = estDateTime.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String tomorrow = tomorrowInEST.format(formatter);
        return tomorrow;


    }
}
