#include<iostream>
using namespace std;
class node
{
    public:
    int data;
    node* next;
    node()
    {
        data=0;
        next=nullptr;
    }
    node(int v)
    {
        data=v;
        next=nullptr;
    }
};
class linked_list
{
    node* head;
public:
    linked_list()
    {
        head=nullptr;
    }
    void addinitial(int a)
    {
        node* r=new node(a);
        if(head == nullptr){
            head=r;
        }
        else
        {
            node* temp=head;
            while(temp->next != nullptr)
            {
                temp=temp->next;
            }
            temp->next=r;
        }
    }
    void addatpos(int a, int pos)
    {
        cout<<"Adding element "<<a<<" at position "<<pos<<"..."<<endl;
        node* r=new node(a);
        if(pos == 0)
        {
            r->next=head;
            head=r;
            return;
        }
        node* temp=head;
        for(int i=0; i<pos-1 && temp != nullptr; i++)
        {
            temp=temp->next;
        }
        if(temp == nullptr)
        {
            cout<<"Position out of bounds"<<endl;
            delete r;
            return;
        }
        r->next=temp->next;
        temp->next=r;
    }
    void addlast(int a)
    {
        cout<<"Adding element "<<a<<" at the end..."<<endl;
        node* r=new node(a);
        if(head == nullptr)
        {
            head=r;
            return;
        }
        node* temp=head;
        while(temp->next != nullptr)
        {
            temp=temp->next;
        }
        temp->next=r;
    }
    void addfirst(int a)
    {
        cout<<"Adding element "<<a<<" at the beginning..."<<endl;
        node* r=new node(a);
        r->next=head;
        head=r;
    }
    void printall()
    {
        node* temp;
        temp=head;
        if(temp == nullptr)
        {
            cout<<"List is empty"<<endl;
            return;
        }
        cout<<"Printing all elements in the list:"<<endl;
        while(temp != nullptr)
        {
            cout<<temp->data<<endl;
            temp=temp->next;
        }
    }
    void deletefirst()
    {
        cout<<"Deleting first element..."<<endl;
        if(head == nullptr)
        {
            cout<<"List is empty"<<endl;
            return;
        }
        node* temp=head;
        head=head->next;
        cout<<"Deleted first element: "<<temp->data<<endl;
        delete temp;
    }
    void deleteatpos(int pos)
    {
        cout<<"Deleting element at position "<<pos<<"..."<<endl;
        if(head == nullptr)
        {
            cout<<"List is empty"<<endl;
            return;
        }
        if(pos == 0)
        {
            deletefirst();
            return;
        }
        node* temp=head;
        for(int i=0; i<pos-1 && temp != nullptr; i++)
        {
            temp=temp->next;
        }
        if(temp == nullptr || temp->next == nullptr)
        {
            cout<<"Position out of bounds"<<endl;
            return;
        }
        node* todelete=temp->next;
        temp->next=todelete->next;
        cout<<"Deleted element: "<<todelete->data<<endl;
        delete todelete;
    }
    void deletelast()
    {
        cout<<"Deleting last element..."<<endl;
        if(head == nullptr)
        {
            cout<<"List is empty"<<endl;
            return;
        }
        if(head->next == nullptr)
        {
            cout<<"Deleting last element: "<<head->data<<endl;
            delete head;
            head = nullptr;
            return;
        }
        node* temp = head;
        while(temp->next->next != nullptr)
        {
            temp = temp->next;
        }
        cout<<"Deleting last element: "<<temp->next->data<<endl;
        delete temp->next;
        temp->next = nullptr;
    }
    void deletebyvalue(int val)
    {
        cout << "Deleting element with value " << val << "..." << endl;
        if(head == nullptr)
        {
            cout << "List is empty" << endl;
            return;
        }
        if(head->data == val)
        {
            node* temp = head;
            head = head->next;
            cout << "Deleted element: " << temp->data << endl;
            delete temp;
            return;
        }
        node* temp = head;
        while(temp->next != nullptr && temp->next->data != val)
        {
            temp = temp->next;
        }
        if(temp->next == nullptr)
        {
            cout << "Value not found in the list" << endl;
            return;
        }
        node* todelete = temp->next;
        temp->next = todelete->next;
        cout << "Deleted element: " << todelete->data << endl;
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