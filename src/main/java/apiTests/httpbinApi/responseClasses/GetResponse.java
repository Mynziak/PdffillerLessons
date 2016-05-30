package apiTests.httpbinApi.responseClasses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Dima on 13.05.2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetResponse {

    public GetResponse(){

    }
    public String origin;

    public String url;

    public Headers headers;

    @Override
    public String toString() {
        return "GetResponse [origin=" + origin + ", url=" + url +
                ", headers=" + headers + "]";
    }


    public class Headers {

        @JsonProperty("Accept-Encoding")
        public String accepEncoding;

        public String Host;

        @JsonProperty("User-Agent")
        public String userAgent;

        @Override
        public String toString() {
            return "Headers [Accept-Encoding=" + accepEncoding + ", Host =" + Host + " User Agent =" + userAgent;
        }
    }
}
