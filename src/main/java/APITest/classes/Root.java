package APITest.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private final String code;
    private final String status;
    private final String attributionHTML;
    private final String etag;

    public Root(@JsonProperty("code") String code, @JsonProperty("status") String status, @JsonProperty("attributionHTML") String attributionHTML, @JsonProperty("etag") String etag) {
        this.code = code;
        this.status = status;
        this.attributionHTML = attributionHTML;
        this.etag = etag;
    }

}

