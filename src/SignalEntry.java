import java.util.HashMap;

public class SignalEntry {

    float x,y;
    float[] signalStrengths;

    HashMap<SignalEntry, Float> euclideanDistances;
    SignalEntry nearestRadioMapEntry = null;

    public SignalEntry(float x, float y, float[] signalStrengths) {
        this.x = x;
        this.y = y;
        this.signalStrengths = signalStrengths;
        euclideanDistances= new HashMap<>();
    }

}
