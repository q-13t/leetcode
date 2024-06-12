#include <chrono>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "LeetCode/Foo.h"
#include "LeetCode/Solution.h"
#include "Utils.h"

using namespace std;
Solution solution;
vector<int> arr1;
vector<int> arr2;

int main(int argc, char const* argv[]) {
    printf("%d \n", solution.minBitFlips(10, 7));
    printf("%d \n", solution.minBitFlips(3, 4));
    printf("%d \n", solution.minBitFlips(243, 640));
    printf("%d \n", solution.minBitFlips(243, 1000000000));
}
