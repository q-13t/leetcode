#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
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

    cout << solution.intersect({1, 2, 2, 1}, {2, 2}) << endl;
    cout << solution.intersect({4, 9, 5}, {9, 4, 9, 8, 4}) << endl;

    return 0;
}
