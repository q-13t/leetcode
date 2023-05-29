package le.test;

public class Trie {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void addAll(String[] words) {
        for (String string : words)
            insert(string);
    }

    public void insert(String word) {
        TrieNode walk = root;
        for (char iterable : word.toCharArray()) {
            if (walk.children[iterable - 'a'] == null)
                walk.children[iterable - 'a'] = new TrieNode();

            walk = walk.children[iterable - 'a'];
        }
        walk.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode walk = root;
        for (char iterable : word.toCharArray()) {
            if (walk.children[iterable - 'a'] == null)
                return false;

            walk = walk.children[iterable - 'a'];
        }
        return walk.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode walk = root;
        for (char iterable : prefix.toCharArray()) {
            if (walk.children[iterable - 'a'] == null)
                return false;

            walk = walk.children[iterable - 'a'];
        }
        return true;
    }
}
