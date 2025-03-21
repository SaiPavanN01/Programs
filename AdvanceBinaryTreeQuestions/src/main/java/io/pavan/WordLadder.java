package io.pavan;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int length = 0;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            length++;
            for(int i =0; i<size;i++){
                String current = queue.poll();
                for(int j=0;j<current.length();j++){
                    char[] temp = current.toCharArray();
                    for(char ch = 'a';ch<='z';ch++){
                        temp[j]=ch;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord))
                            return length+1;
                        if(wordList.contains(newWord) && !visited.contains(newWord)){
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
