public class Tree {
    private class Node{
        String name;
        Node left;
        Node right;
        Node parent;

        Node(){
            left = null;
            right = null;
            parent = null;

        }
        Node(String name){
            this.name = name;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node root = null;

    public void root(String name){
        root = new Node(name);
    }

    private void left(Node focus, String parent, String child){

        if(focus!=null){
            if(focus.name==parent){
                if(focus.left == null){
                    focus.left = new Node(child);
                    focus.left.parent = focus;
                }
                else
                    return;
            }
            left(focus.left, parent,child);
            left(focus.right,parent,child);
        }
        else
            return;

    }

    private void right(Node focus, String parent, String child){
        if(focus!=null){
            if(focus.name==parent){
                if(focus.right == null){
                    focus.right = new Node(child);
                    focus.right.parent = focus;
                }
                else
                    return;
            }
            right(focus.left, parent,child);
            right(focus.right,parent,child);
        }
        else
            return;
    }

    public void left(String parent, String child){
        left(root, parent, child);
    }

    public void right(String parent, String child){
        right(root,parent,child);
    }

    private void descendants(Node focus, String person){
        if(focus!=null){
            if(focus.name==person){
                printTraversal(focus.left);     //Print left descendants
                printTraversal(focus.right);    //Print right descendants
                return;
            }
            descendants(focus.left,person);
            descendants(focus.right,person);
        }
        else{
            return;
        }
    }

    public void descendants(String person){
        descendants(root, person);
    }


    private void printTraversal(Node node){
        if(node!=null){
            System.out.println(node.name);
            printTraversal(node.left);
            printTraversal(node.right);
        }
    }

    private void ancestor(Node focus, String name){
        if(focus!=null){
            if(focus.name==name){
                printAncestors(focus);
                return;
            }
            ancestor(focus.left,name);
            ancestor(focus.right,name);
        }
        else{
            return;
        }

    }

    public void ancestor(String name){
        ancestor(root,name);
    }

    private void printAncestors(Node focus){
        focus = focus.parent;
        while (focus!=null){
            System.out.println(focus.name);
            focus = focus.parent;
        }
    }


    public static void main(String args[]){
        Tree t = new Tree();

    }


}
