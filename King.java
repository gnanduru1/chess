import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.HashSet;
public class King extends Piece{
   public String type = "King";
   public int x0, y0;
   public King(int a, int b, char c){
      super(a,b,c);
      x0 = a;
      y0 = b;
      char boardColor = 'W';
      if(c=='B')
         boardColor = 'B';
   }
   public String type(){
      return "King";
   }
   public ArrayList<Location> moves(Piece[][] p){
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
      HashSet<Location> enemy = new HashSet<Location>();
      char boardColor = 'B';
      if(color == 'B')
         boardColor = 'W';
      
      for(int t=0; t<8; t++){
         for(int u=0; u<8; u++){            
            if(p[t][u]!=null){
               if(p[t][u].color!=color&&!(p[t][u].type().equals("King"))){                 
                  if(!p[t][u].type().equals("Pawn")){
                     for(Location l: p[t][u].moves(p))                  
                        enemy.add(l);                
                  }
                  else{
                     int dy = 1;
                     if(p[t][u].color == 'B')
                        dy = -1;
                     if(t>0){
                        if(p[t-1][u+dy]==null)
                           enemy.add(new Location(t-1,u+dy));                         
                     }
                     if(t<7){
                        if(p[t+1][u+dy]==null)
                           enemy.add(new Location(t+1,u+dy));
                     }
                  }
               }
            }
         }
      }
      ret.removeAll(enemy);
      return ret;
   }
   public JLabel getIcon(){
      if(color == 'W')
         return new JLabel("\u2654");
      return new JLabel("\u265A");      
   }
}
