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
   public String type(){
      return "King";
   }
   public ArrayList<Location> moves(Piece[][] p){
      System.out.println(x+","+y);
      ArrayList<Location> ret = new ArrayList<Location>();
      if (p == null)
         return ret;
      for(int i=-1; i<=1; i++){
         for(int j=-1; j<=1; j++){
            if(x+i<0||x+i>7||y+j<0||y+j>7)
               continue;
            else if(p[x+i][y+j]==null)
               ret.add(new Location(x+i, y+j));
            else if(p[x+i][y+j].color!=color)
               ret.add(new Location(x+i, y+j));
            
         }
      }
      if(x==x0&&y==y0){
         System.out.println(p[x][y]);
         if(p[x+1][y]==null && p[x+2][y]==null && p[x+3][y]!=null){
            if(p[x+3][y].type().equals("Rook")){
               ret.add(new Location(x+2, y));
            }
         }
         if(p[x-1][y]==null && p[x-2][y]==null && p[x-3][y]==null && p[x-4][y]!=null){  
            if(p[x-4][y].type().equals("Rook"))
               ret.add(new Location(x-2, y));
         }     
      }
      for(Location l: ret)
         System.out.println(l.x+","+l.y);
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2654");
      return new JLabel("\u265A");      
   }
}
