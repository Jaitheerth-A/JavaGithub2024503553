// TO IMPLEMENT CIRCULAR QUEUE USING CIRCULAR ARRAY
#include<iostream>
using namespace std;

// Global front, rear, and queue length
static int front = -1, rear = -1, len = 0;

// Set queue size (optional helper)
int Setlen(int a) {
    len = a;
    return len;
}

// Check if queue is empty
bool isEmpty() {
    return front == -1;
}

// Check if queue is full
bool isFull() {
    return ((rear + 1) % len) == front;
}

// Enqueue operation
void Enqueue(int a[], int val) {
    if (isFull()) {
        cout << "QUEUE IS FULL. Cannot insert: " << val << endl;
        return;
    }

    if (isEmpty()) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % len;
    }

    a[rear] = val;
    cout << "Inserted: " << val << endl;
}

// Dequeue operation
void Dequeue(int a[]) {
    if (isEmpty()) {
        cout << "QUEUE IS EMPTY." << endl;
        return;
    }

    int temp = a[front];

    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % len;
    }

    cout << "Removed: " << temp << endl;
}


void print(int a[]) {
    if (isEmpty()) {
        cout << "Queue is Empty." << endl;
        return;
    }

    cout << "Queue: ";
    int count = (rear >= front) ? (rear - front + 1) : (len - front + rear + 1);
    for (int i = 0; i < count; i++) {
        cout << a[(front + i) % len] << endl;
    }
}

// Main function
int main() {
    int n, choice, value;

    cout << "Enter size of queue: ";
    cin >> n;

    int a[n]; // Note: VLA is non-standard in C++, works in GCC/Clang
    Setlen(n);

    do {
        cout << "\nCHOOSE OPERATION:\n1) ENQUEUE\n2) DEQUEUE\n3) EXIT\nENTER CHOICE: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter value: ";
                cin >> value;
                Enqueue(a, value);
                print(a);
                break;

            case 2:
                Dequeue(a);
                print(a);
                break;

            case 3:
                cout << "\nTHANK YOU!\n";
                break;

            default:
                cout << "ERROR! ENTER A VALID CHOICE (1-3).\n";
        }

    } while (choice != 3);

    return 0;
}