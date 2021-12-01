// public class binaryTreeTest {
//     public static void main(String[] args) {
//         //Insert test
//         try{
//             binaryTree<Integer> a = new binaryTree<>();
//             a.addElement(1);
//             a.addElement(2);
//             a.addElement(3);
//             a.addElement(4);

//             assert 4 == a.elems : "Failed test #1";
//         }
//         catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//         //Copy test
//         try{
//             binaryTree<Integer> a = new binaryTree<>();
//             a.addElement(1);
//             a.addElement(2);
//             a.addElement(3);
//             a.addElement(4);

//             binaryTree<Integer> b = new binaryTree<>(a);
//             assert 4 == b.elems : "Failed test #2";
//         }
//         catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//         //Search test
//         try{
//             binaryTree<Integer> a = new binaryTree<>();
//             a.addElement(1);
//             a.addElement(2);
//             a.addElement(3);
//             a.addElement(4);

//             assert true == a.searchElements(1) : "Failed test #3";
//             assert true == a.searchElements(2) : "Failed test #3";
//             assert true == a.searchElements(3) : "Failed test #3";
//             assert true == a.searchElements(4) : "Failed test #3";
//         }
//         catch (Exception e) {
//             System.out.println(e.getMessage());
//         }

//         try{
//             binaryTree<Integer> a = new binaryTree<>();
//             a.addElement(1);
//             a.addElement(2);
//             a.addElement(3);
//             a.addElement(4);

//             a.clear();
//             assert 0 == a.elems : "Failed test #4";
//         }
//         catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }
