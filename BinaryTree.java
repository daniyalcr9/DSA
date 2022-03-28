
// TRAVERSAL IN BINARY TREE
public class BinaryTree {

    Object root;
    BinaryTree left,right;

    public BinaryTree (Object root){
        this.root = root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right){
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public void setRoot(Object root) {
        this.root = root;
    }

    public Object getRoot() {
        return root;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getLeft() {
        return left;
    }

    //PRE ORDER TRAVERSAL
//    public String toString(){
//        StringBuffer buf = new StringBuffer("");
//        buf.append(root);
//        if (left != null){
//            buf.append("," + left);
//       }
//        if (right != null){
//            buf.append("," + right);
//        }
//        return buf + "";
//    }

    // POST ORDER TRAVERSAL
//    public String toString(){
//        StringBuffer buf = new StringBuffer("");

//        if (left != null){`
//            buf.append(left + ",");
//        }
//        if (right != null){
//            buf.append(right + ",");
//        }
//        buf.append(root);
//        return buf + "";
//    }

    // IN ORDER TRAVERSAL
        public String toString(){
        StringBuffer buf = new StringBuffer("");
        if (left != null){
            buf.append(left + ",");
       }
            buf.append(root);

        if (right != null){
            buf.append("," + right);
        }
        return buf + "";
    }

    public static int size(BinaryTree root)
    {
        if (root == null)
            return 0;

        else return (size(root.left) + 1 + size(root.right));

    }
    public static boolean isComplete(BinaryTree root){

        if(root.left != null && root.right != null)
            return true;
        else return false;
    }
    static boolean isLeaf(BinaryTree root) {

        if (root.right == null || root.left == null)
            return true;

        else return false;
    }
    public static void main(String[] args) {
        BinaryTree treeB = new BinaryTree("B");
        BinaryTree treeD = new BinaryTree("D");
        BinaryTree treeE = new BinaryTree("E");
        BinaryTree treeC = new BinaryTree("C",treeD,treeE);
        BinaryTree tree = new BinaryTree("A",treeB,treeC);

        System.out.println(tree);
        System.out.println();
    }
}
