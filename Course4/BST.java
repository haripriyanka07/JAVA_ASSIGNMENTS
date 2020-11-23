public class BST {
    private BSTNode root;
    public BST(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int data){
        root = insert(root, data);
    }
    private BSTNode insert(BSTNode node, int data){
        if(node == null){
            node = new BSTNode(data);
        }else {
            if(data <= node.getData()){
                node.left = insert(node.left, data);
            }else{
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    public void delete(int k){
        if(isEmpty())
            System.out.println("Empty");
        else if (search(k) == false)
            System.out.println("not Present");
        else
            root = delete(root, k);
            System.out.println("Deleted");
    }
    private BSTNode delete(BSTNode root, int data){
        BSTNode pt, pt2, n;
        if(root.getData() == data){
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if(lt == null && rt == null)
                return null;
            else if(lt == null){
                pt=rt;
                return pt;
            }
            else if(rt == null){
                pt=lt;
                return pt;
            }
            else{
                pt2 = rt;
                pt = rt;
                while (pt.getLeft() != null)
                    pt = pt.getLeft();
                pt.setLeft(lt);
                return pt2;
            }
        }
        if(data<root.getData()){
            n = delete(root.getLeft(), data);
            root.setLeft(n);
        }
        else {
            n = delete(root.getRight(), data);
            root.setRight(n);
        }
        return root;
    }
    public boolean search(int val) {
        boolean found = false;
        while((root!=null) && !found){
            int rval = root.getData();
            if(val<rval)
                root = root.getLeft();
            else if (val < rval)
                root = root.getRight();
            else {
                found = true;
                break;
            }
            found = search(val);
        }
        return found;
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(BSTNode r){
        if(r!=null){
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(6);
        tree.insert(3);
        tree.insert(9);
        tree.insert(11);
        tree.insert(15);
        tree.insert(8);
        tree.insert(10);
        tree.inorder();
        tree.delete(8);
        tree.delete(6);
        tree.delete(11);
        tree.inorder();
    }
}
class BSTNode{
    BSTNode left, right;
    int data;

    public BSTNode(){
        left = null;
        right = null;
        data = 0;
    }
    public BSTNode(int n){
        left = null;
        right = null;
        data = n;
    }
    public void setLeft(BSTNode n){
        left = n;
    }
    public void setRight(BSTNode n){
        right = n;
    }
    public BSTNode getLeft(){
        return left;
    }
    public BSTNode getRight(){
        return right;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
