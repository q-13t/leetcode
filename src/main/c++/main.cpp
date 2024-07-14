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

    cout << solution.countOfAtoms("H2O") << endl;
    cout << solution.countOfAtoms("Mg(OH)2") << endl;
    cout << solution.countOfAtoms("K4(ON(SO3)2)2") << endl;
    cout << solution.countOfAtoms("Mg(H2O)N") << endl;

    return 0;
}
