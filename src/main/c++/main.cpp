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
    printf("%d \n", solution.minPatches({1, 3}, 6));
    printf("%d \n", solution.minPatches({1, 5, 10}, 20));
    printf("%d \n", solution.minPatches({1, 2, 2}, 5));
}
