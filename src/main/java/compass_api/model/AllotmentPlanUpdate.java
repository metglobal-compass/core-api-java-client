package compass_api.model;

import java.util.HashMap;
import java.util.List;

public class AllotmentPlanUpdate {
    private HashMap<Integer, List<AllotmentPlanRoomUpdate>> rooms;
    private HashMap<Integer, List<AllotmentPlanRestrictionUpdate>> restrictions;

    public HashMap<Integer, List<AllotmentPlanRoomUpdate>> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<Integer, List<AllotmentPlanRoomUpdate>> rooms) {
        this.rooms = rooms;
    }

    public HashMap<Integer, List<AllotmentPlanRestrictionUpdate>> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(HashMap<Integer, List<AllotmentPlanRestrictionUpdate>> restrictions) {
        this.restrictions = restrictions;
    }
}
