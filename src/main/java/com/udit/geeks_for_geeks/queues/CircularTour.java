package com.udit.geeks_for_geeks.queues;

import java.util.HashSet;

//https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
public class CircularTour {
    public static void main(String[] args) {
        //96 25 46 83 68 15 65 35 51 44 9 88 79 77 85 89
        //55 52 33 100 77 61 40 69

        PetrolPump[] pumps = new PetrolPump[4];
        pumps[0] = new PetrolPump(55, 52);
        pumps[1] = new PetrolPump(33, 100);
        pumps[2] = new PetrolPump(77, 61);
        pumps[3] = new PetrolPump(40, 56);
        int tourStartIndex = new CircularTour().findTourStartIndex(pumps);
        System.out.println("tourStartIndex = " + tourStartIndex);
    }

    int findTourStartIndex(PetrolPump[] pumps) {
        int index = -1, currPatrol = 0;
        if (pumps != null && pumps.length > 0) {
            int size = pumps.length;
            index = 0;
            int start = 0, end = size - 1;
            int lastStartingPetrolPump = 0, visitedPupms = 0;
            for (; visitedPupms != size; ) {
                int distance = pumps[start].distanceToNextPetrolPump;
                currPatrol = currPatrol + pumps[start].petrolCapacity;
                if (distance > currPatrol) {
                    start = (start + 1);
                    currPatrol = 0;
                    if (lastStartingPetrolPump >= start) {
                        index = -1;
                        break;
                    } else {
                        index = start;
                        lastStartingPetrolPump = index;
                        visitedPupms = 0;
                    }
                    end = (start + end) % size;
                } else {
                    currPatrol = currPatrol - distance;
                    visitedPupms++;
                    start = (start + 1) % size;
                }
            }
            HashSet<Integer> integers = new HashSet<>();

        }
        return index;
    }

    static class PetrolPump {
        int petrolCapacity;
        int distanceToNextPetrolPump;

        public PetrolPump(int petrolCapacity, int distanceToNextPetrolPump) {
            this.petrolCapacity = petrolCapacity;
            this.distanceToNextPetrolPump = distanceToNextPetrolPump;
        }
    }
}
