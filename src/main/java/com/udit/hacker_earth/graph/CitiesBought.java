package com.udit.hacker_earth.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Udit Sharma.
 * @since 04 Apr, 2018 10:25 AM
 */
public class CitiesBought {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            Set<String> citiesBought = new HashSet<>();
            int numberOfRoadsBought = scanner.nextInt();
            for (int road = 0; road < numberOfRoadsBought; road++) {
                String edge = scanner.nextLine();
                while (edge == null || edge.trim().isEmpty()) {
                    edge = scanner.nextLine();
                }
                String[] cities = edge.split(" ");
                citiesBought.add(cities[0]);
                citiesBought.add(cities[1]);
            }
            System.out.println(citiesBought.size());
        }
    }
}
