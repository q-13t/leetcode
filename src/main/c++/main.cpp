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

    cout << solution.minDifference({5, 3, 2, 4}) << endl;
    cout << solution.minDifference({1, 5, 0, 10, 14}) << endl;
    cout << solution.minDifference({3, 100, 20}) << endl;
    cout << solution.minDifference({5948, 61227, 91810, 80992, 85935, 26866, 70043, 88210, 10182, 16465, 56751, 12393, 44729, 85241, 41385, 81154, 9063, 50508, 63955, 56598, 65134, 21576, 61467, 51848, 3040, 59751, 87114, 16058, 3140, 48368, 45513, 76202, 73911, 11972, 49341, 13643, 42300, 38656, 31043, 17335, 23081, 42407, 41167, 23600, 19257, 13274, 48446, 85905, 67090, 55680, 65455, 25794, 37980, 62248, 82653, 72050, 31236, 547, 75515}) << endl;

    return 0;
}
