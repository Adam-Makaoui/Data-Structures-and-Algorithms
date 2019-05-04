import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RedBlackBST {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root; // root of the BST
	private int numRed = 0;
	private int numBlack = 0;

	// ----------------------------------NODE CLASS------------------------------//
	// BST helper node data type
	private class Node {
		private int key; // key
		private Node left, right; // links to left and right subtrees
		private boolean color; // color of parent link
		private int size; // subtree count

		public Node(int key, boolean color, int size) {
			this.key = key;
			this.color = color;
			this.size = size;
		}
	}
	// -----------------------------NODE CLASS END---------------------------//

	// Contructor
	public RedBlackBST() {

	}

	/***************************************************************************
	 * Node helper methods.
	 ***************************************************************************/
	// is node x red; false if x is null ?
	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	// number of node in subtree rooted at x; 0 if x is null
	private int size(Node x) {
		if (x == null)
			return 0;
		return x.size;
	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 * 
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return size(root);
	}

	/**
	 * Is this symbol table empty?
	 * 
	 * @return {@code true} if this symbol table is empty and {@code false}
	 *         otherwise
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/***************************************************************************
	 * Red-black tree insertion.
	 ***************************************************************************/

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the
	 * old value with the new value if the symbol table already contains the
	 * specified key. Deletes the specified key (and its associated value) from this
	 * symbol table if the specified value is {@code null}.
	 *
	 * @param key the key
	 * @param val the value
	 * @throws NullPointerException if {@code key} is {@code null}
	 */
	public void put(int key) {

		root = put(root, key);
		if (isRed(root)) { // code added
			numRed--;
			numBlack++;
		}
		root.color = BLACK;
	}

	// insert the key-value pair in the subtree rooted at h
	private Node put(Node h, int key) {
		if (h == null) {
			numRed++; // code added
			return new Node(key, RED, 1);
		}

		int cmp = key - h.key; // this node's key - root's key
		if (cmp < 0) // node's key is smaller than this subroot node's key
			h.left = put(h.left, key);
		else if (cmp > 0)// node's key is smaller than this subroot node's key
			h.right = put(h.right, key);
		else
			h.key = key; // replace key if equal, hence no duplicates

		// fix-up any right-leaning links
		if (isRed(h.right) && !isRed(h.left)) // right leaning fix
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
			numBlack += 1;
			numRed--;
		}
		h.size = size(h.left) + size(h.right) + 1;

		return h;
	}

	/**
	 * @return an integer percentage of the red links in the tree
	 */
	/*
	 * int percentRed() { return 0; }
	 */

	/***************************************************************************
	 * Red-black tree helper functions.
	 ***************************************************************************/

	// make a left-leaning link lean to the right
	private Node rotateRight(Node h) {
		// assert (h != null) && isRed(h.left);
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = RED;
		x.size = h.size;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}

	// make a right-leaning link lean to the left
	private Node rotateLeft(Node h) {
		// assert (h != null) && isRed(h.right);
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = RED;
		x.size = h.size;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}

	// flip the colors of a node and its two children
	private void flipColors(Node h) {
		// h must have opposite color of its two children
		// assert (h != null) && (h.left != null) && (h.right != null);
		// assert (!isRed(h) && isRed(h.left) && isRed(h.right))
		// || (isRed(h) && !isRed(h.left) && !isRed(h.right));
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}

	private int percentRed() {
		System.out.printf("Black nodes = %d Red Nodes = %d \n", numBlack, numRed);
		int totalNodes = numBlack + numRed;
		int result = (int) (Math.round((((numRed / ((float) totalNodes))) * 100))); // ceil rounds up decimal relative
																					// to
																					// round which rounds down
		System.out.printf("Red Node percentage is : %d\n", result);
		return result;
	}

	/**
	 * Unit tests the {@code RedBlackBST} data type.
	 *
	 * @param args the command-line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
		RedBlackBST st = new RedBlackBST();

		// Openong the file contents and allowing for reading
		try {
			BufferedReader input = new BufferedReader(new FileReader(args[0]));

			// Reads an entire line in a text file as a huge string
			String digitHolderLine = input.readLine();

			// regex '\\W' matches and splits any non word character to create an array with
			// just actual shit
			String[] digitArray = digitHolderLine.split("\\W");

			// looping through every item of the file, transcribing it from string to int
			// and adding it to the BST using 'put'
			int i, result = 0;
			for (i = 0; i < digitArray.length; i++) {
				st.put(Integer.parseInt(digitArray[i]));
			}
			// running the method to return a integer
			System.out.println("Reading result from " + args[0]);
			st.percentRed();
		} catch (IOException e) {
			System.out.println("ERROR: No file provided with that name...");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: No file provided with that name...");
		}

		System.out.println("--------------------------------------------");

		// -----------------------------ONE HUNDRED RANDOMIZED
		// TESTS-------------------------------//
		for (int hundredTests = 0; hundredTests < 100; hundredTests++) {

			System.out.println("inserting 10^4 Random keys");
			RedBlackBST st2 = new RedBlackBST();
			// inserting random keys
			for (int j = 0; j < 10000; j++) {
				int randomNum = (int) (Math.random() * ((100000000 - 0) + 1)) + 0;
				st2.put(randomNum);
				// System.out.println(randomNum);
			}

			st2.percentRed();
			System.out.println("--------------------------------------------");

			System.out.println("inserting 10^5 Random keys");
			RedBlackBST st3 = new RedBlackBST();
			// inserting random keys
			for (int k = 0; k < 100000; k++) {
				int randomNum = (int) (Math.random() * ((100000000 - 0) + 1)) + 0;
				st3.put(randomNum);
				// System.out.println(randomNum);
			}
			st3.percentRed();
			System.out.println("--------------------------------------------");

			System.out.println("inserting 10^6 Random keys");
			RedBlackBST st4 = new RedBlackBST();
			// inserting random keys
			for (int l = 0; l < 1000000; l++) {
				int randomNum = (int) (Math.random() * ((100000000 - 0) + 1)) + 0;
				st4.put(randomNum);
				// System.out.println(randomNum);
			}
			st4.percentRed();
			System.out.println("--------------------------------------------");

		} // end of 100 tests
	} // end of main method

} // end of class

/******************************************************************************
 * Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 * This file is part of algs4.jar, which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 *
 *
 * algs4.jar is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * algs4.jar is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * algs4.jar. If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
