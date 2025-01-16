#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/KthLargest.h"
#include "LeetCode/ListNode.h"
#include "LeetCode/Solution.h"
#include "LeetCode/SubrectangleQueries.h"
#include "LeetCode/TreeNode.h"
#include "Utils.h"
#include "bits/stdc++.h"
using namespace std;
using namespace Utils;

Solution solution;
vector<int> arr1;
vector<int> arr2;
vector<int> arr3;

auto _ = []() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    return 0;
}();

int main(int argc, char const* argv[]) {
    FIO;

    cout << solution.xorAllNums({2, 1, 3}, {10, 2, 5, 0}) << endl;
    cout << solution.xorAllNums({2, 1, 1, 1, 3}, {10, 2, 5, 0}) << endl;
    cout << solution.xorAllNums({2, 1, 1, 3}, {10, 2, 5, 0}) << endl;
    cout << solution.xorAllNums({2, 3}, {10, 2, 5, 0}) << endl;
    cout << solution.xorAllNums({1, 2}, {3, 4}) << endl;
    cout << solution.xorAllNums({8, 6, 29, 2, 26, 16, 15, 29}, {24, 12, 12}) << endl;
    cout << solution.xorAllNums({938, 396, 251, 668, 534, 581, 986, 169, 521, 116, 759, 971, 61, 914, 895, 130, 775, 34, 753, 468, 360, 302, 49, 904, 393, 374, 938, 159, 11, 783, 488, 410, 995, 293, 460, 72, 730, 844, 250, 723, 171, 791, 85, 892, 383, 583, 364, 237, 338, 208, 600, 314, 544, 909}, {665, 410, 567, 1000, 299, 157, 994, 927, 267, 107, 190, 347, 389, 802, 252, 877, 317, 110, 184, 710, 609, 304, 175, 82, 975, 115, 611}) << endl;

    return 0;
}