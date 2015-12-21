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
