package io.pavan;


import java.io.*;

public class Main {
    public static void main(String[] args)  {
//        try(InputStreamReader isr = new InputStreamReader(System.in)) {
//            System.out.println("Enter some characters");
//            int letters = isr.read();
//            while(isr.ready()){
//                System.out.println((char)letters);
//                letters= isr.read();
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        try(FileReader fr = new FileReader("note.txt")){
//            int read = fr.read();
//            while(fr.ready()){
//                System.out.println((char) read);
//                read = fr.read();
//            }
//
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            System.out.println("You Typed "+br.readLine());
//        }catch(IOException io){
//            System.out.println(io.getMessage());
//        }
        try(BufferedReader br = new BufferedReader(new FileReader(new File("/Users/pavan/Downloads/Programs/FileHandling/src/main/java/io/pavan/note.txt")))){
            while(br.ready())
                System.out.println(br.readLine());
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}