import java.io.File;
import java.util.Scanner;

public class ReadFiles {
    private Scanner sc;
    File path;


    public ReadFiles(File filepath) { //class constructor to automatically create iterator reading file
        path = filepath;
        createScanner();
    }

    void createScanner(){ //method to create a scanner to read in files
        try {
            sc = new Scanner(path);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    Scanner getSc(){ //method to return scanner
        return sc;
    }

    void printOut() { //method to print file in case of need
        createScanner();
        System.out.println("\nLetsgotprintitall:");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
