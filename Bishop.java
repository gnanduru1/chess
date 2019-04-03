import javax.swing.JLabel;
import java.util.ArrayList;
public class Bishop extends Piece{
   public Bishop(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      if (p == null)
         return ret;
      for(int i=1;i<8;i++){
         if(x+i>7||y+i>7)
            break;
         if(p[x+i][y+i]==null)
            ret.add(new Location(x+i,y+i));
         else if(p[x+i][y+i].color!=color){
            ret.add(new Location(x+i,y+i));
            break;
         }
         else
            break;
      } 
      for(int i=1;i<8;i++){
         if(x+i>7||y-i<0)
            break;
         if(p[x+i][y-i]==null)
            ret.add(new Location(x+i,y-i));
         else if(p[x+i][y-i].color!=color){
            ret.add(new Location(x+i,y-i));
            break;
         }
         else
            break;
      }
      for(int i=1;i<8;i++){
         if(x-i<0||y-i<0)
            break;
         if(p[x-i][y-i]==null)
            ret.add(new Location(x-i,y-i));
         else if(p[x-i][y-i].color!=color){
            ret.add(new Location(x-i,y-i));
            break;
         }
         else
            break;
      }
      for(int i=1;i<8;i++){
         if(x-i<0||y+i>7)
            break;
         if(p[x-i][y+i]==null)
            ret.add(new Location(x-i,y+i));
         else if(p[x-i][y+i].color!=color){
            ret.add(new Location(x-i,y+i));
            break;
         }
         else
            break;
      }    
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2657");
      return new JLabel("\u265D");      
   }
}
