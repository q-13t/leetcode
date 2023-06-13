package le.test.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class NumericalTrie {
    private class NumericalTrieNode {
        int count;
        Map<Integer, NumericalTrieNode> children;

        public NumericalTrieNode() {
            this.count = 0;
            this.children = new HashMap<>();
        }
    }

    NumericalTrieNode trie;

    public NumericalTrie() {
        this.trie = new NumericalTrieNode();
    }

    public void insert(int[] array) {
        NumericalTrieNode trie = this.trie;
        for (int num : array) {
            if (!trie.children.containsKey(num)) {
                trie.children.put(num, new NumericalTrieNode());
            }
            trie = trie.children.get(num);
        }
        trie.count += 1;
    }

    public int search(int[] array) {
        NumericalTrieNode trie = this.trie;
        for (int num : array) {
            if (trie.children.containsKey(num)) {
                trie = trie.children.get(num);
            } else {
                return 0;
            }
        }
        return trie.count;
    }
}