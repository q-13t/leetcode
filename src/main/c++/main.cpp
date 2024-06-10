#include <iostream>
#include <string>
#include <vector>

#include "LeetCode/Solution.h"

Solution solution;
template <typename T>
void print_vec(std::vector<T>& vec) {
    std::cout << "[ ";
    for (auto val : vec)
        std::cout << val << ", ";
    std::cout << "]" << std::endl;
}

int main(int argc, char const* argv[]) {
    // std::printf("%d \n", solution.halvesAreAlike("book"));
    // std::printf("%d \n", solution.halvesAreAlike("textbook"));

    std::vector<int> v = {1, 1, 4, 2, 1, 3};
    std::cout << solution.heightChecker(v) << std::endl;

    v = {5, 1, 2, 3, 4};
    std::cout << solution.heightChecker(v) << std::endl;
    v = {1, 2, 3, 4, 5};
    std::cout << solution.heightChecker(v) << std::endl;

    return 0;
}
