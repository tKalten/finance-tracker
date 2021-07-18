import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class WriteFiles {
    final String dataPath = "output/dataset.txt";
    final String summaryPath = "output/summary.txt";
    ArrayList<DataEntry> dataset;

    public WriteFiles(ArrayList<DataEntry> data) throws IOException {
        dataset = data;
        createDataSetFile();
        createSummaryFile();
    }

    private void createDataSetFile() throws IOException {
        File datasetFile = new File(dataPath);
        datasetFile.getParentFile().mkdirs();
        datasetFile.createNewFile();

        FileWriter datasetFileWriter = new FileWriter(dataPath);
        datasetFileWriter.write("Date   Money   Reason");
        for (DataEntry entry : dataset) {
            datasetFileWriter.write("\n" + entry.getDate() + "  " + entry.getMoney() + "   " + entry.getReason());
        }
        datasetFileWriter.close();
    }

    private void createSummaryFile() throws IOException {
        File summaryFile = new File(summaryPath);
        summaryFile.createNewFile();


        HashSet<String> summarySet = new HashSet<String>();
        for (DataEntry entry : dataset) {
            String month = String.valueOf(entry.getDate().getMonth());
            String year = String.valueOf(entry.getDate().getYear());
            summarySet.add(month + "." + year);
        }


        HashMap<String, Float> summary = new HashMap<String, Float>();
        for (String unique :summarySet){
            float totalValue = 0;
            for (DataEntry entry : dataset) {
                String checkSimilarities = String.valueOf(entry.getDate().getMonth()) + "." + String.valueOf(entry.getDate().getYear());
                if (unique.equals(checkSimilarities)) {
                    totalValue = totalValue + entry.getMoney();

                }
            }
            summary.put(unique, totalValue);

        }

        FileWriter summaryFileWriter = new FileWriter(summaryPath);
        summaryFileWriter.write("MONTH.Year -----Money\n");
        for (String key : summary.keySet()){
            summaryFileWriter.write("\n" + key + " -----" + summary.get(key) + "€");
        }
        summaryFileWriter.close();

    }
}
