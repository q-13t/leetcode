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
    arr1 = {2, 4, 6, 8, 10};
    arr2 = {10, 20, 30, 40, 50};
    arr3 = {4, 5, 6, 7};

    printf("%d \n", solution.maxProfitAssignment(arr1, arr2, arr3));

    arr1 = {85, 47, 57};
    arr2 = {24, 66, 99};
    arr3 = {40, 25, 25};
    printf("%d \n", solution.maxProfitAssignment(arr1, arr2, arr3));

    arr1 = {13, 37, 58};
    arr2 = {4, 90, 96};
    arr3 = {34, 73, 45};
    printf("%d \n", solution.maxProfitAssignment(arr1, arr2, arr3));
}
