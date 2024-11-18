package Maps;
import java.util.*;

class FruitInventoryManagement {
    public static void main(String[] args) {
     HashMap<String,Integer> fruits = new HashMap<String,Integer>();
     fruits.put("Apple",50);
          fruits.put("Banana",30);
     fruits.put("Orange",20);
     //fruits.put("Apple",50);
     System.out.println("Total number of entries:"+fruits.size());

 
          System.out.println("HashMap is not empty:"+fruits.isEmpty());
         if(fruits.containsKey("Apple")){
          System.out.println("Apple are:"+fruits.get("Apple"));
          }
          else{
             System.out.println("Apple  empty:"); 
          }
          if(fruits.containsKey("Banana")){
          System.out.println("Banana are :"+fruits.get("Banana"));
          }
          else{
             System.out.println("Banana are empty:"); 
          }
          if(fruits.containsKey("Orange")){
          System.out.println("Orange exists in the records.");
          }
          else{
             System.out.println("Orange are empty"); 
          }
        if(fruits.containsKey("Mango")){
          System.out.println("Mango are :"+fruits.get("Mango"));
          }
          else{
             System.out.println("Mango does not exist in the records."); 
          }
          int val=30;
          if(fruits.containsValue(val)){
          System.out.println("Quantity "+val+" exists in the records.");
          }
          else{
             System.out.println("Quantity"+ val+" does not exist in the records."); 
          }
          

    }
}
