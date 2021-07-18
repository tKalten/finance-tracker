import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Data { // declare data types
    ArrayList<Integer> index = new ArrayList<Integer>();
    ArrayList<LocalDate> date = new ArrayList<LocalDate>();
    ArrayList<String> reason = new ArrayList<String>();
    ArrayList<Float> money = new ArrayList<Float>();

    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.u");

    ArrayList<Integer> getIndex() { //return data array
        return index;
    }

    ArrayList<LocalDate> getDate() { //return data array
        return date;
    }

    ArrayList<String> getReason() { //return data array
        return reason;
    }

     ArrayList<Float> getMoney() { //return data array
        return money;
    }



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
