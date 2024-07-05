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
    ListNode* head = ListNode::createFromVector({3, 1});
    cout << solution.nodesBetweenCriticalPoints(head);

    head = ListNode::createFromVector({5, 3, 1, 2, 5, 1, 2});
    cout << solution.nodesBetweenCriticalPoints(head);

    head = ListNode::createFromVector({1, 3, 2, 2, 3, 2, 2, 2, 7});
    cout << solution.nodesBetweenCriticalPoints(head);

    head = ListNode::createFromVector({2, 3, 3, 2});
    cout << solution.nodesBetweenCriticalPoints(head);

    head = ListNode::createFromVector({2, 2, 1, 3});
    cout << solution.nodesBetweenCriticalPoints(head);
    return 0;
}
