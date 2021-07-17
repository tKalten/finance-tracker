import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
		ReadFiles financeData = new ReadFiles();
		AssignData assignedData = new AssignData(financeData.getSc());
		Data data = assignedData.getData();
		WriteFiles writeFiles = new WriteFiles(data);

    }
}
