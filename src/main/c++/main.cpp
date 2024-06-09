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

    std::vector<int> v = {1, 2, 2, 4};
    std::vector<int> res = solution.findErrorNums(v);
    print_vec(res);

    v = {1, 1};
    res = solution.findErrorNums(v);
    print_vec(res);

    v = {2, 2};
    res = solution.findErrorNums(v);
    print_vec(res);

    v = {2, 3, 2};
    res = solution.findErrorNums(v);
    print_vec(res);

    return 0;
}
