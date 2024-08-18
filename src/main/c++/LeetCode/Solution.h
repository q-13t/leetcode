#ifndef SOLUTION
#define SOLUTION

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

#include "../Utils.h"
#include "TreeNode.h"
using namespace std;

class Solution {
   public:
    vector<pair<int, int>> serves{{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    vector<vector<double>> t;

    double solve(double A, double B) {
        if (A <= 0 && B <= 0)
            return 0.5;

        if (A <= 0)
            return 1.0;
        if (B <= 0)
            return 0.0;

        if (t[A][B] != -1.0)
            return t[A][B];

        double probability = 0.0;

        for (auto& p : serves) {
            double A_serve = p.first;
            double B_serve = p.second;

            probability += 0.25 * solve(A - A_serve, B - B_serve);
        }

        return t[A][B] = probability;
    }

    double soupServings(int n) {
        t.clear();
        if (n >= 4800)  // I hate this part.
            return 1.0;

        t.resize(n + 1, vector<double>(n + 1, -1.0));
        return solve(n, n);
    }

    template <typename A, typename B>
    std::pair<B, A> flip_pair(const std::pair<A, B>& p) {
        return std::pair<B, A>(p.second, p.first);
    }

    int longestPalindrome(string s) {
        int max = 0, single = 0;
        map<char, int> occurrences;
        for (size_t i = 0; i < s.size(); i++) occurrences[s.at(i)] = occurrences[s.at(i)] + 1;

        if (occurrences.size() == 1) return occurrences.begin()->second;

        std::vector<int> sorted;
        for (auto&& v : occurrences) sorted.push_back(v.second);
        std::sort(sorted.begin(), sorted.end(), std::greater<>());

        for (auto&& value : sorted) {
            if (value >= 2) {
                if (value % 2 != 0) {
                    single = 1;
                    value = value - 1;
                }
                max += value;
            } else if (single != 1) {
                single = 1;
            } else {
                break;
            }
        }

        return max + single;
    }
    int subarraysDivByK(vector<int>& nums, int k) {
        int arrays = 0, rem = 0, sum = 0, def = 0, length = nums.size();
        // Reminder, Count
        std::unordered_map<int, int> map;
        map[0] = 1;
        for (size_t i = 0; i < length; i++) {
            sum += nums[i];
            rem = (sum % k < 0) ? (sum % k) + k : sum % k;
            if (map.find(rem) != map.end())
                arrays += map[rem];
            map[rem]++;
        }
        return arrays;
    }

    bool halvesAreAlike(string s) {
        int left = 0, right = s.size() - 1, left_count = 0, right_count = 0;
        while (left < right) {
            if (s[left] == 'a' || s[left] == 'e' || s[left] == 'i' || s[left] == 'o' || s[left] == 'u' || s[left] == 'A' || s[left] == 'E' || s[left] == 'I' || s[left] == 'O' || s[left] == 'U')
                left_count++;
            if (s[right] == 'a' || s[right] == 'e' || s[right] == 'i' || s[right] == 'o' || s[right] == 'u' || s[right] == 'A' || s[right] == 'E' || s[right] == 'I' || s[right] == 'O' || s[right] == 'U')
                right_count++;
            left++, right--;
        }
        return (right_count == left_count);
    }
#pragma GCC optimize("O3", "unroll-loops")
    vector<int> findErrorNums(vector<int>& nums) {
        std::unordered_map<int, int> map;
        std::vector<int> res(2);
        for (int i = 0; i < nums.size(); i++)
            map[nums[i]]++;

        for (pair<int, int> val : map)
            if (val.second == 2) {
                res[0] = val.first;
                break;
            }

        for (int i = 1; i <= nums.size() + 1; i++) {
            if (map[i] == 0) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

    int heightChecker(vector<int>& heights) {
        std::vector<int> sorted = heights;
        std::sort(sorted.begin(), sorted.end());
        int miss = 0;
        for (int i = 0; i < heights.size(); i++) {
            if (heights[i] != sorted[i]) {
                miss++;
            }
        }
        return miss;
    }

    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        // number, occurrences
        unordered_map<int, int> included;
        map<int, int> missing;
        for (auto&& number : arr1) {
            if (std::find(arr2.begin(), arr2.end(), number) != arr2.end()) {
                // If arr2 contains the number
                included[number]++;
            } else {
                // If arr2 DOES NOT contains the number
                missing[number]++;
            }
        }
        vector<int> result;
        // Add numbers that are in arr2
        for (auto&& number : arr2) {
            auto iterator = included.find(number);
            while (iterator->second != 0) {  // Keep adding number enough times
                result.push_back(number);
                iterator->second--;
            }
        }
        // Add numbers that are NOT in arr2
        for (auto iterator = missing.begin(); iterator != missing.end(); iterator++) {
            while (iterator->second != 0) {  // Keep adding number enough times
                result.push_back(iterator->first);
                iterator->second--;
            }
        }

        return result;
    }
    void sortColors(vector<int>& nums) {
        // // color, count
        // map<int, int> colors;
        // for (int i = 0; i < nums.size(); i++) {
        //     colors[nums[i]]++;
        // }
        // int i = 0;
        // for (auto iterator = colors.begin(); iterator != colors.end(); iterator++) {
        //     while (iterator->second != 0) {  // Keep adding number enough times
        //         nums.at(i) = iterator->first;
        //         iterator->second--;
        //         i++;
        //     }
        // }
        int zeros = 0, ones = 0, twos = 0, iter = 0, size = nums.size();
        for (int i = 0; i < size; i++) {
            switch (nums[i]) {
                case 0: {
                    zeros++;
                    break;
                }
                case 1: {
                    ones++;
                    break;
                }
                case 2: {
                    twos++;
                    break;
                }
            }
        }

        while (zeros != 0) {
            nums[iter] = 0;
            iter++;
            zeros--;
        }
        while (ones != 0) {
            nums[iter] = 1;
            iter++;
            ones--;
        }
        while (twos != 0) {
            nums[iter] = 2;
            iter++;
            twos--;
        }
    }
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        // Player, loss count
        map<int, int> losers;
        map<int, int> winners;

        // Count how many time a player has lost
        for (int i = 0; i < matches.size(); i++) {
            losers[matches[i][1]]++;
            winners[matches[i][0]]++;
        }

        vector<int> no_loss;
        vector<int> one_loss;

        for (auto iter : losers) {
            if (iter.second == 1) {  // Player lost one match
                one_loss.push_back(iter.first);
            }
        }

        for (auto iter : winners) {
            if (losers.find(iter.first) == losers.end()) {  // Player has not lost
                no_loss.push_back(iter.first);
            }
        }
        return {no_loss, one_loss};
    }

    int minBitFlips(int start, int goal) {
        int bin1[32] = {};
        int bin2[32] = {};
        int i = 0, flips = 0, revs = 0;
        while (start != 0) {
            bin1[i++] = start % 2;
            start /= 2;
        }
        i = 0;
        while (goal != 0) {
            bin2[i++] = goal % 2;
            goal /= 2;
        }
        for (i = size(bin1) - 1; i >= 0; i--) {
            flips += bin1[i] ^ bin2[i];
        }
        return flips;
    }
    int minMovesToSeat(vector<int>& seats, vector<int>& students) {
        sort(seats.begin(), seats.end());
        sort(students.begin(), students.end());
        int moves = 0;
        for (int i = 0; i < seats.size(); i++) {
            moves += abs(seats[i] - students[i]);
        }
        return moves;
    }
    int minIncrementForUnique(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        int changes = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] <= nums[i - 1]) {
                changes += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return changes;
    }

    int findMaximizedCapital(int projects, int capital_total, vector<int>&& profits, vector<int>&& capital) {
        vector<pair<int, int>> pairs;
        priority_queue<int> que;
        int iter = 0, size = profits.size();
        for (int i = 0; i < size; i++) {
            pairs.push_back(make_pair(capital[i], profits[i]));
        }

        sort(pairs.begin(), pairs.end());
        while (projects > 0) {  // Create projects

            while (iter < size && pairs[iter].first <= capital_total) {
                que.push(pairs[iter].second);
                iter++;
            }

            if (que.empty()) {
                break;
            } else {
                capital_total += que.top();
                que.pop();
            }
            projects--;
        }
        return capital_total;
    }
    int minPatches(vector<int>&& nums, int n) {
        long long miss = 1, added = 0, idx = 0;
        while (miss <= n) {
            if (idx < nums.size() && nums[idx] <= miss) {
                miss += nums[idx++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }

   private:
    long long findFairPair(int max, vector<int>& nums) {
        int l = 0, size = nums.size(), r = size - 1;
        long long res = 0;
        while (l < r) {
            while (r > l && nums[l] + nums[r] > max) {
                r--;
            }

            res += r - l++;
        }
        return res;
    }

   public:
    long long
    countFairPairs(vector<int>&& nums, int lower, int upper) {
        FIO;
        sort(nums.begin(), nums.end());  // sort the data
        return findFairPair(upper, nums) - findFairPair(lower - 1, nums);
    }
    string defangIPaddr(string address) {
        FIO;
        string newstr;

        for (char ch : address) {
            if (ch == '.') {
                newstr += "[.]";
            } else {
                newstr += ch;
            }
        }

        return newstr;
    }

    bool judgeSquareSum(int c) {
        vector<long> squares;
        for (long i = 0; pow(i, 2) <= c; i++) {
            squares.push_back(pow(i, 2));
        }
        auto left = squares.begin();
        auto right = squares.end();
        right--;
        while (left <= right) {
            long long sum = *left + *right;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int size = difficulty.size(), gain = 0;
        // Profit | difficulty
        map<int, int> pairs;
        for (int i = 0; i < size; i++) {
            pairs[profit[i]] = 2147483647;
        }
        for (int i = 0; i < size; i++) {
            pairs[profit[i]] = (pairs[profit[i]] < difficulty[i]) ? pairs[profit[i]] : difficulty[i];
        }
        sort(worker.begin(), worker.end(), [&](int a, int b) {
            return a > b;
        });
        auto J = pairs.rbegin();
        priority_queue<int> pq;
        auto W = worker.begin();

        while (J != pairs.rend()) {
            while (W != worker.end() && *W >= J->second) {
                gain += J->first;
                W++;
            }
            if (W == worker.end()) {
                break;
            }
            J++;
        }

        return gain;
    }

    int minDays(vector<int>&& bloomDay, int bouquets, int flowers) {
        FIO;
        long long left = 0, right = *max_element(bloomDay.begin(), bloomDay.end());
        int answer = -1;
        while (left <= right) {
            long long mid = left + (right - left) / 2;
            int bc = 0;
            int count = 0;

            for (int i = 0; i < bloomDay.size(); i++) {
                if (bloomDay[i] <= mid) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= flowers) {
                    bc++;
                    count = 0;
                }
            }
            if (bc >= bouquets) {
                answer = mid;
                right = mid - 1;
            } else if (bc < bouquets) {
                left = mid + 1;
            }
        }
        return answer;
    }
    int search(vector<int>&& nums, int target) {
        if (nums[0] == target) {
            return 0;
        }
        int div = 0, start = 0, end = nums.size() - 1;

        while (div < nums.size() - 1 && nums[div + 1] > nums[div]) {
            div++;
        }

        if (target >= nums[0] && target <= nums[div]) {
            end = div;
        } else {
            start = div + 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    bool searchMatrix(vector<vector<int>>&& matrix, int target) {
        int r = matrix[0].size() - 1, l = 0;
        auto iter = matrix.begin();
        for (int i = 0, j = matrix.size() - 1; i <= j; i++, j--) {
            if (matrix[i][r] >= target && matrix[i][0] <= target) {
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (matrix[i][m] == target) {
                        return true;
                    }
                    if (matrix[i][m] >= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
            if (matrix[j][r] >= target && matrix[j][0] <= target) {
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (matrix[j][m] == target) {
                        return true;
                    }
                    if (matrix[j][m] >= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
        }
    }
    /**
     * @brief Angry cow problem type:
     *
     * You are given an array consisting of n integers which denote the position of a stall.
     * You are also given an integer k which denotes the number of aggressive cows.
     * You are given the task of assigning stalls to k cows
     * such that the minimum distance between any two of them is the maximum possible.
     *
     *Iterate thru the numbers beetween 1 and mid OF RANGE and check if all cows can be placed.
     if so answer is valid and can be a candidate thus increase the left range,
     if not decrease the right range.
     *
     * @param distance of stalls
     * @param m cows
     * @return int min max distance
     */
    int maxDistance(vector<int>&& distance, int m) {
        sort(distance.begin(), distance.end());
        int left = 1, right = (distance.back() - distance[0]) / (m - 1);
        int answ = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            //  Check if all balls can be placed if 'distance' is 'mid'
            // In t
            int last_pos = distance[0], placed = 1;
            for (int i = 1; i < distance.size(); i++) {
                if (distance[i] - last_pos >= mid) {
                    last_pos = distance[i];
                    placed++;
                }
                if (placed >= m) {
                    break;
                }
            }

            if (placed >= m) {
                answ = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answ;
    }
    int minEatingSpeed(vector<int>&& piles, int h) {
        sort(piles.begin(), piles.end());
        int left = 1, right = piles.back(), answ = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long needed = 0;
            for (int i = 0; i < piles.size(); i++) {
                needed += ceil((double)piles[i] / mid);
            }
            if (needed <= h) {
                answ = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answ;
    }

    int smallestDivisor(vector<int>&& nums, int threshold) {
        long left = 1, right = *max_element(nums.begin(), nums.end()), answ = 0, mid = 0, sum = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            sum = 0;

            for (int i = 0; i < nums.size(); i++) {
                sum += ceil((double)nums[i] / mid);
            }

            if (sum <= threshold) {
                answ = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answ;
    }
    int maxSatisfied(vector<int>&& customers, vector<int>&& grumpy, int minutes) {
        int current = 0, max = 0, remain = minutes;

        // Find the maximum customers that may be satisfied within minutes window
        for (int i = 0, j = 0; i < customers.size(); i++) {
            if (grumpy[i] == 1) {
                current += customers[i];
                remain--;
            }
            while (remain < 0 || i + 1 - j > minutes) {
                if (grumpy[j] == 1) {
                    remain++;
                    current -= customers[j];
                }
                j++;
            };

            max = max < current ? current : max;
        }
        // Add the rest of satisfied customers
        for (int i = 0; i < customers.size(); i++) {
            if (grumpy[i] == 0) {
                max += customers[i];
            }
        }

        return max;
    }

    bool containsNearbyAlmostDuplicate(vector<int>&& nums, int indexDiff, int valueDiff) {
        set<int> set;

        for (int i = 0; i < nums.size(); i++) {
            if (i > indexDiff) {
                set.erase(nums[i - indexDiff - 1]);
            }
            auto iterator = set.lower_bound(nums[i] - valueDiff);
            if (iterator != set.end() && *iterator <= nums[i] + valueDiff) {
                return true;
            }
            set.insert(nums[i]);
        }

        return false;
    }
    int numberOfSubarrays(vector<int>&& nums, int k) {
        vector<int> count(nums.size() + 1, 0);
        count[0] = 1;
        int answer = 0, total = 0;
        for (int i = 0; i < nums.size(); i++) {
            total += nums[i] % 2;
            if (total - k >= 0) {
                answer += count[total - k];
            }
            count[total]++;
        }
        return answer;
    }
    int numSubarraysWithSum(vector<int>&& nums, int goal) {
        int total_count = 0, current_sum = 0;
        map<int, int> count;
        for (int i = 0; i < nums.size(); i++) {
            current_sum += nums[i];
            if (current_sum == goal) {
                total_count++;
            }
            if (count.find(current_sum - goal) != count.end()) {
                total_count += count[current_sum - goal];
            }
            count[current_sum]++;
        }
        return total_count;
    }

    int longestSubarray(vector<int>&& nums, int limit) {
        FIO;
        int longest = 0;
        multiset<int> set;
        for (int right = 0, left = 0; right < nums.size(); right++) {
            set.insert(nums[right]);

            while (!set.empty() && *set.rbegin() - *set.begin() > limit) {
                set.erase(set.find(nums[left++]));
            }

            longest = max(longest, (int)set.size());
        }

        return longest;
    }

    int minKBitFlips(vector<int>&& nums, int k) {
        FIO;
        int flips = 0, n = nums.size(), flipped = 0;
        deque<int> dq;
        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                flipped ^= dq.front();
                dq.pop_front();
            }
            if (flipped == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                dq.push_back(1);
                flipped ^= 1;
                flips++;
            } else {
                dq.push_back(0);
            }
        }
        return flips;
    }

    int val = 0;
    TreeNode* rebuildTree(TreeNode* root) {
        if (root == nullptr) {
            return root;
        }
        rebuildTree(root->right);
        val += root->val;
        root->val = val;
        rebuildTree(root->left);
        return root;
    }

    TreeNode* bstToGst(TreeNode* root) {
        return rebuildTree(root);
    }

    vector<TreeNode*> inOrderBST;
    void TraverseInOrder(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        TraverseInOrder(root->left);
        inOrderBST.push_back(root);
        TraverseInOrder(root->right);
    }

    TreeNode* buildBalancedBST(int start, int end) {
        if (start > end) {
            return NULL;
        }
        int mid = (start + end) / 2;
        TreeNode* root = inOrderBST[mid];

        root->left = buildBalancedBST(start, mid - 1);
        root->right = buildBalancedBST(mid + 1, end);
        return root;
    }

    TreeNode* balanceBST(TreeNode* root) {
        TraverseInOrder(root);
        return buildBalancedBST(0, (int)inOrderBST.size() - 1);
    }
    int findCenter(vector<vector<int>>& edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }

    long long maximumImportance(int n, vector<vector<int>>& roads) {
        // city occurrence
        FIO;
        vector<long long> priorities(n, 0);
        for (vector<int> vec : roads) {
            priorities[vec[0]]++;
            priorities[vec[1]]++;
        }
        sort(priorities.begin(), priorities.end());
        long long importance = 0;
        for (long long i = 0; i < n; i++) {
            importance += ((i + 1) * priorities[i]);
        }

        return importance;
    }
    vector<vector<int>> divideArray(vector<int>&& nums, int k) {
        sort(whole(nums));
        vector<vector<int>> res;
        for (int i = 2; i < nums.size(); i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return {};
            }
            res.push_back({nums[i - 2], nums[i - 1], nums[i]});
        }
        return res;
    }

    void findAncestors(int ancestor, vector<vector<int>>& adjacent, int current, vector<vector<int>>& ancestors) {
        for (int ch : adjacent[current]) {
            if (ancestors[ch].empty() || ancestors[ch].back() != ancestor) {
                ancestors[ch].push_back(ancestor);
                findAncestors(ancestor, adjacent, ch, ancestors);
            }
        }
    }

    vector<vector<int>> getAncestors(int n, vector<vector<int>>&& edges) {
        // to , from

        vector<vector<int>> ancestor(n);
        vector<vector<int>> adjacent(n);

        for (vector<int> vec : edges) {
            adjacent[vec[0]].push_back(vec[1]);
        }

        for (int i = 0; i < n; i++) {
            findAncestors(i, adjacent, i, ancestor);
        }

        return ancestor;
    }

    class UnionFind {
       private:
        vector<int> data;
        int distinct;

       public:
        UnionFind(int n) {
            distinct = n;
            for (int i = 0; i <= n; i++) {
                data.push_back(i);
            }
        }

        bool unite(int a, int b) {
            if (findData(a) == findData(b)) {
                return false;
            }
            data[findData(a)] = b;
            distinct--;
            return true;
        }

        int findData(int d) {
            if (data[d] != d) {
                data[d] = findData(data[d]);
            }
            return data[d];
        }

        int united() {
            return distinct == 1;
        }
    };

    int maxNumEdgesToRemove(int n, vector<vector<int>>&& edges) {
        UnionFind Alice(n), Bob(n);
        sort(whole(edges), [](vector<int> a, vector<int> b) { return a[0] > b[0]; });
        int required = 0;
        for (vector<int> edge : edges) {
            switch (edge[0]) {
                case 3: {
                    required += (Alice.unite(edge[1], edge[2]) | Bob.unite(edge[1], edge[2]));
                    break;
                }
                case 2: {
                    required += Bob.unite(edge[1], edge[2]);
                    break;
                }
                case 1: {
                    required += Alice.unite(edge[1], edge[2]);
                    break;
                }
            }
        }
        return (Alice.united() && Bob.united()) ? (edges.size() - required) : -1;
    }
    bool threeConsecutiveOdds(vector<int>&& arr) {
        if (arr.size() < 3) {
            return false;
        }
        for (int i = 0; i < arr.size() - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
            if (arr[i + 2] % 2 == 0) {
                i += 2;
            } else if (arr[i + 1] % 2 == 0) {
                i++;
            }
        }
        return false;
    }
    vector<int> intersect(vector<int>&& nums1, vector<int>&& nums2) {
        map<int, int> occurrences1;
        map<int, int> occurrences2;
        vector<int> result;
        for (int num : nums1) {
            occurrences1[num]++;
        }
        for (int num : nums2) {
            occurrences2[num]++;
        }
        for (auto i = occurrences1.begin(), j = occurrences2.begin(); i != occurrences1.end() && j != occurrences2.end();) {
            if (i->first == j->first && i->second != 0 && j->second != 0) {
                result.push_back(i->first);
                i->second--;
                j->second--;
            }
            if (i->second == 0 || i->first < j->first) {
                i++;
            }
            if (j->second == 0 || j->first < i->first) {
                j++;
            }
        }

        return result;
    }

    int minDifference(vector<int>&& nums) {
        if (nums.size() <= 4) {
            return 0;
        }
        sort(whole(nums));

        long min = LONG_MAX, n = nums.size();
        min = nums[n - 4] - nums[0] < min ? nums[n - 4] - nums[0] : min;
        min = nums[n - 3] - nums[1] < min ? nums[n - 3] - nums[1] : min;
        min = nums[n - 2] - nums[2] < min ? nums[n - 2] - nums[2] : min;
        min = nums[n - 1] - nums[3] < min ? nums[n - 1] - nums[3] : min;
        return min;
    }
    ListNode* mergeNodes(ListNode* head) {
        ListNode* tmp = new ListNode();
        ListNode* root = tmp;
        int sum = 0;
        while (head != nullptr) {
            if (head->val == 0 && sum != 0) {
                tmp->val = sum;
                sum = 0;
            }
            if (head->val != 0) {
                if (tmp->val != 0) {
                    tmp->next = new ListNode();
                    tmp = tmp->next;
                }
                sum += head->val;
            }
            head = head->next;
        }
        return root;
    }
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        FIO;
        vector<int> points;
        vector<int> critical_points;
        while (head != nullptr) {
            points.push_back(head->val);
            head = head->next;
        }
        if (points.size() <= 2) {
            return {-1, -1};
        }
        for (int i = 1; i < points.size() - 1; i++) {
            if ((points[i] > points[i + 1] && points[i] > points[i - 1]) || (points[i] < points[i + 1] && points[i] < points[i - 1])) {
                critical_points.push_back(i + 1);
            }
        }
        if (critical_points.size() <= 1) {
            return {-1, -1};
        }

        int min = INT32_MAX;
        for (int i = 1; i < critical_points.size(); i++) {
            min = std::min(min, critical_points[i] - critical_points[i - 1]);
        }
        return {min, (critical_points[critical_points.size() - 1] - critical_points[0])};
    }
    int passThePillow(int n, int time) {
        time = time % (2 * (n - 1));
        return (time < n) ? time + 1 : n - (time - (n - 1));
    }
    int numWaterBottles(int numBottles, int numExchange) {
        int drank = 0, empty = 0, full = numBottles;
        do {
            if (full > 0) {
                drank += full;
                empty += full;
                full = 0;
            }
            if (empty >= numExchange) {
                full = empty / numExchange;
                empty -= full * numExchange;
            }

        } while (empty + full >= numExchange);
        if (full > 0) drank += full;
        return drank;
    }

    int findTheWinner(int n, int k) {
        int i = 1, res = 0;
        while (i <= n) {
            res = (res + k) % i;
            i++;
        }
        return res + 1;
    }

    double averageWaitingTime(vector<vector<int>>&& customers) {
        FIO;
        double waiting = 0;
        long await = 0;
        for (int i = 0; i < customers.size(); i++) {
            await = await > customers[i][0] ? await + customers[i][1] : customers[i][0] + customers[i][1];
            waiting += await - customers[i][0];
        }
        return waiting / customers.size();
    }

    int minOperations(vector<string>&& logs) {
        int depth = 0;
        for (string str : logs) {
            if (str == "../") {
                depth = depth - 1 > 0 ? depth - 1 : 0;
            } else if (str == "./") {
                continue;
            } else {
                depth++;
            }
        }
        return depth;
    }
    string reverseParentheses(string s) {
        auto en = s.begin();
        while (en != s.end()) {
            if (*en == ')') {
                auto beg = en;
                while (beg != s.begin() && *beg != '(') {
                    beg--;
                }
                *beg = ' ';
                *en = ' ';
                reverse(beg, en);
            }
            en++;
        }
        s.erase(remove(s.begin(), s.end(), ' '), s.end());
        return s;
    }

    int maximumGain(string s, int x, int y) {
        FIO;
        string hi, lo;
        int hi_p, lo_p;
        if (y > x) {
            hi = "ba";
            hi_p = y;
            lo = "ab";
            lo_p = x;
        } else {
            hi = "ab";
            hi_p = x;
            lo = "ba";
            lo_p = y;
        }

        FIO;
        vector<char> sta1;
        vector<char> sta2;
        int score = 0;

        for (int i = 0; i < s.size(); i++) {
            if (!sta1.empty() && sta1.back() == hi[0] && s[i] == hi[1]) {
                sta1.pop_back();
                score += hi_p;
            } else {
                sta1.push_back(s[i]);
            }
        }

        for (char ch : sta1) {
            if (!sta2.empty() && sta2.back() == lo[0] && ch == lo[1]) {
                sta2.pop_back();
                score += lo_p;
            } else {
                sta2.push_back(ch);
            }
        }

        return score;
    }

   private:
    struct Robot {
        int position;
        int health;
        char direction;
        int idx;
        Robot(int p, int h, char d, int i) : position(p), health(h), direction(d), idx(i) {};
    };

   public:
    vector<int>
    survivedRobotsHealths(vector<int>&& positions, vector<int>&& healths, string directions) {
        FIO;
        vector<Robot> robots;

        vector<int> result;
        bool contains_diff = false;
        char last_ch = directions[0];
        for (int i = 0; i < positions.size(); i++) {
            if (last_ch != directions[i]) {
                contains_diff = true;
            }
            Robot robot(positions[i], healths[i], directions[i], i);
            robots.push_back(robot);
        }

        if (!contains_diff) {
            return healths;
        }

        sort(whole(robots), [](Robot a, Robot b) { return a.position < b.position; });
        vector<Robot> sta;

        for (int i = 0; i < robots.size(); i++) {
            if (sta.empty()) {
                sta.push_back(robots[i]);
            } else if (sta.back().direction == 'R' && robots[i].direction == 'L') {
                if (sta.back().health > robots[i].health) {
                    sta.back().health--;
                } else if (sta.back().health < robots[i].health) {
                    while (!sta.empty() && sta.back().direction == 'R' && sta.back().health < robots[i].health) {
                        sta.pop_back();
                        robots[i].health--;
                    }
                    if (!sta.empty() && sta.back().direction == 'R') {
                        if (sta.back().health > robots[i].health) {
                            sta.back().health--;
                        } else if (sta.back().health == robots[i].health) {
                            sta.pop_back();
                        } else {
                            sta.push_back(robots[i]);
                        }
                    } else {
                        sta.push_back(robots[i]);
                    }
                } else {
                    sta.pop_back();
                }
            } else {
                sta.push_back(robots[i]);
            }
        }

        sort(whole(sta), [](Robot a, Robot b) { return a.idx < b.idx; });

        for (int i = 0; i < sta.size(); i++) {
            result.push_back(sta[i].health);
        }

        return result;
    }

    string countOfAtoms(string formula) {
        FIO;
        vector<map<string, int>> count;
        count.push_back({});

        for (int i = 0; i < formula.size();) {
            if (formula[i] == '(') {  // 2. if '(' create new map
                count.push_back({});
                i++;
            } else if (formula[i] == ')') {  // 4. if ')' multiply all from top map and add new map to lower map
                string mult;
                //
                while (i + 1 < formula.size() && isdigit(formula[i + 1])) {
                    mult += formula[++i];
                }
                int times = stoi(mult = mult == "" ? "1" : mult);
                map<string, int> temp = count.back();
                count.pop_back();
                for (auto data : temp) {
                    count.back()[data.first] += data.second * times;
                }
                i++;
            } else {  // 1. add all until '('
                string name;
                string amount;
                if (isupper(formula[i])) {
                    name += formula[i++];
                    if (i < formula.size() && islower(formula[i])) {
                        name += formula[i++];
                    }
                }
                while (i < formula.size() && isdigit(formula[i])) {
                    amount += formula[i++];
                }
                if (name != "") {
                    count.back()[name] += stoi(amount = amount == "" ? "1" : amount);  // 3. add all to new map
                }
            }
        }
        string result;
        for (auto data : count.back()) {
            result += data.first;
            if (data.second > 1) {
                result += to_string(data.second);
            }
        }

        return result;
    }
    // descriptions : parent | value | isLeft
    TreeNode* createBinaryTree(vector<vector<int>>&& descriptions) {
        FIO;
        map<int, pair<int, int>> nodes;
        map<int, int> parents;

        for (int i = 0; i < descriptions.size(); i++) {
            parents[descriptions[i][1]]++;

            if (descriptions[i][2] == 1) {  // if it is left
                nodes[descriptions[i][0]].first = descriptions[i][1];
            } else {
                nodes[descriptions[i][0]].second = descriptions[i][1];
            }
        }
        int root;
        for (int i = 0; i < descriptions.size(); i++) {
            if (parents[descriptions[i][0]] == 0) {
                root = descriptions[i][0];
                break;
            }
        }

        vector<int> traverse;
        traverse.push_back(root);

        TreeNode* root_node = new TreeNode(root);
        vector<TreeNode*> builder;
        builder.push_back(root_node);

        while (!traverse.empty()) {
            int val = traverse.front();
            TreeNode* tmp = builder.front();

            builder.erase(builder.begin());
            traverse.erase(traverse.begin());
            if (nodes[val].first != 0) {
                tmp->left = new TreeNode(nodes[val].first);
                traverse.push_back(nodes[val].first);
                builder.push_back(tmp->left);
            } else {
                tmp->left = nullptr;
            }
            if (nodes[val].second != 0) {
                tmp->right = new TreeNode(nodes[val].second);
                traverse.push_back(nodes[val].second);
                builder.push_back(tmp->right);
            } else {
                tmp->right = nullptr;
            }
        }

        return root_node;
    }
    int scoreOfString(string s) {
        int score = 0;
        for (int i = 0; i < s.size() - 1; i++) {
            score += abs((int)s[i] - (int)s[i + 1]);
        }
        return score;
    }
    bool findNode(TreeNode* root, int value, string& path) {
        if (root->val == value) {
            return true;
        }

        if (root->left && findNode(root->left, value, path)) {
            path.push_back('L');
        } else if (root->right && findNode(root->right, value, path)) {
            path.push_back('R');
        }
        return !path.empty();
    }

    string getDirections(TreeNode* root, int startValue, int destValue) {
        string begin, end;
        findNode(root, startValue, begin);
        findNode(root, destValue, end);

        while (!begin.empty() && !end.empty() && begin.back() == end.back()) {
            begin.pop_back();
            end.pop_back();
        }

        return string(begin.size(), 'U') + string(rwhole(end));
    }

    TreeNode* deleteNodes(TreeNode* root, unordered_map<int, bool>& to_delete, vector<TreeNode*>& remainder) {
        if (root == nullptr) {
            return root;
        }

        if (!deleteNodes(root->left, to_delete, remainder)) {
            root->left = nullptr;
        }
        if (!deleteNodes(root->right, to_delete, remainder)) {
            root->right = nullptr;
        }

        if (to_delete[root->val]) {
            if (root->left) remainder.push_back(root->left);
            if (root->right) remainder.push_back(root->right);
            root = nullptr;
        }
        return root;
    }

    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        vector<TreeNode*> remaining;
        unordered_map<int, bool> values;
        for (int val : to_delete) {
            values[val] = true;
        }

        TreeNode* res = deleteNodes(root, values, remaining);
        if (res) {
            remaining.push_back(res);
        }
        return remaining;
    }

    int no_pairs = 0;

    vector<int> doFindPairs(TreeNode* root, int distance) {
        if (!root) {
            return {0};
        }
        if (!root->left && !root->right) {
            return {1};
        }

        vector<int> left = doFindPairs(root->left, distance);
        vector<int> right = doFindPairs(root->right, distance);

        for (int L : left) {
            for (int R : right) {
                if (L + R <= distance && L > 0 && R > 0) {
                    no_pairs++;
                }
            }
        }

        vector<int> res;
        for (int L : left) {
            if (L > 0 && L < distance) {
                res.push_back(L + 1);
            }
        }
        for (int L : right) {
            if (L > 0 && L < distance) {
                res.push_back(L + 1);
            }
        }

        return res;
    }

    int countPairs(TreeNode* root, int distance) {
        doFindPairs(root, distance);
        return no_pairs;
    }

    vector<vector<int>> merge(vector<vector<int>>&& intervals) {
        sort(intervals.begin(), intervals.end(), [&](vector<int>& a, vector<int>& b) { return a[0] < b[0]; });
        vector<vector<int>> res;
        int start = intervals[0][0], new_end = intervals[0][1];
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] > new_end) {  // we move end -> merge
                res.push_back({start, new_end});
                start = intervals[i][0];
            }
            if (new_end < intervals[i][1]) {
                new_end = intervals[i][1];
            }
        }
        res.push_back({start, new_end});
        return res;
    }

    vector<int> luckyNumbers(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int col = matrix[0].size();

        vector<int> mins(rows);
        vector<int> maxs(col);
        vector<int> res;

        for (unsigned i = 0; i < rows; i++) {
            mins[i] = INT_MAX;
            for (unsigned j = 0; j < col; j++) {
                mins[i] = min(mins[i], matrix[i][j]);
            }
        }

        for (unsigned i = 0; i < col; i++) {
            maxs[i] = 0;
            for (unsigned j = 0; j < rows; j++) {
                maxs[i] = max(maxs[i], matrix[j][i]);
            }
        }

        for (unsigned i = 0; i < col; i++) {
            for (unsigned j = 0; j < rows; j++) {
                if (maxs[i] == mins[j]) {
                    res.push_back(maxs[i]);
                }
            }
        }

        return res;
    }

    struct MatrixPoint {
        int value;
        int sum;
        int row;
        int column;

        void clean() {
            value = INT_MAX;
            sum = INT_MAX;
            row = 0;
            column = 0;
        }
    };

    vector<vector<int>> restoreMatrix(vector<int>&& rowSum, vector<int>&& colSum) {
        unsigned int rows = rowSum.size();
        unsigned int cols = colSum.size();
        vector<vector<int>> res(rows);
        for (unsigned int i = 0; i < rows; i++) {
            vector<int> tmp(cols);
            res[i] = tmp;
        }
        MatrixPoint mp;
        do {
            mp.clean();
            for (unsigned int row = 0; row < rows; row++) {
                if (rowSum[row] == 0) {
                    continue;
                }
                for (unsigned int col = 0; col < cols; col++) {
                    if (colSum[col] == 0) {
                        continue;
                    }
                    int sum = colSum[col] + rowSum[row];
                    if (mp.sum > sum) {
                        mp.sum = sum;
                        mp.row = row;
                        mp.column = col;

                        if (colSum[col] != 0 && rowSum[row] != 0) {
                            mp.value = colSum[col] < rowSum[row] ? colSum[col] : rowSum[row];
                        } else if (colSum[col] != 0) {
                            mp.value = colSum[col];
                        } else if (rowSum[row] != 0) {
                            mp.value = rowSum[row];
                        }
                    }
                }
            }
            if (mp.value != INT_MAX) {
                res[mp.row][mp.column] = mp.value;
                rowSum[mp.row] -= mp.value;
                colSum[mp.column] -= mp.value;
            }
        } while (mp.value != INT_MAX);

        return res;
    }

    bool dfs(int src, unordered_map<int, vector<int>>& graph, unordered_set<int>& visited, unordered_set<int>& current_path, vector<int>& res) {
        if (current_path.count(src)) {
            return false;
        }
        if (visited.count(src)) {
            return true;
        }

        visited.insert(src);
        current_path.insert(src);

        for (int neighbour : graph[src]) {
            if (!dfs(neighbour, graph, visited, current_path, res)) {
                return false;
            }
        }
        current_path.erase(src);
        res.push_back(src);
        return true;
    }

    vector<int> topologicalSort(unordered_map<int, vector<int>>& graph, int k) {
        unordered_set<int> visited;
        unordered_set<int> current_path;
        vector<int> res;
        for (int src = 1; src <= k; ++src) {
            if (!dfs(src, graph, visited, current_path, res)) {
                return {};
            }
        }
        reverse(res.begin(), res.end());

        return res;
    }

    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        unordered_map<int, vector<int>> graph;

        for (const auto& edge : rowConditions) {
            graph[edge[0]].push_back(edge[1]);
        }

        vector<int> row_sort = topologicalSort(graph, k);

        graph.clear();
        for (const auto& edge : colConditions) {
            graph[edge[0]].push_back(edge[1]);
        }
        vector<int> col_sort = topologicalSort(graph, k);

        if (row_sort.empty() || col_sort.empty()) {
            return {};
        }

        unordered_map<int, pair<int, int>> value_positions;

        for (int i = 0; i < k; i++) {
            value_positions[row_sort[i]].first = i;
            value_positions[col_sort[i]].second = i;
        }

        vector<vector<int>> res(k, vector<int>(k, 0));

        for (int value = 1; value <= k; ++value) {
            int row = value_positions[value].first;
            int column = value_positions[value].second;
            res[row][column] = value;
        }
        return res;
    }

    int myAtoi(string s) {
        bool isNegative = false;
        bool seenSighn = false;
        string sanitized = "";

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ') {
                if (!sanitized.empty() || seenSighn) {
                    break;
                }
                continue;
            } else if (s[i] == '+') {
                if (!sanitized.empty() || seenSighn) {
                    break;
                }
                seenSighn = true;
            } else if (s[i] == '-' && isNegative) {
                if (seenSighn) {
                    break;
                }
                seenSighn = true;
                break;
            } else if (s[i] == '-' && !isNegative && sanitized.empty()) {
                if (seenSighn) {
                    break;
                }
                seenSighn = true;
                isNegative = true;
            } else if (isdigit(s[i])) {
                sanitized += s[i];
            } else {
                break;
            }
        }

        int point = 0;
        while (point < sanitized.size() && sanitized[point] == '0') {
            point++;
        }
        if (point != 0) sanitized.erase(sanitized.begin(), sanitized.begin() + point);

        long long int result = 0;
        for (int i = sanitized.size() - 1, j = 0; i >= 0; i--, j++) {
            if (i == sanitized.size() - 1) {
                result += (int)(sanitized[i] - '0');
            } else {
                auto val = (int)(sanitized[i] - '0') * pow(10, j);
                if (val + result > INT_MAX) {
                    if (isNegative) {
                        result = INT32_MAX;
                        result++;
                    } else {
                        result = INT32_MAX;
                    }
                    break;
                }
                result += val;
            }
        }
        return isNegative ? (int)(0 - result) : (int)result;
    }

    void swapNames(vector<string>& names, vector<int>& heights, int Left, int Right) {
        string name = names[Right];
        int height = heights[Right];
        names[Right] = names[Left];
        heights[Right] = heights[Left];
        names[Left] = name;
        heights[Left] = height;
    }

    int partitionNames(vector<string>& names, vector<int>& heights, int start, int end) {
        int mid = heights[start], s = start, e = end;
        while (s < e) {
            while (heights[s] >= mid && s <= end - 1) {
                s++;
            }
            while (heights[e] < mid && e >= start + 1) {
                e--;
            }
            if (s < e) {
                swapNames(names, heights, s, e);
            }
        }
        swapNames(names, heights, start, e);
        return e;
    }

    void sortNames(vector<string>& names, vector<int>& heights, int start, int end) {
        if (start < end) {
            int partition = partitionNames(names, heights, start, end);
            sortNames(names, heights, start, partition - 1);
            sortNames(names, heights, partition + 1, end);
        }
    }

    vector<string> sortPeople(vector<string>&& names, vector<int>&& heights) {
        sortNames(names, heights, 0, names.size() - 1);
        return names;
    }

    int commonFactors(int a, int b) {
        short common_factors = 0;
        for (unsigned int i = 1; i <= min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                common_factors++;
            }
        }
        return common_factors;
    }
    int sumCounts(vector<int>&& nums) {
        int sum = 0;
        unordered_set<int> arr;
        for (unsigned int i = 0; i < nums.size(); i++) {
            arr.clear();
            for (unsigned int j = i; j < nums.size(); j++) {
                arr.insert(nums[j]);
                sum += pow(arr.size(), 2);
            }
        }
        return sum;
    }

    vector<int> treeToArrange;
    void getTreeNodes(TreeNode* root) {
        if (root->left) {
            getTreeNodes(root->left);
        }
        treeToArrange.push_back(root->val);
        if (root->right) {
            getTreeNodes(root->right);
        }
    }

    TreeNode* increasingBST(TreeNode* root) {
        getTreeNodes(root);
        TreeNode* tree = new TreeNode(treeToArrange[0]);
        TreeNode* tmp = tree;
        for (unsigned int i = 1; i < treeToArrange.size(); i++) {
            tmp->right = new TreeNode(treeToArrange[i]);
            tmp = tmp->right;
        }
        return tree;
    }
    vector<int> frequencySort(vector<int>&& nums) {
        map<int, int> count;
        for (int val : nums) {
            count[val]++;
        }

        vector<pair<int, int>> ordered(count.begin(), count.end());

        sort(ordered.begin(), ordered.end(), [&](pair<int, int>& a, pair<int, int>& b) {
            if (a.second == b.second) {
                return a.first > b.first;
            } else {
                return a.second < b.second;
            }
        });

        auto iter = ordered.begin();
        for (unsigned int i = 0; i < nums.size(); i++) {
            if (iter->second == 0) {
                iter++;
            }
            nums[i] = iter->first;
            iter->second--;
        }
        return nums;
    }

    vector<int> sortJumbled(vector<int>&& mapping, vector<int>&& nums) {
        vector<pair<int, int>> order;
        for (unsigned int i = 0; i < nums.size(); i++) {
            int num = 0;
            string data = to_string(nums[i]);
            for (int j = data.size() - 1, f = 0; j >= 0; j--, f++) {
                num += mapping[data[j] - '0'] * pow(10, f);
            }
            order.push_back(make_pair(num, nums[i]));
        }

        sort(order.begin(), order.end(), [&](pair<int, int>& a, pair<int, int> b) {
            return a.first < b.first;
        });

        for (unsigned int i = 0; i < order.size(); i++) {
            nums[i] = order[i].second;
        }
        return nums;
    }
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        map<int, int> count;
        for (int val : target) {
            count[val]++;
        }
        for (int val : arr) {
            count[val]--;
        }

        for (pair<int, int> c : count) {
            if (c.second > 0) {
                return false;
            }
        }

        return true;
    }

    int rangeSum(vector<int>&& nums, int n, int left, int right) {
        vector<long> subArr;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subArr.push_back(sum);
            }
        }
        sum = 0;

        sort(whole(subArr));

        for (int i = left - 1; i < right; i++) {
            sum += subArr[i];
        }
        return sum % 1000000007;
    }

    string kthDistinct(vector<string>&& arr, int k) {
        unordered_map<string, int> data;
        for (string str : arr) {
            data[str]++;
        }
        k--;
        for (string str : arr) {
            if (k == 0 && data[str] == 1) {
                return str;
            } else if (k != 0 && data[str] == 1) {
                k--;
            }
        }
        return "";
    }

    int minimumPushes(string word) {
        unordered_map<char, int> count;
        for (char ch : word) {
            count[ch]++;
        }
        vector<pair<char, int>> ordered(whole(count));
        sort(whole(ordered), [](pair<char, int> a, pair<char, int> b) {
            return a.second > b.second;
        });
        int keys_used = 0, mult = 1, clicks = 0;
        for (pair<char, int> data : ordered) {
            clicks += data.second * mult;
            if (++keys_used % 8 == 0) {
                keys_used = 0;
                mult++;
            }
        }
        return clicks;
    }

    map<int, string> mapping = {
        make_pair<int, string>(0, "Zero"),
        make_pair<int, string>(1, "One"),
        make_pair<int, string>(2, "Two"),
        make_pair<int, string>(3, "Three"),
        make_pair<int, string>(4, "Four"),
        make_pair<int, string>(5, "Five"),
        make_pair<int, string>(6, "Six"),
        make_pair<int, string>(7, "Seven"),
        make_pair<int, string>(8, "Eight"),
        make_pair<int, string>(9, "Nine"),
        make_pair<int, string>(10, "Ten"),
        make_pair<int, string>(11, "Eleven"),
        make_pair<int, string>(12, "Twelve"),
        make_pair<int, string>(13, "Thirteen"),
        make_pair<int, string>(14, "Fourteen"),
        make_pair<int, string>(15, "Fifteen"),
        make_pair<int, string>(16, "Sixteen"),
        make_pair<int, string>(17, "Seventeen"),
        make_pair<int, string>(18, "Eighteen"),
        make_pair<int, string>(19, "Nineteen"),
        make_pair<int, string>(20, "Twenty"),
        make_pair<int, string>(30, "Thirty"),
        make_pair<int, string>(40, "Forty"),
        make_pair<int, string>(50, "Fifty"),
        make_pair<int, string>(60, "Sixty"),
        make_pair<int, string>(70, "Seventy"),
        make_pair<int, string>(80, "Eighty"),
        make_pair<int, string>(90, "Ninety"),
        make_pair<int, string>(100, "Hundred"),
        make_pair<int, string>(1000, "Thousand"),
        make_pair<int, string>(1000000, "Million"),
        make_pair<int, string>(1000000000, "Billion")};

    string* getPairOfThree(vector<int>& a, string* res) {
        if (a.size() == 3) {
            if (a[0] > 0 && a.size() == 3) {
                *res += mapping[a[0]];
                *res += "Hundred";
            }
            if (a[1] > 0 && a[1] < 2) {
                *res += mapping[a[1] * 10 + a[2]];
            } else if (a[1] > 0 && a[1] >= 2) {
                *res += mapping[a[1] * 10];
                if (a[2] > 0) {
                    *res += mapping[a[2]];
                }
            } else if (a[1] == 0 && a[2] != 0) {
                *res += mapping[a[2]];
            }
        } else if (a.size() == 2) {
            if (a[0] > 0 && a[0] < 2) {
                *res += mapping[a[0] * 10 + a[1]];
            } else if (a[0] > 0 && a[0] >= 2) {
                *res += mapping[a[0] * 10];
                if (a[1] > 0) {
                    *res += mapping[a[1]];
                }
            }
        } else {
            *res += mapping[a[0]];
        }
        return res;
    }

    string numberToWords(int num) {
        // 1. Split num into pairs of three or les numbers
        // 2. helper function that will transform combination of three digits to words
        // 3. append quantity multiplier after transformation
        vector<vector<int>> chunks;
        string data = to_string(num);
        for (int i = data.size() - 1, j = 0; i >= 0; i--, j++) {
            if (j % 3 == 0) {
                chunks.insert(chunks.begin(), vector<int>());
            }
            chunks.front().emplace(chunks.front().begin(), (int)data[i] - '0');
        }
        string res = "";
        for (int i = 0, j = chunks.size(); i < chunks.size(); i++, j--) {
            getPairOfThree(chunks[i], &res);
            if (j == 4) {
                res += "Billion";
            } else if (j == 3 && res.substr(res.size() - 3) != "ion") {
                res += "Million";
            } else if (j == 2 && res.substr(res.size() - 3) != "ion") {
                res += "Thousand";
            }
        }
        for (int i = 1; i < res.size(); i++) {
            if (res[i] >= 'A' && res[i] <= 'Z') {
                res.insert(res.begin() + i, ' ');
                i += 2;
            }
        }
        return res;
    }
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        vector<vector<int>> result;
        pair<int, int> q = make_pair(rStart, cStart), position;
        int moves = 1, _moves = moves, iterations = 1, direction = 0, amount = rows * cols;
        while (result.size() != amount) {
            position = q;
            switch (direction) {
                case 0: {
                    while (_moves != 0) {
                        if (position.first >= 0 && position.second >= 0 && position.first < rows && position.second < cols) {
                            result.push_back({position.first, position.second});
                        }
                        position.second += 1;
                        _moves--;
                    }
                    _moves = 0;
                    q = position;
                    break;
                }  // -> right
                case 1: {
                    while (_moves != 0) {
                        if (position.first >= 0 && position.second >= 0 && position.first < rows && position.second < cols) {
                            result.push_back({position.first, position.second});
                        }
                        position.first += 1;
                        _moves--;
                    }
                    _moves = 0;
                    q = position;
                    break;
                }  // -> down
                case 2: {
                    while (_moves != 0) {
                        if (position.first >= 0 && position.second >= 0 && position.first < rows && position.second < cols) {
                            result.push_back({position.first, position.second});
                        }
                        position.second -= 1;
                        _moves--;
                    }
                    _moves = 0;
                    q = position;
                    break;
                }  // -> left
                case 3: {
                    while (_moves != 0) {
                        if (position.first >= 0 && position.second >= 0 && position.first < rows && position.second < cols) {
                            result.push_back({position.first, position.second});
                        }
                        position.first -= 1;
                        _moves--;
                    }
                    _moves = 0;
                    q = position;
                    break;
                }  // -> up
            }
            if (_moves == 0 && iterations != 0) {
                iterations--;
                _moves = moves;
            } else if (_moves == 0 && iterations == 0) {
                iterations = 1;
                moves++;
                _moves = moves;
            }
            direction = direction == 3 ? 0 : direction + 1;
        }
        return result;
    }

    bool isGridMagical(vector<vector<int>>& grid, int R, int C) {
        // 1 -> check for unique
        int first = 0;
        int second = 0;
        int third = 0;

        // 2 -> check rows
        first = grid[R][C] + grid[R][C + 1] + grid[R][C + 2];
        second = grid[R + 1][C] + grid[R + 1][C + 1] + grid[R + 1][C + 2];
        third = grid[R + 2][C] + grid[R + 2][C + 1] + grid[R + 2][C + 2];
        if (first != second || second != third || first != third) {
            return false;
        }
        // 3 -> check columns
        first = grid[R][C] + grid[R + 1][C] + grid[R + 2][C];
        second = grid[R][C + 1] + grid[R + 1][C + 1] + grid[R + 2][C + 1];
        third = grid[R][C + 2] + grid[R + 1][C + 2] + grid[R + 2][C + 2];
        if (first != second || second != third || first != third) {
            return false;
        }
        // 4 -> check diagonals
        first = grid[R][C] + grid[R + 1][C + 1] + grid[R + 2][C + 2];
        second = grid[R + 2][C] + grid[R + 1][C + 1] + grid[R][C + 2];
        if (first != second) {
            return false;
        }
        set<int> s{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = R; i < R + 3; i++) {
            for (int j = C; j < C + 3; j++) {
                s.erase(grid[i][j]);
            }
        }
        return s.empty();
    }

    int numMagicSquaresInside(vector<vector<int>>&& grid) {
        if (grid.size() < 3 && grid[0].size() > 3) {
            return 0;
        }
        int valid = 0, rows = grid.size() - 3, cols = grid[0].size() - 3;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (isGridMagical(grid, i, j)) {
                    valid++;
                }
            }
        }
        return valid;
    }

    vector<vector<int>> result;
    vector<int> candidate;
    void do_backtrack_of_CombinationsSum(vector<int>& candidates, int target, int start_idx) {
        if (target == 0) {
            result.push_back(candidate);
            return;
        }
        for (int i = start_idx; i < candidates.size(); i++) {
            if (i > start_idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            candidate.push_back(candidates[i]);
            do_backtrack_of_CombinationsSum(candidates, target - candidates[i], i + 1);
            candidate.pop_back();
        }
    }
    vector<vector<int>> combinationSum2(vector<int>&& candidates, int target) {
        sort(whole(candidates));
        do_backtrack_of_CombinationsSum(candidates, target, 0);

        return result;
    }

    int smallestDistancePair(vector<int>&& nums, int k) {
        sort(whole(nums));
        int l = 0, r = nums[nums.size() - 1] - nums[0], mid = 0, count, i = 0, j = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            count = 0;

            for (i = 0; i < nums.size(); i++) {
                for (j = i + 1; j < nums.size(); j++) {
                    if (nums[j] - nums[i] <= mid) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    int maxDistance(vector<vector<int>>&& arrays) {
        int distance = 0, min = arrays[0][0], max = arrays[0].back();

        for (int i = 1; i < arrays.size(); i++) {
            distance = std::max(distance, abs(max - arrays[i][0]));
            distance = std::max(distance, abs(arrays[i].back() - min));
            min = min > arrays[i][0] ? arrays[i][0] : min;
            max = max < arrays[i].back() ? arrays[i].back() : max;
        }

        return distance;
    }
    long long maxPoints(vector<vector<int>>&& points) {
        int cols = points[0].size();
        vector<long long> currentRow(cols), previousRow(cols);

        for (auto& row : points) {
            // runningMax holds the maximum value generated in the previous
            // iteration of each loop
            long long runningMax = 0;

            // Left to right pass
            for (int col = 0; col < cols; ++col) {
                runningMax = max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            // Right to left pass
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = max(runningMax - 1, previousRow[col]);
                currentRow[col] = max(currentRow[col], runningMax) + row[col];
            }

            // Update previousRow for next iteration
            previousRow = currentRow;
        }

        // Find maximum points in the last row
        long long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }

    int maxScoreSightseeingPair(vector<int>&& values) {
        int score = -1, n = values.size(), dp = values[0];
        for (int i = 1; i < n; i++) {
            score = max(score, dp + values[i] - i);  // values[i] + values[j] + (i - j)
            dp = max(dp, values[i] + i);
        }

        return score;
    }
    int nthUglyNumber(int n) {
        vector<int> ugly(n);
        ugly[0] = 1;
        int N2 = 2, N3 = 3, N5 = 5;
        int I2 = 0, I3 = 0, I5 = 0;
        for (int i = 1; i < n; i++) {
            int next = min(N2, min(N3, N5));
            ugly[i] = next;
            if (next == N2) {
                I2++;
                N2 = ugly[I2] * 2;
            }
            if (next == N3) {
                I3++;
                N3 = ugly[I3] * 3;
            }
            if (next == N5) {
                I5++;
                N5 = ugly[I5] * 5;
            }
        }

        return ugly[n - 1];
    }
};

#endif