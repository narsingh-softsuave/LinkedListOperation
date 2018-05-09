package com.softsuave.linkedlist;

import com.softsuave.linkedlist.entity.Node;

/**
 * @author Nar Singh
 *
 */
public class LinkedList {

	public Node head;

	public LinkedList() {
		this.head = null;
	}

	/**
	 * Print list values
	 */
	public void print() {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return;
		}
		System.out.print("\nList = [");
		Node copy = head;
		while (copy != null) {
			System.out.print(copy.data + "->");
			copy = copy.next;
		}
		System.out.print( "null]\n");
	}

	/**
	 * Insert value to the List
	 * @param data - value to insert 
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			newNode.next = null;
			head = newNode;
			return;
		}
		Node headCopy = head;
		while (headCopy.next != null) {
			headCopy = headCopy.next;
		}
		headCopy.next = newNode;
	}

	/**
	 * Remove last element from the List
	 */
	public void removeLastElement() {
		if (isEmpty())
			return;
		Node headCopy = head;
		Node prevNode = null;
		while (headCopy != null) {
			if (headCopy.next == null) {
				if (prevNode == null) {
					head = null;
					return;
				}
				prevNode.next = null;
				return;
			}
			prevNode = headCopy;
			headCopy = headCopy.next;
		}
	}

	/**
	 * Remove elements which are greater than the target value
	 * @param data - value to compare 
	 */
	public void removeElementsGtThan(int data) {
		if (isEmpty())
			return;
		if (head.data > data && head.next == null) {
			head = null;
			return;
		}
		Node currNode = head;
		Node prevNode = null;

		while (currNode != null && currNode.data > data) {
			prevNode = currNode;
			currNode = currNode.next;
		}

		if (prevNode != null)
			prevNode.next = null;

		Node newHead = currNode;

		if (currNode == null) {
			head = null;
			return;
		}

		while (currNode.next != null) {
			if (currNode.next.data > data) {
				currNode.next = currNode.next.next;
			} else {
				currNode = currNode.next;
			}
		}
		head = newHead;
	}

	/**
	 * Check list is empty or not
	 */
	public Boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

}
