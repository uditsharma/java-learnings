package com.udit.set;

import java.util.*;

public class CheckDuplicates {

    public void findDuplicateUsingSet() {

        List<String> input = new ArrayList<>();
        input.add("Abc");
        input.add("ABC");


        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        for (String str : input) {
            if (set.contains(str)) {
                System.out.println("Duplicate Found : " + str);
            } else {
                set.add(str);
            }
        }

    }

    public static void main(String[] args) {
        new CheckDuplicates().findDuplicateUsingSet();
    }
}
