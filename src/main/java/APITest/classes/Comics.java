package APITest.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comics {
    public String id;
    public String title;
    public String pageCount;

    @JsonCreator
    public Comics(@JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("pageCount") String pageCount) {
        this.id = id;
        this.title = title;
        this.pageCount = pageCount;
    }
}
