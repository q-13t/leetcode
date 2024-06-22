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

    printf("%d \n", solution.numberOfSubarrays({1, 1, 2, 1, 1}, 3));
    printf("%d \n", solution.numberOfSubarrays({2, 4, 6}, 1));
    printf("%d \n", solution.numberOfSubarrays({2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
}
