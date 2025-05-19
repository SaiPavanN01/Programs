package io.pavan.ShortestPathAlgo;

import java.util.*;
// https://leetcode.com/problems/word-ladder-ii/
public class WordLadder2_21 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set< String > set = new HashSet< String >();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue<ArrayList< String >> q = new LinkedList < > ();
        ArrayList < String > ls = new ArrayList < > ();
        ls.add(beginWord);
        q.offer(ls);
        ArrayList < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(beginWord);
        int level = 0;

        // A vector to store the resultant transformation sequence.
        List<List<String>> ans = new ArrayList < > ();


        // BFS traversal with pushing the new formed sequence in queue
        // when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {

            ArrayList < String > levelList = q.peek();
            q.remove();

            // Now, erase all words that have been
            // used in the previous levels to transform
            if (levelList.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    set.remove(it);
                }
            }

            String word = levelList.get(levelList.size() - 1);

            // store the answers if the end word matches with endWord.
            if (word.equals(endWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(levelList);
                } else if (ans.get(0).size() == levelList.size()) {
                    ans.add(levelList);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord) ) {
                        levelList.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will
                        // remove from everywhere
                        ArrayList < String > temp = new ArrayList < > (levelList);
                        q.offer(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        levelList.remove(levelList.size() - 1);
                    }
                }

            }
        }
        return ans;
    }
}
