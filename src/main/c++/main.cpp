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
    arr1 = {1, 2, 2};
    printf("%d \n", solution.minIncrementForUnique(arr1));

    arr1 = {3, 2, 1, 2, 1, 7};
    printf("%d \n", solution.minIncrementForUnique(arr1));
}
