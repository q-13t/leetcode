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
    TreeNode* root = new TreeNode{1};
    root->right = new TreeNode{2};
    root->right->right = new TreeNode{3};
    root->right->right->right = new TreeNode{4};
    cout << "Boferoe: " << endl;
    PrintBinaryTree(root);
    cout << "After: " << endl;
    PrintBinaryTree(solution.balanceBST(root));

    delete root;
}
