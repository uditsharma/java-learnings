package com.udit.hacker_earth.graph;

import java.util.Scanner;

/**
 * @author Udit Sharma.
 * @since 04 Apr, 2018 7:37 AM
 */
public class WhetherATreeOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();


        String edge = scanner.nextLine();
        while (edge == null || edge.trim().isEmpty()) {
            edge = scanner.nextLine();
        }

        String[] edgeNodes = edge.split(" ");
        int degreeSum = 0;
        for (String edgeNode : edgeNodes) {
            degreeSum = degreeSum + Integer.parseInt(edgeNode);
        }

        int numberOfEdges = degreeSum / 2;
        System.out.println(numberOfEdges == nodes - 1 ? "Yes" : "No");
    }
}
