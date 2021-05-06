import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class NearestNeighbour {

    static ArrayList<RadioMapEntry> radioMapEntries = new ArrayList<>();
    static ArrayList<SignalEntry> signalEntries = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        radioMapEntries = CsvReader.loadRadioMapEntries("C:\\Users\\rasmu\\Documents\\GitHub\\UbiCom_assignment2\\src\\train.csv");
        signalEntries = CsvReader.loadSignalEntries("C:\\Users\\rasmu\\Documents\\GitHub\\UbiCom_assignment2\\src\\test.csv");

        for (SignalEntry s: signalEntries) {
            s.getEuclideanDistances(radioMapEntries);
        }
        for (SignalEntry s: signalEntries) {
            RadioMapEntry r = s.euclideanDistances.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
            s.nearestRadioMapEntry = r;
        }

    }

}
