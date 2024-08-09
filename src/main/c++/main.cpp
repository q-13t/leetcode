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
    cout << solution.numMagicSquaresInside({{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}) << endl;
    cout << solution.numMagicSquaresInside({{8}}) << endl;
    cout << solution.numMagicSquaresInside({{7, 0, 5}, {2, 4, 6}, {3, 8, 1}}) << endl;

    return 0;
}