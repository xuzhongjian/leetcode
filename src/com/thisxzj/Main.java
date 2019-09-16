package com.thisxzj;

import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] numString = line.split(",");
        int[] nums = new int[numString.length];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(numString[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer times = map.get(i);
            map.put(i, times == null ? 1 : times + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.println(key + " " + value);
            if (value <= key + 1) {
                cnt = cnt + key + 1;
            } else {
                while (value > 0) {
                    cnt = cnt + key + 1;
                    value = value - key - 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
