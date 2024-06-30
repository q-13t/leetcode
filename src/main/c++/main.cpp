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

    cout << solution.maxNumEdgesToRemove(4, {{3, 1, 2},
                                             {3, 2, 3},
                                             {1, 1, 3},
                                             {1, 2, 4},
                                             {1, 1, 2},
                                             {2, 3, 4}})
         << endl;
    cout << solution.maxNumEdgesToRemove(4, {{3, 1, 2},
                                             {3, 2, 3},
                                             {1, 1, 4},
                                             {2, 1, 4}})
         << endl;
    cout << solution.maxNumEdgesToRemove(4, {{3, 2, 3},
                                             {1, 1, 2},
                                             {2, 3, 4}})
         << endl;
    cout << solution.maxNumEdgesToRemove(2, {{1, 1, 2},
                                             {2, 1, 2},
                                             {3, 1, 2}})
         << endl;

    return 0;
}
