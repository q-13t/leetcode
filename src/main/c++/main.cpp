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
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

int main(int argc, char const* argv[]) {
    FIO;
    TreeNode* root = new TreeNode(5);
    root->left = new TreeNode(1);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(7);
    root->right = new TreeNode(2);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(4);

    // cout << solution.getDirections(root, 3, 4) << endl;
    // cout << solution.getDirections(root, 4,3) << endl;
    // cout << solution.getDirections(root, 7,6) << endl;
    // cout << solution.getDirections(root, 1,2) << endl;
    // cout << solution.getDirections(root, 3, 7) << endl;
    // cout << solution.getDirections(root, 3,6) << endl;
    cout << solution.getDirections(root, 6,2) << endl;

    delete root;
    return 0;
}
