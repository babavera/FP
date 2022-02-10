package apiTests.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {
    public String id;
    public String title;
    public String startYear;
    public String endYear;

    @JsonCreator
    public Series(@JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("startYear") String startYear, @JsonProperty("endYear") String endYear) {
        this.id = id;
        this.title = title;
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
