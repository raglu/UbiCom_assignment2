import java.util.ArrayList;
import java.util.HashMap;

public class SignalEntry {

    float x, y;

    float[] signalStrengths;

    HashMap<RadioMapEntry, Float> euclideanDistances;

    RadioMapEntry nearestRadioMapEntry = null;

    public SignalEntry(float x, float y, float[] signalStrengths) {
        this.x = x;
        this.y = y;
        this.signalStrengths = signalStrengths;
        euclideanDistances= new HashMap<>();
    }

    public void populateEuclideanDistances(ArrayList<RadioMapEntry> radioMapEntries){
        for(RadioMapEntry r: radioMapEntries) {
            euclideanDistances.put(r,calculateEuclideanDistance(r));
        }
    }

    private float calculateEuclideanDistance(RadioMapEntry radioMapEntry) {

        float distance = 0;

        for (int i = 0; i < signalStrengths.length; i++) {
            distance += Math.pow(signalStrengths[i] - radioMapEntry.signalStrengths[i], 2);
        }

        distance = (float) Math.sqrt(distance);

        return distance;
    }

}
