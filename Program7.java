/*
Jeremy Dougherty
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Program7 {

    public static void main(String[] args) {

        int[] bubbleInts = new int[20000];
        int[] selectInts = new int[20000];
        ArrayList<Integer> insertionInts = new ArrayList<>();

        String[] bubbleStrings = new String[10000];
        String[] selectStrings = new String[10000];
        ArrayList<String> collectionStrings = new ArrayList<>();
        ArrayList<String> insertionStrings = new ArrayList<>();

        //Reading integer values from file
        try {
            BufferedReader intReader = new BufferedReader(new FileReader("NumbersInFile.txt"));
            String line;
            int count = 0;
            while ((line = intReader.readLine()) != null) {
                bubbleInts[count] = Integer.parseInt(line.trim());
                selectInts[count] = Integer.parseInt(line.trim());
                insertionInts.add(Integer.valueOf(line.trim()));
                count++;
            }
            intReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //Reading string values from file
        try {
            BufferedReader stringReader = new BufferedReader(new FileReader("StringsInFile.txt"));
            String lines;
            int counter = 0;
            while((lines = stringReader.readLine()) != null){
                bubbleStrings[counter] = lines.trim();
                selectStrings[counter] = lines.trim();
                collectionStrings.add(lines.trim());
                insertionStrings.add(lines.trim());
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //BubbleSort for Integers
        long start = System.nanoTime();
        boolean swap = true;
        while(swap) {
            swap = false;

            for(int i = 0; i < bubbleInts.length - 1; i++) {
                if (bubbleInts[i] > bubbleInts[i + 1]) {
                    swap = true;
                    int temp = bubbleInts[i];
                    bubbleInts[i] = bubbleInts[i + 1];
                    bubbleInts[i + 1] = temp;
                }
            }
        }
        long end = System.nanoTime();
        double intBubbleSortTime = (double) (end - start) / 1_000_000_000;

        //SelectSort for Integers
        start = System.nanoTime();
        for(int i = 0; i < selectInts.length - 1; i++){
            int min = selectInts[i];
            int location = i;
            for(int j = i + 1; j < selectInts.length; j++){
                if(selectInts[j] < min){
                    min = selectInts[j];
                    location = j;
                }
            }
            int temp = selectInts[i];
            selectInts[i] = selectInts[location];
            selectInts[location] = temp;
        }
        end = System.nanoTime();
        double intSelectSortTime = (double) (end - start) / 1_000_000_000;

        //InsertionSort for Integers
        start = System.nanoTime();
        for(int i = 1; i < insertionInts.size(); i++){
            int current = insertionInts.get(i);
            int j = i - 1;
                    while(j >=0 && insertionInts.get(j) > current){
                        insertionInts.set(j + 1,insertionInts.get(j));
                        j--;
                    }
                    insertionInts.set(j + 1, current);
        }
        end = System.nanoTime();
        double intInsertionSortTime = (double) (end - start) / 1_000_000_000;

        //BubbleSort for Strings
        start = System.nanoTime();
        for(int i = 0; i < bubbleStrings.length - 1; i++){
            for(int j = i + 1; j < bubbleStrings.length; j++){
                if(bubbleStrings[j].compareTo(bubbleStrings[i]) < 0){
                    String temp = bubbleStrings[i];
                    bubbleStrings[i] = bubbleStrings[j];
                    bubbleStrings[j] = temp;
                }
            }
        }
        end = System.nanoTime();
        double stringBubbleSortTime = (double) (end - start) / 1_000_000_000;

        //SelectSort for Strings
        start = System.nanoTime();
        for(int i = 0; i < selectStrings.length - 1; i++){
            String min = selectStrings[i];
            int location = i;
            for(int j = i + 1; j < selectStrings.length; j++){
                if(selectStrings[j].compareTo(min) < 0){
                    min = selectStrings[j];
                    location = j;
                }
            }
            String temp = selectStrings[i];
            selectStrings[i] = selectStrings[location];
            selectStrings[location] = temp;
        }
        end = System.nanoTime();
        double stringSelectSortTime = (double) (end - start) /1_000_000_000;

        //InsertionSort for Strings
        start = System.nanoTime();
        for(int i = 1; i < insertionStrings.size(); i++){
            String current = insertionStrings.get(i);
            int j = i - 1;
                while(j >= 0 && insertionStrings.get(j).compareTo(current) > 0){
                    insertionStrings.set(j + 1, insertionStrings.get(j));
                    j--;
                }
                insertionStrings.set(j + 1, current);
        }
        end = System.nanoTime();
        double stringInsertionSortTime = (double) (end - start) / 1_000_000_000;

        //CollectionSort for Strings
        start = System.nanoTime();
        Collections.sort(collectionStrings);
        end = System.nanoTime();
        double stringCollectionSortTime = (double) (end - start) /1_000_000_000;

        //Writing results to file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            writer.write("Bubble Sort w/ 20000 Integers: "+intBubbleSortTime+" seconds" +
                    "\n Select Sort Time w/ 20000 Integers: "+intSelectSortTime+" seconds" +
                    "\n Insertion Sort Time w/ 20000 Integers: "+intInsertionSortTime+" seconds" +
                    "\n Bubble Sort Time w/ 10000 Strings: "+stringBubbleSortTime+" seconds" +
                    "\n Select Sort Time w/ 10000 Strings: "+stringSelectSortTime+" seconds" +
                    "\n Insertion Sort Time w/ 10000 Strings: "+stringInsertionSortTime+" seconds" +
                    "\n Collection Sort Time w/ 10000 Strings: "+stringCollectionSortTime+" seconds");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



