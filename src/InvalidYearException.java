
public class InvalidYearException extends Exception {

   public InvalidYearException(){
      super("Year is not in range of 1985-2015");  
   }
   
   public InvalidYearException(String str){
      super(str);  
   }
}
