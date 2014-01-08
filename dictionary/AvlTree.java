package dictionary;

public class AvlTree {
	
	AvlNode root;
	
	public AvlTree() {
		root=null;
	}
	 public void makeEmpty( )
     {
         root = null;
     }

     
     public boolean isEmpty( )
     {
         return root == null;
     }
     
     public void insert( Comparable x ,String discrptn)
     {
         root = insert( x, root ,discrptn);
     }
     
     public String find( Comparable x )
     {
         return  find( x, root );
     }

     private Comparable elementAt( AvlNode t )
     {
         return t == null ? null : t.element;
     }

   
     private AvlNode insert( Comparable x, AvlNode t ,String discription)
     {
    	 //String index1=x.toString().substring(0,1);
    	// Comparable y=(Comparable)index1;
    	 
	         if( t == null )
	             t = new AvlNode( x, null, null,discription );
	         else if( x.toString().compareToIgnoreCase( t.element.toString() ) < 0 )
	         {
	             t.left = insert( x, t.left, discription);
	             if( height( t.left ) - height( t.right ) == 2 )
	                 if( x.toString().compareToIgnoreCase( t.element.toString() ) < 0 )
	                     t = rotateWithLeftChild( t );
	                 else
	                     t = doubleWithLeftChild( t );
	         }
	         else if(  x.toString().compareToIgnoreCase( t.element.toString() ) > 0 )
	         {
	             t.right = insert( x, t.right,discription );
	             if( height( t.right ) - height( t.left ) == 2 )
	                 if(  x.toString().compareToIgnoreCase( t.element.toString() ) > 0 )
	                     t = rotateWithRightChild( t );
	                 else
	                     t = doubleWithRightChild( t );
	         }
	         else
	            System.out.println(x + " is already exists") ;  // Duplicate; do nothing
	         t.height = max( height( t.left ), height( t.right ) ) + 1;
	         return t;
	       
    	
    }
    	
    
    	

   

     
     public String find( Comparable x, AvlNode t )
     {
         while( t != null )
             if(x.toString().compareToIgnoreCase( t.element.toString() ) < 0 )
                 t = t.left;
             else if(x.toString().compareToIgnoreCase( t.element.toString() ) > 0 )
                 t = t.right;
             else
                 return t.discrption;    // Match

         return null;   // No match
     }

     public void printTree( )
     {
         if( isEmpty( ) )
             System.out.println( "Empty tree" );
         else
             printTree( root );
     }
	 private void printTree(AvlNode root) {
		if(root!=null){
			printTree(root.left);
			System.out.println(root.discrption);
			printTree(root.right);
			
		}
		
	}
	 
     
     private static int height( AvlNode t )
     {
         return t == null ? -1 : t.height;
     }

     
     private static int max( int lhs, int rhs )
     {
         return lhs > rhs ? lhs : rhs;
     }

     
     private static AvlNode rotateWithLeftChild( AvlNode k2 )
     {
         AvlNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }

     private static AvlNode rotateWithRightChild( AvlNode k1 )
     {
         AvlNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }

    
     private static AvlNode doubleWithLeftChild( AvlNode k3 )
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }

     
     private static AvlNode doubleWithRightChild( AvlNode k1 )
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }

     
     

	

}
