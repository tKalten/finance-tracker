import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;


public class AssignData extends Data{
    String year;
    String line;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.u");
    LocalDate date;
    String reason;
    Float money;
    String[] lineArray;
    Data data = new Data();


    public AssignData(Scanner sc) {
        for (year = "20"+sc.nextLine();sc.hasNextLine();){
            line = sc.nextLine();
             if (isValidDate(line+"."+year)){
                 date = LocalDate.parse(line + "." + year,this.formatter);
             }
             else if(!(line.equals(""))){
                 lineArray = line.split(" ");
                 reason = "";
                 for (String lineString : lineArray){
                     lineString = lineString.replace(",", ".");
                     if (isFloat(lineString)){
                         money = Float.parseFloat(lineString);
                     }
                     else{
                         reason = reason + " " + lineString;
                     }
                 }
                 data.date.add(date);
                 data.reason.add(reason);
                 data.money.add(money);
            }
        }
    }

    Data getData(){
        return this.data;
    }

    boolean isValidDate(String strDate){
        try {LocalDate.parse(strDate,this.formatter);
        }
        catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

    boolean isFloat(String strNumber){
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

}





