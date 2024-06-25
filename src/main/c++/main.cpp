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
    TreeNode* root = new TreeNode{4, new TreeNode{1, new TreeNode{0}, new TreeNode{2, nullptr, new TreeNode{3}}}, new TreeNode{6, new TreeNode{5}, new TreeNode{7, nullptr, new TreeNode{8}}}};
    PrintBinaryTree(solution.bstToGst(root));
    root = new TreeNode{4, new TreeNode{1, new TreeNode{0}, new TreeNode{2, nullptr, new TreeNode{3}}}, new TreeNode{6, new TreeNode{5}, new TreeNode{7, nullptr, new TreeNode{9}}}};
    PrintBinaryTree(solution.bstToGst(root));
    delete root;
}
