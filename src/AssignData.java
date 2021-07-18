import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignData extends DataEntry{
    LocalDate tempDate;
    String tempReason;
    Float tempMoney;
    Integer tempIndex;
    DataEntry tempEntry = new DataEntry();
    ArrayList<DataEntry> dataSet = new ArrayList<DataEntry>();


    public AssignData(){ //default constructor

    }

    public void addFileToDataset(Scanner sc) { //class constructor to assign each value to the corresponding data column
        String year;
        tempIndex = 0;
        for (year = "20"+sc.nextLine(); sc.hasNextLine();){  //define first line of file as year
            String line = sc.nextLine();
             if (isValidDate(line +"."+ year)){   //check if line is a valid tempDate
                 tempDate = LocalDate.parse(line + "." + year,this.formatter); //if yes - store tempDate
             }
             else if(!(line.equals(""))){ // check lines which are not empty and no tempDates
                 tempIndex++;
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
                 tempEntry.date = tempDate;
                 tempEntry.reason = tempReason;
                 tempEntry.money = tempMoney;
                 dataSet.add(tempEntry);
            }
        }
    }

    ArrayList<DataEntry> getDataSet() {
        return dataSet;
    }


}





