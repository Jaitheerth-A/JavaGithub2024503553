// dblink.cpp
#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int v) {
        data = v;
        next = nullptr;
        prev = nullptr;
    }
};

class DblList {
    Node* head;
    Node* tail;

public:
    DblList() {
        head = tail = nullptr;
    }

    // Insert at end (default), beginning (-1), or position (0)
    void insert(int v, int mode = 1) {
        Node* r = new Node(v);

        if (head == nullptr) { // Empty list
            head = tail = r;
            cout << "Inserted " << v << " as first node.\n";
            return;
        }

        if (mode == 1) { // End
            tail->next = r;
            r->prev = tail;
            tail = r;
            cout << "Inserted " << v << " at END.\n";
        } 
        else if (mode == -1) { // Beginning
            r->next = head;
            head->prev = r;
            head = r;
            cout << "Inserted " << v << " at BEGINNING.\n";
        } 
        else if (mode == 0) { // Position
            int pos;
            cout << "Enter position to insert " << v << ": ";
            cin >> pos;

            Node* temp = head;
            for (int i = 0; i < pos - 1 && temp->next != nullptr; i++) {
                temp = temp->next;
            }

            if (temp == tail) { // Insert at end
                tail->next = r;
                r->prev = tail;
                tail = r;
            } else {
                r->next = temp->next;
                r->prev = temp;
                temp->next->prev = r;
                temp->next = r;
            }
            cout << "Inserted " << v << " at position " << pos << ".\n";
        }
        else {
            cout << "Invalid mode!\n";
        }
    }

    // Delete node (1=end, -1=beginning, 0=position, 2=value)
    void remove(int mode = 1) {
        if (head == nullptr) {
            cout << "List is empty!\n";
            return;
        }

        if (mode == 1) { // End
            Node* temp = tail;
            if (head == tail) head = tail = nullptr;
            else {
                tail = tail->prev;
                tail->next = nullptr;
            }
            cout << "Deleted from END: " << temp->data << endl;
            delete temp;
        } 
        else if (mode == -1) { // Beginning
            Node* temp = head;
            if (head == tail) head = tail = nullptr;
            else {
                head = head->next;
                head->prev = nullptr;
            }
            cout << "Deleted from BEGINNING: " << temp->data << endl;
            delete temp;
        } 
        else if (mode == 0) { // Position
            int pos;
            cout << "Enter position to delete: ";
            cin >> pos;

            Node* temp = head;
            for (int i = 0; i < pos && temp != nullptr; i++) {
                temp = temp->next;
            }
            if (temp == nullptr) {
                cout << "Invalid position!\n";
                return;
            }

            if (temp == head) head = head->next;
            if (temp == tail) tail = tail->prev;
            if (temp->prev) temp->prev->next = temp->next;
            if (temp->next) temp->next->prev = temp->prev;

            cout << "Deleted from POSITION " << pos << ": " << temp->data << endl;
            delete temp;
        } 
        else if (mode == 2) { // By value
            int val;
            cout << "Enter value to delete: ";
            cin >> val;

            Node* temp = head;
            while (temp && temp->data != val) {
                temp = temp->next;
            }
            if (!temp) {
                cout << "Value not found!\n";
                return;
            }

            if (temp == head) head = head->next;
            if (temp == tail) tail = tail->prev;
            if (temp->prev) temp->prev->next = temp->next;
            if (temp->next) temp->next->prev = temp->prev;

            cout << "Deleted value: " << temp->data << endl;
            delete temp;
        }
        else {
            cout << "Invalid delete mode!\n";
        }
    }

    // Display list
    void display(int mode = 1) {
        if (head == nullptr) {
            cout << "List is empty!\n";
            return;
        }

        if (mode == 1) { // Forward
            cout << "List (Forward): ";
            Node* temp = head;
            while (temp) {
                cout << temp->data << " ";
                temp = temp->next;
            }
            cout << endl;
        } else if (mode == -1) { // Reverse
            cout << "List (Reverse): ";
            Node* temp = tail;
            while (temp) {
                cout << temp->data << " ";
                temp = temp->prev;
            }
            cout << endl;
        }
    }
};

// Menu-driven program
int main() {
    DblList dl;
    int choice, val, mode;

    do {
        cout << "\n--- MENU ---\n";
        cout << "1. Insert\n2. Delete\n3. Display\n4. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter value: ";
            cin >> val;
            cout << "Enter mode (1=end, -1=beginning, 0=position): ";
            cin >> mode;
            dl.insert(val, mode);
            break;

        case 2:
            cout << "Enter mode (1=end, -1=beginning, 0=position, 2=value): ";
            cin >> mode;
            dl.remove(mode);
            break;

        case 3:
            cout << "Enter display mode (1=forward, -1=reverse): ";
            cin >> mode;
            dl.display(mode);
            break;

        case 4:
            cout << "Exiting...\n";
            break;

        default:
            cout << "Invalid choice!\n";
        }
    } while (choice != 4);

    return 0;
}