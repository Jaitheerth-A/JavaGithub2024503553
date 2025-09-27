#include <iostream>
#include <cctype>
using namespace std;

// Node for character stack
class CharNode {
public:
    char data;
    CharNode* next;
    CharNode(char d) {
        data = d;
        next = nullptr;
    }
};

// Stack class for characters
class CharStack {
    CharNode* top;
public:
    CharStack() { top = nullptr; }

    void push(char c) {
        CharNode* temp = new CharNode(c);
        temp->next = top;
        top = temp;
    }

    char pop() {
        if (isEmpty()) {
            cout << "Stack Underflow!\n";
            return '\0';
        }
        char val = top->data;
        CharNode* del = top;
        top = top->next;
        delete del;
        return val;
    }

    char peek() {
        return (top) ? top->data : '\0';
    }

    bool isEmpty() {
        return top == nullptr;
    }
};

// Expression class for infix to postfix conversion
class ExpressionConverter {
public:
    int precedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }

    string infixToPostfix(string infix) {
        CharStack st;
        string postfix = "";

        for (char c : infix) {
            if (isalnum(c)) {  // Operand
                postfix += c;
            } 
            else if (c == '(') {
                st.push(c);
            } 
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix += st.pop();
                }
                st.pop(); // Remove '('
            } 
            else { // Operator
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(c)) {
                    postfix += st.pop();
                }
                st.push(c);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            postfix += st.pop();
        }
        return postfix;
    }
};

// ===============================
// Main Function
// ===============================
int main() {
    ExpressionConverter converter;
    string infix;

    cout << "Enter infix expression: ";
    cin >> infix;

    string postfix = converter.infixToPostfix(infix);
    cout << "Postfix Expression: " << postfix << endl;

    return 0;
}