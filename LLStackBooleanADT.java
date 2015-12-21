// The Stack ADT -- linked list implementation

class BooleanNode {

   private boolean data;
   private BooleanNode next;

   public BooleanNode () {
     this(0, null);
   }

   public BooleanNode (boolean d) {
     data = d;
   }
  
   public BooleanNode (boolean d, BooleanNode n) {
     data = d;
     next = n;
   }

   public void setData (boolean newData) {
     data = newData;
   }

   public void setNext (BooleanNode newNext) {
     next = newNext;
   } 

   public boolean getData () {
     return data;
   }

   public BooleanNode getNext () {
      return next;
   }

   public void displayNode () {
      System.out.print (data);
   }
}

class LLStackBooleanADT implements LLStackBoolean {

   private BooleanNode top;
   private int size;

   public LLStackBooleanADT () {
     top = null;
     size = 0;
   }          

   public boolean empty () {
     return (top == null);
   }

   public void push (boolean number) {
     BooleanNode newNode = new BooleanNode ();
     newNode.setData(number);
     newNode.setNext(top);
     top = newNode;
     size++;     
   }

   public boolean pop () {
     boolean i;
     i = top.getData();
     top = top.getNext();
     size--;
     return i;
   }

   public boolean ontop () {
     boolean i = pop();
     push(i);
     return i;
   }

   public int size () {
     return size;
   }

}