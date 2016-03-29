package apiTests;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by DimaM on 11/30/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectClass {
    public ProjectClass(){   // это особенность библиотеки, нужно писать дефолный конструктор, иначе библиотека жейсона не видит класс
    }

    public String clone_state;
    public String created;
    public String date;
    public   String filename;
    public String folder_id;
    public   int form_id;
    public    int system_id;
    public   int user_id;
    public StatusClass status;

}
