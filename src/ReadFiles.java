import java.io.File;
import java.util.Scanner;

public class ReadFiles {
    static File file = new File("C:\\Users\\thoma\\OneDrive - Technische Universität Graz\\privat\\java\\20210717finance_tracker\\finance_lists\\16.07.txt");
    static Scanner sc;
    static String line;

    public ReadFiles() {
        createScanner();
        while (sc.hasNextLine()) {
            line = new String(sc.nextLine());

            if(line.equals("1")){
                System.out.println(line);
            } else {
                System.out.println("NO");
            }

        }
    }

    static void createScanner(){
        try {
            sc = new Scanner(file);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    static void printOut() {
        createScanner();
        System.out.println("\nLetsgotprintitall:");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
