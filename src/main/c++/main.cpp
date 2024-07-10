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

    cout << solution.minOperations({"d1/", "d2/", "../", "d21/", "./"}) << endl;
    cout << solution.minOperations({"d1/", "d2/", "./", "d3/", "../", "d31/"}) << endl;
    cout << solution.minOperations({"d1/", "../", "../", "../"}) << endl;
    cout << solution.minOperations({"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"}) << endl;

    return 0;
}
