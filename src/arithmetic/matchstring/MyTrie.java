package arithmetic.matchstring;


public class MyTrie {
    public static void main(String[] args) throws Exception {
        MyTrie trie = new MyTrie();
        trie.insert("flink");
        trie.insert("netty");
        trie.insert("mysql");
        trie.insert("redis");
        trie.insert("my");
        trie.insert("my");
        trie.insert("my");
        trie.insert("my");
        trie.insert("my");
        trie.insert("my");

        // false
        System.out.println(trie.search("mongodb"));
        // true
        System.out.println(trie.search("redis"));
        //false
        System.out.println(trie.search("my"));
        // true
        System.out.println(trie.search("mysql"));
        System.out.println(trie.getWordFrequency("my"));
        // true
//        System.out.println(trie.startWith("my"));
        trie.remove("my");
        System.out.println(trie.getWordFrequency("my"));
        System.out.println(trie.startWith("my"));
        System.out.println(trie.startWith("my"));
        System.out.println(trie.startWith("my"));
        trie.remove("my");
        System.out.println();
        System.out.println(trie.getWordFrequency("my"));
    }

    // 这个方法可以优化一下。。。。
    public boolean startWith(String word) throws Exception {
        int wordFrequency = getWordFrequency(word);
        return getWordFrequency(word) > 0;
    }

    private TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    // 插入元素
    public void insert(String word){
        insert(word,root,0);
    }

    private void insert(String word, TrieNode root, int index) {
        if (index < 0 || index >= word.length()) return;
        if (root.children[word.charAt(index) - 'a'] == null){
            root.children[word.charAt(index) - 'a'] = new TrieNode(word.charAt(index));
        }

        if (index == word.length()-1){
            root.children[word.charAt(index) - 'a'].frequency ++;
            return ;
        }

        insert(word, root.children[word.charAt(index++) - 'a'], index);
    }

    //搜索元素，看该元素是否存在
    public boolean search(String word){
        return search(word,root,0);
    }

    private boolean search(String word, TrieNode root, int index) {
        if (index < 0 || index >= word.length()) return false;
        if (index == word.length()-1)return true;
        if (root.children[word.charAt(index) - 'a'] == null){
            return false;
        }
        return search(word, root.children[word.charAt(index++) - 'a'], index);
    }

    // 查看元素词频
    public int getWordFrequency(String word) throws Exception {
        if (!search(word)){
            throw new Exception("This word isn't exist in the tree.");
        }
        return getWordFrequency(word,root,0);
    }

    private int getWordFrequency(String word, TrieNode root, int index) {
        if (index == word.length()-1){
            return root.children[word.charAt(index) - 'a'].frequency;
        }
        return getWordFrequency(word, root.children[word.charAt(index++) - 'a'], index);
    }

    // 插入元素
    public void remove(String word) throws Exception {
        if (!search(word)){
            throw new Exception("This word isn't exist in the tree.");
        }
        if (getWordFrequency(word) <= 0){
            throw new Exception("This word isn't exist Exception, because of the @linkgetWordFrequency(word) == 0.");
        }
        remove(word,root,0);
    }

    private void remove(String word, TrieNode root, int index) {
        if (index == word.length()-1){
            root.children[word.charAt(index) - 'a'].frequency --;
            return;
        }
        remove(word, root.children[word.charAt(index++) - 'a'], index);
    }

    class TrieNode{
        char data;
        int frequency;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
            frequency = 0;
        }

        public TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            frequency = 0;
        }
    }
}
