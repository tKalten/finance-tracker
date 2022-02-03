import java.io.IOException;
import java.time.LocalDate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Main {
	static String financeFolder;
	static File folder;
	static AssignData assignFinanceData;
	static ReadFiles financeDataIn;

    public static void main(String[] args) throws IOException {
		financeFolder = "expenses";
		folder = new File(financeFolder);
		assignFinanceData = new AssignData();


    	for (File file : Objects.requireNonNull(folder.listFiles())) {
			ReadFiles financeDataIn = new ReadFiles(file);
			assignFinanceData.addFileToDataset(financeDataIn.getSc());
		}

		ArrayList<DataEntry> financeData = assignFinanceData.getDataSet();

    	new WriteFiles(financeData);
    }
}
