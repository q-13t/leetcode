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
    cout << solution.maxProbability(3, {{0, 1}, {1, 2}, {0, 2}}, {0.5, 0.5, 0.2}, 0, 2) << endl;
    cout << solution.maxProbability(3, {{0, 1}, {1, 2}, {0, 2}}, {0.5, 0.5, 0.3}, 0, 2) << endl;
    cout << solution.maxProbability(3, {{0, 1}}, {0.5}, 0, 2) << endl;
    cout << solution.maxProbability(5, {{2, 3}, {1, 2}, {3, 4}, {1, 3}, {1, 4}, {0, 1}, {2, 4}, {0, 4}, {0, 2}}, {0.06, 0.26, 0.49, 0.25, 0.2, 0.64, 0.23, 0.21, 0.77}, 0, 3) << endl;
    return 0;
}