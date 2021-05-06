import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class NearestNeighbourAlgorithm {


    public static void main(String args[]){
        loadRadioMapEntries("C:\\Users\\rasmu\\Documents\\GitHub\\UbiCom_assignment2\\src\\train.csv");
        loadSignalEntries("C:\\Users\\rasmu\\Documents\\GitHub\\UbiCom_assignment2\\src\\test.csv");

        for (SignalEntry s: signalEntries) {
            s.populateEuclideanDistances(radioMapEntries);
        }
        for (SignalEntry s: signalEntries) {
            RadioMapEntry r = s.euclideanDistances.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
            s.nearestRadioMapEntry = r;
        }

    }

    static ArrayList<RadioMapEntry> radioMapEntries = new ArrayList<>();
    static ArrayList<SignalEntry> signalEntries = new ArrayList<>();

    static void loadRadioMapEntries(String fileName) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String row;
            boolean isHeader = true;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (!isHeader) {
                    float asdf[] = new float[] {Float.parseFloat(data[4]), Float.parseFloat(data[5]), Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Float.parseFloat(data[9]), Float.parseFloat(data[10]), Float.parseFloat(data[11]), Float.parseFloat(data[12])};
                    radioMapEntries.add(new RadioMapEntry(Float.parseFloat(data[2]), Float.parseFloat(data[3]), asdf));
                } isHeader = false;
            }
            csvReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadSignalEntries(String fileName) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String row;
            boolean isHeader = true;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (!isHeader) {
                    float asdf[] = new float[] {Float.parseFloat(data[4]), Float.parseFloat(data[5]), Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Float.parseFloat(data[9]), Float.parseFloat(data[10]), Float.parseFloat(data[11]), Float.parseFloat(data[12])};
                    signalEntries.add(new SignalEntry(Float.parseFloat(data[2]), Float.parseFloat(data[3]), asdf));
                } isHeader = false;
            }
            csvReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
