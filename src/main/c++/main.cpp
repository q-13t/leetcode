#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/Solution.h"
#include "LeetCode/SubrectangleQueries.h"
#include "Utils.h"

// `Flush Input Output`
// Unties `cin` and `cout` from each other in order to speed up the IO operations. This makes buffers not be automatically flushed.
#define FIO                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);

using namespace std;
Solution solution;
vector<int> arr1;
vector<int> arr2;

int main(int argc, char const* argv[]) {
    FIO;
    vector<vector<int>> rectangle = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};

    SubrectangleQueries* obj = new SubrectangleQueries(rectangle);

    obj->updateSubrectangle(0, 0, 3, 2, 5);
    cout << obj->getValue(0, 2) << endl;
}
