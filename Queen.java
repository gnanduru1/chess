import javax.swing.JLabel;
import java.util.ArrayList;
public class Queen extends Piece{
   public String type = "Queen";
   public Queen(int a, int b, char c){
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      ret.addAll((new Bishop(x,y,color)).moves(p));
      ret.addAll((new Rook(x,y,color)).moves(p));
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2655");
      return new JLabel("\u265B");      
   }
}
