package com.tedemach.August2;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    class MyHashSet {

        private HashList[] memo;
        private final int MOD_OP = 1097;

        /** Initialize your data structure here. */
        public MyHashSet() {
            memo = new HashList[MOD_OP];
            Arrays.fill(memo, new HashList());
        }

        public void add(int key) {
            memo[hashIndex(key)].add(key);
        }

        public void remove(int key) {
            memo[hashIndex(key)].remove(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return memo[hashIndex(key)].contains(key);
        }

        private int hashIndex(int key) {
            return key % MOD_OP;
        }

        private class HashList {
            private LinkedList<Integer> list;

            public HashList() {
                list = new LinkedList<>();
            }

            public void add(int val) {
                if (contains(val))
                    return; // to not have duplicate
                list.addFirst(val); // otherwise add
            }

            public void remove(int val) {
                if (!contains(val))
                    return;
                list.remove(Integer.valueOf(val));
            }

            public boolean contains(int val) {
                return list.contains(val);
            }
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
     * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
     * obj.contains(key);
     */
}