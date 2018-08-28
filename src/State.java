import java.util.ArrayList;

public class State {
    String name;
    ArrayList <Interactions> interactions;

    public State(String name, ArrayList<Interactions> interactions) {
        this.name = name;
        this.interactions = interactions;
    }
}
