import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    static String date = "1.9.21";

    public static void main(String[] args) {
	ReadFiles test = new ReadFiles();
	test.printOut();

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.u");
        LocalDate testdate = LocalDate.parse(date,formatter);

	System.out.println(testdate.getMonth());
    }
}
