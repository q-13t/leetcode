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
#define MX 100001
#pragma GCC optimize("03")
#pragma GCC target("avx")
#pragma GCC target("-fsplit-loops")

int main(int argc, char const* argv[]) {
    FIO;

    PrintTreePreorder(solution.createBinaryTree({{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}));
    PrintTreePreorder(solution.createBinaryTree({{1, 2, 1}, {2, 3, 0}, {3, 4, 1}}));
    PrintTreePreorder(solution.createBinaryTree({{8, 25, 1}, {60, 61, 1}, {90, 1, 1}, {4, 3, 1}, {100, 22, 0}, {8, 4, 0}, {1, 100, 1}, {60, 65, 0}, {22, 60, 1}, {100, 8, 1}, {52, 90, 1}, {65, 28, 0}}));

    return 0;
}
