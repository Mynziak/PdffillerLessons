package apiTests.httpbinApi.responseClasses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Dima on 16.05.2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CookiesResponse {

    @JsonProperty("_ga")
    public String ga;

    @JsonProperty("_gat")
    public int gat;

}


