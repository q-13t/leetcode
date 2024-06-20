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
vector<int> arr3;

int main(int argc, char const* argv[]) {
    FIO;

    printf("%d \n", solution.minEatingSpeed({3, 6, 7, 11}, 8));
    printf("%d \n", solution.minEatingSpeed({30, 11, 23, 4, 20}, 5));
    printf("%d \n", solution.minEatingSpeed({30, 11, 23, 4, 20}, 6));
    printf("%d \n", solution.minEatingSpeed({332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));
}
