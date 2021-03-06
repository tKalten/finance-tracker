import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class AssignData extends DataEntry{
    LocalDate tempDate;
    String tempReason;
    Float tempMoney;
    DataEntry tempEntry;
    ArrayList<DataEntry> dataSet = new ArrayList<DataEntry>();


    public AssignData(){ //default constructor

    }

    public void addFileToDataset(Scanner sc) { //class constructor to assign each value to the corresponding data column
        String year;
        for (year = "20"+sc.nextLine(); sc.hasNextLine();){  //define first line of file as year
            String line = sc.nextLine();
             if (isValidDate(line +"."+ year)){   //check if line is a valid tempDate
                 tempDate = LocalDate.parse(line + "." + year,this.formatter); //if yes - store tempDate
             }
             else if(!(line.equals(""))){ // check lines which are not empty and no tempDates
                 String[] lineArray = line.split(" "); //split string at spaces
                 tempReason = "";
                 for (String lineString : lineArray){
                     lineString = lineString.replace(",", "."); //replace , with . for correct float recognition
                     if (isFloat(lineString)){  //check strings for float
                         tempMoney = Float.parseFloat(lineString);
                     }
                     else{
                         tempReason = tempReason + " " + lineString; //combine all other strings which are not floats
                     }
                 }

                 //add to the data array
                 tempEntry = new DataEntry();
                 tempEntry.setDate(tempDate);
                 tempEntry.setReason(tempReason);
                 tempEntry.setMoney(tempMoney);
                 dataSet.add(tempEntry);
            }
        }
    }

    public void printOut(){
        for (DataEntry entry : dataSet) {
            System.out.println("Date: " + entry.getDate());
            System.out.println("Reason: "+ entry.getReason());
            System.out.println("Money: " + entry.getMoney() + "\n");
        }

    }

    ArrayList<DataEntry> getDataSet() {
        Collections.sort(dataSet);
        return dataSet;
    }
}





