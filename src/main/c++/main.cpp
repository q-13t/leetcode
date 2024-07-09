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

int main(int argc, char const* argv[]) {
    FIO;
    cout << solution.averageWaitingTime({{1, 2}, {2, 5}, {4, 3}}) << endl;
    cout << solution.averageWaitingTime({{5, 2}, {5, 4}, {10, 3}, {20, 1}}) << endl;
    cout << solution.averageWaitingTime({{4, 9}, {5, 8}, {6, 4}, {8, 4}, {10, 5}, {13, 4}, {13, 5}, {14, 2}, {14, 5}, {18, 6}}) << endl;

    return 0;
}
