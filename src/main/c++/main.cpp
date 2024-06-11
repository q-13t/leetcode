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

int main(int argc, char const* argv[]) {
    vector<int> arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    vector<int> arr2 = {2, 1, 4, 3, 9, 6};
    vector<int> res = solution.relativeSortArray(arr1, arr2);
    Utils::print_vec(res);

    arr1 = {28, 6, 22, 8, 44, 17};
    arr2 = {22, 28, 8, 6};
    res = solution.relativeSortArray(arr1, arr2);
    Utils::print_vec(res);
}
