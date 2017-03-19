/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesteddelimiters;

import java.io.*;
import java.util.Stack;


public class NestedDelimiters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedDelimiters.readDelimiters("Payroll3.java");
		
	}
	
	public static void readDelimiters(String fileName){
		
		Stack<Character> delimiters = new Stack();//Stack to keep track of delimiter in file
		File file= new File(fileName);
		
		char c;
		int r;
		Reader reader;
		try{
			InputStream in = new FileInputStream(file);
			 reader= new BufferedReader(new InputStreamReader(in));
			
			while((r=reader.read())!=-1){
				c = (char) r;
				System.out.print(c);
				
				//When an opening delimiter is found, push the matching closing pair to the stack
				if (c=='{'){
					delimiters.push('}');
				}else if (c=='['){
					delimiters.push(']');
				}else if (c=='('){
					delimiters.push(')');						
				}else if ((c=='}') ||(c==']') || (c==')')){
					//If a closing delimiter is found, check to see if it matches to the expected closing delimiter
					if (c==delimiters.peek()){
						delimiters.pop();//If so, remove it from the stack
					}else{//If not,  then output error message
						System.out.println("\n\nMismatched delimiter " + c);
						reader.close();
						in.close();
						return;
					}
				}		
			}			
			reader.close();
			in.close();
			
			//Check to see if all closing delimiters were found
			if (!delimiters.isEmpty()){
				System.out.println("\n\nUnmatched delimiter" + delimiters.pop());
			}
			return;
		}catch (Exception e){
			System.out.println("Error reading file");
		}
	}

}