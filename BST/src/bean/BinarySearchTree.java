package bean;

import java.util.Comparator;
import java.util.Iterator;


public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
    protected BSTNode<T> root;
    protected Comparator<T> comp;
    protected boolean found;

    public BinarySearchTree() {
        root = null;
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    public BinarySearchTree(Comparator<T> comp) {
        root = null;
        this.comp = comp;

    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        } else {
            BSTNode<T> temp = root;
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }
            return temp.getInfo();
        }
    }

    @Override
    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            return getPredecessor(root);
        }
    }

    private T getPredecessor(BSTNode<T> node) {
        BSTNode<T> temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getInfo();
    }

    @Override
    public Iterator<T> getIterator(Traversal orderType) {
        final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
        switch (orderType) {
            case Preorder:
                preOrder(root, infoQueue);
                break;
            case Postorder:
                postOrder(root, infoQueue);
                break;
            default:
                inOrder(root, infoQueue);
                break;
        }
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !infoQueue.isEmpty();
            }

            @Override
            public T next() {
                if (infoQueue.isEmpty()) {
                    throw new IndexOutOfBoundsException("illegal invocation of next");
                }
                return infoQueue.dequeue();
            }

            public void remove() {
                throw new UnsupportedOperationException("Unsupported remove attempted");
            }
        };

    }

    private void inOrder(BSTNode<T> node, LinkedQueue<T> infoQueue) {
        if (node != null) {
            inOrder(node.getLeft(), infoQueue);
            infoQueue.enqueue(node.getInfo());
            inOrder(node.getRight(), infoQueue);
        }
    }

    private void postOrder(BSTNode<T> node, LinkedQueue<T> infoQueue) {
        if (node != null) {
            postOrder(node.getLeft(), infoQueue);
            postOrder(node.getRight(), infoQueue);
            infoQueue.enqueue(node.getInfo());
        }
    }

    private void preOrder(BSTNode<T> node, LinkedQueue<T> infoQueue) {
        if (node != null) {
            infoQueue.enqueue(node.getInfo());
            preOrder(node.getLeft(), infoQueue);
            preOrder(node.getRight(), infoQueue);
        }
    }

    @Override
    public boolean add(T element) {
        root = recAdd(element, root);
        return true;
    }

    private BSTNode<T> recAdd(T element, BSTNode<T> node) {
        if (node == null) {
            node = new BSTNode<T>(element);
        } else if (comp.compare(node.getInfo(), element) < 0) {
            node.setRight(recAdd(element, node.getRight()));
        } else {
            node.setLeft(recAdd(element, node.getLeft()));
        }
        return node;
    }

    @Override
    public T get(T target) {
        return recGet(target, root);
    }

    private T recGet(T target, BSTNode<T> node) {
        if (node == null) {
            return null;
        } else if (comp.compare(target, node.getInfo()) > 0) {
            return recGet(target, node.getRight());
        } else if (comp.compare(target, node.getInfo()) < 0) {
            return recGet(target, node.getLeft());
        } else {
            return node.getInfo();
        }
    }

    @Override
    public boolean contains(T element) {
        return recContains(element, root);
    }

    private boolean recContains(T element, BSTNode<T> node) {
        if (node == null) {
            return false;
        } else if (comp.compare(node.getInfo(), element) > 0) {
            return recContains(element, node.getLeft());
        } else if (comp.compare(node.getInfo(), element) < 0) {
            return recContains(element, node.getRight());
        } else {
            return true;
        }
    }

    @Override
    public boolean remove(T target) {
        root = recRemove(target, root);
        return found;
    }

    private BSTNode<T> recRemove(T target, BSTNode<T> node) {
        if (node == null) {
            found = false;
        } else if (comp.compare(target, node.getInfo()) > 0) {
            node.setRight(recRemove(target, node.getRight()));
        } else if (comp.compare(target, node.getInfo()) < 0) {
            node.setLeft(recRemove(target, node.getLeft()));
        } else {
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    private BSTNode<T> removeNode(BSTNode<T> node) {
        T data;
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public int size() {
        return iterSize(root);
    }

    private int recSize(BSTNode<T> node) {
        if (node == null)
            return 0;
        else
            return 1 + recSize(node.getLeft()) + recSize(node.getRight());
    }

    private int iterSize(BSTNode<T> node) {
        int count = 0;
        if (node != null) {
            LinkedStack<BSTNode<T>> ls = new LinkedStack<BSTNode<T>>();
            BSTNode<T> currNode;
            ls.push(root);
            while (!ls.isEmpty()) {
                currNode = ls.top();
                ls.pop();
                count++;
                if (currNode.getLeft() != null) {
                    ls.push(currNode.getLeft());
                }
                if (currNode.getRight() != null) {
                    ls.push(currNode.getRight());
                }
            }
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return getIterator(Traversal.Inorder);
    }
    public int depth(){
        return recDepth(root);
    }
    private int recDepth(BSTNode<T> node){
        if(node==null){
            return 0;
        }else{
            return 1+ Math.max(recDepth(node.getLeft()),recDepth(node.getRight()));
        }
    }
}
