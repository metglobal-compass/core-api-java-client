package compass_api.model.Booking;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "timezone_type",
        "timezone"
})
public class BookingRoomPriceCreatedAt {

    @JsonProperty("date")
    private String date;
    @JsonProperty("timezone_type")
    private Integer timezoneType;
    @JsonProperty("timezone")
    private String timezone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("timezone_type")
    public Integer getTimezoneType() {
        return timezoneType;
    }

    @JsonProperty("timezone_type")
    public void setTimezoneType(Integer timezoneType) {
        this.timezoneType = timezoneType;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
