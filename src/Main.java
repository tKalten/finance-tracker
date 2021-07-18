import java.time.LocalDate;
import java.io.File;


public class Main {
	static String financeFolder;
	static File folder;
	static AssignData financeData;
	static ReadFiles financeDataIn;

    public static void main(String[] args) {
		financeFolder = "test_lists";
		folder = new File(financeFolder);
		financeData = new AssignData();





    	for (File file : folder.listFiles()) {
			ReadFiles financeDataIn = new ReadFiles(file);
			financeData.addFile(financeDataIn.getSc());
		}

    	for (Integer index : financeData.getIndex()) {
    		System.out.println("Date: " + financeData.getDate().get(index));
			System.out.println("Reason: "+ financeData.getReason().get(index));
			System.out.println("Money:" + financeData.getMoney().get(index) + "\n");
		}
    }
}
