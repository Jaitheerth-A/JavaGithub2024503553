#include <iostream>
#include <cctype>
#include <cmath>
#include <cstdlib> // for exit()
using namespace std;

// Node for integer stack
class IntNode {
public:
    int data;
    IntNode* next;
    IntNode(int d) {
        data = d;
        next = nullptr;
    }
};

// Integer Stack Class
class IntStack {
    IntNode* top;
public:
    IntStack() { top = nullptr; }

    void push(int val) {
        IntNode* temp = new IntNode(val);
        temp->next = top;
        top = temp;
    }

    int pop() {
        if (isEmpty()) {
            cout << "Error: Stack underflow! Invalid postfix expression.\n";
            exit(1);
        }
        int val = top->data;
        IntNode* del = top;
        top = top->next;
        delete del;
        return val;
    }

    int peek() {
        if (isEmpty()) {
            cout << "Error: Stack empty.\n";
            exit(1);
        }
        return top->data;
    }

    bool isEmpty() {
        return top == nullptr;
    }
};

// Postfix Evaluator Class
class PostfixEvaluator {
public:
    int applyOperator(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if(b == 0){
                    cout << "Error: Division by zero!\n";
                    exit(1);
                }
                return a / b;
            case '^': return pow(a, b);
            default:
                cout << "Error: Invalid operator '" << op << "'\n";
                exit(1);
        }
        return 0;
    }

    int evaluate(string postfix) {
        IntStack st;
        for (char c : postfix) {
            if (isdigit(c)) {
                st.push(c - '0'); // convert char to int
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                int b = st.pop();
                int a = st.pop();
                int res = applyOperator(a, b, c);
                st.push(res);
            } else {
                cout << "Error: Invalid character '" << c << "' in expression.\n";
                exit(1);
            }
        }
        if(st.isEmpty()) {
            cout << "Error: Empty expression.\n";
            exit(1);
        }
        int result = st.pop();
        if(!st.isEmpty()) {
            cout << "Error: Invalid postfix expression. Extra operands left in stack.\n";
            exit(1);
        }
        return result;
    }
};

// ===============================
// Main Function
// ===============================
int main() {
    PostfixEvaluator evaluator;
    string postfix;

    cout << "Enter postfix expression (single-digit operands only): ";
    cin >> postfix;

    int result = evaluator.evaluate(postfix);
    cout << "Result: " << result << endl;

    return 0;
}