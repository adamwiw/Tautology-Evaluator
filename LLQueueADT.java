class LLQueueADT implements LLQueue {

   private int size;
   private Node front;
   private Node rear;

   public LLQueueADT () {
     size = 0;
     front = null;
     rear = null;
   }

   public boolean empty () {
     return (size == 0);
   }

   public void enqueue (String number) {
     Node newNode = new Node ();
     newNode.setData(number);
     newNode.setNext(null);
     if (this.empty()) 
       front = newNode;
     else
       rear.setNext(newNode);
     rear = newNode;
     size++;
   }

   public String dequeue () {
     String i;
     i = front.getData();
     front = front.getNext();
     size--;
     if (this.empty())
        rear = null;
     return i;
   }

   public String front () {
     return front.getData();
   }

   public int size () {
      return size;
   }
    
    public boolean found(String data)
    {
        Node current = front;
        boolean found = false;
        
        while(current != null)
        {
            if(current.equals(data))
                found = true;
            current = current.getNext();
        }
        return found;
    }
}
