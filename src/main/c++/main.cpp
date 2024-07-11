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

    cout << solution.reverseParentheses("(abcd)") << endl;
    cout << solution.reverseParentheses("(u(love)i)") << endl;
    cout << solution.reverseParentheses("(ed(et(oc))el)") << endl;
    cout << solution.reverseParentheses("ab(bcdefghijkl(mno)p)qz") << endl;
    cout << solution.reverseParentheses("yfgnxf") << endl;
    cout << solution.reverseParentheses("ta()usw((((a))))") << endl;

    return 0;
}
