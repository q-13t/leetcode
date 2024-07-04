#ifndef LISTNODE
#define LISTNODE
#include <iostream>
#include <vector>

using namespace std;
struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
    static ListNode* createFromVector(vector<int>&& vec) {
        ListNode* head = new ListNode(vec[0]);
        if (vec.size() < 1) {
            return head;
        }
        ListNode* curr = new ListNode();
        head->next = curr;
        for (int i = 1; i < vec.size(); i++) {
            curr->val = vec[i];
            if (i + 1 < vec.size()) {
                curr->next = new ListNode;
                curr = curr->next;
            }
        }
        return head;
    }

    static void printList(ListNode* head) {
        while (head != nullptr) {
            cout << head->val << " ";
            head = head->next;
        }
        cout << endl;
    }
};
#endif