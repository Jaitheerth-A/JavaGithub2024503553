#include <iostream>
using namespace std;
class node
{
public:
    int data;
    node* next;
    node()
    {
        data = 0;
        next = nullptr;
    }
    node(int v)
    {
        data = v;
        next = nullptr;
    }
};
class linked_list
{
    node* head;
public:
    linked_list()
    {
        head = nullptr;
    }

    void addlast(int a)
    {
        node* r = new node(a);
        if (head == nullptr)
        {
            head = r;
            r->next = head;
        }
        else
        {
            node* temp = head;
            while (temp->next != head)
                temp = temp->next;
            temp->next = r;
            r->next = head;
        }
    }

    void addfirst(int a)
    {
        node* r = new node(a);
       if (head == nullptr)
        {
            head = r;
            r->next = head;
        }
        else
        {
            node* temp = head;
            while (temp->next != head)
                temp = temp->next;
            temp->next = r;
            r->next = head;
            head = r;
        }
    }

    void addatpos(int a, int pos)
    {
        node* r = new node(a);
        if (pos == 0)
        {
            addfirst(a);
            delete r; // Already added in addfirst
            return;
        }
        if (head == nullptr)
        {
            cout << "Position out of bounds" << endl;
            delete r;
            return;
        }
        node* temp = head;
        for (int i = 0; i < pos - 1 && temp->next != head; i++)
            temp = temp->next;
        if (temp->next == head && pos > 1)
        {
            cout << "Position out of bounds" << endl;
            delete r;
            return;
        }
        r->next = temp->next;
        temp->next = r;
    }

    void printall()
    {
        if (head == nullptr)
        {
            cout << "List is empty" << endl;
            return;
        }
        node* temp = head;
        cout << "Circular Linked List: ";
        do
        {
            cout <<endl<< temp->data;
            temp = temp->next;
        } while (temp != head);
        cout << endl;
    }

    void deletefirst()
    {
        if (head == nullptr)
        {
            cout << "List is empty" << endl;
            return;
        }
        if (head->next == head)
        {
            cout << "Deleting first element: " << head->data << endl;
            delete head;
            head = nullptr;
            return;
        }
        node* temp = head;
        node* last = head;
        while (last->next != head)
            last = last->next;
        cout << "Deleting first element: " << head->data << endl;
        last->next = head->next;
        temp = head;
        head = head->next;
        delete temp;
    }

    void deletelast()
    {
        if (head == nullptr)
        {
            cout << "List is empty" << endl;
            return;
        }
        if (head->next == head)
        {
            cout << "Deleting last element: " << head->data << endl;
            delete head;
            head = nullptr;
            return;
        }
        node* temp = head;
        while (temp->next->next != head)
            temp = temp->next;
        cout << "Deleting last element: " << temp->next->data << endl;
        delete temp->next;
        temp->next = head;
    }

    void deleteatpos(int pos)
    {
        if (head == nullptr)
        {
            cout << "List is empty" << endl;
            return;
        }
        if (pos == 0)
        {
            deletefirst();
            return;
        }
        node* temp = head;
        for (int i = 0; i < pos - 1 && temp->next != head; i++)
            temp = temp->next;
        if (temp->next == head)
        {
            cout << "Position out of bounds" << endl;
            return;
        }
        node* todelete = temp->next;
        cout << "Deleted element: " << todelete->data << endl;
        temp->next = todelete->next;
        delete todelete;
    }

    void deletebyvalue(int val)
    {
        if (head == nullptr)
        {
            cout << "List is empty" << endl;
            return;
        }
        if (head->data == val)
        {
            deletefirst();
            return;
        }
        node* temp = head;
        while (temp->next != head && temp->next->data != val)
            temp = temp->next;
        if (temp->next == head)
        {
            cout << "Value not found in the list" << endl;
            return;
        }
        node* todelete = temp->next;
        cout << "Deleted element: " << todelete->data << endl;
        temp->next = todelete->next;
        delete todelete;
    }
};
int main()
{
    linked_list a;
    int choice, value, pos;
    do {
        cout << "\nMenu:\n";
        cout << "1. Add element at end\n";
        cout << "2. Add element at beginning\n";
        cout << "3. Add element at position\n";
        cout << "4. Delete first element\n";
        cout << "5. Delete last element\n";
        cout << "6. Delete element at position\n";
        cout << "7. Print all elements\n";
        cout << "8. Delete by value\n";
        cout << "0. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        switch(choice) {
            case 1:
                cout << "Enter value to add at end: ";
                cin >> value;
                a.addlast(value);
                break;
            case 2:
                cout << "Enter value to add at beginning: ";
                cin >> value;
                a.addfirst(value);
                break;
            case 3:
                cout << "Enter value to add: ";
                cin >> value;
                cout << "Enter position (0-based index): ";
                cin >> pos;
                a.addatpos(value, pos);
                break;
            case 4:
                a.deletefirst();
                break;
            case 5:
                a.deletelast();
                break;
            case 6:
                cout << "Enter position to delete (0-based index): ";
                cin >> pos;
                a.deleteatpos(pos);
                break;
            case 7:
                a.printall();
                break;
            case 8:
                cout << "Enter value to delete: ";
                cin >> value;
                a.deletebyvalue(value);
                break;
            default:
                if(choice != 0)
                    cout << "Invalid choice. Please try again.\n";
        }
    } while(choice != 0);
    return 0;
}