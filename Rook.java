import javax.swing.JLabel;
import java.util.ArrayList;
public class Rook extends Piece{
   public Rook(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      
      return null;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2656");
      return new JLabel("\u265C");      
   }
}
