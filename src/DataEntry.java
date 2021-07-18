import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataEntry implements Comparable<DataEntry>{ // declare data types

    private LocalDate date;
    private String reason;
    private Float money;

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
    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getReason(){
        return this.reason;
    }

    public void setReason(String reason){
        this.reason = reason;
    }

    public float getMoney(){
        return this.money;
    }

    public void setMoney(Float money){
        this.money = money;
    }

    @Override
    public int compareTo(DataEntry dEntry) {
        int i = getDate().compareTo(dEntry.getDate());
        if (i!=0) return i;
        return getReason().compareTo(dEntry.getReason());
    }
}
