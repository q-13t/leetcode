#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/KthLargest.h"
#include "LeetCode/ListNode.h"
#include "LeetCode/NumberContainers.h"
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

    NumberContainers* nc = new NumberContainers();
    cout << nc->find(10) << endl;
    nc->change(2, 10);
    nc->change(1, 10);
    nc->change(3, 10);
    nc->change(5, 10);
    cout << nc->find(10) << endl;
    nc->change(1, 20);
    cout << nc->find(10) << endl;

    nc = new NumberContainers();
    nc->change(1, 10);
    cout << nc->find(10) << endl;
    nc->change(1, 20);
    cout << nc->find(10) << endl;
    cout << nc->find(20) << endl;
    cout << nc->find(30) << endl;

    return 0;
}