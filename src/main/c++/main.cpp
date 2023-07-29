#include <iostream>

#include "LeetCode/Solution.h"

Solution solution;

int main(int argc, char const *argv[]) {
    std::cout << solution.soupServings(50) << std::endl;
    std::cout << solution.soupServings(100) << std::endl;
    std::cout << solution.soupServings(4000) << std::endl;
    std::cout << solution.soupServings(4500) << std::endl;
    std::cout << solution.soupServings(4800) << std::endl;
    std::cout << solution.soupServings(4900) << std::endl;
    std::cout << solution.soupServings(4999) << std::endl;
    std::cout << solution.soupServings(5000) << std::endl;
    return 0;
}
