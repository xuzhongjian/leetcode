import java.util.*;

/**
 * date    2019-09-17
 * time    15:15
 *
 * @author thisxzj - 中建
 */


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String line = input.nextLine().trim();
        while (line != null && !line.equals("")) {
            int i = Integer.parseInt(line);
            list.add(i);
            if (input.hasNextLine()) {
                line = input.nextLine().trim();
            } else {
                line = null;
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.print(lack(list));
    }

    public static int lack(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer i : list) {
            max = Math.max(i, max);
        }
        List<Integer> integerLinkedList = new LinkedList<>();
        for (int i = 0; i < max; i++) {
            integerLinkedList.add(i);
        }
        for (Integer i : list) {
            integerLinkedList.remove(i);
        }
        return integerLinkedList.get(0);
    }
}
