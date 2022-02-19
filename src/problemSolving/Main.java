package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int i) {
		this.val = i;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val + "";
	}
}

public class Main {

	static Integer[] nums = { 7, 9, 11 };

	static String[] chars = { "a", "b", "c", "d", "a", "e", "d", "z" };

	static List<ListNode> list = Arrays.asList(new ListNode(3), new ListNode(4), new ListNode(8), new ListNode(6));

	/**
	 * ############################ MAIN #######################
	 * ############################
	 */
	public static void main(String[] args) {
		sortByComparator(list, valComparator);
		// System.out.println(Arrays.toString(rotateArrayAtIndex(nums, 2)));
		System.out.println();
	}
	// ############################ ############################
	// ############################

	public static ListNode reverseList1(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = curr.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		return prev;
	}

	public static String LRUCache(String[] strArr) {
		List<String> cache = new ArrayList<String>();
		for (String c : strArr) {
			if (cache.contains(c)) {
				cache.remove(cache.indexOf(c)); // remove the element to be reinserted in the front
				cache.add(c);
			} else {
				cache.add(c);
			}
			if (cache.size() > 5) {
				cache.remove(0);
			}
		}
		return String.join("-", cache);
	}

	/**
	 * shift Or rotate an array by degree
	 */
	public static int[] rotateArrayAtIndex(int[] arr, int degree) {
		while (degree > 0) {
			int temp = arr[0];
			int n = arr.length;
			for (int i = 0; i < n; i++) {
				temp = arr[(i + 1) % n] + temp;
				arr[(i + 1) % n] = temp - arr[(i + 1) % n];
				temp = temp - arr[(i + 1) % n];
			}
			degree--;
		}
		return arr;
	}

	/**
	 * ############################# COMPARAISON ##############################
	 * Comparable interface: Is called by sort method in collections but it defines
	 * a static sorting criteria (sorting based on 1 parameters and the sorting
	 * parameters : arrcannot be changed dynamically)
	 * 
	 * Comparator interface: Comparator, we can define multiple methods with sorting
	 * method based on our requirements.
	 *
	 * Using comparator to determine the criteria variable
	 */
	public static Comparator<ListNode> valComparator = (el1, el2) -> {
		// ASC order
		return el1.val - el2.val;
	};

	public static void sortByComparator(List<ListNode> list, Comparator<ListNode> comparator) {
		Collections.sort(list, valComparator);
	}

	/**
	 * transform a decimal to binary representation binary
	 * 
	 */
	public static String toBinary(int num) {
		StringBuilder result = new StringBuilder();
		int division = num;
		if (num == 0)
			return "0";
		else {
			while (division != 0) {
				result.append(division % 2);
				division = division / 2;
			}
			result.reverse();
			return result.toString();
		}
	}

	/**
	 * second largest number in an array
	 */
	static int secondLargest(Integer[] arr) {

		int max = Integer.MIN_VALUE;
		int smax = Integer.MIN_VALUE;

		for (int i : arr) {
			// update Max and second max accordingly
			if (i > max) {
				smax = max;
				max = i;
			} else if (i > smax) {
				smax = i;
			}
		}
		return smax;
	}

	/**
	 * check if only odd numbers exists ODD number is {3 9 15} FARDIYA
	 */
	public static boolean onlyOddNumbers(List<Integer> list) {
		return !list.parallelStream().anyMatch(x -> x % 2 == 0);
	}

	/**
	 * Palindrome Check
	 */
	public static boolean isPlaindrom(String in) {
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) != in.charAt(in.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * remove white spaces from string
	 */
	public static String removeWhiteSpaces(String in) {
		return in.replaceAll("\\s", "");

	}

	/**
	 * remove leading and trailing white spaces
	 */
	public static String trim(String in) {
		return in.trim();
	}

	/**
	 * factorial of an integer
	 */
	public static int factorial(int in) {
		if (in == 1)
			return 1;
		return in * factorial(in - 1);
	}

	/**
	 * reverse a linked list
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode pointer = head;
		ListNode next = head;
		ListNode previous = null;

		while (next != null) {
			next = pointer.next;
			pointer.next = previous;
			previous = pointer;
			pointer = next;
		}
		return previous;
	}

	/**
	 * Binary search
	 */
	public int search(int[] nums, int target) {
		int right = nums.length - 1, 
				left = 0,
				pivote = (right - left) / 2;
		while (left <= right) {
			pivote = left + (right - left) / 2;
			if (nums[pivote] == target) {
				return pivote;
			} else if (target > nums[pivote]) {
				left = pivote + 1;
			} else {
				right = pivote - 1;
			}
		}
		return -1;
	}

	/**
	 * 2 arrays contains same elements
	 */
	static boolean sameElements(Object[] array1, Object[] array2) {
		HashSet<Object> nonDuplicate1 = new HashSet<Object>(Arrays.asList(array1));
		HashSet<Object> nonDuplicate2 = new HashSet<Object>(Arrays.asList(array2));
		if (nonDuplicate1.size() == nonDuplicate2.size()) {
			return false;
		} else {
			Iterator<Object> array1Iterator = nonDuplicate1.iterator();
			while (array1Iterator.hasNext()) {
				if (!nonDuplicate2.contains(array1Iterator.next())) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * reducer function initially : partialResult = 0, b = arr.get(0), if array is
	 * if empty => partialResumt will be returned
	 */
	public static int sumOfAll(List<Integer> arr) {

		// transform to IntStream that has the sum()
		arr.stream().mapToInt(el -> el.intValue()).sum();

		BinaryOperator<Integer> reducer = (result, b) -> result + b;

		return arr.stream().reduce(0, reducer);
	}

	/**
	 * second largest number in array
	 */
	public static int secondHighest(String s) {
		int max = Integer.MIN_VALUE;
		int smax = Integer.MAX_VALUE;
		char[] sChars = s.toCharArray();

		for (int i = 0; i < sChars.length; i++) {
			if (Character.isDigit(sChars[i])) {
				int charNumber = Character.getNumericValue(sChars[i]);
				if (charNumber > max) {
					smax = max;
					max = charNumber;
				} else if (charNumber > smax) {
					smax = charNumber;
				}
			}
		}
		return smax;
		// return s.chars() // create an IntStream of the characters in the String
		// .filter(Character::isDigit) // only consider digit characters
		// .distinct() // don't consider duplicates
		// .map(c -> -c) // sort in descending order
		// .sorted()
		// .skip(1) // skip first one (to get second largest)
		// .map(c -> -c-'0') // convert digit character to int
		// .findFirst().orElse(-1); // return first (second after skip), if not found
		// return -1
	}
}
