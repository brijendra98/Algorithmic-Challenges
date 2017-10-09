/*
Detect a cycle in a linked list. Note that the head pointer may be 'NULL' if the list is empty.

A Node is defined as:
    struct Node {
        int data;
        struct Node* next;
    }
*/

bool has_cycle(Node* head) {
    // Complete this function
    // Do not write the main method
    Node *one=head;
    Node *two=head;

    while(one && two && two->next) {
        one = one->next;
        two = two->next->next;
        if(one == two) {
            return 1;
        }
    }
    return 0;
}
