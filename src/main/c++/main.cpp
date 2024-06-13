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
    arr1 = {3, 1, 5};
    arr2 = {2, 7, 4};
    printf("%d \n", solution.minMovesToSeat(arr1, arr2));
    arr1 = {4, 1, 5, 9};
    arr2 = {1, 3, 2, 6};
    printf("%d \n", solution.minMovesToSeat(arr1, arr2));
    arr1 = {2, 2, 6, 6};
    arr2 = {1, 3, 2, 6};
    printf("%d \n", solution.minMovesToSeat(arr1, arr2));
}
