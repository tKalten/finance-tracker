import java.time.LocalDate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	static String financeFolder;
	static File folder;
	static AssignData assignFinanceData;
	static ReadFiles financeDataIn;

    public static void main(String[] args) {
		financeFolder = "test_lists";
		folder = new File(financeFolder);
		assignFinanceData = new AssignData();





    	for (File file : folder.listFiles()) {
			ReadFiles financeDataIn = new ReadFiles(file);
			assignFinanceData.addFileToDataset(financeDataIn.getSc());
		}

		ArrayList<DataEntry> financeData = assignFinanceData.getDataSet();

    	for (DataEntry entry : financeData) {
    		System.out.println("Date: " + entry.getDate());
			System.out.println("Reason: "+ entry.getReason());
			System.out.println("Money: " + entry.getMoney() + "\n");
		}
    }
}
