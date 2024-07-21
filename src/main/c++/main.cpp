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

    // cout << solution.myAtoi("42") << endl;
    // cout << solution.myAtoi(" -042") << endl;
    // cout << solution.myAtoi("1337c0d3") << endl;
    // cout << solution.myAtoi("0-1") << endl;
    // cout << solution.myAtoi("words and 987") << endl;
    // cout << solution.myAtoi("+-12") << endl;
    // cout << solution.myAtoi("20000000000000000000") << endl;
    cout << solution.myAtoi("+1") << endl;

    return 0;
}
