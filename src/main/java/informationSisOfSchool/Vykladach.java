package informationSisOfSchool;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dima on 31.05.2016.
 */
public class Vykladach extends ItemAbstractClass {


    @Override
    public String addItem() throws IOException {
        System.out.println("Enter name of Vykladach:");
        String addVn = getTextFromScreen();
        System.out.println("Enter lastName of Vykladach:");
        String addVs = getTextFromScreen();
        return (addVn + " " + addVs);
    }

    @Override
    public List<String> deleteItem(List<String> listVykladachi) throws IOException {
        System.out.println("Enter name of Vykladach:");
        String deleteVn = getTextFromScreen();
        System.out.println("Enter lastName of Vykladach:");
        String deleteVs = getTextFromScreen();
        String vykladachDelete = deleteVn + " " + deleteVs;
        System.out.println("Will be deleted: " + vykladachDelete);
        String foundVykladach = null;
        for (String vykladach : listVykladachi) {
            if (vykladach.equals(vykladachDelete)) foundVykladach = vykladachDelete;
        }
        if (!foundVykladach.equals(null)) listVykladachi.remove(vykladachDelete);
        else System.out.println("No such vykladach has found, bitch!");

        return listVykladachi;
    }

    @Override
    public List<String> updateItem(List<String> listVykladachi) throws IOException {
        System.out.println("Enter name of Vykladach :");
        String updateVn = getTextFromScreen();
        System.out.println("Enter secondName of Vykladach:");
        String updateVs = getTextFromScreen();
        String vykladachOld = updateVn + " " + updateVs;
        System.out.println("Vykladach that will be changed is: " + vykladachOld);
        System.out.println("Enter update for current  of Vykladach (enter name and lastdName) :");
        String vykladachNew = getTextFromScreen();
        String foundVykladach = null;
        int indexFounded = 0;
        for (String vykladach : listVykladachi) {
            if (vykladach.equals(vykladachOld)) {
                foundVykladach = vykladach;
                indexFounded = listVykladachi.indexOf(vykladach);
            }
        }
        if (!foundVykladach.equals(null)) listVykladachi.set(indexFounded, vykladachNew);
        else System.out.println("No such vykladach has found, bitch!");
        return listVykladachi;
    }
}
