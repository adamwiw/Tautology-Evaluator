// The Stack ADT -- linked list implementation

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
