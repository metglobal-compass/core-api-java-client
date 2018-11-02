package compass_api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude
@JsonPropertyOrder({
        "1"
})

public class Rate {

    @JsonProperty("1")
    private RateContent RateContent;

    @JsonProperty("1")
    public RateContent getRateContent() {
        return RateContent;
    }

    @JsonProperty("1")
    public void setRateContent(RateContent rateContent) {
        this.RateContent = rateContent;
    }
}
