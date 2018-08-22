package com.udit.techgig.contest;

import java.util.Scanner;

public class CountingLeaf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] nodes = new int[nodesCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < nodesCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            nodes[arItr] = arItem;
        }

        int nodesToDelete = Integer.parseInt(scanner.nextLine().trim());

    }
}
