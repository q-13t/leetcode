package le.test;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

    public static int romanToInt(String s) {
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

    private static ListNode reverseListNode(ListNode node) {
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
     * Iterates over half of provided {@code number} checking numbers on corresponding indexes *
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
     * Iterates over {@code string} in order to determine if given braces are written in correct form.
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
     * Iterates over two {@link ListNode}s and merges them into single sorted {@code ListNode}.
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
     * Iterates over whole array, replacing greater values right after first entry of smaller. And returns the index of last unique entry.
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
    public int removeDuplicates(int[] numbs) {
        // create local variable k indicating first greater number in an array and tmp for swapping numbers in array
        int k = 0, tmp = 0;
        // Iterate over whole numbs array
        for (int i = 1; i < numbs.length; i++) {
            // assign k=i; because all previous entries are unique
            k = i;
            // iterate over whole array again searching for first greater number than current
            while (numbs[i - 1] >= numbs[k]) {
                k++;
                // Edge case: if k reached end of array -> .gc() is called to fee up memory and i as index of last unique entry is returned
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
     * Iterates over array once replacing each specified {@code value} with next non equal to value number. And returns amount of values without specified number;
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
            // If current number does not match value to be removed current one is replaced with it
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
        // EDGE CASE: if first element in array is greater than target return 0 (as target would have been there)
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
        // EDGE CASE: if array does not contain target System.gc(); is called to free up memory and length of numbers + 1 is returned (as target would have been there)
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
                // If current character is not space word has started or is continuing and its length is increased
                k++;
            } else if (sentence.charAt(i) == ' ' && k != 0) {
                // If current char is space and k is not zero => word has ended and its length is returned
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
            } else {// if current digit increased by 1 is smaller than 10 it IS increased and digits are returned (average case)
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
        // Iterate over the strings until left index is less than 0 or right index is less than 0 or carry is not 0
        while (left >= 0 || right >= 0 || carry != 0) {
            // assign sum as carry
            sum = carry;
            // if left index is less than 0 add number from string a at position left; add 0 otherwise
            sum += left >= 0 ? a.charAt(left--) - '0' : 0;
            // if right index is less than 0 add number from string a at position right; add 0 otherwise
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
        // If the list is empty or has just one node, return it as there's no duplicates to be removed
        if (head == null || head.next == null) {
            return head;
        }

        // Create a new ListNode called result with the first value of the original list
        ListNode result = new ListNode(head.val);

        // Create an instance of the new list and set temp as the first node
        ListNode temp = result;

        // Iterate through each node of the original list
        while (head != null) {

            // If the value of the current node being iterated does not match the last added value in the new list,
            // then add this value to the end of the new list, pointing temp to the recently added node
            if (head.val != temp.val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }

            // Move on to the next node of the original list
            head = head.next;
        }

        // Once finished iterating through the entire original list, return the newly created list without any duplicates
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
                while (prev.right != null && prev.right != cur) {// if there exist a right and the right is not pointing himself
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
            // If the current depth surpasses the previous maximum depth, update the maximum depth accordingly.
            if (current_depth > max_depth) {
                max_depth = current_depth;
            }
            // recursively call maxDepth method for the left and right children of the current node until leaf nodes are reached.
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
                    // set the current value as sum of two values above it as Pascal's triangle needs
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

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.remove(nums[i]);
            }
        }
        return map.keySet().iterator().next();
    }
}