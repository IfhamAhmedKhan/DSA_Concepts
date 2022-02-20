package project;

import java.util.Stack;

public class DSA_Polish_Notation {
    public static void main(String[] args) {
        //infix to postfix
        String exp="+AB";
        System.out.println(Test.infixToPostfix(exp));
        //infix to prefix
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + InfixToPreFix.infixToPreFix(exp));
        //prefix to infix
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Infix Expression: " + new PreFixToInFix().convert(exp));
        //postfix to infix
        String exp1="AB+";
        System.out.println("Postfix Expression: " + exp1);
        System.out.println("Infix Expression: " + new PostFixToInfix().convert(exp1));
    }
}
//Infix to postfix
class Test {
   public static int Prec(char ch){
   switch(ch){
       case'+':
       case'-':
       return 1;
       
       case'*':
       case'/':
       return 2;
       
       case'^':
       return 3;
   }
   return -1;
   }
   
   public static String infixToPostfix(String exp){
   String result = new String();
   
   Stack<Character> stack= new Stack<>();
   
       for (int i = 0; i < exp.length(); i++) {
           char c = exp.charAt(i);
           //check if character is operand then add it to output.
           if(Character.isLetterOrDigit(c))
               result+= c;
           //check if it is opening bracket then push it to stack
           else if(c=='(')
               stack.push(c);
           //if it find character ')' pop until '('
           else if(c==')'){
               while(!stack.isEmpty() && stack.peek()!='(')
               result+=stack.pop();
           }
           else
           {
           while(!stack.isEmpty() && Prec(c)<=Prec(stack.peek())){
               result+= stack.pop();
           }
           stack.push(c);
       }    
   }
       //pop all the operators from stack
       while(!stack.isEmpty()){
       if(stack.peek()=='(')
       return "Invalid Expression";
       result+=stack.pop();
       
       }
       return result;
   }
}
//Infix to prefix
class InfixToPreFix {
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static StringBuilder infixToPreFix(String expression){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor "("
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

}
//prefix to infix
class PreFixToInFix {
    public String convert(String expression){

        Stack<String> stack = new Stack<>();
        for (int i = expression.length()-1; i >=0 ; i--) {
            char c = expression.charAt(i);

            if(isOperator(c)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s1+c+s2+")";
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        String result=stack.pop();

        return result;
    }

    boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

}
//Posfix to infix
class PostFixToInfix {

    public String convert(String expression){

        Stack<String> stack = new Stack<>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            if(c=='*'||c=='/'||c=='^'||c=='+'||c=='-' ){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s2+c+s1+")";
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        String result=stack.pop();
        return result;
    }

}
