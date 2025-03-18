package io.pavan;

import java.io.*;

public class CreatingAFile {
    public static void main(String[] args) {
        // creating a file
        try{
            File fo = new File("/Users/pavan/Downloads/Programs/FileHandling/src/main/java/io/pavan/new-file.txt");
            fo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //writing a contents to a file
        try{
            FileWriter fr = new FileWriter("/Users/pavan/Downloads/Programs/FileHandling/src/main/java/io/pavan/new-file.txt");
            fr.write("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज, अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुच:");
            fr.close();
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
        //reading a contents from a file
        try{
            BufferedReader br = new BufferedReader(new FileReader("/Users/pavan/Downloads/Programs/FileHandling/src/main/java/io/pavan/new-file.txt"));
            while(br.ready()){
                System.out.println(br.readLine());
            }
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
        //delete a file
        try{
            File file = new File("/Users/pavan/Downloads/Programs/FileHandling/src/main/java/io/pavan/dummy.txt");
            file.createNewFile();
            if(file.delete())
                System.out.println(file.getName());
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

    }
}
