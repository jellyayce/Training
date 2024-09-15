import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tictactoe
{
    int boardWidth = 600;
    int boardHeight = 650;
    String playerX = "X";
    String playerO = "O";
    String whoseTurn = playerX;

    JFrame frame = new JFrame();
    JLabel textlabel = new JLabel();
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton[][] button = new JButton[3][3];
    JButton restartButton = new JButton("RESTART");
    int moves = 0;

    public Tictactoe()
    {
        frame.setSize(boardWidth, boardHeight);
        frame.setTitle("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        textlabel.setFont(new Font("Arial", Font.BOLD, 50));
        textlabel.setText("TIC TAC TOE");
        textlabel.setForeground(Color.white);
        textlabel.setBackground(Color.darkGray);
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(textlabel);
        frame.add(panel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(4,3));
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setForeground(Color.white);
        frame.add(buttonPanel);

        for(int i = 0; i<button.length;i++)
        {
            for(int j = 0; j<button[i].length;j++)
            {
                button[i][j] = createButton(44, 44, 44, 255, 255, 255, "Arial", Font.BOLD, 120, false);
                buttonPanel.add(button[i][j]);
                button[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if (isGameOver()) 
                        {
                            return;
                        }
                        JButton button = (JButton)e.getSource();
                        if (button.getText()=="") 
                        {
                            button.setText(whoseTurn);
                            moves++;
                            if (isGameOver()) 
                            {
                                textlabel.setText(whoseTurn+" is the Winner!");
                                restartButton.setEnabled(true);
                            }
                            else if (moves==9) 
                            {
                                textlabel.setText("It's a DRAW!");
                                Draw();
                                restartButton.setEnabled(true);
                            }
                            else if(!isGameOver())
                            {
                                whoseTurn = whoseTurn == playerX ? playerO : playerX;
                                textlabel.setText(whoseTurn+"'s Turn");
                            }
                        }
                    }
                });
            }
        }
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setForeground(Color.white);
        restartButton.setBackground(Color.red);
        restartButton.setEnabled(false);
        restartButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                for (int i = 0; i<3; i++) {
                    for (int j = 0; j<3; j++) {
                        button[i][j].setText("");
                        button[i][j].setBackground(new Color(44,44,44));
                        button[i][j].setForeground(Color.white);
                        whoseTurn = playerX;
                        moves = 0;
                        textlabel.setText("TIC TAC TOE");
                        restartButton.setEnabled(false);
                    }
                }
            }
        });
        buttonPanel.add(restartButton);
         
    }
    public JButton createButton(int r, int g, int b, int r1, int g1, int b1, String ff, int fw, int fs, boolean f)
    {
        JButton button = new JButton();
        button.setBackground(new Color(r,g,b));
        button.setForeground(new Color(r1,g1,b1));
        button.setFont(new Font(ff,fw,fs));
        button.setFocusable(f);
        return button;
    }
    public boolean isGameOver(){
        return (checkRow() || checkCol() || checkDiag());
    }
    public boolean checkRow(){
        for (int i = 0; i<button.length; i++) 
        {
            if (button[i][0].getText() == button[i][1].getText() && button[i][0].getText() == button[i][2].getText() && button[i][0].getText() != "") 
            {
                button[i][0].setForeground(Color.green);
                button[i][1].setForeground(Color.green);
                button[i][2].setForeground(Color.green);
                return true;
            }
        }
        return false;
    }
    public boolean checkCol(){
        for (int i = 0; i<button.length; i++) 
        {
            if (button[0][i].getText() == button[1][i].getText() && button[0][i].getText() == button[2][i].getText() && button[0][i].getText() != "") 
            {
                button[0][i].setForeground(Color.green);
                button[1][i].setForeground(Color.green);
                button[2][i].setForeground(Color.green);
                return true;
            }
        }
        return false;
    }
    public boolean checkDiag(){
        if (button[0][0].getText() == button[1][1].getText() && button[1][1].getText() == button[2][2].getText() && button[0][0].getText() != "") 
        {
            button[0][0].setForeground(Color.green);
            button[1][1].setForeground(Color.green);
            button[2][2].setForeground(Color.green);
            return true;
        }
        if (button[0][2].getText() == button[1][1].getText() && button[1][1].getText() == button[2][0].getText() && button[0][2].getText() != "") 
        {
            button[0][2].setForeground(Color.green);
            button[1][1].setForeground(Color.green);
            button[2][0].setForeground(Color.green);
            return true;
        }
        return false;
    }
    public void Draw(){
        for(int i = 0; i<button.length; i++)
        {
            for (int j = 0; j<button.length; j++) {
                button[i][j].setForeground(Color.red);
                button[i][j].setBackground(Color.gray);
            }
        }
    }
}
