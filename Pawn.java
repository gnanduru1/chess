import javax.swing.JLabel;
import java.util.ArrayList;
public class Pawn extends Piece{   
   public String type(){
      return "Pawn";
   }
   public Pawn(int a, int b, char c){   
      super(a,b,c);
   }
   public ArrayList<Location> moves(Piece[][] p){
      ArrayList<Location> ret = new ArrayList<Location>();
      if (p == null)
         return ret;
      if(color=='W'){
         if(x!=0){
            if(p[x-1][y+1]!=null){
               if(p[x-1][y+1].color=='B')
                  ret.add(new Location(x-1,y+1));
            }
         }
         if(x!=7){
            if(p[x+1][y+1]!=null){
               if(p[x+1][y+1].color=='B')
                  ret.add(new Location(x+1,y+1));
            }
         }
         if(y==1){
            if(p[x][y+1]==null&&p[x][y+2]==null)
               ret.add(new Location(x, y+2));
         }
         if(p[x][y+1]==null)
            ret.add(new Location(x, y+1));         
      }
      else{
         if(x!=0){
            if(p[x-1][y-1]!=null){
               if(p[x-1][y-1].color=='W')
                  ret.add(new Location(x-1, y-1));
            }
         }
         if(x!=7){
            if(p[x+1][y-1]!=null){
               if(p[x+1][y-1].color=='W')
                  ret.add(new Location(x+1, y-1));
            }
         }
         if(y==6){
            if(p[x][y-1]==null&&p[x][y-2]==null)
               ret.add(new Location(x, y-2));
         }
         if(p[x][y-1]==null)
            ret.add(new Location(x, y-1));        
      }
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2659");
      return new JLabel("\u265F");      
   }
}
