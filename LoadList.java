/*
Name: Tanner Dryden
CPTS 233: Project Assignment #1
Date: 9/18/2020
gitRepo url: https://github.com/TannerDryden/233-Programming-Assignment-1.git
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;




public class LoadList {

    public static void main(String[] arg) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Long> timeList = new LinkedList<>();

        long timeStart, timeEnd, insertStart, insertEnd;
        long time_insert = 0;


        try {
            // Gets file name from user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the file name: ");
            String fileName = scanner.nextLine();

            // finds path of file
            URL path = ClassLoader.getSystemResource(fileName);

            // creates a reader for the file
            File inputFile = new File(path.toURI());

            Scanner fileReader = new Scanner(inputFile);

            // adds data to the list and sorts as the file is read
            insertStart = System.nanoTime();

            while(fileReader.hasNextLine()) {
                timeStart = System.nanoTime();

                String stringData = fileReader.nextLine();
                list.add(Integer.parseInt(stringData));

                // Sort the list low -> high
                Collections.sort(list);

                timeEnd = System.nanoTime();

                // record times for each insertion
                timeList.add(timeEnd - timeStart);
                System.out.println("one sort finished");
            }
            insertEnd = System.nanoTime();
            fileReader.close();

            // report total time for insertion
            time_insert = insertEnd - insertStart;

            // exception handling
             } catch (URISyntaxException | FileNotFoundException error) {
               System.out.println("File not in the directory");
               error.printStackTrace();
                }

        Collections.sort(timeList);

        // prints list for testing
        System.out.println(list);
        System.out.println(timeList);

        // min number of the list
        System.out.println("The min number is: " + list.getFirst());
        // med number of the list
        System.out.println("The median number is: " + ListFunctions.findMedInt(list));
        // max number of the list
        System.out.println("The max number is: " + list.getLast());

        // finds min time insert
        System.out.println("The min time was " + ListFunctions.findMinLong(timeList) + " nanoseconds");
        // finds med time insert
        System.out.println("The median time was " + ListFunctions.findMedLong(timeList) + " nanoseconds");
        // finds max time insert
        System.out.println("The max time was " + ListFunctions.findMaxLong(timeList) + " nanoseconds");
        // time to insert
        System.out.println("The total time to insert is: " + time_insert + " nanoseconds");
    }
}
