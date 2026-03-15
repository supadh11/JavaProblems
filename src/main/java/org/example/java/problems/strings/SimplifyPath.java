package org.example.java.problems.strings;

import java.util.Stack;

/*
71. Simplify Path
You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
The simplified canonical path should follow these rules:

The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.

Solution :
1) Take a stack as data store.
2) Loop over the directories name splitted by "/"
3) push the directories name if it is not ".",".","/"
4) pop the last stacked directory name if current is ".."
5) after the loop, start another loop till stack is empty
6) insert the popped value from stack at 0th index and then a "/" to form the path. basically prepending the directory names
 */
public class SimplifyPath {

    public static void main(String args[]){

        String path = "/home/user/Documents/../Pictures";
        String validPath = simplifyPath(path);
        System.out.println(validPath);
    }

    private static String simplifyPath(String path) {

        String[] directories = path.split("/");
        StringBuffer resultPath = new StringBuffer("");
        int count = directories.length;
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<count;i++){
            if(directories[i].equals("..") && !stack.empty()) stack.pop();
            else{
               if(!directories[i].equals(".") && !directories[i].equals("..")  && !directories[i].equals("") ) stack.push(directories[i]);
            }
        }
        if(stack.empty()) return "/";
        while(!stack.empty()){
            resultPath.insert(0,stack.pop()).insert(0,"/");
        }

        return resultPath.toString();
    }
}
