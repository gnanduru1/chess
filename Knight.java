import javax.swing.JLabel;
import java.util.ArrayList;
public class Knight extends Piece{
   public String type = "Knight";
   public Knight(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      if (p == null)
         return ret;
      if(x>0&&y>1){
         if(p[x-1][y-2]==null)
            ret.add(new Location(x-1, y-2));
         else if(p[x-1][y-2].color!=color)
            ret.add(new Location(x-1, y-2));
      }
      if(x>0&&y<6){
         if(p[x-1][y+2]==null)
            ret.add(new Location(x-1, y+2));
         else if(p[x-1][y+2].color!=color)
            ret.add(new Location(x-1, y+2));
      }
      if(x>1&&y>0){
         if(p[x-2][y-1]==null)
            ret.add(new Location(x-2, y-1));
         else if(p[x-2][y-1].color!=color)
            ret.add(new Location(x-2, y-1));
      }
      if(x>1&&y<7){
         if(p[x-2][y+1]==null)
            ret.add(new Location(x-2, y+1));
         else if(p[x-2][y+1].color!=color)
            ret.add(new Location(x-2, y+1));
      }
      if(x<7&&y>1){
         if(p[x+1][y-2]==null)
            ret.add(new Location(x+1, y-2));
         else if(p[x+1][y-2].color!=color)
            ret.add(new Location(x+1, y-2));
      }
      if(x<7&&y<6){
         if(p[x+1][y+2]==null)
            ret.add(new Location(x+1, y+2));
         else if(p[x+1][y+2].color!=color)
            ret.add(new Location(x+1, y+2));
      }
      if(x<6&&y>0){
         if(p[x+2][y-1]==null)
            ret.add(new Location(x+2, y-1));
         else if(p[x+2][y-1].color!=color)
            ret.add(new Location(x+2, y-1));
      }
      if(x<6&&y<7){
         if(p[x+2][y+1]==null)
            ret.add(new Location(x+2, y+1));
         else if(p[x+2][y+1].color!=color)
            ret.add(new Location(x+2, y+1));
      }
      
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2658");
      return new JLabel("\u265E");      
   }
}
