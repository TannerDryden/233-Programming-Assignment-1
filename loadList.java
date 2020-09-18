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

public class loadList {

    public static void main(String[] arg) {
        LinkedList list = new LinkedList();

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

            // adds data to the list as the file is read
            while(fileReader.hasNextLine()) {
                String stringData = fileReader.nextLine();
                list.add(Integer.parseInt(stringData));
            }
            fileReader.close();

            // Sort the list low -> high
            Collections.sort(list);

            // exception handling
        } catch (URISyntaxException | FileNotFoundException error) {
            System.out.println("File not in the directory");
            error.printStackTrace();
        }

        // prints list for testing
        System.out.println(list);
    }
}
