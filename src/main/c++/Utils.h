#ifndef UTILS
#define UTILS

#include <iostream>
#include <vector>

#include "LeetCode/TreeNode.h"

#define whole(x) x.begin(), x.end()
#define rwhole(x) x.rbegin(), x.rend()

/**
 * @brief Utility functions that help with representing / collecting data.
 *
 */
namespace Utils {

TreeNode* buildBalancedBST(int start, int end, vector<int>* vec) {
    if (start > end) {
        return NULL;
    }
    int mid = (start + end) / 2;
    TreeNode* root = new TreeNode(vec->at(mid));

    root->left = buildBalancedBST(start, mid - 1, vec);
    root->right = buildBalancedBST(mid + 1, end, vec);
    return root;
}

/**
 * @brief Prints an std::vector in format [e_1, e_2, e_3, ... e_n]
 * @tparam T Any type that supports std::cout
 * @param vec to be printed
 *
 */
template <typename T>
ostream& operator<<(ostream& cout, vector<T> const& v) {
    cout << "Size: " << v.size() << "; Type: " << typeid(T).name() << " - [";
    for (int i = 0; i < v.size(); i++) {
        if (i) cout << ", ";
        cout << v[i];
    }
    return cout << "]";
}
// `Flush Input Output`
// Unties `cin` and `cout` from each other in order to speed up the IO operations. This makes buffers not be automatically flushed.
#define FIO                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);

/**
 * @brief An operator that prints true or false.
 *
 * @param cout
 * @param b
 * @return ostream&
 */
ostream& operator<<(ostream& cout, bool const& b) {
    return cout << (b ? "true" : "false");
}

/**
 * @brief A timer class that measures time in milliseconds.
 *
 */
struct Timer {
    chrono::_V2::system_clock::time_point start, end, mark;
    chrono::duration<float> duration;
    Timer() { start = chrono::high_resolution_clock::now(); }
    void checkPoint() {
        cout << "\nTime point: " << (mark - start).count() * 1000.0f << " ms\n";
    }
    void point() {
        cout << "\nTime point: " << (chrono::high_resolution_clock::now() - start).count() * 1000.0f << " ms\n";
    }
    void check() {
        mark = chrono::high_resolution_clock::now();
    }
    ~Timer() {
        end = chrono::high_resolution_clock::now();
        duration = end - start;
        cout << "\nTime taken: " << duration.count() * 1000.0f << " ms\n";
    }
};

void PrintTreePreorder(TreeNode* root) {
    if (root == nullptr) {
        return;
    }

    cout << root->val << " ";
    PrintTreePreorder(root->left);
    PrintTreePreorder(root->right);
}

void PrintBinaryTree(TreeNode* root) {
    if (root == nullptr) {
        return;
    }
    cout << endl;
    PrintTreePreorder(root);
}
};  // namespace Utils
#endif