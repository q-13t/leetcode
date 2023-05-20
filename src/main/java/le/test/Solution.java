package le.test;

import java.util.Set;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.AbstractList;

public class Solution {

    public int romanToInt(String s) {
        int number = 0;
        char previous = 'a';
        for (char iterable : s.toCharArray()) {
            switch (iterable) {
                case 'I': {
                    number += 1;
                    break;
                }
                case 'V': {
                    number += 5;
                    if (previous == 'I') {
                        number -= 2;
                    }
                    break;
                }
                case 'X': {
                    number += 10;
                    if (previous == 'I') {
                        number -= 2;
                    }
                    break;
                }
                case 'L': {
                    number += 50;
                    if (previous == 'X') {
                        number -= 20;
                    }
                    break;
                }
                case 'C': {
                    number += 100;
                    if (previous == 'X') {
                        number -= 20;
                    }
                    break;
                }
                case 'D': {
                    number += 500;
                    if (previous == 'C') {
                        number -= 200;
                    }
                    break;
                }
                case 'M': {
                    number += 1000;
                    if (previous == 'C') {
                        number -= 200;
                    }
                    break;
                }

            }
            previous = iterable;
        }
        return number;
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        StringBuilder answer = new StringBuilder();
        try {
            for (int i = 0; i < 200; i++) {
                char current = strings[0].charAt(i);
                for (int j = 0; j < strings.length; j++) {
                    if (current != strings[j].charAt(i)) {
                        return answer.toString();
                    }
                }
                answer.append(current);
            }
        } catch (Exception e) {
            return answer.toString();
        }
        return answer.toString();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode reversed = reverseListNode(middleNode(head).next);
        while (reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static ListNode reverseListNode(ListNode node) {
        ListNode current = node;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];// array of alphabet length with all 0
        for (char c : magazine.toCharArray()) {// count resources
            freq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {// evaluate resources
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static List<String> fizzBuzz(int n) {
        String[] answer = new String[n];
        for (int i = n; i > 0; i--) {
            if (i % 15 == 0) {
                answer[i - 1] = "FizzBuzz";
                continue;
            } else if (i % 3 == 0) {
                answer[i - 1] = "Fizz";
                continue;
            } else if (i % 5 == 0) {
                answer[i - 1] = "Buzz";
                continue;
            } else {
                answer[i - 1] = String.valueOf(i);
                continue;
            }
        }
        return Arrays.asList(answer);
    }

    public static ListNode middleNode(ListNode node) {
        ListNode fast = node;
        while (fast != null && fast.next != null) {

            node = node.next;
            fast = fast.next.next;
        }
        return node;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] strength = new int[mat.length];
        for (int i = 0; i < strength.length; i++) {
            if (mat[i][mat[i].length - 1] == 1) {
                strength[i] = mat[i].length;
            } else if (mat[i][0] == 0) {
                strength[i] = 0;
            } else {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 1) {
                        strength[i] += 1;
                    }
                }
            }
        }
        int[] result = new int[k];
        int index = 0;

        for (int i = 0; i < k; i++) {
            index = 0;
            for (int j = 1; j < strength.length; j++) {
                if (strength[index] > strength[j]) {
                    index = j;
                }
            }
            result[i] = index;
            strength[index] = Integer.MAX_VALUE;
        }
        return result;
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                steps++;
                num = num % 2;
                continue;
            }
            steps++;
            num = num - 1;
        }
        return steps;
    }

    public static int maximumWealth(int[][] accounts) {
        System.gc();
        int maxWealth = Integer.MIN_VALUE, current;
        for (int i = 0; i < accounts.length; i++) {
            current = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                current += accounts[i][j];
            }
            if (maxWealth < current) {
                maxWealth = current;
            }
        }
        System.gc();
        return maxWealth;
    }

    public static int[] twoSum(int[] numbers, int target) {
        System.gc();
        if (numbers == null || numbers.length < 2) {
            return null;
        } else if (numbers[numbers.length - 1] + numbers[numbers.length - 2] == target) {
            return new int[] { numbers.length - 2, numbers.length - 1 };
        } else if (numbers[0] + numbers[1] == target) {
            return new int[] { 0, 1 };
        }
        System.gc();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && j != i) {
                    System.gc();
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addition = 0;
        ListNode tmp = new ListNode();
        ListNode head = tmp;
        while (!(l1 == null && l2 == null) || (addition != 0)) {
            int sum = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + addition);
            tmp.val = sum % 10;
            addition = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (!(l1 == null && l2 == null) || (addition != 0)) {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }

        return head;
    }

    // Sliding window approach
    public int lengthOfLongestSubstring(String s) {
        int chars[] = new int[128];// [window] each character on it's position(ASCII index) represented as position
                                   // in String
        int right = 0, left = 0, intCharVal = 0; // variables for sliding window
        for (int index = 0; index < s.length(); index++) {
            intCharVal = s.charAt(index);// value of each character as integer
            left = Math.max(left, chars[intCharVal]);// start of substring without repeating characters
            right = Math.max(right, index - left + 1);// end of substring without repeating characters
            chars[intCharVal] = index + 1; // setting last occurrence of each character in string
        }
        return right;
    }

    public double findMedianSortedArrays(int[] numbs1, int[] numbs2) {
        int[] merged = new int[numbs1.length + numbs2.length];
        int i = 0;
        for (; i < numbs1.length; i++) {
            merged[i] = numbs1[i];
        }
        for (int k = 0; i < merged.length; i++, k++) {
            merged[i] = numbs2[k];
        }

        Arrays.sort(merged);

        int middle = merged.length / 2;
        if (merged.length % 2 == 0) {
            return ((double) merged[middle - 1] + (double) merged[middle]) / 2;
        } else {
            return (double) merged[middle];
        }
    }

    /**
     * Iterates over provided {@code string} in order to find longest palindrome.
     * </p>
     * {@code Time O(n^2)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param string original string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String string) {
        String result = "";
        int length = string.length(), l, m;
        char[] array = string.toCharArray();

        // Iterate over provided String once
        for (int i = 0; i < length; i++) {

            // search for palindrome expanded from string at i (for single letter palindrome
            // case)
            l = i;
            m = i;
            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = string.substring(l, m + 1);
                }
                l--;
                m++;
            }

            // search for palindrome expanded from string at i (for double letter palindrome
            // case)
            l = i;
            m = i + 1;
            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = string.substring(l, m + 1);
                }
                l--;
                m++;
            }
        }

        return result;
    }

    /**
     * Iterates over half of provided {@code number} checking numbers on
     * corresponding indexes *
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param number
     * @return {@code true} if number is palindrome
     */
    public boolean isPalindrome(int number) {
        boolean isPalindrome = true;
        char[] numbers = String.valueOf(number).toCharArray();
        int half_size = numbers.length / 2;
        for (int i = 0, j = numbers.length - 1; i < half_size && j >= half_size; i++, j--) {
            if (numbers[i] != numbers[j]) {
                return false;
            }
        }
        return isPalindrome;
    }

    /**
     * Iterates over {@code string} in order to determine if given braces are
     * written in correct form.
     * </p>
     * Only "(", ")", "[", "]", "{", "}" are valid.
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param string
     * @return {@code true} if given string is valid
     */
    public boolean isValid(String string) {
        if (string.length() % 2 != 0 || string.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case '(': {
                    stack.add('(');
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                }
                case '{': {
                    stack.add('{');
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                }
                case '[': {
                    stack.add('[');
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Iterates over two {@link ListNode}s and merges them into single sorted
     * {@code ListNode}.
     * </p>
     * {@code list1 and list2 must be sorted.}
     * </p>
     * {@code Time O(n log(n))}
     * </p>
     * {@code Space O(n)}
     * 
     * @param list1
     * @param list2
     * @return merger and sorted list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Edge case: if both input lists are empty, return null
        if (list1 == null && list2 == null) {
            return null;
        }
        // Create a new ListNode object to use as a temporary pointer and set it as the
        // head of the merged list
        ListNode temp = new ListNode();
        ListNode head = temp;
        // Create a new ArrayList to store all the values from the input lists
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // Iterate through list1 and add all its elements to the ArrayList
        while (list1 != null) {
            numbers.add(list1.val);
            list1 = list1.next;
        }
        // Iterate through list2 and add all its elements to the ArrayList
        while (list2 != null) {
            numbers.add(list2.val);
            list2 = list2.next;
        }
        // Sort the ArrayList in ascending order
        Collections.sort(numbers);
        // Iterate through the sorted ArrayList and add each element to the merged list
        for (int i = 0; i < numbers.size(); i++) {
            // Set the value of the current node to the ith element in the ArrayList
            temp.val = numbers.get(i);
            // If there are more elements in the ArrayList, create a new node and set it as
            // the next node in the merged list
            if (i + 1 < numbers.size()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        // Call garbage collector explicitly to free up memory
        System.gc();
        // Return the head node of the merged and sorted list
        return head;
    }

    /**
     * Iterates over whole array, replacing greater values right after first entry
     * of smaller. And returns the index of last unique entry.
     * </p>
     * {@code numbs are sorted in ASCENDING order.}
     * </p>
     * {@code Time O(n^2)}
     * </p>
     * {@code Space O(1)}
     * 
     * @param numbs array of sorted numbers
     * @return amount of unique numbers
     */
    public int removeSingleDuplicates(int[] numbs) {
        // create local variable k indicating first greater number in an array and tmp
        // for swapping numbers in array
        int k = 0, tmp = 0;
        // Iterate over whole numbs array
        for (int i = 1; i < numbs.length; i++) {
            // assign k=i; because all previous entries are unique
            k = i;
            // iterate over whole array again searching for first greater number than
            // current
            while (numbs[i - 1] >= numbs[k]) {
                k++;
                // Edge case: if k reached end of array -> .gc() is called to fee up memory and
                // i as index of last unique entry is returned
                if (k == numbs.length) {
                    System.gc();
                    return i;
                }
            }
            // swap current and greater numbers
            tmp = numbs[i];
            numbs[i] = numbs[k];
            numbs[k] = tmp;
        }
        // returns length of numbers if numbs consists of only unique elements
        return numbs.length;
    }

    /**
     * Iterates over array once replacing each specified {@code value} with next non
     * equal to value number. And returns amount of values without specified number;
     * 
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(1)}
     * 
     * @param numbs to remove value from
     * @param value to be removed
     * @return amount of numbers without specified value
     */
    public int removeElement(int[] numbs, int val) {
        // Initiate k to represent current position of value to be removed
        int k = 0;

        // Iterate over array replacing specific value with another non matching
        for (int i = 0; i < numbs.length; i++) {
            // If current number does not match value to be removed current one is replaced
            // with it
            if (numbs[i] != val) {
                numbs[k++] = numbs[i];
            }
        }
        // Return amount of values without specified number
        return k;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * Iterates over array in order to determine the position of target.
     * 
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(1)}
     * 
     * 
     * @param numbs
     * @param target
     * @return position where {@code target} is or should be.
     */
    public int searchInsert(int[] numbs, int target) {
        // EDGE CASE: if first element in array is greater than target return 0 (as
        // target would have been there)
        if (numbs[0] >= target) {
            return 0;
        }
        // initialize i to represent current position of target
        int i = 1;
        // Iterate over array to find the position of target
        for (; i < numbs.length; i++) {
            // if current namer is the target return current position
            if (numbs[i] >= target) {
                System.gc();
                return i;
            }
        }
        // EDGE CASE: if array does not contain target System.gc(); is called to free up
        // memory and length of numbers + 1 is returned (as target would have been
        // there)
        System.gc();
        return i;
    }

    /**
     * Iterates over {@code sentence} to find the length of the last word. *
     * 
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(1)}
     * 
     * @param sentence
     * @return length of the last word.
     */
    public int lengthOfLastWord(String sentence) {
        // Initialize size as size of sentence and k as length of the last word
        int size = sentence.length(), k = 0;
        // Reversibly iterate over sentence
        for (int i = size - 1; i >= 0; i--) {
            if (sentence.charAt(i) != ' ') {
                // If current character is not space word has started or is continuing and its
                // length is increased
                k++;
            } else if (sentence.charAt(i) == ' ' && k != 0) {
                // If current char is space and k is not zero => word has ended and its length
                // is returned
                return k;
            }
        }
        // if sentence is single word or has no spaces size of word is returned
        return k;
    }

    /**
     * Adds 1 to the last number of {@code digits}. And formats the result.
     * </p>
     * {@code digits are representation of single but very long number.}
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param digits
     * @return The same digits increased by one
     */
    public int[] plusOne(int[] digits) {
        // Initialize last as index of last element in digits
        int last = digits.length - 1;
        if (digits[last] == 9) { // If last element is equal to 9 it is replaced with 0 and function continues
            digits[last] = 0;
        } else {// if last number is les than 9 it is increased and digits returned (best case)
            digits[last] += 1;
            return digits;
        }
        // Iteration over an array from behind
        for (int i = last - 1; i >= 0; i--) {
            if ((digits[i] + 1) / 10 >= 1) {// if current digit increased by 1 is bigger than 10 it is changed to 0
                digits[i] = 0;
            } else {// if current digit increased by 1 is smaller than 10 it IS increased and digits
                    // are returned (average case)
                digits[i] += 1;
                return digits;
            }
        }
        // if all digits were 9 (worst case) INITIALIZE new array one element bigger
        int[] result = new int[digits.length + 1];
        // set first element to 1 (rest will be 9)
        result[0] = 1;
        // return new result
        return result;
    }

    /**
     * Iterates over 2 strings in order to add two strings as binaries
     * </p>
     * {@code Strings are binary.}
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param a number represented as binary string
     * @param b number represented as binary string
     * @return sum of two binary strings
     */
    public String addBinary(String a, String b) {
        // potential code
        // return Long.toBinaryString(Long.valueOf(a, 2) + Long.valueOf(b, 2));

        // Initialize variables for the function
        int carry = 0, left = a.length() - 1, right = b.length() - 1, sum = 0;
        // Initialize String buffer that will hold the resulting string
        StringBuffer sb = new StringBuffer();
        // Iterate over the strings until left index is less than 0 or right index is
        // less than 0 or carry is not 0
        while (left >= 0 || right >= 0 || carry != 0) {
            // assign sum as carry
            sum = carry;
            // if left index is less than 0 add number from string a at position left; add 0
            // otherwise
            sum += left >= 0 ? a.charAt(left--) - '0' : 0;
            // if right index is less than 0 add number from string a at position right; add
            // 0 otherwise
            sum += right >= 0 ? b.charAt(right--) - '0' : 0;

            // insert the resulting binary addition at a start of the string
            sb.insert(0, sum % 2);
            // assign carry for the next iteration
            carry = sum / 2;
        }
        // return StringBuilder
        return sb.toString();
    }

    public int mySqrt(int x) {
        // return (int) Math.sqrt(x);
        long low = 0, high = x, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int n1 = 1;
        int n2 = 2;
        int next = 0;

        for (int i = 3; i <= n; i++) {
            next = n1;
            n1 = n2;
            n2 = next + n2;
        }

        return n2;
    }

    /**
     * Deletes duplicating numbers from {@code ListNode}.
     * </p>
     * {@code head must be sorted in ascending order.}
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(m)}
     * 
     * @param head Sorted {@code ListNode}.
     * @return Sorted {@code ListNode} without duplicates.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty or has just one node, return it as there's no duplicates
        // to be removed
        if (head == null || head.next == null) {
            return head;
        }

        // Create a new ListNode called result with the first value of the original list
        ListNode result = new ListNode(head.val);

        // Create an instance of the new list and set temp as the first node
        ListNode temp = result;

        // Iterate through each node of the original list
        while (head != null) {

            // If the value of the current node being iterated does not match the last added
            // value in the new list,
            // then add this value to the end of the new list, pointing temp to the recently
            // added node
            if (head.val != temp.val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }

            // Move on to the next node of the original list
            head = head.next;
        }

        // Once finished iterating through the entire original list, return the newly
        // created list without any duplicates
        return result;
    }

    public void merge(int[] numbs1, int m, int[] numbs2, int n) {
        if (m < n && m == 0) {
            for (int i = 0; i < numbs2.length; i++) {
                numbs1[i] = numbs2[i];
            }
        } else {
            m--;
            for (int i = 0; i < numbs2.length; i++) {
                if (numbs1[m] <= numbs2[i]) {
                    numbs1[++m] = numbs2[i];
                } else {
                    int k = numbs1.length - 1;
                    while (k > 0 && (numbs1[k] == 0 || numbs1[k - 1] > numbs2[i])) {
                        numbs1[k] = numbs1[--k];
                    }
                    m++;
                    numbs1[k] = numbs2[i];
                }
            }
        }
        for (int i = 0; i < numbs1.length; i++) {
            System.out.print(numbs1[i] + ", ");
        }
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = new TreeNode();
        while (cur != null) {
            if (cur.left == null) {// if there is no left element
                inOrder.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {// if there exist a right and the right is not pointing
                                                                 // himself
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;// create the thread
                    cur = cur.left;
                } else {
                    prev.right = null; // cut the thread
                    inOrder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inOrder;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirrored(root, root);
    }

    private boolean isMirrored(TreeNode head, TreeNode tail) {
        if (head == null && tail == null) {
            return true;
        }
        if (head != null && tail != null && head.val == tail.val) {
            return isMirrored(head.right, tail.left) && isMirrored(head.left, tail.right);
        }
        return false;
    }

    int max_depth = 0;
    int current_depth = 0;

    /**
     * Evaluates depth of binary tree. *
     * </p>
     * {@code Time O(n)} n as number of nodes.
     * </p>
     * {@code Space O(h)} h as height of tree.
     * 
     * @param root {@link TreeNode} as {@code root} of binary tree.
     * @return Maximum depth of {@code root} tree.
     */
    public int maxDepth(TreeNode root) {
        // if there is no root node, return 0.
        if (root == null) {
            return max_depth;
        } else {
            // increment the current depth by 1 as we move down the tree.
            current_depth++;
            // If the current depth surpasses the previous maximum depth, update the maximum
            // depth accordingly.
            if (current_depth > max_depth) {
                max_depth = current_depth;
            }
            // recursively call maxDepth method for the left and right children of the
            // current node until leaf nodes are reached.
            maxDepth(root.left);
            maxDepth(root.right);
            // decrement the current depth as we move up the tree.
            current_depth--;
            // return the maximum depth achieved.
            return max_depth;
        }
    }

    public TreeNode sortedArrayToBST(int[] numbs) {
        return CreateBST(numbs, 0, numbs.length - 1);
    }

    private TreeNode CreateBST(int numbs[], int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(numbs[mid]);
        root.left = CreateBST(numbs, l, mid - 1);
        root.right = CreateBST(numbs, mid + 1, r);
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    int min_depth = Integer.MAX_VALUE;

    public int minDepth(TreeNode node) {

        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            if (min_depth > current_depth + 1)
                min_depth = current_depth + 1;
            return min_depth;
        } else {
            current_depth++;
            minDepth(node.left);
            minDepth(node.right);
            current_depth--;
            return min_depth;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return checkPathSum(root, 0, targetSum);
    }

    private boolean checkPathSum(TreeNode node, int sum, int targetSum) {
        if (node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }
        boolean left = node.left != null && checkPathSum(node.left, sum + node.val, targetSum);
        boolean right = node.right != null && checkPathSum(node.right, sum + node.val, targetSum);
        return left || right;
    }

    /**
     * Generates Pascal's triangle *
     * </p>
     * {@code Time O(n^2)}
     * </p>
     * {@code Space O(n^2)}
     * 
     * @param numRows height of triangle.
     * @return 2 nested {@link List}s containing triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        // Initialize Lists that contain the triangle
        List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        // Start iteration over triangles rows
        for (int i = 0; i < numRows; i++) {
            // Add new List to the row
            list.add(new ArrayList<>(i));
            // Start iterating over rows columns
            for (int j = 0; j <= i; j++) {
                // First and Last elements in Pascal's triangle are always 1 so set them
                if (j == 0 || j == i) {
                    list.get(i).add(1);
                } else {
                    // set the current value as sum of two values above it as Pascal's triangle
                    // needs
                    list.get(i).add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
        }
        // Return the triangle
        return list;
    }

    /**
     * Returns {@link List} contains n'th row of Pascal's triangle.
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * 
     */
    public List<Integer> getRow(int rowIndex) {
        // Initialize list that will contain n'th row of Pascal's triangle
        List<Integer> list = new ArrayList<Integer>(rowIndex);
        // Since all rows start with 1 add it
        list.add(1);
        // Initialize helping variables for formula
        long current = 0, prev = 1;
        // Iterate rowIndex times since all row at index n has n elements
        for (int i = 1; i <= rowIndex; i++) {
            // calculate current value by formula for m'th element of n'th row
            current = (prev * ((rowIndex - i + 1)) / i);
            // add value to list
            list.add((int) current);
            // save value for next iteration
            prev = current;
        }
        // return full list
        return list;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, bestDeal = 0, bestToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            bestToday = prices[i] - min;
            if (bestToday > bestDeal) {
                bestDeal = bestToday;
            }
        }
        return bestDeal;
    }

    /**
     * Iterates over sentence to determine if it is palindrome.
     * </p>
     * {@code All non word characters are ignored}.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param string
     * @return {@code true} if {@code string} is palindrome.
     */
    public boolean isPalindrome(String string) {
        // Convert string to lover case and remove all non word characters
        string = string.toLowerCase().replaceAll("\\W|_", "");
        if (string.length() == 1) {// if length of string is 1 it is palindrome -> return true
            return true;
        }
        // Convert string to char array for comparison
        char[] chars = string.toCharArray();
        // Iterate from front and back of char array
        for (int i = 0, j = chars.length - 1; i < chars.length && j >= i; j--, i++) {
            // EDGE CASE: If chars are not the same, string is not palindrome, return false
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        // If iteration ended return true
        return true;
    }

    public int singleNumber(int[] numbs) {
        HashMap<Integer, Integer> map = new HashMap<>(numbs.length);
        for (int i = 0; i < numbs.length; i++) {
            if (!map.containsKey(numbs[i])) {
                map.put(numbs[i], 1);
            } else {
                map.remove(numbs[i]);
            }
        }
        return map.keySet().iterator().next();
    }

    public int bulbSwitch(int n) {
        int[] bulbs = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                for (int j = 0; j < bulbs.length; j++) {
                    bulbs[j] = 1;
                }
            } else if (i == 2) {
                for (int j = 1; j <= bulbs.length; j++) {
                    if (j % 2 == 0) {
                        bulbs[j - 1] = 0;
                    }
                }
            } else if (i == 3) {
                for (int j = 1; j <= bulbs.length; j++) {
                    if (j % 3 == 0) {
                        if (bulbs[j - 1] == 0) {
                            bulbs[j - 1] = 1;
                        } else {
                            bulbs[j - 1] = 0;
                        }
                    }
                }
            } else if (i == n) {
                if (bulbs[n - 1] == 0) {
                    bulbs[n - 1] = 1;
                } else {
                    bulbs[n - 1] = 0;
                }
            } else {
                for (int j = 1; j <= bulbs.length; j++) {
                    if (j % i == 0) {
                        if (bulbs[j - 1] == 0) {
                            bulbs[j - 1] = 1;
                        } else {
                            bulbs[j - 1] = 0;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i] == 1) {
                count++;
            }
        }
        return count;
    }

    public int removeMultipleDuplicates(int[] numbs) {
        int number = numbs[0], amount = 1;
        boolean wereReplacements = false;
        for (int i = 1; i < numbs.length; i++) {
            if (numbs[i] == Integer.MAX_VALUE) {
                number = i;
                break;
            } else if (number == numbs[i]) {
                amount++;
                if (amount > 2) {
                    wereReplacements = true;
                    numbs[i] = Integer.MAX_VALUE;
                    int k = i + 1;
                    while (k < numbs.length) {
                        int tmp = numbs[k - 1];
                        numbs[k - 1] = numbs[k];
                        numbs[k] = tmp;
                        k++;
                    }
                    i--;
                }
            } else if (number != numbs[i]) {
                number = numbs[i];
                amount = 1;
            }
        }
        if (wereReplacements) {
            return number;
        } else {
            return numbs.length;
        }
    }

    /**
     * Finds and returns element that occurs the most times. *
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param numbs
     * @return element that occurs the most times
     */
    public int majorityElement(int[] numbs) {
        // EDGE CASE: If numbers is null or has no elements return -1 as no elements
        // have been found
        if (numbs == null || numbs.length == 0) {
            return -1;
        }
        // Initialize map that will contain the unique entries and their amount
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbs.length);
        // Iterate over array adding the amount of occurrences of elements to the map
        for (int n : numbs) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // Initialize number and its occurrences to get most frequent from the HashMap
        int numb = 0, max = 0;
        // Iterate over HashMap to find most frequent number
        for (int i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                numb = i;
            }
        }
        // Return the most frequent number
        return numb;
    }

    public void rotate(int[] numbs, int k) {
        // int tmp = 0;
        // for (int i = 0; i < k; i++) {
        // tmp = numbs[numbs.length - 1];
        // for (int j = numbs.length - 1; j > 0; j--) {
        // numbs[j] = numbs[j - 1];
        // }
        // numbs[0] = tmp;
        // }
        int[] result = new int[numbs.length];
        for (int i = 0; i < numbs.length; i++) {
            result[(i + k) % numbs.length] = numbs[i];
        }
        System.arraycopy(result, 0, numbs, 0, numbs.length);
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE, bestDeal = 0, bestToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            bestToday = prices[i] - min;
            if (bestToday > 0) {
                bestDeal += bestToday;
                min = prices[i];
            }
        }
        return bestDeal;
    }

    /**
     * Checks if we can jump from index 0 to last index.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param numbs representing number of indexes we can jump from each position
     * @return {@code true} if we can reach end, {@code false} otherwise.
     */
    public boolean canJump(int[] numbs) {
        if (numbs.length == 0) { // Check if the input array is empty, i.e., length equals zero
            return true; // If so, immediately return true because it's considered "jumpable"
        }

        int desired = numbs.length - 1; // Initialize the desired index as the last element in the array
        for (int i = numbs.length - 2; i >= 0; i--) {
            // Traverse the array backwards while checking if we can reach the current
            // desired index
            if (i + numbs[i] >= desired) { // If we can reach the current desired index,
                desired = i; // then update the desired index to be the current index
            }
        }

        return desired == 0; // If the desired index has reached the start (index 0), then the array is
                             // considered "jumpable"
    }

    /**
     * This method takes an array of strings and returns the number of similarity
     * groups.
     * 
     * @param strings - An array of strings
     */
    public int numSimilarGroups(String[] strings) {
        ArrayList<String> group = new ArrayList<>();
        int amountOfGroups = 0, replacedWords = 0;
        while (replacedWords != strings.length) { // while there are still words left to be processed
            int changes = 0;
            do {
                changes = 0;
                for (int i = 0; i < strings.length; i++) { // loop through all strings and check if they are similar
                    if (strings[i] != "0") { // if string is not already included in a group
                        if (group.isEmpty()) { // if there are no groups yet, create a new group with this string
                            group.add(strings[i]);
                            strings[i] = "0";
                            changes++;
                            replacedWords++;
                        } else { // if there are already groups, check if this string is similar to any of the
                                 // strings in the existing groups
                            for (String string : group) {
                                if (areSimilar(string, strings[i])) { // if strings are similar, add this string to the
                                                                      // group and mark it as processed
                                    group.add(strings[i]);
                                    replacedWords++;
                                    changes++;
                                    strings[i] = "0";
                                    break;
                                }
                            }
                        }
                    }
                }
            } while (changes != 0); // continue processing as long as we find new similar strings
            group.clear(); // clear the group for the next set of strings
            amountOfGroups++; // increment the number of similarity groups
        }
        return amountOfGroups;
    }

    /**
     * This method checks whether two strings are similar or not based on a
     * condition. Two strings are considered similar if they have exactly two
     * different characters, and swapping those two characters would make them
     * equal.
     * 
     * @param first  - First String
     * @param second - Second String
     * @return boolean - true if strings are similar, false otherwise.
     */
    boolean areSimilar(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) { // loop through all characters in both strings and count the number
                                                   // of differences
            if (first.charAt(i) != second.charAt(i))
                count++;
            if (count > 2)
                return false; // if there are more than two differences, the strings are not similar
        }
        return count == 2 || count == 0 && !first.equals(second); // if there are exactly two differences or no
                                                                  // differences and the strings are not equal to begin
                                                                  // with, the strings are similar
    }

    /**
     * Returns minimum amount of jumps required to get from index 0 to last index of
     * {@code numbs}.
     * </p>
     * {@code Time O(n^2)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param numbs representing number of indexes we can jump from each position
     * @return minimum amount of jumps.
     */
    public int jump(int[] numbs) {
        // Initialize variables for number of jumps,
        // the last index that can be reached from the end of the array,
        // and the minimum index that can be reached from the end of array.
        int jumpTimes = 0, canReach = numbs.length - 1, minNumb = numbs.length - 1;

        // Loop until we reach the beginning of the array (i.e. index 0).
        while (minNumb != 0) {

            // Set the "can reach" index to the current "minimum" index.
            canReach = minNumb;

            // Find the farthest index from the current index that can be reached
            // in a single jump and set it as the new "minimum" index.
            for (int i = minNumb - 1; i >= 0; i--) {
                if (i + numbs[i] >= canReach) {
                    minNumb = i;
                }
            }

            // Increment the number of jumps required to reach the end of the array.
            jumpTimes++;
        }

        // Return the minimum number of jumps required to reach the end of the array.
        return jumpTimes;

    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        reverse(citations);
        int papers = citations.length;
        while (papers > 0 && papers > citations[papers - 1]) {
            papers--;
        }
        return papers;
    }

    void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public int[] productExceptSelf(int[] numbs) {
        int n = numbs.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int current = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= current;
            current *= numbs[i];
        }
        current = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= current;
            current *= numbs[i];
        }
        return ans;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int k = gas.length;
        int totalGas = 0;
        int currentGas = 0;
        for (int i = 0; i < k; i++) {
            totalGas = totalGas + gas[i] - cost[i];
            currentGas = currentGas + gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        if (totalGas >= 0) {
            return start;
        }
        System.gc();
        return -1;
    }

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];

        Arrays.fill(res, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        return Arrays.stream(res).sum();
    }

    /**
     * Finds the amount of rain water stored in between {@code height}s.
     * 
     * 
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param height -> map representing collectors for rainwater.
     */
    public int trap(int[] height) {
        // Get the length of the input array
        int length = height.length;

        // Initialize variables for keeping track of the current height and the amount
        // of water stored
        int currentHeight = 0;
        int water = 0;

        // Create two arrays to store the maximum heights on the left and right sides of
        // each element in the input array
        int[] left = new int[length];
        int[] right = new int[length];

        // Calculate the maximum height from the left side of each element in the input
        // array and store it in the `left` array
        for (int i = 0; i < length; i++) {
            if (currentHeight < height[i]) {
                currentHeight = height[i];
            }
            left[i] = currentHeight;
        }

        // Reset the variable for keeping track of the current height, then calculate
        // the maximum height from the right side of each element in the input array and
        // store it in the `right` array
        currentHeight = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (currentHeight < height[i]) {
                currentHeight = height[i];
            }
            right[i] = currentHeight;
        }

        // Calculate the amount of water stored at each element in the input array by
        // subtracting its height from the minimum of the maximum heights on its left
        // and right sides, then add all these amounts of water together to
        // get the total amount of water stored
        for (int i = 0; i < length; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        // Return the total amount of water stored
        return water;
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                stringBuilder.append("M");
                num -= 1000;
            } else if (num >= 900) {
                stringBuilder.append("CM");
                num -= 900;
            } else if (num >= 500) {
                stringBuilder.append("D");
                num -= 500;
            } else if (num >= 400) {
                stringBuilder.append("CD");
                num -= 400;
            } else if (num >= 100) {
                stringBuilder.append("C");
                num -= 100;
            } else if (num >= 90) {
                stringBuilder.append("XC");
                num -= 90;
            } else if (num >= 50) {
                stringBuilder.append("L");
                num -= 50;
            } else if (num >= 40) {
                stringBuilder.append("XL");
                num -= 40;
            } else if (num >= 10) {
                stringBuilder.append("X");
                num -= 10;
            } else if (num >= 9) {
                stringBuilder.append("IX");
                num -= 9;
            } else if (num >= 5) {
                stringBuilder.append("V");
                num -= 5;
            } else if (num >= 4) {
                stringBuilder.append("IV");
                num -= 4;
            } else if (num >= 1) {
                stringBuilder.append("I");
                num -= 1;
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ");
        int length = words.length;
        for (int i = length - 1; i >= 0; i--) {
            if (words[i].isEmpty())
                continue;
            if (i != length - 1) {
                answer.append(" ");
            }
            answer.append(words[i]);
        }
        return answer.toString();
    }

    public boolean isSubsequence(String toSearch, String in) {
        if (toSearch.length() > in.length()) {
            return false;
        } else if (toSearch.isEmpty()) {
            return true;
        }
        for (int i = 0, j = 0; i < in.length(); i++) {
            if (toSearch.charAt(j) == in.charAt(i)) {
                j++;
            }
            if (j == toSearch.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given an array of integers `numbers` and an integer `target`, finds two
     * numbers in the array that add up to the target, and returns their indices as
     * an integer array.
     *
     * @param numbers An array of integers
     * @param target  The target sum
     * @return An integer array with the indices of the two numbers that add up to
     *         the target
     */
    public int[] twoSumII(int[] numbers, int target) {
        // If the input array is null or has less than 2 elements, return null
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        // Initialize left pointer to first index and right pointer to last index
        int left = 0, right = numbers.length - 1;

        // Keep iterating until we find a pair of numbers that add up to target
        while (numbers[left] + numbers[right] != target) {
            // If the sum of the current pair is greater than target, move the right pointer
            // to the left
            if (numbers[left] + numbers[right] > target) {
                --right;
            } else { // Otherwise, move the left pointer to the right
                ++left;
            }
        }

        // If we have found a pair of numbers that add up to target, return their
        // indices as an array
        return new int[] { ++left, ++right };
    }

    /**
     * Using {@code height}s determines te maximum available water that can be
     * stored between them.
     * </p>
     * Is calculated as area of rectangle
     * 
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param height
     * @return maximum water that can be stored
     */
    public int maxArea(int[] height) {
        // Initialize variables
        int water = 0, left = 0, right = height.length - 1, currentWater = 0;
        // Loop until pointer meet
        while (left < right) {
            // get the amount of water using current pointers
            currentWater = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
            // update if needed maximum amount of available stored water
            water = water > currentWater ? water : currentWater;
            // move pointers to higher position
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        // return maximum stored water
        return water;
    }

    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        Set<List<Integer>> result = new HashSet<>();
        int mid = 0, right = 0, sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            mid = i + 1;
            right = numbers.length - 1;
            while (mid < right) {
                sum = numbers[i] + numbers[mid] + numbers[right];
                if (sum == 0) {
                    result.add(Arrays.asList(numbers[i], numbers[mid], numbers[right]));
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public int minSubArrayLen(int target, int[] numbers) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (i < numbers.length) {
            sum += numbers[i];
            if (sum >= target)
                while (sum >= target) {
                    min = min > i - j + 1 ? i - j + 1 : min;
                    sum -= numbers[j];
                    j++;
                }
            i++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * Checks if string {@code s} is isomorphic to string {@code t}. *
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(min(n,m))}.
     * 
     * @param s string to replace.
     * @param t string to be equal.
     * @return {@code true} if {@code s} is isomorphic, {@code false} otherwise.
     */
    public boolean isIsomorphic(String s, String t) {
        // create a HashMap to store character mappings from s to t
        HashMap<Character, Character> references = new HashMap<Character, Character>();

        // iterate through string s and map each character to its corresponding
        // character in string t
        for (int i = 0; i < s.length(); i++) {
            if (!references.containsKey(s.charAt(i))) { // if character in s is not mapped yet
                if (references.values().contains(t.charAt(i))) { // if character in t is already mapped
                    System.gc(); // calling garbage collector
                    return false;
                } else {
                    references.put(s.charAt(i), t.charAt(i)); // map the characters
                }
            } else { // if the character in s has already been seen before
                if (references.get(s.charAt(i)) != t.charAt(i)) { // but the corresponding character in t does not match
                                                                  // the current one
                    System.gc();// calling garbage collector
                    return false;
                }
            }
        }

        // create a new StringBuilder object to hold mapped string
        StringBuilder reference = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            reference.append(references.get(s.charAt(i))); // append each mapped character from s to the new string
                                                           // builder
        }
        // compare the built string to string t to make sure they are identical
        if (!reference.toString().equals(t)) {
            System.gc();// calling garbage collector
            return false;
        }

        System.gc();// calling garbage collector
        return true;

    }

    /**
     * Given a {@code pattern} and a string {@code s}, find if {@code s} follows the
     * same pattern.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param pattern
     * @param s
     * @return if {@code s} follows the pattern, {@code false} otherwise.
     */
    public boolean wordPattern(String pattern, String s) {
        // Convert the pattern string into an array of characters
        char[] chars = pattern.toCharArray();

        // Split the input "s" string into an array of words based on 'space' delimiter
        String[] words = s.split(" ");

        // If the number of words in the string 's' is different from the length of the
        // 'chars' array then return false.
        if (chars.length != words.length) {
            return false;
        }

        // Create a hash map to store character to word mappings
        HashMap<Character, String> references = new HashMap<>();

        // Loop through each word in the 'words' array and check if it matches with the
        // corresponding character in the 'chars' array
        for (int i = 0; i < words.length; i++) {

            // If the 'references' hash map doesn't contain the character or the word
            if (!references.containsKey(chars[i]) && !references.containsValue(words[i])) {

                // Add a new character to word mapping to the 'references' hash map
                references.put(chars[i], words[i]);

            } else if (references.containsKey(chars[i]) && !references.get(chars[i]).equals(words[i])) {

                // If the 'references' hash map already contains the character but with a
                // different word, return false.
                return false;

            } else if ((references.containsValue(words[i]) && !references.containsKey(chars[i]))
                    || (!references.containsValue(words[i]) && references.containsKey(chars[i]))) {

                // If the 'references' hash map already contains the word but with a different
                // character, or the opposite, return false.
                return false;
            }
        }

        // Return true if all the mappings are valid
        return true;

    }

    /**
     * Checks if two words are anagrams
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param original
     * @param desired
     * @return {@code true} if words are anagrams, {@code false} otherwise.
     */
    public boolean isAnagram(String original, String desired) {
        // If two words are of different length they can't be anagrams -> return false;
        if (original.length() != desired.length()) {
            return false;
        }
        // Create map of english lowercase characters
        int[] map = new int[26];
        // Iterate over 2 words all the way
        for (int i = 0; i < original.length(); i++) {
            // add one at a position of current character in original word
            map[original.charAt(i) - 'a']++;
            // subtract one at a position of current character in desired word
            map[desired.charAt(i) - 'a']--;
        }
        // iterate over map
        for (int i = 0; i < map.length; i++) {
            // if any character is missing or insufficient words cannot be anagrams ->
            // return false;
            if (map[i] != 0) {
                return false;
            }
        }
        // If all characters met exact amount of times words are anagrams -> return
        // true;
        return true;
    }

    /**
     * checks if {@code number} is {@code happy}.
     * </p>
     * {@code number} is {@code happy} if:
     * <ul>
     * <li>Starting with any positive integer, replace the number by the sum of the
     * squares of its digits.</li>
     * <li>Repeat the process until the number equals 1 (where it will stay), or it
     * loops endlessly in a cycle which does not include 1.</li>
     * <li>Those numbers for which this process ends in 1 are happy.</li>
     * </ul>
     * 
     * </p>
     * {@code Time O(k log(n))}.
     * </p>
     * {@code Space O(k)}.
     * 
     * @param number to be checked.
     * @return {@code true} if {@code number} is {@code happy},
     *         {@code false otherwise}.
     */
    public boolean isHappy(int number) {
        // Create set to check if we are not in an endless loop
        Set<Integer> set = new HashSet<>();
        // convert number into array
        int[] intTab = getInts(number);
        // initialize sum of powers
        int sum = 0;
        // Iterate until sum not equals 1
        while (sum != 1) {
            sum = 0;
            // iterate over each number and add its power 2 to the sum
            for (int i : intTab) {
                sum += Math.pow(i, 2);
            }
            // if sum was already met we are in an endless loop -> EDGE CASE: return false;
            if (!set.add(sum)) {
                return false;
            }
            // convert number into array
            intTab = getInts(sum);
        }
        // if while loop has ended return true because number is 'happy'
        return true;
    }

    int[] getInts(int number) {
        int[] ints = new int[String.valueOf(number).length()];
        int i = 0;
        while (number > 0) {
            ints[i++] = number % 10;
            number = number / 10;
        }
        return ints;
    }

    /**
     * Checks if there are 2 identical numbers in {@code numbers} within {@code k}
     * distance.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param numbers
     * @param k       should be > 0
     * @return {@code true} if there are 2 identical numbers within {@code k}
     *         distance, {@code false} otherwise.
     */
    public boolean containsNearbyDuplicate(int[] numbers, int k) {
        // Initialize HashMap representing [number,index] of numbers array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        // Iterate over whole array
        for (int i = 0; i < numbers.length; i++) {
            // If map contains key and its index with current index is less or equal k ->
            // free up memory and return true
            if (map.containsKey(numbers[i]) && Math.abs(map.get(numbers[i]) - i) <= k) {
                System.gc();
                return true;
            } else {// add this number and its index to the HashMap
                map.put(numbers[i], i);
            }
        }
        // Free up memory and return false if there was no fulfilling conditions in
        // numbers array
        System.gc();
        return false;
    }

    public List<String> summaryRanges(int[] numbers) {
        ArrayList<String> ranges = new ArrayList<String>();
        for (int i = 0; i < numbers.length; i++) {
            int start = numbers[i];
            while (i + 1 < numbers.length && numbers[i] + 1 == numbers[i + 1])
                i++;
            if (start != numbers[i]) {
                ranges.add("" + start + "->" + numbers[i]);
            } else {
                ranges.add("" + start);
            }
        }
        return ranges;
    }

    public List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        return new AbstractList<List<String>>() {
            List<List<String>> result;

            @Override
            public int size() {
                if (result == null)
                    initialize();
                return result.size();
            }

            public void initialize() {
                for (String iterableString : strings) {
                    char[] keys = new char[26];
                    for (int i = 0; i < iterableString.length(); i++) {
                        keys[iterableString.charAt(i) - 'a']++;
                    }
                    String key = new String(keys);
                    List<String> list = map.get(key);
                    if (list == null)
                        map.put(key, new ArrayList<>());
                    map.get(key).add(iterableString);
                }
                result = new ArrayList<>(map.values());
            }

            @Override
            public List<String> get(int index) {
                if (result == null)
                    initialize();
                return result.get(index);
            }

        };
    }

    /**
     * Counts maximum consecutive length of {@code numbers}.
     * </p>
     * {@code Time O(n log(n))}.
     * </p>
     * {@code Space O(1)}.
     */
    public int longestConsecutive(int[] numbers) {
        // EDGE CASE: if array is empty it cannot be consecutive
        if (numbers.length == 0)
            return 0;
        // Sort array in ascending order
        Arrays.sort(numbers);
        // define variables of current length and maximum consecutive length
        int maxContinuous = 1, current = 1;
        // iterate over an array
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1])// if there are 2 same numbers in an row don't count them as consecutive ->
                                             // skip;
                continue;
            else if (numbers[i] - 1 == numbers[i - 1]) {// if numbers are consecutive increase current length and set
                                                        // the max length
                current++;
                maxContinuous = maxContinuous > current ? maxContinuous : current;
            } else// if numbers are not consecutive reset current length to 1
                current = 1;
        }
        // free up memory and return maximum consecutive length
        System.gc();
        return maxContinuous;
    }

    /**
     * Checks if {@code numbers} contains any duplicating numbers .
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param numbers
     * @return
     */
    public boolean containsDuplicate(int[] numbers) {
        // Initialize HashSet to store numbers
        HashSet<Integer> set = new HashSet<>(numbers.length);
        // Iterate over array
        for (Integer integer : numbers) {
            // if set previously contained value free up memory and return true
            if (!set.add(integer)) { // if not numbers is simply added to set
                System.gc();
                return true;
            }
        }
        // if whole array was iterated -> free up memory and return false, as no
        // duplicates were detected
        System.gc();
        return false;
    }

    public List<List<String>> groupAnagram2(String[] strings) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        for (String iterable : strings) {
            result.putIfAbsent(sortStringAscending(iterable), new ArrayList<>());
        }
        for (String string : strings) {
            result.get(sortStringAscending(string)).add(string);
        }
        return new ArrayList<List<String>>(result.values());
    }

    private static String sortStringAscending(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();
    }

    public int[] topKFrequent(int[] numbers, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>(numbers.length);
        for (int i : numbers) {
            if (occurrences.putIfAbsent(i, 1) != null) {
                occurrences.put(i, occurrences.get(i) + 1);
            }
        }
        int[] result = new int[k];
        int max = 0, changed = 0;

        for (int i = 0; i < k; i++) {
            max = 0;
            changed = 0;
            for (int iterable : occurrences.keySet()) {
                if (max < occurrences.get(iterable)) {
                    max = occurrences.get(iterable);
                    result[i] = iterable;
                    changed = iterable;
                }
            }
            occurrences.put(changed, Integer.MIN_VALUE);
        }

        return result;
    }

    /**
     * Performs check and decides if sudoku {@code board} is valid.
     * </p>
     * Validation rules are:
     * </p>
     * - Each row must contain the digits 1-9 without repetition.
     * </p>
     * - Each column must contain the digits 1-9 without repetition.
     * </p>
     * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
     * without repetition. *
     * </p>
     * {@code Time O(n^2)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        // Horizontal check
        HashSet<Character> numbers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            numbers.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!numbers.add(board[i][j]))
                    return false;
            }
        }
        // Vertical check
        for (int i = 0; i < 9; i++) {
            numbers.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (!numbers.add(board[j][i]))
                    return false;
            }
        }
        // Square check
        int columnStart = 0, columnEnd = 3;
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                numbers.clear();
            }
            for (int j = columnStart; j < columnEnd; j++) {
                if (board[i][j] == '.')
                    continue;
                else if (!numbers.add(board[i][j]))
                    return false;
            }
            if (i == 8 && columnEnd != 9) {
                columnEnd += 3;
                columnStart += 3;
                i = -1;
                numbers.clear();
            }
        }
        return true;
    }

    /**
     * Encodes provided array of {@link String}s into single specific String.
     * </p>
     * Encoding schema is {@code <length>Word} and so on.
     * </p>
     * Example: {@code Java,Is,Awesome,!} -> {@code <4>Java<2>Is<7>Awesome<1>!}
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param strings
     * @return Encoded string
     * @see #decodeString(String)
     */
    public String encodeString(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append("<" + strings[i].length() + ">" + strings[i]);
        }
        return result.toString();
    }

    /**
     * Decodes provided single {@link String} into array of separate Strings
     * </p>
     * Decoding schema is {@code <length>Word} and so on.
     * </p>
     * Example: {@code <4>Java<2>Is<7>Awesome<1>!} -> {@code Java,Is,Awesome,!}
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param strings
     * @return Decoded array of strings
     * @see #encodeString(String[])
     */
    public String[] decodeString(String encodedString) {
        LinkedList<String> strings = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        int wordLength = 0;
        for (int i = 0; i < encodedString.length(); i++) {
            while (encodedString.charAt(++i) != '>') {
                word.append(encodedString.charAt(i));
            }
            wordLength = Integer.valueOf(word.toString());
            word = new StringBuilder();
            while (wordLength > 0) {
                word.append(encodedString.charAt(++i));
                wordLength--;
            }
            strings.add(word.toString());
            wordLength = 0;
            word = new StringBuilder();
        }
        return strings.toArray(new String[strings.size()]);
    }

    /**
     * Evaluates {@code reverse Polish notation}.
     * </p>
     * {@code Time O(n)}. As length of {@code tokens}.
     * </p>
     * {@code Space O(k)}. As amount of {@code numbers}.
     * </p>
     * {@code tokens MUST BE VALID}
     * 
     * @param tokens are numbers and arithmetic operators {@code 0-9, +, -, *, /}.
     * @return expressions end value.
     */
    public int evalRPN(String[] tokens) {
        // Initialize stack to store numbers
        Stack<Integer> stack = new Stack<Integer>();
        // initialize variables for calculation
        int a = 0, b = 0;
        // Iterate over all tokens of RPN
        for (String token : tokens) {
            switch (token) {
                case "+": {// Perform mathematical calculation
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b + a);
                    break;
                }
                case "-": {// Perform mathematical calculation
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;
                }
                case "*": {// Perform mathematical calculation
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b * a);
                    break;
                }
                case "/": {// Perform mathematical calculation
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;
                }

                default: {// expected to be a number -> add to stack
                    stack.add(Integer.valueOf(token));
                    break;
                }
            }
        }
        // Free up memory and return last value from stack -> arithmetic result
        System.gc();
        return stack.pop();
    }

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        parenthesisRecursion(parenthesis, 0, 0, "", n);
        return parenthesis;
    }

    private void parenthesisRecursion(List<String> parenthesis, int open, int close, String string, int n) {
        if (string.length() == n * 2) {
            parenthesis.add(string);
            return;
        }
        if (open < n) {
            parenthesisRecursion(parenthesis, open + 1, close, string + "(", n);
        }
        if (close < open) {
            parenthesisRecursion(parenthesis, open, close + 1, string + ")", n);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temperaturesStack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!temperaturesStack.isEmpty() && temperaturesStack.peek() < temperatures[i]) {
                temperatures[indexes.peek()] = i - indexes.pop();
                temperaturesStack.pop();
            }
            temperaturesStack.add(temperatures[i]);
            indexes.add(i);
        }
        if (!temperaturesStack.isEmpty()) {
            for (int i = temperaturesStack.size(); i > 0; i--) {
                temperatures[indexes.pop()] = 0;
            }
        }
        return temperatures;
    }

    public int minimumDeletions(String string) {
        Stack<Integer> B_sBefore = new Stack<>();
        Stack<Integer> A_sAfter = new Stack<>();
        int amount = 0;
        for (int i = 0; i < string.length(); i++) {// count b-s before
            B_sBefore.add(amount);
            if (string.charAt(i) == 'b') {
                amount++;
            }
        }
        amount = 0;
        for (int i = string.length() - 1; i >= 0; i--) {// count a-s after
            A_sAfter.add(amount);
            if (string.charAt(i) == 'a') {
                amount++;
            }
        }
        Collections.reverse(A_sAfter);
        int minReplaces = Integer.MAX_VALUE;
        int sum = 0;
        while (!B_sBefore.isEmpty()) {
            sum = B_sBefore.pop() + A_sAfter.pop();
            minReplaces = minReplaces > sum ? sum : minReplaces;
        }
        return minReplaces;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder word = new StringBuilder();
        int n = s.length();
        int cycleLength = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLength) {
                word.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLength - i < n) {
                    word.append(s.charAt(j + cycleLength - i));
                }
            }
        }
        return word.toString();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Stack<ListNode> nodes = new Stack<>();
        while (head.next != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public Node copyRandomList(Node head) {
        Node copy = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (copy != null) {
            map.put(copy, new Node(copy.val));
            copy = copy.next;
        }
        copy = head;

        while (copy != null) {
            Node clone = map.get(copy);
            clone.next = map.get(copy.next);
            clone.random = map.get(copy.random);
            copy = copy.next;
        }

        return map.get(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode copy = head;
        while (copy != null) {
            list.add(copy);
            copy = copy.next;
        }
        Collections.reverse(list.subList(left - 1, right));
        copy = list.get(0);
        ListNode temp = copy;
        for (int i = 1; i < list.size(); i++) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return copy;
    }

    public String simplifyPath(String path) {
        path.replaceAll("/+", "/");
        String[] split = path.split("/");
        StringBuilder validPath = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(""))
                stack.add(split[i]);
        }
        int count = 0;
        Stack<String> finalStack = new Stack<>();

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(".")) {
                continue;
            } else if (current.equals("..")) {
                count++;
                continue;
            } else {
                if (count != 0) {
                    count--;
                    continue;
                } else {
                    finalStack.add(current);
                }
            }
        }
        if (finalStack.isEmpty()) {
            System.gc();
            return "/";
        } else {
            while (!finalStack.isEmpty()) {
                validPath.append("/" + finalStack.pop());
            }
        }
        System.gc();
        return validPath.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int first = 0, second = 0;
        while (result.length() != word1.length() + word2.length()) {
            if (first < word1.length()) {
                result.append(word1.charAt(first++));
            }
            if (second < word2.length()) {
                result.append(word2.charAt(second++));
            }
        }
        return result.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        }
        StringBuilder gcd = new StringBuilder();
        Stack<String> results = new Stack<>();
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                gcd.append(str2.charAt(i));
                if (str1.replaceAll(gcd.toString(), "").length() == 0 &&
                        str2.replaceAll(gcd.toString(), "")
                                .length() == 0) {
                    results.add(gcd.toString());
                }
            }
        }
        if (results.isEmpty()) {
            return "";
        }
        return results.pop();
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        int maxCandies = 0;
        List<Boolean> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            maxCandies = maxCandies < candies[i] ? candies[i] : maxCandies;
        }
        for (int i = 0; i < length; i++) {
            if (candies[i] + extraCandies >= maxCandies)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 1 && flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            } else if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i > 0 && i < flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if (n == 0)
            return true;
        else
            return false;
    }

    public String reverseVowels(String string) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                stack.add(ch);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                result.append(stack.pop());
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        StringBuilder compressed = new StringBuilder();
        char previous = chars[0];
        int amount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (i == chars.length - 1) {
                if (chars[i] == previous) {
                    compressed.append(previous);
                    if (amount != 1) {
                        compressed.append(++amount);
                    }
                } else {
                    compressed.append(previous);
                    if (amount != 1) {
                        compressed.append(amount);
                    }
                    compressed.append(chars[i]);
                }
            } else if (chars[i] == previous) {
                amount++;
            } else if (chars[i] != previous) {
                compressed.append(previous);
                if (amount != 1) {
                    compressed.append(amount);
                }
                previous = chars[i];
                amount = 1;
            }
        }
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }
        return compressed.length();
    }

    public void moveZeroes(int[] numbers) {
        int m = -1;
        int tmp = 0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == 0) {
                if (m == -1 || numbers[m] != 0) {
                    m = i;
                }
            } else {
                if (m != -1) {
                    tmp = numbers[i];
                    numbers[i] = numbers[m];
                    numbers[m++] = tmp;
                }
            }
        }
        System.gc();
    }

    public int maxOperations(int[] numbers, int k) {
        int amountOfOperations = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (Integer number : map.keySet()) {
            if (Double.valueOf(number) == Double.valueOf(k) / 2d) {
                amountOfOperations += Math.floor(map.get(number) / 2);
                map.put(number, map.get(number) / 2);
            } else if (map.get(k - number) != null && (map.get(k - number) != 0 || map.get(number) != 0)) {
                int amount = Math.min(map.get(number), map.get(k - number));
                amountOfOperations += amount;
                map.put(number, map.get(number) - amount);
                map.put(k - number, map.get(k - number) - amount);
            }
        }
        System.gc();
        return amountOfOperations;
    }

    public double findMaxAverage(int[] numbers, int k) {
        int maxAVG = Integer.MIN_VALUE;
        int j = 0;
        int currentValue = 0;
        for (int i = 0; i < numbers.length - k + 1; i++) {
            j = i + k - 1;
            currentValue = 0;
            while (j >= i) {
                currentValue += numbers[j--];
            }
            maxAVG = maxAVG < currentValue ? currentValue : maxAVG;
        }
        return (double) maxAVG / k;
    }

    public int maxVowels(String s, int k) {
        int currentVowels = 0;
        int maxVowels = 0;
        int i = 0;
        int j = 0;
        char atJ = '0';
        char atI = '0';
        while (j < s.length()) {
            atJ = s.charAt(j);
            if (atJ == 'a' || atJ == 'e' || atJ == 'i' || atJ == 'o' || atJ == 'u') {
                currentVowels++;
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxVowels = currentVowels > maxVowels ? currentVowels : maxVowels;
                atI = s.charAt(i);
                if (atI == 'a' || atI == 'e' || atI == 'i' || atI == 'o' || atI == 'u') {
                    currentVowels--;
                }
                j++;
                i++;
            }
        }
        System.gc();
        return maxVowels;
    }

    public int largestAltitude(int[] gain) {
        int[] heights = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            heights[i + 1] = gain[i];
        }
        for (int i = 1; i < heights.length; i++) {
            heights[i] += heights[i - 1];
        }
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            maxHeight = heights[i] > maxHeight ? heights[i] : maxHeight;
        }
        return maxHeight;
    }

    public int pivotIndex(int[] numbers) {
        int length = numbers.length;
        int[] arrLeft = new int[length];
        int[] arrRight = new int[length];
        for (int i = 0; i < length; i++) {// copy the arrays
            arrLeft[i] = numbers[i];
            arrRight[i] = numbers[i];
        }
        for (int i = 1; i < length; i++) {// sum up the left to right array
            arrLeft[i] += arrLeft[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {// sum up the right to left array
            arrRight[i] += arrRight[i + 1];
        }
        for (int i = 0; i < length; i++) {
            if (arrLeft[i] == arrRight[i]) {
                return i;
            }
        }
        return -1;
    }

    public List<List<Integer>> findDifference(int[] numbers1, int[] numbers2) {
        List<List<Integer>> result = new ArrayList<>() {
            {
                add(new ArrayList<>());
                add(new ArrayList<>());
            }
        };
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        for (int i = 0; i < numbers1.length; i++) {
            first.add(numbers1[i]);
        }
        for (int i = 0; i < numbers2.length; i++) {
            second.add(numbers2[i]);
        }
        for (Integer integer : first) {
            if (!second.contains(integer)) {
                result.get(0).add(integer);
            }
        }
        for (Integer integer : second) {
            if (!first.contains(integer)) {
                result.get(0).add(integer);
            }
        }
        return result;
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> reference = new HashSet<>();
        for (Integer integer : count.values()) {
            if (!reference.add(integer)) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        int[] str1 = new int[26];
        int[] str2 = new int[26];
        for (char ch : word1.toCharArray())
            str1[ch - 'a']++;

        for (char ch : word2.toCharArray()) {
            str2[ch - 'a']++;
            if (str1[ch - 'a'] == 0)
                return false;
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < 26; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    public int equalPairs(int[][] grid) {
        int equalPairs = 0;
        int nXn = grid.length;
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>(nXn);
        ArrayList<ArrayList<Integer>> columns = new ArrayList<>(nXn);
        for (int i = 0; i < nXn; i++) {
            rows.add(new ArrayList<>(nXn));
            for (int j = 0; j < nXn; j++) {
                rows.get(i).add(grid[i][j]);
            }
        }
        for (int i = 0; i < nXn; i++) {
            columns.add(new ArrayList<>(nXn));
            for (int j = 0; j < nXn; j++) {
                columns.get(i).add(grid[j][i]);
            }
        }
        for (int i = 0; i < nXn; i++) {
            for (int j = 0; j < nXn; j++) {
                if (rows.get(i).equals(columns.get(j))) {
                    equalPairs++;
                }
            }
        }
        return equalPairs;
    }

    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char ch = '0';
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '*') {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        for (Character character : stack) {
            result.append(character);
        }
        return result.toString();
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (radiant.poll() < dire.poll()) {
                radiant.offer(n++);
            } else {
                dire.offer(n++);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next;
        if (fast == null) {
            return slow.next;
        }
        while (fast != null) {
            fast = fast.next;
            if (fast == null || fast.next == null) {
                slow.next = slow.next.next;
                break;
            }
            if (fast.next != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        Stack<ListNode> odd = new Stack<>();
        Stack<ListNode> even = new Stack<>();
        int i = 1;
        ListNode copy = head;
        while (copy != null) {
            if (i % 2 == 0) {
                even.add(new ListNode(copy.val));
            } else {
                odd.add(new ListNode(copy.val));
            }
            copy = copy.next;
            i++;
        }
        if (even.isEmpty() && odd.isEmpty()) {
            return head;
        }
        Collections.reverse(even);
        Collections.reverse(odd);
        ListNode result = odd.pop();
        copy = result;
        while (!odd.isEmpty()) {
            copy.next = odd.pop();
            copy = copy.next;
        }
        while (!even.isEmpty()) {
            copy.next = even.pop();
            if (!even.isEmpty())
                copy = copy.next;
        }
        return result;
    }

    public int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode headCopy = head;
        ListNode copy = new ListNode();
        ListNode temp = copy;
        while (headCopy != null) {
            temp.val = headCopy.val;
            temp.next = new ListNode();
            temp = temp.next;
            headCopy = headCopy.next;
        }
        ListNode reversed = reverseListNode(head);
        while (copy != null && reversed != null) {
            int sum = copy.val + reversed.val;
            maxSum = maxSum > sum ? maxSum : sum;
            copy = copy.next;
            reversed = reversed.next;
        }
        return maxSum;
    }

    public boolean leafSimilar(TreeNode first, TreeNode second) {
        Stack<Integer> FirstTree = new Stack<>();
        getLeafNodes(first, FirstTree);

        Stack<Integer> SecondTree = new Stack<>();
        getLeafNodes(second, SecondTree);

        return FirstTree.equals(SecondTree);
    }

    private void getLeafNodes(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            stack.add(node.val);
        } else {
            getLeafNodes(node.left, stack);
            getLeafNodes(node.right, stack);
        }
    }

    Stack<Integer> MaxValues = new Stack<>();
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return goodNodes;
        } else {
            if (!MaxValues.isEmpty() && MaxValues.peek() <= root.val) {
                goodNodes++;
                MaxValues.add(root.val);
            } else if (MaxValues.isEmpty()) {
                goodNodes++;
                MaxValues.add(root.val);
            }
            goodNodes(root.left);
            goodNodes(root.right);
            if (!MaxValues.isEmpty() && MaxValues.peek() == root.val) {
                MaxValues.pop();
            }
        }
        return goodNodes;
    }

    ArrayList<Integer> numbs = new ArrayList<>();
    int sumAmount = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return sumAmount;
        } else {
            numbs.add(root.val);
        }
        long currentSum = 0;
        for (int i = numbs.size() - 1; i >= 0; i--) {
            currentSum += numbs.get(i);
            if (currentSum == targetSum) {
                sumAmount++;
            }
        }

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        if (!numbs.isEmpty()) {
            numbs.remove(numbs.size() - 1);
        }
        return sumAmount;
    }
}
