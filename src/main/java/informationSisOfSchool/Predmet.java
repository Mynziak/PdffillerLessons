package informationSisOfSchool;

import java.util.List;

/**
 * Created by Dima on 31.05.2016.
 */
public class Predmet {

    String predmet;
    String vykladach;
    List groups;

    public Predmet (String predmet, String vykladach, List groups) {
        this.predmet = predmet;
        this.vykladach = vykladach;
        this.groups = groups;
    }
}
