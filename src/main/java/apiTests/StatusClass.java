package apiTests;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by DimaM on 12/1/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)  //аннто
public class StatusClass {

    public StatusClass(){

    }

    public int code;
    public String text ;
}
