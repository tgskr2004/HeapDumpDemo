import java.util.ArrayList;
import java.util.List;

public class OOMSimulator {
    public static void main(String[] args) {
        List<int[]> memoryHog = new ArrayList<>();
        while (true) {
            memoryHog.add(new int[100000]);
        }
    }
}
