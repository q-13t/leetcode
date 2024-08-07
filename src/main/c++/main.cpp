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

    // cout << solution.numberToWords(123) << endl;
    // cout << solution.numberToWords(12345) << endl;
    // cout << solution.numberToWords(1234567) << endl;
    cout << solution.numberToWords(101) << endl;
    // cout << solution.numberToWords(INT_MAX) << endl;
    // arr1 = {5, 1, 2};
    // string res = "";
    // cout << *solution.getPairOfThree(arr1, &res) << endl;
    // arr1 = {2};
    // res = "";
    // cout << *solution.getPairOfThree(arr1, &res) << endl;
    // arr1 = {1, 6};
    // res = "";
    // cout << *solution.getPairOfThree(arr1, &res) << endl;
    // arr1 = {2, 6};
    // res = "";
    // cout << *solution.getPairOfThree(arr1, &res) << endl;

    return 0;
}
