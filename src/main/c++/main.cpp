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

    cout << solution.firstCompleteIndex({1, 3, 4, 2}, {{1, 4}, {2, 3}}) << endl;
    cout << solution.firstCompleteIndex({2, 8, 7, 4, 1, 3, 5, 6, 9}, {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}) << endl;
    cout << solution.firstCompleteIndex({1, 4, 5, 2, 6, 3}, {{4, 3, 5}, {1, 2, 6}}) << endl;

    return 0;
}