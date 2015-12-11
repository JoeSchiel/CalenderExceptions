
public class InvalidMonthException extends Exception {

   public InvalidMonthException(){
      super("Month is not in range of 0-12");  
   }
   
   public InvalidMonthException(String str){
      super(str);  
   }
}

