// The Stack ADT -- linked list implementation

class StringNode {

   private String data;
   private StringNode next;

   public StringNode () {
     this(0, null);
   }

   public StringNode (String d) {
     data = d;
   }
  
   public StringNode (String d, StringNode n) {
     data = d;
     next = n;
   }

   public void setData (String newData) {
     data = newData;
   }

   public void setNext (Node newNext) {
     next = newNext;
   } 

   public String getData () {
     return data;
   }

   public StringNode getNext () {
      return next;
   }

   public void displayNode () {
      System.out.print (data);
   }
}

class LLStackADT implements LLStack {

   private StringNode top;
   private int size;

   public LLStackADT () {
     top = null;
     size = 0;
   }          

   public boolean empty () {
     return (top == null);
   }

   public void push (String number) {
     StringNode newNode = new StringNode ();
     newNode.setData(number);
     newNode.setNext(top);
     top = newNode;
     size++;     
   }

   public String pop () {
     String i;
     i = top.getData();
     top = top.getNext();
     size--;
     return i;
   }

   public String ontop () {
     String i = pop();
     push(i);
     return i;
   }

   public int size () {
     return size;
   }

}