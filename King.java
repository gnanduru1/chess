import javax.swing.JLabel;
import java.util.ArrayList;
public class King extends Piece{
   public King(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      
      return null;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2654");
      return new JLabel("\u265A");      
   }
}
