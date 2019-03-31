import javax.swing.*;
import java.awt.*;
public class ChessPanel extends JPanel{
   public void paintComponent(Graphics g){      
      for(int i=0; i<800; i+=100){
         for(int j=0; j<800; j+=100){
            if((i%200==0&&j%200==0)||(i%200==100&&j%200==100))
               g.setColor(new Color(255,228,196));                              
            else
               g.setColor(new Color(139,69,19));
            g.fillRect(i, j, 100, 100);
         }
      }
   }
}