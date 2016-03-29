package otherTests;

import browserfactory.BrowseFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DimaM on 12/10/2015.
 */
public class Bot2048 extends BrowseFactory {


   public By cell = By.cssSelector(".tile-container");



    List<String> grid  = Arrays.asList("-", "-", "-", "-");
    List<String> grid1  = Arrays.asList("-", "-", "-", "-");
    List<String> grid2  = Arrays.asList("-", "-", "-", "-");
    List<String> grid3  = Arrays.asList("-", "-", "-", "-");

    public void getCell(String position, String value){

        switch(position){
            case "1-1": grid.set(0, value + " "); break;
            case "1-2": grid1.set(0, value + " "); break;
            case "1-3": grid2.set(0, value + " "); break;
            case "1-4": grid3.set(0, value + " "); break;
            case "2-1": grid.set(1, value + " "); break;
            case "2-2": grid1.set(1, value + " "); break;
            case "2-3": grid2.set(1, value + " "); break;
            case "2-4": grid3.set(1, value + " "); break;
            case "3-1": grid.set(2, value + " "); break;
            case "3-2": grid1.set(2, value + " "); break;
            case "3-3": grid2.set(2, value + " "); break;
            case "3-4": grid3.set(2, value + " "); break;
            case "4-1": grid.set(3, value + " "); break;
            case "4-2": grid1.set(3, value + " "); break;
            case "4-3": grid2.set(3, value + " "); break;
            case "4-4":  grid3.set(3, value + " "); break;

            default: position = "position is absent"; break;
        }

    }

    public HashMap listElems(){

        String pos = " tile-position-";
        String tile = "tile tile-";
        String tileNew = " tile-new";

        HashMap<String, String>  map = new HashMap();

        List<WebElement> list = driver.findElements(By.cssSelector(".tile-container .tile"));
        for(WebElement item : list){
            String sd=  item.getAttribute("class");
            String a = sd.substring(sd.indexOf(tile) + tile.length(), sd.indexOf(pos)); //first result
            String pa1 = sd.substring(sd.indexOf(pos) + pos.length(), sd.indexOf(tileNew)); //first position
            map.put(pa1,a);
         //System.out.println(map);
        }
        return map;
    }


    @Test
    public void test() throws IOException {

  driver.get("http://gabrielecirulli.github.io/2048/");


        HashMap<String, String> map1 = listElems();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            getCell(key, value);
        }
        System.out.println(grid);
        System.out.println(grid1);
        System.out.println(grid2);
        System.out.println(grid3);




}







}
