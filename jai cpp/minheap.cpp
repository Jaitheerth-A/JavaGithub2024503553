#include <iostream>
using namespace std;

class PriorityQueue {
private:
    int arr[100];   // array to store heap elements
    int size;       // current size of heap

    // Heapify up (for insert)
    void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr[parent], arr[index]);
                index = parent;
            } else {
                break;
            }
        }
    }

    // Heapify down (for extract)
    void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && arr[left] > arr[largest])
            largest = left;
        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != index) {
            swap(arr[index], arr[largest]);
            heapifyDown(largest);
        }
    }

public:
    PriorityQueue() { size = 0; }

    // Insert element
    void insert(int val) {
        if (size >= 100) {
            cout << "Queue is full!" << endl;
            return;
        }
        arr[size] = val;
        heapifyUp(size);
        size++;
        cout << "Inserted: " << val << endl;
    }

    // Get maximum element
    int getMax() {
        if (size == 0) {
            cout << "Queue is empty!" << endl;
            return -1;
        }
        return arr[0];
    }

    // Extract maximum element
    void extractMax() {
        if (size == 0) {
            cout << "Queue is empty!" << endl;
            return;
        }
        int maxVal = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);
        cout << "🗑️ Extracted max: " << maxVal << endl;
    }

    // Display heap
    void display() {
        if (size == 0) {
            cout << " Queue is empty!" << endl;
            return;
        }
        cout << "Priority Queue (heap order): ";
        for (int i = 0; i < size; i++)
            cout << arr[i] << " ";
        cout << endl;
    }

    // Check if empty
    bool isEmpty() {
        return size == 0;
    }
};

// ------------------- MENU -------------------
int main() {
    PriorityQueue pq;
    int choice, value;

    cout << "====== MAX PRIORITY QUEUE USING ARRAY ======" << endl;

    while (true) {
        cout << "\n------ MENU ------" << endl;
        cout << "1. Insert element" << endl;
        cout << "2. Get maximum element" << endl;
        cout << "3. Extract maximum element" << endl;
        cout << "4. Display queue" << endl;
        cout << "5. Check if queue is empty" << endl;
        cout << "6. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter value to insert: ";
                cin >> value;
                pq.insert(value);
                break;
            case 2:
                if (!pq.isEmpty())
                    cout << " Maximum element: " << pq.getMax() << endl;
                break;
            case 3:
                pq.extractMax();
                break;
            case 4:
                pq.display();
                break;
            case 5:
                if (pq.isEmpty())
                    cout << " Queue is empty." << endl;
                else
                    cout << " Queue is NOT empty." << endl;
                break;
            case 6:
                cout << " Exiting program. Thank you!" << endl;
                return 0;
            default:
                cout << " Invalid choice! Try again." << endl;
        }
    }
}