package com.tedemach.August5;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class Trie {
        private Map<Character, Trie> children;
        private boolean isEnd;

        public Trie() {
            children = new HashMap<>();
            isEnd = false;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public Trie add(char c) {
            if (children.containsKey(c))
                return children.get(c);
            Trie trie = new Trie();
            children.put(c, trie);
            return trie;
        }

        public Trie getOrNull(char c) {
            return children.getOrDefault(c, null);
        }
    }

    private Trie root;

    /** Initialize your data structure here. */
    public Solution() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie current = root;
        for (char c : word.toCharArray()) {
            current = current.add(c);
        }
        current.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Trie trie) {
        if (trie == null || word.length() < index)
            return false;
        if (index == word.length())
            return trie.isEnd();
        char c = word.charAt(index);
        if (c != '.') {
            return search(word, index + 1, trie.getOrNull(c));
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (search(word, index + 1, trie.getOrNull(i)))
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */

/**
 * Trie (currentChar, HM<Suffix>, isEnd) search(word) .abc [a-z]abc
 *
 *
 */