package io.pavan;

public class KarpRabinAlgo {
    private final int PRIME =101;
    public double calculateHash(String pattern){
        double hash =0;
        for(int i=0;i<pattern.length();i++){
            hash+=pattern.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }
    public double updateHash(double previousHash,char olChar, char newChar,int patternLength){
        double newHash=(previousHash-olChar)/PRIME;
        newHash+=newChar*Math.pow(PRIME,patternLength-1);
        return newHash;
    }
    public void search(String text, String pattern){
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0,patternLength));
        for(int i=0; i<=text.length()-patternLength; i++){
            if(textHash == patternHash){
                if(text.substring(i,i+patternLength).equals(pattern))
                    System.out.println("Pattern found at "+i);
            }
            if(i<text.length()-patternLength){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
            }
        }
    }
}
