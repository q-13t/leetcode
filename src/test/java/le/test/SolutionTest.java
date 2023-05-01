package le.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testLongestCommonPrefix() {
        // Test case for valid input
        String[] input1 = { "flower", "flow", "flight" };
        assertEquals("fl", Solution.longestCommonPrefix(input1));

        // Test case for empty input
        String[] input2 = {};
        assertEquals("", Solution.longestCommonPrefix(input2));

        // Test case for null input
        String[] input3 = null;
        assertEquals("", Solution.longestCommonPrefix(input3));

        // Test case where there is no common prefix
        String[] input4 = { "dog", "racecar", "car" };
        assertEquals("", Solution.longestCommonPrefix(input4));
    }

    @Test
    public void testIsPalindrome() {
        // Test case for odd number of elements
        ListNode input1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        assertTrue(Solution.isPalindrome(input1));

        // Test case for even number of elements
        ListNode input2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        assertTrue(Solution.isPalindrome(input2));

        // Test case for non-palindrome list
        ListNode input3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        assertFalse(Solution.isPalindrome(input3));

        // Test case for empty list
        ListNode input4 = null;
        assertTrue(Solution.isPalindrome(input4));
    }

    @Test
    public void testCanConstruct() {
        // Test 1: Ransom note can be constructed from magazine
        String ransomNote = "aabbcc";
        String magazine = "aaabbbccc";
        assertTrue(Solution.canConstruct(ransomNote, magazine));

        // Test 2: Ransom note cannot be constructed from magazine
        ransomNote = "abc";
        magazine = "defg";
        assertFalse(Solution.canConstruct(ransomNote, magazine));

        // Test 3: Empty strings
        ransomNote = "";
        magazine = "";
        assertTrue(Solution.canConstruct(ransomNote, magazine));

        // Test 4: Magazine contains all letters of ransom note but in different order
        ransomNote = "hello";
        magazine = "lheol";
        assertTrue(Solution.canConstruct(ransomNote, magazine));

        // Test 5: Ransom note and magazine have same string
        ransomNote = "samestring";
        magazine = "samestring";
        assertTrue(Solution.canConstruct(ransomNote, magazine));

        // Test 6: More than one occurrence of a character in ransom note, but only one
        // in magazine
        ransomNote = "hello";
        magazine = "helo";
        assertFalse(Solution.canConstruct(ransomNote, magazine));
    }

}
