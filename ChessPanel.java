import javax.swing.*;
import java.awt.*;
public class ChessPanel extends JPanel{
   public ChessPanel(){  
      //8x8 chessboard grid
      setLayout(new GridLayout(8,8));  
         
      //Draw chessboard 
      JLabel[][] labels = new JLabel[8][8];
      Color back;
           
      for(int i=0; i<8; i++){
         for(int j=0; j<8; j++){
            if((i%2==0&&j%2==0)||(i%2==1&&j%2==1))
               back = new Color(255,228,196);                              
            else
               back = new Color(139,69,19);
            labels[i][j] = new JLabel();
            labels[i][j].setBackground(back);
            labels[i][j].setOpaque(true);
            add(labels[i][j]);
         }
      }
      revalidate();
      repaint();
      
      //Instantiate Piece array, board[][]
      //Array is [x][y], with [0][0] at bottom left and [7][7] at top right      
      Piece[][] board = new Piece[8][8];
      char c = 'W';
      int temp = 1;
      for(int i=0; i<=7; i+=7){      
         board[0][i] = new Rook(0,i,c);
         board[7][i] = new Rook(7,i,c);
         
         board[1][i] = new Bishop(1,i,c);
         board[6][i] = new Bishop(6,i,c);
         
         board[2][i] = new Knight(2,i,c);
         board[5][i] = new Knight(5,i,c);
         
         board[4][i] = new King(3,i,c);
         board[3][i] = new Queen(4,i,c);
         
         for(int j=0; j<8; j++)
            board[j][i+temp] = new Pawn(j,i+temp,c);
         c = 'B';
         temp = -1;
      }
      
      //Update labels[][] text to Unicode values of board[][]
      for(int i=0; i<8; i++){
         for(int j=0; j<8; j++){
            if(board[i][j]!=null){
               JLabel pointer = labels[7-j][i];
               pointer.setText(board[i][j].getIcon().getText());
               pointer.setHorizontalAlignment(SwingConstants.CENTER);
               pointer.setFont(new Font(pointer.getFont().getName(), Font.PLAIN, 90));
               //Set text color to white if piece is white
               if(board[i][j].color=='W')
                  pointer.setForeground(Color.WHITE);
               }
         }
      }
      revalidate();
      repaint();
   }
}