import javax.swing.JLabel;
import java.util.ArrayList;
public class Rook extends Piece{
   public String type = "Rook";
   public Rook(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      if (p == null)
         return ret;
      for(int i=1;i<8;i++){
         if(x+i>7)
            break;
         if(p[x+i][y]==null)
            ret.add(new Location(x+i,y));
         else if(p[x+i][y].color!=color)
            ret.add(new Location(x+i,y));
         break;
      } 
      for(int i=1;i<8;i++){
         if(y-i<0)
            break;
         if(p[x][y-i]==null)
            ret.add(new Location(x,y-i));
         else if(p[x][y-i].color!=color)
            ret.add(new Location(x,y-i));
         break;
      }
      for(int i=1;i<8;i++){
         if(x-i<0)
            break;
         if(p[x-i][y]==null)
            ret.add(new Location(x-i,y));
         else if(p[x-i][y].color!=color)
            ret.add(new Location(x-i,y));
         else
            break;
      }
      for(int i=1;i<8;i++){
         if(y+i>7)
            break;
         if(p[x][y+i]==null)
            ret.add(new Location(x,y+i));
         else if(p[x][y+i].color!=color)
            ret.add(new Location(x,y+i));
         else
            break;
      }
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2656");
      return new JLabel("\u265C");      
   }
}
