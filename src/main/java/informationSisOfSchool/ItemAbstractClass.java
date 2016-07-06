package informationSisOfSchool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Dima on 03.06.2016.
 */
public abstract class ItemAbstractClass {

    public abstract String addItem() throws IOException;

    public abstract List<String> deleteItem(List<String> list) throws IOException;

    public abstract List<String>  updateItem(List<String> list) throws IOException;

    public static   String getTextFromScreen() throws IOException {
        BufferedReader bufferName = new BufferedReader(new InputStreamReader(System.in));
        return bufferName.readLine();
    }




}
