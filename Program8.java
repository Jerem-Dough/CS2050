/*
Jeremy Dougherty
 */

import java.io.*;

public class Program8 {

    public static void main(String[] args) {

        BST bst = new BST();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("dracula.txt"));
            String line;
            while((line = reader.readLine()) != null){
                String[] split = line.split(" ");
                for(String words : split){
                    bst.insert(words);
                }
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("Couldn't read file successfully");
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("analysis.txt"));
            int nodeCount = bst.nodeCounter(bst.getRoot());
            int treeHeight = bst.treeHeight(bst.getRoot());
            int maxNodeCount = bst.maxNodes(treeHeight);

            writer.write("Total Nodes: "+nodeCount+
                    "\nTree Height: "+treeHeight+
                    "\nMax Nodes: "+maxNodeCount);
            writer.close();
        } catch(IOException e){
            System.out.println("Couldn't write to file successfully");
            e.printStackTrace();
        }
    }
}

