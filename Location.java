public class Location{
   public int x;
   public int y;
   public Location(int a, int b){
      x = a;
      y = b;
   }
   public String toString(){
      return x+", "+y;
   }   
   public boolean equals(Location c){
      return (c.x == x && c.y == y);
   }
}