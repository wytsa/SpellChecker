/**
 * 
 */
package edu.wou.cs260.SpellChecker;

import java.util.Collection;
import java.util.Iterator;
//import java.util.Queue;
import java.util.Set;

import edu.wou.cs260.SpellChecker.DLList.DLLNode;

/**
 * @author wytsa
 * 
 */
public class BSTreeSet<E extends Comparable<E>> implements Set<E>, CompareCount {

	public BSTreeSet(){	
		root = null;
		size = 0;
		compareCount = 0;
	}
	
	private int size;
	private Node root;
	private int compareCount;

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		Node temp = new Node(arg0);
		if(temp.item == null){
			throw new NullPointerException();
		}
		else if(subTree == null){
			
		}
		else{
			root = addHelper(root, arg0);
			return true;
		}
	}
	
	private Node addHelper(Node subTree, E item){
		if(subTree == null){
			size++;
			return new Node(item);
		}
		else if(subTree.item.compareTo(item) < 0){// go left
			subTree.lChild = addHelper(subTree.lChild, item);
		}
		else{// go right
			subTree.rChild = addHelper(subTree.rChild, item);
			subTree.height = calcHeight(subTree);
			return subTree;
		}
		return subTree;
	}
	
	private int calcHeight(Node subTree){
		return Math.max(getHeight(subTree.lchild), getHeight.rchild);//TODO
	}
	
	private int getHeight(Node subTree){
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return has(root, arg0);
		
	}
	
	@SuppressWarnings("unchecked")
	private Boolean has(Node subTree, Object item){
		if(subTree.item.compareTo((E) item) == 0){
			compareCount++;
			return true;
		}
		else if(subTree.item.compareTo((E) item) < 0){// go left
			has(subTree.lChild, item);
		}
		else{// if(subTree.item.compareTo(item) > 0){// go right
			has(subTree.rChild, item);
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(root == null){
			return true;
		}
		else{
			return false;
		}
	}

	//@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		
		// TODO Auto-generated method stub
//		CREATE an new Queue<Node>
//		Enqueue (add) only the root node
//		WHILE ( the Queue is not empty) DO
//			Dequeue (remove) a node from the queue
//			With the node that was dequeued, if it has a left child, enqueue that child
//			With the node that was dequeued, if it has a right child, enqueue that child
//			Visit the data element from the dequeued node
//		end while
		return null;//new iterator();
	}
	
	//traversal
	protected void visit(Node current){
		System.out.println(current.item);
	}
	
	protected void preOrder(Node current){
		if(current == null){
			return;
		}
		else{
			visit(current);
			preOrder(current.lChild);
			preOrder(current.rChild);
		}
	}
	
	protected void inOrder(Node current){
		if(current == null){
			return;
		}
		else{
			inOrder(current.lChild);
			visit(current);
			inOrder(current.rChild);
		}
	}
	
	protected void postOrder(Node current){
		if(current == null){
			return;
		}
		else{
			postOrder(current.lChild);
			postOrder(current.rChild);
			visit(current);
		}
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class Node {
		// fields
		E item;
		int height;
		Node lChild;
		Node rChild;

		// methods
		// 3 constructors
		Node() {
			this(null, null, null);
		}

		Node(E item) {
			this(null, item, null);
		}

		Node(Node lChild, E item, Node rChild) {
			this.lChild = lChild;
			this.item = item;
			this.rChild = rChild;
			height = 0;
		}
	}
	
	class TreeIterator implements Iterator<E>{
		
		DLList<E> que = new DLList<E>();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public int getLastCompareCount() {
		// TODO Auto-generated method stub
		return compareCount;
	}

}
