package 자료구조.LinkedList;

class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	public static LinkedList insert(LinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	public static void printList(LinkedList list) {
		StringBuffer sb = new StringBuffer("LinkedList: ");
		Node currNode = list.head;
		while (currNode != null) {
			sb.append(currNode.data).append(" ");
			currNode = currNode.next;
		}
		System.out.println(sb);
	}

	public static LinkedList delete(LinkedList list, int key) {
		Node currNode = list.head, prev = null;

		if (currNode != null && currNode.data == key) {
			list.head = currNode.next;
			System.out.println("head " + key + " found and deleted");
			return list;
		}

		while (currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}

		if (currNode != null) {
			prev.next = currNode.next;
			System.out.println(key + " found and deleted");
			return list;
		}

		System.out.println(key + " not found");
		return list;
	}

	public static LinkedList deleteAtPosition(LinkedList list, int idx) {
		Node currNode = list.head, prev = null;
		if (currNode != null && idx == 0) {
			list.head = currNode.next;
			System.out.println(idx + " position element deleted");
			return list;
		}



		return list;
	}
}

public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 1; i < 10; i++) {
			LinkedList.insert(list, i);
		}
		for (int i = 11; i >= 0; i--) {
			LinkedList.delete(list, i);
		}
		LinkedList.printList(list);
	}
}
