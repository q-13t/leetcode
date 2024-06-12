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
    arr1 = {2, 0, 2, 1, 1, 0};
    solution.sortColors(arr1);
    // Utils::print_vec();

    arr1 = {2, 0, 1};
    solution.sortColors(arr1);
    // Utils::print_vec();
}
