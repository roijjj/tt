/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relation;

/**
 *
 * @author cody
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Relation {
	
	
    /**
     * @param args
     */
	static Stack<String> s;
    public static void main(String[] args) {
    	

        ArrayList<Person> persons = new ArrayList<Person>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("text.txt"));
            int N = scanner.nextInt();
            // gets count from file
            System.out.println(N);
            for(int x = 0 ; x<N;x++) {
                // read name
                String name ="";
                name= scanner.next();
                Person person = new Person(name.toLowerCase());
                // read count
                int childCount = scanner.nextInt();

                System.out.print(name + " " + childCount);
                // repeat reading child name upto childCount
                for (int i = 0; i < childCount; i++) {
                    String cName = scanner.next();
                    //printing out the data present
                    System.out.print(" " + cName);
                    //adding in the list of childrens
                    person.addChild(cName.toLowerCase());
                }
                //adding the person in the list
                persons.add(person);
                System.out.println();
            }
            
            System.out.println("Enter child Name");
            scanner = new Scanner(System.in);
            String ChildName =  scanner.nextLine().toLowerCase();
            String fname = ChildName;
            System.out.println("Enter Ancestor name");
            String AncesName =  scanner.nextLine().toLowerCase();
            s = new Stack<String>();
            //System.out.println("sup"+s);
            s.push(fname);
            //for(int i = 0 ;i<persons.size(); )
            while(true){
            	if(fname.equalsIgnoreCase(AncesName)){
            		System.out.println("the folowing is the list :");
            		break;
            	}
            	//System.out.println("sup"+s);
            	fname = search(persons,fname);
            	//System.out.println("sup"+s);
            	if(fname==null){
            		System.out.println(ChildName.toUpperCase()+" is not a descendant of "+AncesName.toUpperCase());
            		break;
            	}
            	
            }
            if(s.size()>1){
	            while(!s.isEmpty()){
	            	System.out.print(s.pop());
	            	if(!s.isEmpty()){
	            		System.out.print("->");
	                }
	            }
        	}
        } catch (Exception e) {
            // TODO: handle exception
        } finally {

            if (scanner != null)
                scanner.close();
        }
    }
    
    public static String search(ArrayList<Person> persons,String name){
    	for(Person p : persons){
    		if(p.childrens.contains(name)){
    			s.push(p.name);
    			return p.name;
    		}
    		
    	}
    	return null;
    }
    
    
    
}
