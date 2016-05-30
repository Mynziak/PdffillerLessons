package apiTests.httpbinApi.responseClasses;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Dima on 17.05.2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponse {

    public String args;

    public String data;

    public String files;

    public Form form;

    public Headers headers;

    public String json;

    public String origin;

    public String url;

    public class Form {

        public String comments;

        public String custemail;

        public String custname;

        public String custtel;

        public String delivery;

        public String size;

        public String topping;
    }

    public class Headers {

        public String Accept;

        @JsonProperty("Accept-Encoding")
        public String AcceptEncoding;

        @JsonProperty("Accept-Language")
        public String AcceptLanguage;

        @JsonProperty("Cache-Control")
        public String CacheControl;

        @JsonProperty("Content-Length")
        public String ContentLength;
    }


}


