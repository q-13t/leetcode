#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/Solution.h"
#include "Utils.h"

using namespace std;
Solution solution;
vector<int> arr1;
vector<int> arr2;

int main(int argc, char const* argv[]) {
    printf("%d \n", solution.findMaximizedCapital(2, 0, {1, 2, 3}, {0, 1, 1}));

    printf("%d \n", solution.findMaximizedCapital(3, 0, {1, 2, 3}, {0, 1, 2}));
    printf("%d \n", solution.findMaximizedCapital(1, 0, {1, 2, 3}, {1, 1, 2}));
}
