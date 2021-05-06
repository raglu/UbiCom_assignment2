import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    static ArrayList<RadioMapEntry> loadRadioMapEntries(String fileName) throws IOException {
        ArrayList<RadioMapEntry> radioMapEntries = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        String row;
        boolean isHeader = true;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (!isHeader) {
                float asdf[] = new float[]{Float.parseFloat(data[4]), Float.parseFloat(data[5]), Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Float.parseFloat(data[9]), Float.parseFloat(data[10]), Float.parseFloat(data[11]), Float.parseFloat(data[12])};
                radioMapEntries.add(new RadioMapEntry(Float.parseFloat(data[2]), Float.parseFloat(data[3]), asdf));
            }
            isHeader = false;
        }
        csvReader.close();

        return radioMapEntries;
    }

    static ArrayList<SignalEntry> loadSignalEntries(String fileName) throws IOException {
        ArrayList<SignalEntry> signalEntries = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        String row;
        boolean isHeader = true;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (!isHeader) {
                float asdf[] = new float[]{Float.parseFloat(data[4]), Float.parseFloat(data[5]), Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Float.parseFloat(data[9]), Float.parseFloat(data[10]), Float.parseFloat(data[11]), Float.parseFloat(data[12])};
                signalEntries.add(new SignalEntry(asdf));
            }
            isHeader = false;
        }
        csvReader.close();

        return signalEntries;

    }
}
