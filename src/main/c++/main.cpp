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

    std::cout << solution.countPrefixSuffixPairs({"a", "aba", "ababa", "aa"}) << std::endl;
    std::cout << solution.countPrefixSuffixPairs({"pa", "papa", "ma", "mama"}) << std::endl;
    std::cout << solution.countPrefixSuffixPairs({"abab", "ab"}) << std::endl;
    std::cout << solution.countPrefixSuffixPairs({"a", "abb"}) << std::endl;
    std::cout << solution.countPrefixSuffixPairs({"bb", "bb"}) << std::endl;

    return 0;
}