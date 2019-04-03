public class Location{
   public int x;
   public int y;
   public Location(int a, int b){
      x = a;
      y = b;
   }
   public String toString(){
      return "("+x+", "+y+")";
   }   
   public boolean equals(Object obj){      
      if(obj==null)
         return false;
      Location ob = (Location) obj;
      return (ob.x == x && ob.y == y);
   }
   public boolean equals(Location obj){
      return equals((Object) obj);
   }
   public int compareTo(Object c){
      return 1;
   }
   public int hashCode(){
      return toString().hashCode();
   }
}  