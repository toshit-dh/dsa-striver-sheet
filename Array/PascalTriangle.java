package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        return generateList(new ArrayList<>(), numRows);
    }

    public static List<List<Integer>> generateList(List<List<Integer>> list, int numRows) {
        if (numRows == 0) {
            return list;
        }
        if (numRows == 1) {
            list.add(new ArrayList<>(List.of(1)));
            return list;
        }
        list = generateList(list, numRows - 1);
        List<Integer> add = new ArrayList<>();
        add.add(1);
        List<Integer> integers = list.getLast();
        for (int i = 0; i < integers.size() - 1; i++) {
            int ele = integers.get(i) + integers.get(i + 1);
            add.add(ele);
        }
        add.add(1);
        list.add(add);
        return list;
    }

    public static void main(String[] args) {
        var list = generate(10);
        for (List<Integer> integers : list){
            System.out.println(integers);
        }
    }
}
