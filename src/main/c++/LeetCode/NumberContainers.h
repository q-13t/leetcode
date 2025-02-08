
#include "map"
#include "queue"
#include "vector"
using namespace std;

class NumberContainers {
    unordered_map<int, priority_queue<int, vector<int>, greater<int>>> indexes;
    unordered_map<int, int> values;

   public:
    NumberContainers() {
    }

    void change(int index, int number) {
        values[index] = number;
        indexes[number].push(index);
    }

    int find(int number) {
        auto finder = indexes.find(number);
        if (finder == end(indexes)) {
            return -1;
        } else {
            auto& ref = finder->second;
            while (!ref.empty() && values[ref.top()] != number) {
                ref.pop();
            }
            return ref.empty() ? -1 : ref.top();
        }
    }
};