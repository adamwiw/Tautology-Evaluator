class StringNode {

   private String data;
   private StringNode next;

   public StringNode () {
     //this(0, null);
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

   public void setNext (StringNode newNext) {
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
