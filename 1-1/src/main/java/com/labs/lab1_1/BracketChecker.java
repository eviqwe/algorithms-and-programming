package com.labs.lab1_1;

import java.util.Stack;

public class BracketChecker {
    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // открывающую скобку кладем на вершину стека
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // закрывающая скобка, а открывающих не осталось
                if (stack.isEmpty()) {
                    return false;
                }

                // проверяем, что на вершине лежит скобка такого же типа
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        // если в стеке что то осталось, значит какие то скобки не закрыли
        return stack.isEmpty();
    }
}
