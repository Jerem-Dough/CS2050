/*
Jeremy Dougherty
 */
public class BST{
    private BSTNode root;
    public BST(){
        this.root = null;
    }
    BSTNode getRoot(){
        return this.root;
    }

    public void insert(String data){
        data = data.toLowerCase().replaceAll("[^a-z]","");
        this.root = insertMethod(this.root, data);
    }

    private BSTNode insertMethod(BSTNode root, String data){
        if(root == null){
            root = new BSTNode(data);
            return root;
        }
        if(data.compareTo(root.word) < 0 ){
            root.left = insertMethod(root.left, data);
        }
        else if(data.compareTo(root.word) > 0 ){
            root.right = insertMethod(root.right, data);
        }
        return root;
    }

    public void inOrder(BSTNode word){
        if(word == null){
            return;
        }
        inOrder(word.left);
        System.out.println(word.word + " ");
        inOrder(word.right);
    }

    public int nodeCounter(BSTNode word){
        if(word == null){
            return 0;
        }
        int i = nodeCounter(word.left);
        int j = nodeCounter(word.right);
        return 1 + i + j;
    }

    public int treeHeight(BSTNode word){
        if(word == null){
            return 0;
        }
        int leftHeight = treeHeight(word.left);
        int rightHeight = treeHeight(word.right);

        if(leftHeight > rightHeight){
            return leftHeight + 1;
        }
        else{
            return rightHeight + 1;
        }
    }

    public int maxNodes(int h){
        return (int) Math.pow(2, h) - 1;
    }
}
