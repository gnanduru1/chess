import java.util.ArrayList;
import javax.swing.JLabel;
public class Piece{
   public String type(){
      return "Arbitrary piece";
   }
   public char color;
   public int x,y;
   public Piece(){
      color = 'E';
   }
   public Piece(int a, int b, char c){
      x = a;
      y = b;
      color = c;
   }
   public ArrayList<Location> moves(Piece[][] p){
      return null;
   }
   public JLabel getIcon(){
      return null;
   }
}
