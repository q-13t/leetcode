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
// using namespace Utils;

Solution solution;
vector<int> arr1;
vector<int> arr2;
vector<int> arr3;

int main(int argc, char const* argv[]) {
    FIO;

    cout << solution.threeConsecutiveOdds({2, 6, 4, 1}) << endl;
    cout << solution.threeConsecutiveOdds({1, 2, 34, 3, 4, 5, 7, 23, 12}) << endl;

    return 0;
}
