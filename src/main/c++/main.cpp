#include <iostream>
#include <string>
#include <vector>

#include "LeetCode/Solution.h"

Solution solution;

int main(int argc, char const* argv[]) {
    std::vector<int> v = {4, 5, 0, -2, -3, 1};
    // std::cout << solution.subarraysDivByK(v, 5);
    std::printf("%d \n", solution.subarraysDivByK(v, 5));
    v = {5};
    std::printf("%d \n", solution.subarraysDivByK(v, 9));
    v = {-5};
    std::printf("%d \n", solution.subarraysDivByK(v, 5));
    v = {-1, 2, 9};
    std::printf("%d \n", solution.subarraysDivByK(v, 2));
    return 0;
}
