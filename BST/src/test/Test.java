package test;

import bean.BSTInterface;
import bean.BinarySearchTree;


import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst= new BinarySearchTree<>();
//        int[] numbers={25,15,50,10,22,35,70,4,12,18,24,31,44,66,90};
//        int[] numbers={2,1,3,4,5};
        int[] numbers={4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90 };
        for(int temp:numbers){
            bst.add(temp);
        }
        System.out.println(bst.depth());
        System.out.println(bst.size());
        Iterator<Integer> i1= bst.getIterator(BSTInterface.Traversal.Inorder);
        while (i1.hasNext()){
            System.out.print(i1.next()+" ");
        }
        System.out.println();
        Iterator<Integer> i2= bst.getIterator(BSTInterface.Traversal.Preorder);
        while (i2.hasNext()){
            System.out.print(i2.next()+" ");
        }
        System.out.println();
        Iterator<Integer> i3= bst.getIterator(BSTInterface.Traversal.Postorder);
        while (i3.hasNext()){
            System.out.print(i3.next()+" ");
        }
    }
}
