import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataEntry { // declare data types

    LocalDate date;
    String reason;
    Float money;

    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.u");

    boolean isFloat(String strNumber){ //check for valid floats
        if (strNumber == null){
            return false;
        }
        try {
            Float.parseFloat(strNumber);
        } catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    boolean isValidDate(String strDate){ //check for valid dates
        try {LocalDate.parse(strDate,this.formatter);
        }
        catch (java.time.format.DateTimeParseException e){
            return false;
        }
        return true;
    }
}
