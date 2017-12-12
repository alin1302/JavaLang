package calculator;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CacheOperations {

    public ArrayList<Operation> List1;
    public ArrayList<Operation> List2;

    public CacheOperations() {
        List1 = new ArrayList<>(10);
        List2 = new ArrayList<>(50);
    }

    public void Add(Operation operation) {
        System.out.print("Add: ");
        if (List1.size() < 3) {
            List1.add(operation);
            System.out.println("List1");
        } else {
            List2.add(operation);
            System.out.println("List2");
        }
    }

    public boolean inLists(Operation operation) {
        if (List1.contains(operation) || List2.contains(operation)) {
            return true;
        }
        return false;
    }

    public double getOperation(Operation operation) {
        int index = -1;

        if (List1.contains(operation)) {
            for (int i = 0; i < List1.size(); i++) {
                if (List1.get(i).equals(operation)) {
                    index = List1.indexOf(operation);
                }
            }
            System.out.println("Result in List1");
            return (List1.get(index).result);
        }

        if (List2.contains(operation)) {
            for (int i = 0; i < List2.size(); i++) {
                if (List2.get(i).equals(operation)) {
                    index = List2.indexOf(operation);
                }
            }
            System.out.println("Result in List2");
            return (List2.get(index).result);
        }
        return -0;
    }
}
