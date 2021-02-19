package arithmetic.matchstring;


import java.util.TreeMap;

/**
 * Trie树 也就是字典查找树，是一种能够实现在一个字符串集中实现快速查找和匹配的多叉树结构，
 * 关于Trie树的深入分析我就不展开了，因为我自己也理解的不深刻^_^，这里只给出Trie树的定义，
 * 以及常用的应用场景，然后给出一个简单的java实现，当然代码简洁性和性能上有很大的优化空间。
 *
 * 首先，Trie树的定义（或者说是性质）：
 *
 * 1. 根节点是一个空节点，不包含字符
 * 2. 每个节点含有一个字符，以及若干个子节点
 * 3. 每个节点的所有子节点所包含的字符都不相同
 * 3. 树的每个节点到根节点的路径上的所有字符组成一个字符串，表示这个字符串在树中可能存在，或者至少Trie树中存在以此字符串为前缀的字符串
 * 4. 每个非根节点还应该包含一个整型数值，表示根节点到这个节点组成的字符串在Trie树中出现的次数
 *
 *
 * Trie数的常见应用场景：
 * 1. 字符串检索
 * 2. 词频统计
 * 3. 前缀检索
 * 4.前缀词频统计
 * 5. 对所有的字符串按照字典序排序
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("flink");
        trie.insert("netty");
        trie.insert("mysql");
        trie.insert("redis");

        // false
        System.out.println(trie.search("mongodb"));
        // true
        System.out.println(trie.search("redis"));
        //false
        System.out.println(trie.search("my"));
        // true
        System.out.println(trie.search("mysql"));
        // true
        System.out.println(trie.startWith("my"));
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        insert(word,root,0);
    }

    /** 将从index处开始的字串插入到root的子节点中，即将index对应的字符插入到root的子节点中 */
    private void insert(String word, TrieNode root, int index) {
        if (index >= word.length() || index <= -1) return;
        char c = word.charAt(index);
        TreeMap<Character, TrieNode> children = root.children;
        if (children == null){
            children = new TreeMap<>();
            root.children = children;
        }

        if (!children.containsKey(c)){
            children.put(c,new TrieNode(c));
        }

        if (index == word.length()-1){
            children.get(c).frequency++;
            return;
        }
        insert(word,children.get(c),index+1);
    }

    public boolean search(String word){
        return search(word,root,0);
    }

    private boolean search(String word, TrieNode root, int index) {
        if (index <= -1 || index >= word.length()) return false;
        char c = word.charAt(index);
        if (root.children == null || !root.children.containsKey(c)) return false;

        if (index == word.length() -1){
            return root.children.get(c).frequency > 0;
        }
        return search(word, root.children.get(c), index+1);
    }

    public boolean startWith(String prefix){
        return startWith(prefix,root,0);
    }

    private boolean startWith(String prefix, TrieNode root, int index) {
        if (index <= -1 || index >= prefix.length()) return false;
        char c = prefix.charAt(index);
        if (root.children == null || !root.children.containsKey(c)) return false;
        if (index == prefix.length() -1) return true;
        return startWith(prefix, root.children.get(c), index+1);

    }

    class TrieNode{
        char c;
        int frequency = 0;
        TreeMap<Character,TrieNode> children;

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {}
    }

}
