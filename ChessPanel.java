import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ChessPanel extends JPanel{
   //Whose turn it is
   char turn = 'W';
   //board's labels and pieces
   JLabel[][] labels;
   Piece[][] board;
   //Contains locations of highlighted tiles (to be reset)
   ArrayList<Location> resets;
   Location oldPiece;
   public ChessPanel(){  
      //8x8 chessboard grid
      resets = new ArrayList<Location>();
      setLayout(new GridLayout(8,8));  
         
      //Draw chessboard 
      labels = new JLabel[8][8];
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
      board = new Piece[8][8];
      char c = 'W';
      int temp = 1;
      for(int i=0; i<=7; i+=7){      
         board[0][i] = new Rook(0,i,c);
         board[7][i] = new Rook(7,i,c);
         
         board[1][i] = new Knight(1,i,c);
         board[6][i] = new Knight(6,i,c);
         
         board[2][i] = new Bishop(2,i,c);
         board[5][i] = new Bishop(5,i,c);
         
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
      addMouseListener(new myMouseListener());
   }
   class myMouseListener implements MouseListener{
      public void mouseClicked(MouseEvent e){
         //Location of pointer when clicked
         PointerInfo a = MouseInfo.getPointerInfo();
         Point b = a.getLocation();
         int x = (int)(b.getX()-110)/100;
         int y = 7-(int)(b.getY()-150)/100;
         boolean exit = false;      
         
         //Reset highlighted tiles to normal colors
         for(Location l: resets){   
            //Move piece         
            if(l.equals(new Location(x, y))){ 
               //Change turn
               if(turn=='W') turn='B';
               else turn='W';
               //Replace empty space/captured piece with null
               //Update board with piece's new position
               board[x][y] = board[oldPiece.x][oldPiece.y];          
               board[oldPiece.x][oldPiece.y] = null;              
               
               //Update x and y positions of this piece
               if(board[x][y]!= null){
                  board[x][y].x = x;
                  board[x][y].y = y;
               }   
               swap(7-y,x,7-oldPiece.y,oldPiece.x);  
               
               //Pawn promotion
               if(board[x][y].type()=="Pawn"){
                  if((board[x][y].color == 'W' && y==7)||(board[x][y].color == 'B' && y==0)){
                     board[x][y] = new Queen(x,y,board[x][y].color);
                     labels[7-y][x].setText(board[x][y].getIcon().getText());
                     //labels[x][y].setHorizontalAlignment(SwingConstants.CENTER);                  
                     //labels[7-y][x].setFont(new Font(labels[7-y][x].getFont().getName(), Font.PLAIN, 90));
                     //if(board[x][y].color=='W')
                     //   labels[7-y][x].setForeground(Color.WHITE);
                  }
               }
                  
               exit = true;
            }               
            //Reset tiles
            if(((7-l.x)+(7-l.y))%2==1)
               labels[7-l.y][l.x].setBackground(new Color(255,228,196));
            else
               labels[7-l.y][l.x].setBackground(new Color(139,69,19));            
         }
         //Empty the "resets" array
         resets = new ArrayList<Location>();
         
         //Stop method if a piece was moved
         if(exit)
            return;
         //Stop if tile clicked is empty
         if(board[x][y]==null)
            return;
         //Stop if piece clicked is not being played on this turn
         if(board[x][y].color!=turn)
            return; 
         ArrayList<Location> array = board[x][y].moves(board);         
         for(Location l: array){
            resets.add(l);
            JLabel n = labels[7-l.y][l.x];
            Color r = n.getBackground();
            if(r.getRed()==255)
               n.setBackground(new Color(255, 255, 40));
            else            
               n.setBackground(new Color(170, 130, 8));
         }         
         //Save location of piece clicked for the next call of MouseClicked
         oldPiece = new Location(x,y);
      }
      private void swap(int x1, int y1, int x2, int y2){        
         Color color1 = labels[x1][y1].getForeground();
         Color color2 = labels[x2][y2].getForeground();
         
         labels[x1][y1].setText(labels[x2][y2].getText());
         labels[x2][y2].setText("");
         
         labels[x1][y1].setHorizontalAlignment(SwingConstants.CENTER);
         labels[x1][y1].setFont(new Font(labels[x1][y1].getFont().getName(), Font.PLAIN, 90));
         labels[x1][y1].setForeground(color2);
         
         labels[x2][y2].setHorizontalAlignment(SwingConstants.CENTER);
         labels[x2][y2].setFont(new Font(labels[x2][y2].getFont().getName(), Font.PLAIN, 90));
         labels[x2][y2].setForeground(color1);
      }
      public void mouseExited(MouseEvent e){}
      public void mouseEntered(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
      public void mousePressed(MouseEvent e){}
   }
}