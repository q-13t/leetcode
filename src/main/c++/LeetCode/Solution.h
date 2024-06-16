#ifndef SOLUTION
#define SOLUTION

#include <algorithm>
#include <bitset>
#include <cmath>
#include <iostream>
#include <limits>
#include <map>
#include <queue>
#include <regex>
#include <set>
#include <unordered_map>
#include <vector>
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

#define FIO                       \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);

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
};

#endif