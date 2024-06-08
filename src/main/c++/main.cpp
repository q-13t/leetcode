#include <iostream>
#include <string>
#include <vector>

#include "LeetCode/Solution.h"

Solution solution;

int main(int argc, char const* argv[]) {
    std::cout << (solution.longestPalindrome("abccccdd") == 7) << std::endl;
    std::cout << (solution.longestPalindrome("a") == 1) << std::endl;
    std::cout << (solution.longestPalindrome("ccc") == 3) << std::endl;
    std::cout << (solution.longestPalindrome("bananas") == 5) << std::endl;

    return 0;
}
