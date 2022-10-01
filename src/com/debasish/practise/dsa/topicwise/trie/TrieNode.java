package com.debasish.practise.dsa.topicwise.trie;

public class TrieNode {
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    // isEndOfWord is true if the node represents
    // end of a word
    boolean isEnd;

    TrieNode() {
        isEnd = false;
        for (int i = 0; i < ALPHABET_SIZE; i++)
            children[i] = null;
    }
}
