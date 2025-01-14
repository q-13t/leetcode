

#include <algorithm>
#include <bitset>
#include <cmath>
#include <cstring>
#include <iostream>
#include <limits>
#include <map>
#include <queue>
#include <regex>
#include <set>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;
#define whole(x) x.begin(), x.end()

class KthLargest {
   private:
    vector<int> arr;
    int kth = 0;

   public:
    KthLargest(int k, vector<int>&& nums) {
        kth = k - 1;
        sort(whole(nums));
        arr = nums;
    }

    int add(int val) {
        if (arr.size() == 0) {
            arr.push_back(val);
            return val;
        }
        int l = 0, r = arr.size() - 1, m = (r + l) / 2;
        while (l <= r) {
            m = (r + l) / 2;
            if (arr[m] == val) {
                arr.insert(arr.begin() + m, val);
                break;
            } else if (m > 0 && m < arr.size() && arr[m - 1] <= val && arr[m] >= val) {
                arr.insert(arr.begin() + m, val);
                break;
            } else if (m + 1 == arr.size() && arr[m] <= val) {
                arr.insert(arr.begin() + m + 1, val);
                break;
            } else if (m == 0 && arr[m] >= val) {
                arr.insert(arr.begin(), val);
                break;
            } else if (arr[m] > val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        for (int i : arr) {
            cout << i << " ";
        }
        cout << endl;
        return arr[arr.size() - 1 - kth];
    }
};
// 2 3 4 5 5 8

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */