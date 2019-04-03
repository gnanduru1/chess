import java.util.*;
public class Test{
   public static void main(String[] args){
      ArrayList<Location> list = new ArrayList<Location>();
      ArrayList<Location> list2 = new ArrayList<Location>();
      list.add(new Location(5,6));
      list.add(new Location(5,5));
      list2.add(new Location(5,6));
      System.out.println(list);
      list.removeAll(list2);
      System.out.println(list);
   }
   
}