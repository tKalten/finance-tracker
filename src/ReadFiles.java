import java.io.File;
import java.util.Scanner;

public class ReadFiles {
    static File file = new File("C:\\Users\\thoma\\OneDrive - Technische Universität Graz\\privat\\java\\20210717finance_tracker\\finance_lists\\16.07.txt");
    static Scanner sc;
    static String line;

    public ReadFiles() {
        createScanner();
    }

    static void createScanner(){
        try {
            sc = new Scanner(file);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    Scanner getSc(){
        return this.sc;
    }

    static void printOut() {
        createScanner();
        System.out.println("\nLetsgotprintitall:");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
