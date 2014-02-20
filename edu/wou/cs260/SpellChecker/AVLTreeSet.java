package edu.wou.cs260.SpellChecker;

import edu.wou.cs260.SpellChecker.BSTreeSet.Node;

/**
 * @author sam
 *
 */
public class AVLTreeSet<E extends Comparable<E>> extends BSTreeSet<E>{
	// fields
	
	protected int balVal(Node temp){
		if(temp == null){
			return 0;
		}
		else{
			return (getHeight(temp.rChild) - getHeight(temp.lChild));
		}
	}
/*	methods
	
	mech methods
	singleLeft
	singleRight
	doubleLeft
	doubleRight
	
	poll methods
	reballanceNode
	*/
	
	protected Node singleRight(Node current){
		Node temp = current.lChild;
		current.lChild = temp.rChild;
		temp.rChild = current;
		current.height = calcHeight(current);
		temp.height = calcHeight(temp);
		return temp;
	}
	
	protected Node doubleRight(Node current){
		current.lChild = singleLeft(current.lChild);
		return singleRight(current);
	}
	
	protected Node singleLeft(Node current){
		Node temp = current.rChild;
		current.rChild = temp.lChild;
		temp.lChild = current;
		current.height = calcHeight(current);
		temp.height = calcHeight(temp);
		return temp;
	}
	
	protected Node doubleLeft(Node current){
		current.rChild = singleRight(current.rChild);
		return singleLeft(current);
	}
	
	protected Node addHelper(Node subTree, E arg0){
		if(subTree == null){
			size++;
			return new Node(arg0);
		}
		else if(subTree.item.compareTo(arg0) > 0){// go left
			subTree.lChild = addHelper(subTree.lChild, arg0);
		}
		else{// go right
			subTree.rChild = addHelper(subTree.rChild, arg0);
		}
		subTree.height = reballanceNode(subTree);
		return subTree;
	}

	private int reballanceNode(Node subTree) {
		if(balVal(subTree) > -2 && balVal(subTree) < 2){
			return calcHeight(subTree);
		}
		// TODO Auto-generated method stub
		return 0;
	}
}
