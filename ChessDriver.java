import javax.swing.JFrame;
public class ChessDriver{
   public static void main(String[] args){
      JFrame frame = new JFrame("Chessboard");
      frame.setSize(820,855);
      frame.setLocation(100,100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ChessPanel());
      frame.setVisible(true);      
   }
}