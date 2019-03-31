import javax.swing.JLabel;
import java.util.HashMap;
import java.util.HashSet;
public class Test{
   public static void main(String[] args){
      Piece x = new Knight(4,4,'W');
      Piece[][] p = new Piece[8][8];
      p[4][4] = x;
      p[5][6] = new Pawn(5,6,'W');
      for(Location l: x.moves(p))
         System.out.println(l);
   }
}