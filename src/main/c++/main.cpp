#include <iostream>
#include <string>
#include <vector>

#include "LeetCode/Solution.h"

Solution solution;

int main(int argc, char const* argv[]) {
    std::printf("%d \n", solution.halvesAreAlike("book"));
    std::printf("%d \n", solution.halvesAreAlike("textbook"));
    std::printf("%d \n", solution.halvesAreAlike("ebeilA"));
    std::printf("%d \n", solution.halvesAreAlike("Uaec"));

    return 0;
}
