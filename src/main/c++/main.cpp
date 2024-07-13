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

#define FIO                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);

int main(int argc, char const* argv[]) {
    FIO;

    cout << solution.survivedRobotsHealths({5, 4, 3, 2, 1}, {2, 17, 9, 15, 10}, "RRRRR") << endl;
    cout << solution.survivedRobotsHealths({3, 5, 2, 6}, {10, 10, 15, 12}, "RLRL") << endl;
    cout << solution.survivedRobotsHealths({1, 2, 5, 6}, {10, 10, 11, 11}, "RLRL") << endl;
    cout << solution.survivedRobotsHealths({1, 40}, {10, 11}, "RL") << endl;
    cout << solution.survivedRobotsHealths({3, 47}, {46, 26}, "LR") << endl;
    cout << solution.survivedRobotsHealths({37, 35}, {16, 19}, "RL") << endl;
    cout << solution.survivedRobotsHealths({4, 37, 23}, {50, 15, 49}, "RLR") << endl;
    cout << solution.survivedRobotsHealths({34, 50, 42, 2}, {6, 27, 17, 38}, "LLRR") << endl;
    cout << solution.survivedRobotsHealths({3, 2, 30, 24, 38, 7}, {47, 12, 49, 11, 47, 38}, "RRLRRR") << endl;
    cout << solution.survivedRobotsHealths({4, 48, 23, 42}, {16, 25, 26, 16}, "LLLR") << endl;

    return 0;
}
