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
import java.util.ArrayList;

class Person{
        public String name;
        public ArrayList<String> childrens;
        public String parent;
        
        public Person(String name) {
            this.name = name;
            childrens = new ArrayList<String>();
        }

        public void addChild(String c){
            childrens.add(c);
            
        }
}