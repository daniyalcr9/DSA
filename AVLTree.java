import java.util.concurrent.RecursiveTask;

public class AVLTree {
    private int key, height;
    private AVLTree right, left;
    public static final AVLTree NIL = new AVLTree();
    private AVLTree(){
        setRight(this);
        setLeft(getRight());
    }
    public AVLTree (int key){
        setKey(key);
        setRight(NIL);
        setLeft(getRight());
    }
    private AVLTree(int key, AVLTree left, AVLTree right){
        super();
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 1 + Math.max(getLeft().height , getRight().height);
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setRight(AVLTree right) {
        this.right = right;
    }

    public void setLeft(AVLTree left) {
        this.left = left;
    }

    public AVLTree getLeft() {
        return left;
    }

    public AVLTree getRight() {
        return right;
    }
    public int size(){
        if (this == NIL) return 0;
        return 1 + getLeft().height + getRight().height;
    }
    public String toString(){
        if (this == NIL) return "";
        return getLeft() + " " + getKey() + " " + getRight();
    }
    public boolean add(int key){
        int oldSize = size();
        grow(key);
        return size()>oldSize;
    }
    public AVLTree grow(int key){
        if (this == NIL){
            return new AVLTree(key);
        }
        if (key == this.key){
            return this;
        }
        if (key > this.key){
            setLeft(getLeft().grow(key));
        }
        else {
            setRight(getRight().grow(key));
        }
        rebalance();
        height = 1 + Math.max(getRight().height,getLeft().height);
        return this;
    }
    public void rotateLeft(){
        setLeft(new AVLTree(getKey(),getLeft(),getRight().getLeft()));
        setKey(getRight().getKey());
        setRight(getRight().getRight());
    }
    public void rotateRight(){
        setRight(new AVLTree(getKey(),getRight(),getLeft().getRight()));
        setKey(getLeft().getKey());
        setLeft(getLeft().getLeft());
    }
    public void rebalance(){
        if (getRight().height > getLeft().height + 1){
            if (getRight().getLeft().height > getLeft().getLeft().height){
                getRight().rotateRight();
            } this.rotateLeft();
        }
        if (getLeft().height > getRight().height + 1){
            if (getLeft().getRight().height > getRight().getRight().height){
                getLeft().rotateLeft();
            } this.rotateRight();
        }
    }


    public static void main(String[] args) {
        AVLTree treeB =new AVLTree(12);
        AVLTree treeD =new AVLTree(11);
        AVLTree treeE =new AVLTree(32);
        AVLTree treeC =new AVLTree(30,treeD,treeE);
        AVLTree tree =new AVLTree(15,treeB,treeC);

        System.out.println(tree);
      //  System.out.println("Size : " + treeC.size());
        System.out.println(tree.grow(23));
       // System.out.println(tree);
        System.out.println(tree.add(24));
        //System.out.println(tree);
        tree.rebalance();
        System.out.println(tree);

    }
}