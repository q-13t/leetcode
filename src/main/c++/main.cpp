#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
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
    vector<vector<int>> arr = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
    // cout << solution.luckyNumbers(arr) << endl;
    arr = {{1, 10, 4, 2},
           {9, 3, 8, 7},
           {15, 16, 17, 12}};
    cout << solution.luckyNumbers(arr) << endl;

    return 0;
}
