package assignments.sheet_7;

import java.util.*;

class BinaryTree<T> {
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        return node;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }

    public Iterator<T> iterate(Iterable<T> iter) {
        return iter.iterator();
    }
}

class InorderIterable<T> implements Iterable<T> {
    private final BinaryTree<T> binaryTree;

    public InorderIterable(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new InorderIterator<T>(binaryTree);
    }

    private class InorderIterator<T> implements Iterator<T> {
        Queue<BinaryTree<T>> queue;
        private InorderIterator(BinaryTree<T> binaryTree) {
            this.queue = createInorderTraversalResult(binaryTree);
        }

        private Queue<BinaryTree<T>> createInorderTraversalResult(BinaryTree<T> binaryTree){
            if (binaryTree == null) return new LinkedList<>();
            Queue<BinaryTree<T>> queue = new LinkedList<>();
            Stack<BinaryTree<T>> stack = new Stack<>();

            BinaryTree<T> curr = binaryTree;

            while(!stack.isEmpty() || curr != null){
                if (curr != null){
                    stack.push(curr);
                    curr = curr.getLeft();
                }else{
                    BinaryTree<T> node = stack.pop();
                    queue.add(node);
                    curr = node.getRight();
                }
            }
            return queue;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (queue.isEmpty()) throw new NoSuchElementException();
            return queue.remove().getValue();
        }
    }
}

class PreorderIterable<T> implements Iterable<T> {
    private final BinaryTree<T> binaryTree;

    public PreorderIterable(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new PreorderIterator<>(binaryTree);
    }

    private class PreorderIterator<T> implements Iterator<T> {
        Queue<BinaryTree<T>> queue;
        private PreorderIterator(BinaryTree<T> binaryTree) {
            this.queue = createPreorderTraversalResult(binaryTree);
        }

        private Queue<BinaryTree<T>> createPreorderTraversalResult(BinaryTree<T> root){
            if (root == null) return new LinkedList<>();
            Queue<BinaryTree<T>> queue = new LinkedList<>();
            Stack<BinaryTree<T>> stack = new Stack<>();

            stack.push(root);

            while(!stack.isEmpty()){
                BinaryTree<T> curr = stack.pop();
                queue.add(curr);
                if(curr.getRight() != null){
                    stack.push(curr.getRight());
                }
                if (curr.getLeft() != null)  {
                    stack.push(curr.getLeft());
                }
            }
            return queue;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (queue.isEmpty()) throw new NoSuchElementException();
            return queue.remove().getValue();
        }
    }
}

class PostorderIterable<T> implements Iterable<T> {
    private final BinaryTree<T> binaryTree;

    public PostorderIterable(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new PostorderIterator<>(binaryTree);
    }

    private class PostorderIterator<T> implements Iterator<T> {
        Queue<BinaryTree<T>> queue;
        private PostorderIterator(BinaryTree<T> binaryTree) {
            this.queue = createPostorderTraversalResult(binaryTree);
        }

        private Queue<BinaryTree<T>> createPostorderTraversalResult(BinaryTree<T> root){
            if (root == null) return new LinkedList<>();
            Queue<BinaryTree<T>> queue = new LinkedList<>();
            Stack<BinaryTree<T>> stack = new Stack<>();

            stack.push(root);
            BinaryTree<T> prev = null;

            while(!stack.isEmpty()){
                BinaryTree<T> curr = stack.peek();
                if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
                    if (curr.getLeft() != null) stack.push(curr.getLeft());
                    else if (curr.getRight() != null) stack.push(curr.getRight());
                    else {
                        stack.pop();
                        queue.add(curr);
                    }
                }else if (curr.getLeft() == prev) {
                    if (curr.getRight() != null) {
                        stack.push(curr.getRight());
                    }else{
                        stack.pop();
                        queue.add(curr);
                    }
                }else if (curr.getRight() == prev) {
                    stack.pop();
                    queue.add(curr);
                }
                prev = curr;
            }
            return queue;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (queue.isEmpty()) throw new NoSuchElementException();
            return queue.remove().getValue();
        }
    }
}

class LevelorderIterable<T> implements Iterable<T> {
    private final BinaryTree<T> binaryTree;

    public LevelorderIterable(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new LevelorderIterator<>(binaryTree);
    }

    private class LevelorderIterator<T> implements Iterator<T> {
        Queue<BinaryTree<T>> queue;
        private LevelorderIterator(BinaryTree<T> binaryTree) {
            this.queue = createLevelOrderTraversalResult(binaryTree);
        }

        private Queue<BinaryTree<T>> createLevelOrderTraversalResult(BinaryTree<T> root){
            if (root == null) return new LinkedList<>();
            Queue<BinaryTree<T>> resultQueue = new LinkedList<>();
            Queue<BinaryTree<T>> queue = new LinkedList<>();

            queue.add(root);

            while(!queue.isEmpty()){
                BinaryTree<T> curr = queue.remove();
                resultQueue.add(curr);
                if (curr.getLeft() != null)  {
                    queue.add(curr.getLeft());
                }
                if(curr.getRight() != null){
                    queue.add(curr.getRight());
                }
            }
            return resultQueue;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (queue.isEmpty()) throw new NoSuchElementException();
            return queue.remove().getValue();
        }
    }
}


public class BinTreeTraversal {
    public static void main(String[] args) {
        /*
            Following is an usage example, creating a binary tree and printing out all values in the order of the given iterator
         */

        BinaryTree<Integer> root = new BinaryTree<>(1);

        root.setLeft(new BinaryTree<>(2));
        root.setRight(new BinaryTree<>(3));
        root.getLeft().setLeft(new BinaryTree<>(4));
        root.getLeft().setRight(new BinaryTree<>(5));
        // root.getRight().setLeft(new BinaryTree<>(6));
        // root.getRight().setRight(new BinaryTree<>(7));

        // Your implementation should be able to perform a for each with the given syntax
        System.out.println("Inorder:");
        for (int item : new InorderIterable<>(root)) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("Preorder:");
        for (int item : new PreorderIterable<>(root)) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("Postorder:");
        for (int item : new PostorderIterable<>(root)) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("Levelorder:");
        for (int item : new LevelorderIterable<>(root)) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}