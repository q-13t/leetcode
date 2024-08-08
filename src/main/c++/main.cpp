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
    for (vector<int> vec : solution.spiralMatrixIII(3, 3, 1, 2)) {
        cout << vec << endl;
    }
    for (vector<int> vec : solution.spiralMatrixIII(1, 4, 0, 0)) {
        cout << vec << endl;
    }
    for (vector<int> vec : solution.spiralMatrixIII(5, 6, 1, 4)) {
        cout << vec << endl;
    }
    return 0;
}