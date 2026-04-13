package org.example.java.problems.stack;

import java.util.Stack;

/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Solution :

Create two stack, one to implement push, peek and pop and another to keep track of min variable
whenever pop happens check if it is equals to the top element, if it is then pop the element from the minstack
in case of push check if val is <= to the top of minStack if it is then push in both stack and minStack

 */
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        if(minStack.size() == 0 || val <= minStack.peek()){
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        int val  = stack.pop();
        if(minStack.peek() == val){
            minStack.pop();
        }

    }

    public int top() {
        return (Integer)stack.peek();
    }

    public int getMin() {
        if(minStack.size() > 0){
            return minStack.peek();
        }else{
            return -1;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
