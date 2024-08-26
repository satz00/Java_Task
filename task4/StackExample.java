package task4;

import java.util.Stack;

public class StackExample {
    Stack <Integer> stack = new Stack<>();

    public void addInStack(int i) {
        stack.push(i);
        System.out.println(stack);
    }
    public void poppingInStack() {
        System.out.println(stack.pop());
        System.out.println(stack);
    }
    public void checkEmpty() {
        System.out.println(stack.empty());
    }
}
