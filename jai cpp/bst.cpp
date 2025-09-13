#include<iostream>
using namespace std;

class Node {
public:
    int data;
    Node* left;
    Node* right;
    Node(int val) {
        data = val;
        left = nullptr;
        right = nullptr;
    }
};
class BST {
    Node* root;

    // Helper function to insert a node
    Node* insert(Node* node, int val) {
        if (node == nullptr)
            return new Node(val);

        if (val < node->data)
            node->left = insert(node->left, val);
        else if (val > node->data)
            node->right = insert(node->right, val);

        return node;
    }

    // Helper function for in-order traversal
    void inOrder(Node* node) {
        if (node == nullptr)
            return;

        inOrder(node->left);
        cout << node->data << " ";
        inOrder(node->right);
    }
    void preOrder(Node* node) {
        if (node == nullptr)
            return;

        cout << node->data << " ";
        preOrder(node->left);
        preOrder(node->right);
    }
    void preOrder() {
        preOrder(root);
        cout << endl;
    }
    void postOrder(Node* node) {
        if (node == nullptr)        
            return;     
        postOrder(node->left);
        postOrder(node->right);
        cout << node->data << " ";
    }
    void postOrder() {
        postOrder(root);
        cout << endl;
    }

    // Helper function to search a key
    bool search(Node* node, int key) {
        if (node == nullptr)
            return false;

        if (node->data == key)
            return true;
        else if (key < node->data)
            return search(node->left, key);
        else
            return search(node->right, key);
    }

    // Helper function to find the minimum node in subtree
    Node* findMin(Node* node) {
        while (node && node->left != nullptr)
            node = node->left;
        return node;
    }

    // Helper function to delete a node
    Node* deleteNode(Node* node, int key) {
        if (node == nullptr)
            return node;

        if (key < node->data)
            node->left = deleteNode(node->left, key);
        else if (key > node->data)
            node->right = deleteNode(node->right, key);
        else {
            // Node to delete found

            // Case 1: Node with no child
            if (node->left == nullptr && node->right == nullptr) {
                delete node;
                return nullptr;
            }
            // Case 2: Node with one child
            else if (node->left == nullptr) {
                Node* temp = node->right;
                delete node;
                return temp;
            }
            else if (node->right == nullptr) {
                Node* temp = node->left;
                delete node;
                return temp;
            }
            // Case 3: Node with two children
            else {
                Node* temp = findMin(node->right);
                node->data = temp->data;
                node->right = deleteNode(node->right, temp->data);
            }
        }
        return node;
    }

public:
    BST() { root = nullptr; }

    void insert(int val) {
        root = insert(root, val);
    }

    void inOrder() {
        inOrder(root);
        cout << endl;
    }

    bool search(int key) {
        return search(root, key);
    }

    void deleteNode(int key) {
        root = deleteNode(root, key);
    } 
    void menu() {
        cout << "1. Insert" << endl;
        cout << "2. Inorder Traversal" << endl;
        cout << "3. Preorder Traversal" << endl;
        cout << "4. Postorder Traversal" << endl;
        cout << "5. Search" << endl;
        cout << "6. Delete" << endl;
        cout << "7. Exit" << endl;
        int choice, val;
        do {
            cout << "Enter your choice: ";
            cin >> choice;
            switch (choice) {
                case 1:      
                    cout << "Enter value to insert: ";
                    cin >> val;
                    insert(val);
                    break;
                case 2:
                    cout << "Inorder Traversal:" << endl;
                    inOrder();
                    break;
                case 3:
                    cout << "Preorder Traversal:" << endl;
                    preOrder();
                    break;
                case 4:
                    cout << "Postorder Traversal:" << endl;
                    postOrder();
                    break;
                case 5:
                    cout << "Enter value to search: ";
                    cin >> val; 
                    if (search(val))
                        cout << val << " found in the tree." << endl;
                    else
                        cout << val << " not found in the tree." << endl;
                    break;
                case 6:
                    cout << "Enter value to delete: ";
                    cin >> val;
                    deleteNode(val);
                    cout << val << " deleted from the tree." << endl;
                    break;
                case 7:
                    cout << "Exiting..." << endl;
                    break;
                default:
                    cout << "Invalid choice. Try again." << endl;
    }        } while (choice != 7);
    }
};

int main() {
    BST tree;
    tree.menu();
    return 0;
}