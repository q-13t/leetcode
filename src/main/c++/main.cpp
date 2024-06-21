#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/Solution.h"
#include "LeetCode/SubrectangleQueries.h"
#include "Utils.h"

// `Flush Input Output`
// Unties `cin` and `cout` from each other in order to speed up the IO operations. This makes buffers not be automatically flushed.
#define FIO                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);

using namespace std;
Solution solution;
vector<int> arr1;
vector<int> arr2;
vector<int> arr3;

int main(int argc, char const* argv[]) {
    FIO;

    printf("%d \n", solution.maxSatisfied(
                        {1, 0, 1, 2, 1, 1, 7, 5},  // customers
                        {0, 1, 0, 1, 0, 1, 0, 1},  // grumpy
                        3));
    printf("%d \n", solution.maxSatisfied({1}, {0}, 1));
    printf("%d \n", solution.maxSatisfied({5, 8}, {0, 1}, 1));
    printf("%d \n", solution.maxSatisfied({10, 1, 7}, {0, 0, 0}, 2));
    printf("%d \n", solution.maxSatisfied({1, 2, 3, 4, 5}, {1, 1, 1, 1, 1}, 1));
    printf("%d \n", solution.maxSatisfied({10, 1, 10, 1, 10, 1, 10}, {1, 1, 1, 1, 1, 1, 1}, 1));
    printf("%d \n", solution.maxSatisfied({0}, {0}, 1));
    printf("%d \n", solution.maxSatisfied({2, 2, 6, 9}, {0, 0, 1, 1}, 1));
    printf("%d \n", solution.maxSatisfied({5, 10, 2, 2, 3, 8}, {1, 1, 1, 1, 0, 1}, 2));
    printf("%d \n", solution.maxSatisfied({2, 4, 1, 4, 1}, {1, 0, 1, 0, 1}, 2));
}
