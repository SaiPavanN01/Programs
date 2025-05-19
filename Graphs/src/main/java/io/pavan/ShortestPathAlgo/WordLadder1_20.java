package io.pavan.ShortestPathAlgo;

import java.util.*;
// https://leetcode.com/problems/word-ladder/
public class WordLadder1_20 {
    class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    // Time: O(N*wordLength*26)
    // Space: O(N) -> for set
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
            set.add(wordList.get(i));
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord))
                return steps;
            for(int i=0;i<word.length();i++){
                for(char ch ='a';ch <= 'z';ch++){
                    char[] replaceCharArray = word.toCharArray();
                    replaceCharArray[i] = ch;
                    String replaceWord = new String(replaceCharArray);
                    if(set.contains(replaceWord)){
                        q.offer(new Pair(replaceWord,steps+1));
                        set.remove(replaceWord);
                    }

                }
            }
        }
        return 0;
    }
}
