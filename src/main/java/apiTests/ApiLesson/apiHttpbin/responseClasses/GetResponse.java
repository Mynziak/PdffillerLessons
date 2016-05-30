package apiTests.ApiLesson.apiHttpbin.responseClasses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by ANS on 13/05/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetResponse {

    public GetResponse() {
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

        public Headers() {
        }

        @JsonProperty("Accept-Encoding")
        public String acceptEncoding;

        @JsonProperty("Host")
        public String host;

        @JsonProperty("User-Agent")
        public String userAgent;

        @Override
        public String toString() {
            return "Headers [Accept-Encoding=" + acceptEncoding + ", Host=" + host +
                    ", User-Agent=" + userAgent + "]";
        }
    }


}
