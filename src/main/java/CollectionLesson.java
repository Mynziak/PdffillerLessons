import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DimaM on 8/4/2015.
 */
public class CollectionLesson {

//String[] testers = {"1","2"};
  List<String> testers = new ArrayList<String>();


    @Test
    public void collectTest(){
        testers.add("Din");
        testers.add(0,"LLL");
        testers.add(2,"AAA");
        System.out.println(testers.get(0));

        for (String tester: testers){
            System.out.print(tester+" ");
        }

        if(!testers.isEmpty()){
            System.out.println(testers.size());

        }
    }
}

