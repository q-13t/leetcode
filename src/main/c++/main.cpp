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
    // FIO;
    printf("%d 4\n", solution.search({4, 5, 6, 7, 0, 1, 2}, 0));
    printf("%d -1\n", solution.search({4, 5, 6, 7, 0, 1, 2}, 3));
    printf("%d -1\n", solution.search({1}, 0));
    printf("%d 0\n", solution.search({1}, 1));
    printf("%d 1\n", solution.search({3, 1}, 1));
}
