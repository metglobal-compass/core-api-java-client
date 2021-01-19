package compass_api.model;

import java.util.ArrayList;
import java.util.Map;

public class RateContent {

    private Map<Integer, Float> adult;
    private Map<Integer, Object> child; // Value can be List or Map.

    public Map<Integer, Float> getAdult() {
        return adult;
    }

    public void setAdult(Map<Integer, Float> adult) {
        this.adult = adult;
    }

    public Map<Integer, Object> getChild() {
        return child;
    }
}
