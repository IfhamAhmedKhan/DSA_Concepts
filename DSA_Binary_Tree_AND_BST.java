package project;
//(a) Inorder (Left, Root, Right) : 4 2 5 1 3 
//(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
//(c) Postorder (Left, Right, Root) : 4 5 2 3 1
public class DSA_Binary_Tree_AND_BST {
public static void main(String[] args) {
        
        //Binary tree
        TLNode root= new TLNode(1);
        root.left=new TLNode(2);
        root.right=new TLNode(3);
        root.left.left= new TLNode(4);
        root.left.right= new TLNode(5);
        root.right.left= new TLNode(6);
        root.right.right= new TLNode(7);
       
        //preorder(root);
        //postorder(root);
        Binarytree.Inorder(root);
        // TODO code application logic here
        BST bs=new BST();
        bs.root= bs.insert(50,bs.root);
        bs.root= bs.insert(30,bs.root);
        bs.root= bs.insert(20,bs.root);
        bs.root= bs.insert(70,bs.root);
        bs.root= bs.insert(60,bs.root);
        bs.root= bs.insert(80,bs.root);
       
        bs.inorder(bs.root);
       bs.root=bs.delete(bs.root, 50);
        System.out.println("");
        bs.inorder(bs.root);
        
    }    
   
}
class TLNode{
int data;
TLNode left, right;
TLNode(int d){
    this.data=d;
}

}

class Binarytree {
   
    static void preorder(TLNode r){
    if(r==null){return;}
        System.out.println(r.data+"");
        preorder(r.left);
        preorder(r.right);
   
    }
    static void Inorder(TLNode r){
    if(r==null){return;}
        Inorder(r.left);
        System.out.println(r.data+"");
        Inorder(r.right);
   
    }
   
     static void postorder(TLNode r){
    if(r==null){return;}
        postorder(r.left);
        postorder(r.right);
        System.out.println(r.data+"");
    }

}
//---------------------------------------------------
class BST {
    TLNode root;
    TLNode insert(int d, TLNode root){
        if(root==null){
        root=new TLNode(d);
        }
        else if(d<root.data) {
        root.left=insert(d,root.left);
        }
        else {
            root.right=insert(d,root.right);
        }
        return root;
    }
    
    void preorder(TLNode r){
    if(r==null){return;}
        System.out.println(r.data+"");
        preorder(r.left);
        preorder(r.right);
    }
    
    void inorder(TLNode r){
    if(r==null){return;}
    inorder(r.left);
        System.out.println(r.data+"");
        inorder(r.right);
    }
    
    void postorder(TLNode r){
    if(r==null){return;}
        postorder(r.left);
        postorder(r.right);
        System.out.println(r.data+"");
    }
    
    TLNode delete(TLNode root, int data){
    if(root==null){
        return root;
    }
    else if(data<root.data){
        root.left=delete(root.left,data);
    }
    else if(data>root.data){
        root.right=delete(root.right,data);
    }
    else{
        if(root.left==null){
        return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
   
        root.data=minValue(root.right);
        root.right=delete(root.right,root.data);
    }
    return root;
    }
    
    int minValue(TLNode root){
    int minv=root.data;
    while(root.left!=null){
    minv=root.left.data;
    root=root.left;
    }
    return minv;
    }
}

