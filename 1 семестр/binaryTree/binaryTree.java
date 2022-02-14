import java.util.Stack;

class binaryTreeNode<R extends Comparable<R>> {
    binaryTreeNode<R> right;
    binaryTreeNode<R> left;
    R data;

}

public class binaryTree<T extends Comparable<T>>{

    binaryTreeNode<T> root;
    int elems;

    public binaryTree() {
        this.root = root;
    }

    public binaryTree(binaryTree<T> tree) {
        Stack<binaryTreeNode<T>> stack = new Stack<>();
        binaryTreeNode<T> head = tree.root;
        while(head != null){
            this.addElement(head.data);
            if(head.right != null){
                stack.add(head.right);
            }
            if(head.left != null){
                head = head.left;
            }
            else if (stack.isEmpty()){
                break;
            }
            else{
                head = stack.pop();
            }
        }
    }    

    public void addElement(T data){
        binaryTreeNode<T> tree = new binaryTreeNode<T>();
        tree.data = data;
        if(elems == 0){
            root = tree;
            elems++;
        }
        else{
            binaryTreeNode<T> temp = root;

            while(true){          
                if(tree.data.compareTo(temp.data) > 0 && temp.right == null){
                    temp.right = tree;
                    elems++;
                    break;
                }
                if(tree.data.compareTo(temp.data) > 0 && temp.right != null){
                    temp = temp.right;
                }
                if(tree.data.compareTo(temp.data) < 0 && temp.left == null){
                    temp.left = tree;
                    elems++;
                    break;
                }
                if(tree.data.compareTo(temp.data) < 0 && temp.left != null){
                    temp = temp.left;
                }
            }
        }

    }

    public boolean searchElements(T data){
        binaryTreeNode<T> temp = root;
        binaryTreeNode<T> tree = new binaryTreeNode<T>();
        tree.data = data;
        while(true){
            if(data.compareTo(temp.data) > 0 && temp.data != tree.data){
                if(temp.right == null){
                    return false;
                }
                else{
                    temp = temp.right;
                    continue;
                }
            }
            if(data.compareTo(temp.data) < 0 && temp.data != tree.data){
                if(temp.left == null){
                    return false;
                }
                else{
                    temp = temp.left;
                    continue;
                }
            }
            if(data.compareTo(temp.data) == 0){
                return true;
            }
        }
    }

    public void clear(){
        this.root = null;
        this.elems = 0;
    }
    public static void main(String[] args) {
        binaryTree<Integer> a = new binaryTree<>();
        int[] arr = {12, 11, 14, 15, 1, 2 ,6, 3, 4, 18, 19, 16, 5, 7, 10, 8, 20, 9, 13, 17, 23, 21, 24, 22, 25};
        for(int now : arr){
            a.addElement(now);
        } 
        if(a.searchElements(18)){
            System.out.println("OK");
        }
        else{
            System.out.println("Bad");
        }
    }
}
