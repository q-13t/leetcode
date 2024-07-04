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
    ListNode* head = ListNode::createFromVector({0, 3, 1, 0, 4, 5, 2, 0});
    ListNode::printList(head);
    ListNode::printList(solution.mergeNodes(head));

    head = ListNode::createFromVector({0, 1, 0, 3, 0, 2, 2, 0});
    ListNode::printList(head);
    ListNode::printList(solution.mergeNodes(head));

    return 0;
}
