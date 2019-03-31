import javax.swing.JLabel;
import java.util.ArrayList;
public class Knight extends Piece{
   public Knight(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      ret.add(new Location(1,1));
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2658");
      return new JLabel("\u265E");      
   }
}
