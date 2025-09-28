#include <iostream>
#include <climits> // for INT_MIN
using namespace std;

// Node class for BST
class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};

// Priority Queue implemented using BST
class PriorityQueue {
private:
    Node* root;

    // Insert node into BST
    Node* insert(Node* node, int val) {
        if (node == nullptr) return new Node(val);
        if (val < node->data)
            node->left = insert(node->left, val);
        else
            node->right = insert(node->right, val); // duplicates go right
        return node;
    }

    // Find minimum node (leftmost)
    Node* findMin(Node* node) {
        if (!node) return nullptr;
        while (node->left != nullptr)
            node = node->left;
        return node;
    }

    // Delete a node with a given value
    Node* deleteNode(Node* node, int val) {
        if (node == nullptr) return nullptr;

        if (val < node->data)
            node->left = deleteNode(node->left, val);
        else if (val > node->data)
            node->right = deleteNode(node->right, val);
        else {
            // Node found
            if (node->left == nullptr) {
                Node* temp = node->right;
                delete node;
                return temp;
            } else if (node->right == nullptr) {
                Node* temp = node->left;
                delete node;
                return temp;
            }

            // Node with two children: replace with inorder successor
            Node* successor = findMin(node->right);
            node->data = successor->data;
            node->right = deleteNode(node->right, successor->data);
        }
        return node;
    }

    // Inorder traversal
    void inorder(Node* node) {
        if (node == nullptr) return;
        inorder(node->left);
        cout << node->data << " ";
        inorder(node->right);
    }

public:
    PriorityQueue() { root = nullptr; }

    // Insert value (enqueue)
    void insert(int val) {
        root = insert(root, val);
        cout << "Inserted: " << val << endl;
    }

    // Get minimum value (peek)
    int getMin() {
        if (root == nullptr) {
            cout << "Queue is empty!" << endl;
            return INT_MIN;
        }
        Node* minNode = findMin(root);
        return minNode->data;
    }

    // Extract minimum (dequeue)
    void extractMin() {
        if (root == nullptr) {
            cout << "Queue is empty!" << endl;
            return;
        }
        int minVal = getMin();
        root = deleteNode(root, minVal);
        cout << "Extracted min: " << minVal << endl;
    }

    // Check if queue is empty
    bool isEmpty() {
        return root == nullptr;
    }

    // Display priority queue in ascending order
    void display() {
        if (root == nullptr) {
            cout << "Priority Queue is empty." << endl;
            return;
        }
        cout << "Priority Queue (ascending): ";
        inorder(root);
        cout << endl;
    }
    void menu(){
         int choice, value;

    cout << "====== PRIORITY QUEUE USING BST (MIN-HEAP) ======" << endl;

    while (true) {
        cout << "\n------ MENU ------" << endl;
        cout << "1. Insert element" << endl;
        cout << "2. Get minimum element" << endl;
        cout << "3. Extract minimum element" << endl;
        cout << "4. Display queue" << endl;
        cout << "5. Check if queue is empty" << endl;
        cout << "6. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter value to insert: ";
                cin >> value;
                insert(value);
                break;

            case 2:
                if (!isEmpty())
                    cout << "Minimum element: " << getMin() << endl;
                break;

            case 3:
                extractMin();
                break;

            case 4:
                display();
                break;

            case 5:
                if (isEmpty())
                    cout << "Queue is empty." << endl;
                else
                    cout << "Queue is NOT empty." << endl;
                break;

            case 6:
                cout << "Exiting program.Thank you!" << endl;return;
            default:
                cout << "Invalid choice! Try again." << endl;
        }
    }
    }
};

// Main program
int main() {
    PriorityQueue pq;
    pq.menu();
    return 0;
}