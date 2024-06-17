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
    cout << solution.judgeSquareSum(5) << endl;
    cout << solution.judgeSquareSum(3) << endl;
    cout << solution.judgeSquareSum(4) << endl;
    cout << solution.judgeSquareSum(2) << endl;
    cout << solution.judgeSquareSum(2147482647) << endl;
}
