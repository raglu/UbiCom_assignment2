import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class NearestNeighbour {

    static ArrayList<SignalEntry> radioMapEntries = new ArrayList<>();
    static ArrayList<SignalEntry> signalEntries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        radioMapEntries = CsvReader.loadEntries("C:\\Users\\rasmu\\Documents\\GitHub\\UbiCom_assignment2\\src\\train.csv");
        signalEntries = CsvReader.loadEntries("C:\\Users\\rasmu\\Documents\\GitHub\\UbiCom_assignment2\\src\\test.csv");

        for (SignalEntry s : signalEntries) {
            getEuclideanDistances(s, radioMapEntries);
        }
        for (SignalEntry s : signalEntries) {
            s.nearestRadioMapEntry = s.euclideanDistances.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        }

        int i = 1;

        for (SignalEntry s : signalEntries) {
            float deltax = s.nearestRadioMapEntry.x - s.x;
            float deltay = s.nearestRadioMapEntry.y - s.y;
            System.out.println("Entry " + i + ": " + deltax + " " + deltay );
            i++;
        }

    }

    static void getEuclideanDistances(SignalEntry s, ArrayList<SignalEntry> radioMapEntries){
        for(SignalEntry r: radioMapEntries) {
            s.euclideanDistances.put(r,calculateEuclideanDistance(s,r));
        }
    }

    static float calculateEuclideanDistance(SignalEntry s, SignalEntry radioMapEntry) {

        float distance = 0;

        for (int i = 0; i < s.signalStrengths.length; i++) {
            distance += Math.pow(s.signalStrengths[i] - radioMapEntry.signalStrengths[i], 2);
        }

        distance = (float) Math.sqrt(distance);

        return distance;
    }


}
