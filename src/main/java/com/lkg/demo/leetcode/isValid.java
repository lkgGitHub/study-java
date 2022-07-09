package com.lkg.demo.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class isValid {

    public static void main(String[] args) {
        System.out.println(isValid2( "]"));
    }

    //方法：栈
    private static boolean isValid1(String s) {
        if (s == null|| s.length()<1) return true;

        Stack<Character> st = new Stack<>();
        for (char ch: s.toCharArray()){
            if (ch == '{' || ch=='[' || ch=='('){
                st.push(ch);
            }else if ((ch=='}' && !st.empty() && st.peek()=='{') || (ch==']' && !st.empty() &&  st.peek()=='[')
                    || (ch==')' && !st.empty() && st.peek()=='(')){
                st.pop();
            }else if (ch == ' '){
            }else {
                return false;
            }
        }
        return st.empty();
    }

    private static boolean isValid2(String s) {
        if (s == null|| s.length()<1) return true;

        Stack<Character> st = new Stack<>();
        for (char ch: s.toCharArray()){
            switch (ch){
                case '{':st.push(ch);break;
                case '[':st.push(ch);break;
                case '(':st.push(ch);break;
                case '}':
                    if (!st.empty() && st.peek()=='{')
                        st.pop();
                    else return false;
                    break;
                case ']':
                    if (!st.empty() && st.peek()=='[')
                        st.pop();
                    else return false;
                    break;
                case ')':
                    if (!st.empty() && st.peek()=='(')
                        st.pop();
                    else return false;
                    break;
                case ' ':break;
                default:return false;
            }
        }
        return st.empty();
    }

}
