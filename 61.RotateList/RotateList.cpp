/**
 * 61. Rotate List
 * 虽然👎有点多【加快慢指针在这题感觉有点多余(总移动指针次数一样)，链表也没说有没有头节点】，但是也算复习一下指针和链表吧
 */
#include <iostream>
#include <vector>
using namespace std;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution
{
public:
    ListNode *rotateRight(ListNode *head, int k)
    {
        if (!head || !head->next || k == 0)
            return head;
        ListNode *tail, *newHead;
        tail = head;
        int len = 1;
        while (tail->next)
        {
            tail = tail->next;
            len++;
        }
        tail->next = head; // 注意这个指针的位置可以反复利用
        k %= len;
        for (int i = 0; i < len - k; i++)
            tail = tail->next;
        newHead = tail->next;
        tail->next = NULL;
        return newHead; // 最好不要修改实参指针head，返回个新的
    }
};

int main()
{
    Solution s;
    vector<vector<int>> lists = {{1, 2, 3, 4, 5}, {0, 1, 2}, {1}, {}};
    int ks[] = {2, 4, 3, 1};
    ListNode *head, *p;
    for (int i = 0; i < lists.size(); i++)
    {
        p = new ListNode(-1); // 初始是指向0x0的，先分配个头节点地址
        head = p;
        for (auto &&j : lists[i])
        {
            p->next = new ListNode(j);
            p = p->next;
        }
        ListNode *r = s.rotateRight(head->next, ks[i]); // 题目的List是没有头节点的
        while (r != NULL)
        {
            cout << r->val << " ";
            r = r->next;
        }
        cout << endl;
        delete head;
    }

    return 0;
}