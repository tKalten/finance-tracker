import java.io.FileWriter;
import java.io.File;

public class WriteFiles {

    public WriteFiles(Data data){
        int bound = data.date.size();
        for (int i = 0; i < bound; i++) {
            System.out.print(data.date.get(i));
            System.out.print(data.reason.get(i));
            System.out.print(data.money.get(i));
        }
    }
}
