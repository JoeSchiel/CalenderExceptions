
public class InvalidDayException extends Exception {

   public InvalidDayException(){
      super("Invalid day");  
   }
   
   public InvalidDayException(String str){
      super(str);  
   }
   
}
