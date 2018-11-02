package compass_api.model;

import java.util.ArrayList;
import java.util.Map;

public class RateContent {

    private Map<Integer, Float> adult;
    private Map<Integer, ArrayList<Float>> child;

    public Map<Integer, Float> getAdult() {
        return adult;
    }

    public void setAdult(Map<Integer, Float> adult) {
        this.adult = adult;
    }

    public Map<Integer, ArrayList<Float>> getChild() {
        return child;
    }
}
