package assignment4;

import java.util.EmptyStackException;
import java.util.Stack;

public class PreProcessor {

    private BasicFile f;
    private String contents;
    private Stack<Object> stk;

    public PreProcessor(){
        f = new BasicFile();
        while (!f.isFile()) // make sure the user picks a valid file
            f = new BasicFile();

        contents = f.readFile();

        stk = new Stack<Object>();
    }

    boolean isParenBalanced(){
        int index = 0;
        boolean fail = false;

        try{
            while(index < contents.length() && !fail){

                char ch = contents.charAt(index);

                switch (ch){
                    case Constants.LEFT_PARENTHESES:
                        stk.push( new Character(ch));
                    break;
                    case Constants.RIGHT_PARENTHESES:
                        stk.pop();
                    break;
                    default:
                    break;
                }
                index++;
            }

        }catch(EmptyStackException e){
            e.printStackTrace();
            fail = true;
        }
        return (stk.empty() && !fail);
    }

    boolean isCurlyBalanced(){
        int index = 0;
        boolean fail = false;

        try{
            while(index < contents.length() && !fail){

                char ch = contents.charAt(index);

                switch (ch){
                    case Constants.LEFT_CURLY_BRACE:
                        stk.push( new Character(ch));
                        break;
                    case Constants.RIGHT_CURLY_BRACE:
                        stk.pop();
                        break;
                    default:
                        break;
                }
                index++;
            }

        }catch(EmptyStackException e){
            System.out.println(e.toString());
            fail = true;
        }
        return (stk.empty() && !fail);
    }

    boolean isBracketBalanced(){
        int index = 0;
        boolean fail = false;

        try{
            while(index < contents.length() && !fail){

                char ch = contents.charAt(index);

                switch (ch){
                    case Constants.LEFT_BRACKET:
                        stk.push( new Character(ch));
                        break;
                    case Constants.RIGHT_BRACKET:
                        stk.pop();
                        break;
                    default:
                        break;
                }
                index++;
            }

        }catch(EmptyStackException e){
            e.printStackTrace();
            fail = true;
        }
        return (stk.empty() && !fail);
    }

    boolean isCommentValid(){
        int index = 0;
        boolean fail = false;

        try{
            while(index < contents.length() && !fail){

                char ch = contents.charAt(index);

                switch (ch){
                    case Constants.FORWARD_SLASH:
                        if(stk.empty())
                        {
                            stk.push(new Character(ch));
                        }
                        else {
                                stk.pop();
                            }
                        break;
                    case Constants.STAR:
                        Character top = ' ';
                        top = (Character) stk.peek();
                        if(top == Constants.FORWARD_SLASH) {
                            while (index < contents.length()) {
                                ch = contents.charAt(index);
                                System.out.println(ch);
                                if (ch == '/' && contents.charAt(index - 1) == '*') {
                                    System.out.println((Character) stk.peek());
                                        stk.pop();
                                    System.out.println(stk.empty());
                                        break;
                                }
                                    index++;
                            }
                        }
                    break;
                    default:
                        break;
                }
                index++;
            }



        }catch(EmptyStackException e){
            e.printStackTrace();
            fail = true;
        }
        return (stk.empty() && !fail);
    }

    public String getContents(){
        return contents;
    }

    boolean isValid(){
        return (isBracketBalanced() && isCurlyBalanced() && isParenBalanced() && isCommentValid());
    }
}
