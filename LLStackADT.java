// The Stack ADT -- linked list implementation

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
