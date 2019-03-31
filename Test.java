import javax.swing.JLabel;
import java.util.HashMap;
import java.util.HashSet;
public class Test{
   public static void main(String[] args){
      Piece k = new Knight(2,5,'B');
      Piece x = new Pawn(1,6,'W');
      Piece[][] p = new  Piece[8][8];
      p[2][7] = new Pawn(2,7,'B');
      p[0][7] = k;
      p[1][6] = x;
      for(Location l: x.moves(p))
         System.out.println(l);
   }
}