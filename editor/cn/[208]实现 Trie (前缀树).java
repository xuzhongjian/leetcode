//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 541 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @author zjxu97 at 4/23/21 10:23 PM
 */
class Trie {

    boolean isEnd = false;
    private Trie[] tries = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0) {
            this.isEnd = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        if (this.tries[index] == null) {
            this.tries[index] = new Trie();
        }
        Trie nextTrie = this.tries[index];

        nextTrie.insert(word.substring(1));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0) return this.isEnd;
        int index = word.charAt(0) - 'a';

        Trie nextTire = tries[index];
        if (nextTire == null) return false;

        return nextTire.search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;
        int index = prefix.charAt(0) - 'a';

        Trie nextTire = tries[index];
        if (nextTire == null) return false;

        return nextTire.startsWith(prefix.substring(1));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
