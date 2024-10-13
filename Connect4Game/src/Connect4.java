import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Connect4 {
	
	//FIX THE RESTART METHOD
	//MAYBE DISABLE ALL THE TOP BUTTONS AFTER A WIN SO USER CANT CLICK ANYMORE?

	private JFrame window = new JFrame("CONNECT 4");    
	private JPanel myPanel = new JPanel();
	private JPanel myPanelB = new JPanel();
	private JButton[][] boardButtons = new JButton[6][7]; //the buttons that holds the letters for the users, first bracket is rows, then columns
	private JButton[] topButtons = new JButton[7]; //the  buttons at the very top where the user puts in the letter

	private int column1 = 5;
	private int column2 = 5;
	private int column3 = 5;
	private int column4 = 5;
	private int column5 = 5;
	private int column6 = 5;
	private int column7 = 5;
	private int playersTurn = 0;
	private String letter = "";

	private boolean checkHorizontalWin(String letter) {
		//Goes through every y button (row) to make sure its checking in every column
		for (int y = 0; y < boardButtons.length; y++) {        
			for (int x = 0; x < boardButtons[y].length - 3; x++) { //Checks for the x variable in the columns length-3 to make sure its length is 4(since its connect 4)

				//This checks if the x letter is the same in the next 4 buttons but on the same y value
				if (boardButtons[y][x].getText().equals(letter)
						&& boardButtons[y][x + 1].getText().equals(letter)
						&& boardButtons[y][x + 2].getText().equals(letter)
						&& boardButtons[y][x + 3].getText().equals(letter)
						) {
					return true;
				}
			}
		}
		return false;
	}


	private boolean checkVerticalWin(String letter) {

		//Checks for the y variable in the rows length-3 to make sure its length is 4(since its connect 4)
		for (int y = 0; y < boardButtons.length - 3; y++) {
			for (int x = 0; x < boardButtons[y].length; x++) { //Goes through every x button (columns) in y to make sure its checking each column length which is 1

				//This checks if the y letter is the same in the next 4 buttons but on the same x value
				if (boardButtons[y][x].getText().equals(letter)
						&& boardButtons[y + 1][x].getText().equals(letter)
						&& boardButtons[y + 2][x].getText().equals(letter)
						&& boardButtons[y + 3][x].getText().equals(letter)
						) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonalToTheLeftWin(String letter) {
		for (int y = 0; y < boardButtons.length - 3; y++) {
			for (int x = 0; x < boardButtons[y].length - 3; x++) {
				if (boardButtons[y][x].getText().equals(letter)
						&& boardButtons[y + 1][x + 1].getText().equals(letter)
						&& boardButtons[y + 2][x + 2].getText().equals(letter)
						&& boardButtons[y + 3][x + 3].getText().equals(letter)
						) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonalToTheRightWin(String letter) {
		for (int y = 0; y < boardButtons.length - 3; y++) {
			for (int x = 3; x < boardButtons[y].length; x++) {
				if (boardButtons[y][x].getText().equals(letter)
						&& boardButtons[y + 1][x - 1].getText().equals(letter)
						&& boardButtons[y + 2][x - 2].getText().equals(letter)
						&& boardButtons[y + 3][x - 3].getText().equals(letter)
						) {
					return true;
				}
			}
		}
		return false;
	}

	public Connect4() {
		window.setSize(500,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setLayout(new GridLayout(1,7));
		myPanelB.setLayout(new GridLayout(6,7));
		for (int i = 0; i < topButtons.length; i ++){
			topButtons[i] = new JButton();
			myPanel.add(topButtons[i]);

			topButtons[i].setBackground(Color.blue.darker());
			topButtons[i].setOpaque(true);
			topButtons[i].setBorderPainted(true);
			InnerActionListener listener = new InnerActionListener();
			topButtons[i].addActionListener(listener);
		}
		for (int y = 0; y < 6; y ++){
			for (int x = 0; x < 7; x ++){
				boardButtons[y][x] = new JButton();
				myPanelB.add(boardButtons[y][x]);
			}
		}
		window.add(myPanel, BorderLayout.NORTH);
		window.add(myPanelB, BorderLayout.CENTER);
		window.setVisible(true);
	}

	class InnerActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			playersTurn++;

			if (playersTurn % 2 == 0) {
				letter = "O";
			}
			else {
				letter = "X";
			}

			//This gets what button at the top is clicked and then reduces the count of buttons below after it is occupied by the set letter
			if (e.getSource() == topButtons[0]){

				boardButtons[column1][0].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column1][0].setBackground(Color.yellow);
					boardButtons[column1][0].setForeground(Color.yellow);
					boardButtons[column1][0].setOpaque(true);
					boardButtons[column1][0].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column1][0].setBackground(Color.red);
					boardButtons[column1][0].setForeground(Color.red);
					boardButtons[column1][0].setOpaque(true);
					boardButtons[column1][0].setBorder(BorderFactory.createEtchedBorder());
				}
				column1--;
			}
			if (e.getSource() == topButtons[1]){
				boardButtons[column2][1].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column2][1].setBackground(Color.yellow);
					boardButtons[column2][1].setForeground(Color.yellow);
					boardButtons[column2][1].setOpaque(true);
					boardButtons[column2][1].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column2][1].setBackground(Color.red);
					boardButtons[column2][1].setForeground(Color.red);
					boardButtons[column2][1].setOpaque(true);
					boardButtons[column2][1].setBorder(BorderFactory.createEtchedBorder());    
				}
				column2--;
			}
			if (e.getSource() == topButtons[2]){
				boardButtons[column3][2].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column3][2].setBackground(Color.yellow);
					boardButtons[column3][2].setForeground(Color.yellow);
					boardButtons[column3][2].setOpaque(true);
					boardButtons[column3][2].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column3][2].setBackground(Color.red);
					boardButtons[column3][2].setForeground(Color.red);
					boardButtons[column3][2].setOpaque(true);
					boardButtons[column3][2].setBorder(BorderFactory.createEtchedBorder());    
				}
				column3--;
			}
			if (e.getSource() == topButtons[3]){
				boardButtons[column4][3].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column4][3].setBackground(Color.yellow);
					boardButtons[column4][3].setForeground(Color.yellow);
					boardButtons[column4][3].setOpaque(true);
					boardButtons[column4][3].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column4][3].setBackground(Color.red);
					boardButtons[column4][3].setForeground(Color.red);
					boardButtons[column4][3].setOpaque(true);
					boardButtons[column4][3].setBorder(BorderFactory.createEtchedBorder());    
				}
				column4--;
			}
			if (e.getSource() == topButtons[4]){
				boardButtons[column5][4].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column5][4].setBackground(Color.yellow);
					boardButtons[column5][4].setForeground(Color.yellow);
					boardButtons[column5][4].setOpaque(true);
					boardButtons[column5][4].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column5][4].setBackground(Color.red);
					boardButtons[column5][4].setForeground(Color.red);
					boardButtons[column5][4].setOpaque(true);
					boardButtons[column5][4].setBorder(BorderFactory.createEtchedBorder());    
				}
				column5--;
			}
			if (e.getSource() == topButtons[5]){
				boardButtons[column6][5].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column6][5].setBackground(Color.yellow);
					boardButtons[column6][5].setForeground(Color.yellow);
					boardButtons[column6][5].setOpaque(true);
					boardButtons[column6][5].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column6][5].setBackground(Color.red);
					boardButtons[column6][5].setForeground(Color.red);
					boardButtons[column6][5].setOpaque(true);
					boardButtons[column6][5].setBorder(BorderFactory.createEtchedBorder());    
				}
				column6--;
			}
			if (e.getSource() == topButtons[6]){
				boardButtons[column7][6].setText(letter);
				if (letter.equals("X")) {
					boardButtons[column7][6].setBackground(Color.yellow);
					boardButtons[column7][6].setForeground(Color.yellow);
					boardButtons[column7][6].setOpaque(true);
					boardButtons[column7][6].setBorder(BorderFactory.createEtchedBorder());
				}
				if (letter.equals("O")) {
					boardButtons[column7][6].setBackground(Color.red);
					boardButtons[column7][6].setForeground(Color.red);
					boardButtons[column7][6].setOpaque(true);
					boardButtons[column7][6].setBorder(BorderFactory.createEtchedBorder());    
				}
				column7--;
			}

			//Makes it so the buttons at the top isn't clickable after its columns is full
			if (boardButtons[0][0].getText().equals("O") || boardButtons[0][0].getText().equals("X")){
				topButtons[0].setEnabled(false);
			}
			if (boardButtons[0][1].getText().equals("O") || boardButtons[0][1].getText().equals("X")){
				topButtons[1].setEnabled(false);
			}
			if (boardButtons[0][2].getText().equals("O") || boardButtons[0][2].getText().equals("X")){
				topButtons[2].setEnabled(false);
			}
			if (boardButtons[0][3].getText().equals("O") || boardButtons[0][3].getText().equals("X")){
				topButtons[3].setEnabled(false);
			}
			if (boardButtons[0][4].getText().equals("O") || boardButtons[0][4].getText().equals("X")){
				topButtons[4].setEnabled(false);
			}
			if (boardButtons[0][5].getText().equals("O") || boardButtons[0][5].getText().equals("X")){
				topButtons[5].setEnabled(false);
			}                       

			if (boardButtons[0][6].getText().equals("O") || boardButtons[0][6].getText().equals("X")){
				topButtons[6].setEnabled(false);
			}

			if (checkHorizontalWin(letter) || checkVerticalWin(letter) || 
					checkDiagonalToTheLeftWin(letter) || checkDiagonalToTheRightWin(letter)) 
			{ 
				if (letter == "X") {
					letter = "Player 1";
				}
				else if (letter == "O") {
					letter = "Player 2";
				}

				JOptionPane.showMessageDialog(null, letter + " has won!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
				int response =  JOptionPane.showConfirmDialog(null, "Do you want to restart?", "Restart?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					restartGame();
				}
				if (response == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				if (response == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				}

				//needs to be for only the top row of the boards; so if all top rows are filled up, its a tie
			} else if ((boardButtons[0][6].getText().equals("X") || boardButtons[0][6].getText().equals("O")) 
					&& (boardButtons[0][5].getText().equals("X") || boardButtons[0][5].getText().equals("O"))
					&& (boardButtons[0][4].getText().equals("X") || boardButtons[0][4].getText().equals("O"))
					&& (boardButtons[0][3].getText().equals("X") || boardButtons[0][3].getText().equals("O"))
					&& (boardButtons[0][2].getText().equals("X") || boardButtons[0][2].getText().equals("O"))
					&& (boardButtons[0][1].getText().equals("X") || boardButtons[0][1].getText().equals("O"))
					&& (boardButtons[0][0].getText().equals("X") || boardButtons[0][0].getText().equals("O"))

					&& (!checkHorizontalWin(letter) && !checkVerticalWin(letter) && !checkDiagonalToTheLeftWin(letter)
							&& !checkDiagonalToTheRightWin(letter)) ) {

				JOptionPane.showMessageDialog(null, "It's a Tie!", "Tie!", JOptionPane.INFORMATION_MESSAGE);
				int response =  JOptionPane.showConfirmDialog(null, "Do you want to restart?", "Restart?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					restartGame();
				}
				if (response == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				if (response == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				}
			}
		} 
		private void restartGame () {
			new Connect4();
		}
	}

	public static void main(String[] args){
		new Connect4();
	}
}