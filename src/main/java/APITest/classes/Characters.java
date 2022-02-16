package APITest.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@JsonIgnoreProperties (ignoreUnknown = true)
public class Characters {
    private final String id;
    private final String name;

    @JsonCreator
    public Characters(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}