package org.example.corejava;

public class ValidParanthesis {
        public static boolean isValid(String s) {
            if(s.length() == 0 || s.isBlank() || s.isEmpty()){
                System.out.println("String is either null or blank");
                return false;
            }else{
                Stack<Character> stack = new Stack<>();
                for (char c : s.toCharArray()) {
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else if (c == ')' || c == '}' || c == ']') {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        char top = stack.pop();
                        if ((c == ')' && top != '(') ||
                                (c == '}' && top != '{') ||
                                (c == ']' && top != '[')) {
                            return false;
                        }
                    }
                }
                return stack.isEmpty();
            }
        }

        public static void main(String[] args) {
            System.out.println(isValid("(a + (b -c) +z) - z)"));
            System.out.println(isValid("(a + (b -c) +z - z)"));
            System.out.println(isValid("((a + (b -c) +z - z)"));
            System.out.println(isValid("(a + {b -c)  +z}"));
            System.out.println(isValid("y + (a + (b -c) +z - z)"));
            System.out.println(isValid(""));
        }
    }

