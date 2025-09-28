#include <iostream>
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

    // Inorder Traversal (LNR)
    void inOrder(Node* node) {
        if (node == nullptr)
            return;
        inOrder(node->left);
        cout << node->data << " ";
        inOrder(node->right);
    }

    // Preorder Traversal (NLR)
    void preOrder(Node* node) {
        if (node == nullptr)
            return;
        cout << node->data << " ";
        preOrder(node->left);
        preOrder(node->right);
    }

    // Postorder Traversal (LRN)
    void postOrder(Node* node) {
        if (node == nullptr)
            return;
        postOrder(node->left);
        postOrder(node->right);
        cout << node->data << " ";
    }

    // Search a key
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

    // Find minimum node in a subtree
    Node* findMin(Node* node) {
        while (node && node->left != nullptr)
            node = node->left;
        return node;
    }

    // Delete a node
    Node* deleteNode(Node* node, int key) {
        if (node == nullptr)
            return node;

        if (key < node->data)
            node->left = deleteNode(node->left, key);
        else if (key > node->data)
            node->right = deleteNode(node->right, key);
        else {
            // Node found
            if (node->left == nullptr && node->right == nullptr) {
                delete node;
                return nullptr;
            } else if (node->left == nullptr) {
                Node* temp = node->right;
                delete node;
                return temp;
            } else if (node->right == nullptr) {
                Node* temp = node->left;
                delete node;
                return temp;
            } else {
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
        if (root == nullptr) {
            cout << "Tree is empty.\n";
            return;
        }
        inOrder(root);
        cout << endl;
    }

    void preOrder() {
        if (root == nullptr) {
            cout << "Tree is empty.\n";
            return;
        }
        preOrder(root);
        cout << endl;
    }

    void postOrder() {
        if (root == nullptr) {
            cout << "Tree is empty.\n";
            return;
        }
        postOrder(root);
        cout << endl;
    }

    bool search(int key) {
        return search(root, key);
    }

    void deleteNode(int key) {
        root = deleteNode(root, key);
    }

    void menu() {
        cout << "\n--- Binary Search Tree Menu ---\n";
        cout << "1. Insert\n";
        cout << "2. Inorder Traversal\n";
        cout << "3. Preorder Traversal\n";
        cout << "4. Postorder Traversal\n";
        cout << "5. Search\n";
        cout << "6. Delete\n";
        cout << "7. Exit\n";

        int choice, val;
        do {
            cout << "\nEnter your choice: ";
            cin >> choice;
            switch (choice) {
                case 1:
                    cout << "Enter value to insert: ";
                    cin >> val;
                    insert(val);
                    break;
                case 2:
                    cout << "Inorder Traversal: ";
                    inOrder();
                    break;
                case 3:
                    cout << "Preorder Traversal: ";
                    preOrder();
                    break;
                case 4:
                    cout << "Postorder Traversal: ";
                    postOrder();
                    break;
                case 5:
                    cout << "Enter value to search: ";
                    cin >> val;
                    if (search(val))
                        cout << val << " found in the tree.\n";
                    else
                        cout << val << " not found in the tree.\n";
                    break;
                case 6:
                    cout << "Enter value to delete: ";
                    cin >> val;
                    if (search(val)) {
                        deleteNode(val);
                        cout << val << " deleted from the tree.\n";
                    } else {
                        cout << val << " not found in the tree.\n";
                    }
                    break;
                case 7:
                    cout << "Exiting...\n";
                    break;
                default:
                    cout << "Invalid choice. Try again.\n";
            }
        } while (choice != 7);
    }
};

int main() {
    BST tree;
    tree.menu();
    return 0;
}