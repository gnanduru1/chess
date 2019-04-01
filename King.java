import javax.swing.JLabel;
import java.util.ArrayList;
public class King extends Piece{
   public String type = "King";
   public int x0, y0;
   public King(int a, int b, char c){
      super(a,b,c);
      x0 = a;
      y0 = b;
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      if (p == null)
         return ret;
      for(int i=-1; i<=1; i++){
         for(int j=-1; j<=1; j++){
            if(x+i<0||x+i>7||y+i<0||y+i>7)
               continue;
            else if(p[x+i][y+i]==null)
               ret.add(new Location(x+i, y+i));
            else if(p[x+i][y+i].color!=color)
               ret.add(new Location(x+i, y+i));
         }
      }
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2654");
      return new JLabel("\u265A");      
   }
}
