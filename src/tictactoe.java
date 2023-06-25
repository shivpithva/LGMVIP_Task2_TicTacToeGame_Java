//Created by Shivam Pithva 
//Inter as Java Developer Intern at LetGrowMore
// Task 2 : Create a Tic-Tac-Toe Game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tictactoe extends JFrame implements ActionListener{
    
    JFrame frame;
    JPanel playerscorePanel, gamePanel, currentPlayerPanel, buttomPanel;
    JLabel imglabel, player1scoreLabel, player2scoreLabel, scoreresetButtonPanelLabel, currentPlayerLabel;
    JButton[][] buttons;
    JButton resetButton, exitButton;
    ImageIcon image;
    int totalMoves, player1score, player2score, currentPlayer;
    int[][] board;
    
    public tictactoe(){
        
//        setting intial values
        currentPlayer = 1;
        totalMoves = 0;
        player1score = 0;
        player2score = 0;
        board = new int[3][3];
        
//      Creating new Frame
        frame = new JFrame();
        frame.setTitle("Tic Tac Toe Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600,700);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setLocationRelativeTo(null);
      
//        Setting image for Game Logo
        image = new ImageIcon(getClass().getResource("logofinal.png")); 
        imglabel = new JLabel(image); //new imglabel created for add image
        imglabel.setHorizontalAlignment(JLabel.CENTER);
        imglabel.setVerticalAlignment(JLabel.TOP);
        imglabel.setBounds(0, 0, 600, 150);
        frame.add(imglabel);
        
//        player's score borad
//        panel
        playerscorePanel = new JPanel();
        playerscorePanel.setBackground(Color.white);
        playerscorePanel.setBounds(0, 120, 600, 25);
        playerscorePanel.setLayout(new GridLayout(1,2));
        frame.add(playerscorePanel);
//       label
        player1scoreLabel = new JLabel("Player 1 Score : 0");
        player1scoreLabel.setForeground(new Color(244,50,83));
        player1scoreLabel.setFont(new Font("Arial",Font.BOLD,18));
        player1scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        playerscorePanel.add(player1scoreLabel);
        
        player2scoreLabel = new JLabel("Player 2 Score : 0");
        player2scoreLabel.setForeground(new Color(54,170,214));
        player2scoreLabel.setFont(new Font("Arial",Font.BOLD,18));
        player2scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        playerscorePanel.add(player2scoreLabel);
        
//        which player turn showing
//        panel
        currentPlayerPanel = new JPanel();
        currentPlayerPanel.setBackground(new Color(73,100,254));
        currentPlayerPanel.setBounds(0, 147, 600, 22);
        currentPlayerPanel.setLayout(new GridBagLayout());
        frame.add(currentPlayerPanel);
//        label
        currentPlayerLabel = new JLabel("Player 1's Turn");
        currentPlayerLabel.setForeground(Color.white);
        currentPlayerLabel.setFont(new Font("Arial",Font.PLAIN,17));
        currentPlayerPanel.add(currentPlayerLabel);
        
//        creating game board 
//panel
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3,3));
        gamePanel.setBackground(Color.white);
        gamePanel.setBounds(100, 200, 400, 400);
        frame.add(gamePanel);

//buttons
        buttons = new JButton[3][3];
        
//        first Row
             buttons[0][0] = new JButton();
             buttons[0][0].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[0][0].setBackground(Color.white);
             buttons[0][0].setOpaque(true);
             buttons[0][0].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(73,100,254)));
             buttons[0][0].setFocusable(false);
             buttons[0][0].addActionListener(this);
             gamePanel.add(buttons[0][0]);
             buttons[0][1] = new JButton();
             buttons[0][1].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[0][1].setBackground(Color.white);
             buttons[0][1].setOpaque(true);
             buttons[0][1].setBorder(BorderFactory.createMatteBorder(4, 0, 4, 4, new Color(73,100,254)));
             buttons[0][1].setFocusable(false);
             buttons[0][1].addActionListener(this);
             gamePanel.add(buttons[0][1]);
             buttons[0][2] = new JButton();
             buttons[0][2].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[0][2].setBackground(Color.white);
             buttons[0][2].setOpaque(true);
             buttons[0][2].setBorder(BorderFactory.createMatteBorder(4, 0, 4, 4, new Color(73,100,254)));
             buttons[0][2].setFocusable(false);
             buttons[0][2].addActionListener(this);
             gamePanel.add(buttons[0][2]);    
//        Second Row
             buttons[1][0] = new JButton();
             buttons[1][0].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[1][0].setBackground(Color.white);
             buttons[1][0].setOpaque(true);
             buttons[1][0].setBorder(BorderFactory.createMatteBorder(0, 4, 4, 4, new Color(73,100,254)));
             buttons[1][0].setFocusable(false);
             buttons[1][0].addActionListener(this);
             gamePanel.add(buttons[1][0]);
             buttons[1][1] = new JButton();
             buttons[1][1].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[1][1].setBackground(Color.white);
             buttons[1][1].setOpaque(true);
             buttons[1][1].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(73,100,254)));
             buttons[1][1].setFocusable(false);
             buttons[1][1].addActionListener(this);
             gamePanel.add(buttons[1][1]);
             buttons[1][2] = new JButton();
             buttons[1][2].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[1][2].setBackground(Color.white);
             buttons[1][2].setOpaque(true);
             buttons[1][2].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(73,100,254)));
             buttons[1][2].setFocusable(false);
             buttons[1][2].addActionListener(this);
             gamePanel.add(buttons[1][2]);
//             Third Row
             buttons[2][0] = new JButton();
             buttons[2][0].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[2][0].setBackground(Color.white);
             buttons[2][0].setOpaque(true);
             buttons[2][0].setBorder(BorderFactory.createMatteBorder(0, 4, 4, 4, new Color(73,100,254))); 
             buttons[2][0].setFocusable(false);
             buttons[2][0].addActionListener(this);
             gamePanel.add(buttons[2][0]);
             buttons[2][1] = new JButton();
             buttons[2][1].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[2][1].setBackground(Color.white);
             buttons[2][1].setOpaque(true);
             buttons[2][1].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(73,100,254)));
             buttons[2][1].setFocusable(false);
             buttons[2][1].addActionListener(this);
             gamePanel.add(buttons[2][1]);
             buttons[2][2] = new JButton();
             buttons[2][2].setFont(new Font("Arial",Font.BOLD, 50));
             buttons[2][2].setBackground(Color.white);
             buttons[2][2].setOpaque(true);
             buttons[2][2].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(73,100,254)));
             buttons[2][2].setFocusable(false);
             buttons[2][2].addActionListener(this);
             gamePanel.add(buttons[2][2]);

//             creating reset button and exit button 
//panel
            buttomPanel = new JPanel();
            buttomPanel.setBackground(Color.red);
            buttomPanel.setBounds(0, 620, 600, 40);
            buttomPanel.setLayout(new GridLayout(1,2));
            frame.add(buttomPanel);
//           Reset Button
        resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setBackground(new Color(244,50,83));
        resetButton.setOpaque(true);
        resetButton.setForeground(Color.white);
        resetButton.setFont(new Font("Arial",Font.BOLD,20));
        resetButton.setHorizontalAlignment(JLabel.CENTER);
        resetButton.setBorder(BorderFactory.createMatteBorder(0,50,0,50, Color.white));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        buttomPanel.add(resetButton);
//        Exit Button
        exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.setBackground(new Color(244,50,83));
        resetButton.setOpaque(true);
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Arial",Font.BOLD,20));
        exitButton.setHorizontalAlignment(JLabel.CENTER);
        exitButton.setFocusable(false);
        exitButton.setBorder(BorderFactory.createMatteBorder(0,50,0,50, Color.white));
        exitButton.addActionListener(this);
        buttomPanel.add(exitButton);
                    
        frame.setVisible(true); //makes visible to whole frame
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == resetButton) {
             player1score = 0;
             player2score = 0;
             player1scoreLabel.setText("Player 1 Score : " + player1score);
             player2scoreLabel.setText("Player 2 Score : " + player2score);
             resetGame();
             return;
    }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
           
//        get the info button and player and set the either "X" or "O" and shows which player turn is now.
JButton clickedButton = (JButton) e.getSource();
 for (int row = 0; row < 3; row++) {
 for (int col = 0; col < 3; col++) {
 if (clickedButton == buttons[row][col]) {
 if (board[row][col] == 0) {
 board[row][col] = currentPlayer;
 totalMoves++;
 if (currentPlayer == 1) {
 clickedButton.setText("X");
 clickedButton.setForeground(new Color(244,50,83));
 currentPlayerLabel.setText("Player 2's Turn");
 currentPlayer = 2;
 } else {
 clickedButton.setText("O");
 clickedButton.setForeground(new Color(54,170,214));
 currentPlayerLabel.setText("Player 1's Turn");
 currentPlayer = 1;
 }
 
// Checks which player win the game and show that and update the score
 if (checkWin(row, col)) {
 String winner = (currentPlayer == 1) ? "Player 2" : "Player 1";
 JOptionPane.showMessageDialog(this, winner + " wins!");
  updateScore(winner);
 resetGame();
 } else if (totalMoves == 9) {
 JOptionPane.showMessageDialog(this, "It's a draw!");
 resetGame();
 }
 } else {
 JOptionPane.showMessageDialog(this, "Invalid move!");
 }
 return;
 }
 }
 }
 }
//    Logic of Winning for tictactoe game
 private boolean checkWin(int row, int col) {
 // Check row
 // Check row
 if (board[row][0] == board[row][1] && board[row][1] == board[row][2])
 return true;
 // Check column
 if (board[0][col] == board[1][col] && board[1][col] == board[2][col])
 return true;
 // Check diagonal
 if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != 0)
 return true;
 if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != 0)
 return true;
 return false;
 }
 
// It update the score and and display it.
 private void updateScore(String winner) {
if(winner.equals("Player 1")) {
    player1score++;
    player1scoreLabel.setText("Player 1 Score : " + player1score);
}else {
    player2score++;
    player2scoreLabel.setText("Player 2 Score : " + player2score);
}}
 
// Reset Game Class which reset game board
 private void resetGame() {
 currentPlayer = 1;
 totalMoves = 0;
 currentPlayerLabel.setText("Player 1's Turn");
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 buttons[i][j].setText("");
 board[i][j] = 0;
 }
 }
 }
    
    public static void main(String args[]){
        new tictactoe();  
    }
}
