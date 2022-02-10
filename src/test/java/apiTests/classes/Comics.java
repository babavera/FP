package apiTests.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comics {
    public String id;
    public String title;
    @JsonCreator
    public Comics(@JsonProperty("id") String id, @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
    }
}
