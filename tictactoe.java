package hickman_tictactoe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class tictactoe extends JFrame implements ActionListener {
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private JPanel gbPanel;

	private JLabel whoWins; 
	
	private JButton button[] = new JButton[9];
	private JButton resetButton; 
	
	// display the buttons as images
	//private JLabel xLabel;
	//private JLabel oLabel;
	//private ImageIcon xIcon;
	//private ImageIcon oIcon;
	
	
	private game tttGame; 
	private  int gameCount=0;
	
	
	// CREATE AND DISPLAY THE GUI BOARD FOR THE GAME
	public tictactoe()	{
		buildBoard();
		addToPanel();
		displayBoard();
		
		this.add(gbPanel, BorderLayout.CENTER);
		this.add(whoWins, BorderLayout.NORTH);
		this.add(resetButton, BorderLayout.SOUTH);	}
	
	private void displayBoard() {  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Tic-Tac-Toe"); }
	
	
	
	// MAKE GAME BOARD 
	private void buildBoard()	{
		tttGame = new game(true, false); 
		gbPanel = new JPanel(); 
		gbPanel.setLayout(new GridLayout(3,3));
		whoWins = new JLabel("", SwingConstants.CENTER);
		
		
		for (int i = 0; i < 9; i++) {
			button[i] = new JButton(""); 
			button[i].addActionListener(this);
			button[i].setFocusPainted(false);	}
		
		
		//resetButton.setForeground(Color.RED);
		resetButton = new JButton("Click here to play again!"); 
		resetButton.addActionListener(this);
		resetButton.setFocusPainted(false);	}
	
	
	
	
	// ADD THE BUTTONS TO THE GUI
	private void addToPanel(){
		for (int i = 0; i < button.length; i++) {
			gbPanel.add(button[i]);		}}
	
	
	/* DETERMINE THE WINNER BASED ON HOW MANY TIMES THE BUTTONS HAVE BEEN CLICKED
	 * THE WINNER IS THEN CHOSEN AND ASSIGNED TO THE WINNER VARIABLE TO BE DISPLAYED FOR THE USERS	*/
	public void actionPerformed(ActionEvent e){
		
		/* attempt at making the letters into image icons
		ImageIcon xIcon = new ImageIcon("buttons\\xbutton.png");
		ImageIcon oIcon = new ImageIcon("buttons\\obutton.png");
		
		for (int i = 0; i < button.length; i++) {
			
			if(button[i]==e.getSource()){
				
				if(tttGame.isPlayerOne()){
					button[i].setIcon(xIcon);
					
					tttGame.setPlayerOne(false);
					tttGame.setPlayerTwo(true);	}
				
				else {	button[i].setIcon(oIcon);
					tttGame.setPlayerOne(true);
					tttGame.setPlayerTwo(false);	}
				
				gameCount++; 
				button[i].setEnabled(false);	}}*/
		
		for (int i = 0; i < button.length; i++) {
			
			if(button[i]==e.getSource()){
				
				if(tttGame.isPlayerOne()){
					button[i].setText("X");
					tttGame.setPlayerOne(false);
					tttGame.setPlayerTwo(true);	}
				
				else {	button[i].setText("O");
					tttGame.setPlayerOne(true);
					tttGame.setPlayerTwo(false);	}
				
				gameCount++; 
				button[i].setEnabled(false);	}}

		Boolean winner = tttGame.operation(button);
		
		if(winner){
			whoWins.setText("Congratulations, player " + tttGame.winner + " won the game!");
			
			for (int i = 0; i < button.length; i++) {
				button[i].setEnabled(false);	}}
		
		else if(gameCount==9){
			whoWins.setText("No winner, play again!");	}
		
		if(e.getSource() == resetButton){
			resetTheGame();}}
	
	
	
	
	
	// RESET THE GAME USING THE RESET BUTTON
	public void resetTheGame(){
		
		for (int i = 0; i < button.length; i++) {
			button[i].setText("");
			button[i].setEnabled(true);
			button[i].setBackground(null);	}
		
		whoWins.setText("");
		gameCount=0;	}
	
	
	
	
	
	// A CLASS TO SET UP THE PLAYERS AND DETERMINE THE WINNERS BASED ON BUTTON CLICKS,
	// USING MULTIPLE IF STATEMENTS TO DETERMINE HOW THE USER WINS
	public class game {
		
		String winner; 
		public boolean playerOne , playerTwo; 
		
		public game(boolean playerOne, boolean playerTwo) {
			this.playerOne = playerOne;
			this.playerTwo = playerTwo;	}

		public boolean isPlayerOne() {
			return playerOne;	}
			
		public void setPlayerOne(boolean playerOne) {
			this.playerOne = playerOne;	}
		
		public boolean isPlayerTwo() {
			return playerTwo;	}
		
		public void setPlayerTwo(boolean playerTwo) {
			this.playerTwo = playerTwo;	}
		

		
		// USE (a LOT) IF STATEMENTS TO DETERMINE WINNERS
		public boolean operation(JButton[] button) {
			
			if		(button[0].getText().equalsIgnoreCase("O") && 
					button[1].getText().equalsIgnoreCase("O")&&
					button[2].getText().equalsIgnoreCase("O")) {
						winner = "(O)";
						return true; }
			
			
			if		(button[0].getText().equalsIgnoreCase("O") && 
					button[3].getText().equalsIgnoreCase("O") &&
					button[6].getText().equalsIgnoreCase("O")) {
						winner = "(O)";
						return true; }
			
			
			if		(button[0].getText().equalsIgnoreCase("O") && 
					button[4].getText().equalsIgnoreCase("O") &&
					button[8].getText().equalsIgnoreCase("O")) {
						winner = "(O)";
						return true; }
			
			
			if		(button[1].getText().equalsIgnoreCase("O") && 
					button[4].getText().equalsIgnoreCase("O") &&
					button[7].getText().equalsIgnoreCase("O"))	{
						winner = "(O)";
						return true;	}
			
			
			if		(button[2].getText().equalsIgnoreCase("O") && 
					button[5].getText().equalsIgnoreCase("O") &&
					button[8].getText().equalsIgnoreCase("O"))	{
						winner = "(O)";
						return true;	}
			
			
			if		(button[2].getText().equalsIgnoreCase("O") && 
					button[4].getText().equalsIgnoreCase("O") &&
					button[6].getText().equalsIgnoreCase("O"))	{
						winner = "(O)";
						return true;	}
			
			
			if		(button[3].getText().equalsIgnoreCase("O") && 
					button[4].getText().equalsIgnoreCase("O") &&
					button[5].getText().equalsIgnoreCase("O"))	{
						winner = "(O)";
						return true;	}
			
			
			if		(button[6].getText().equalsIgnoreCase("O") && 
					button[7].getText().equalsIgnoreCase("O") &&
					button[8].getText().equalsIgnoreCase("O"))	{
						winner = "(O)";
						return true;	}
			
			
			if		(button[0].getText().equalsIgnoreCase("X") && 
					button[1].getText().equalsIgnoreCase("X") &&
					button[2].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			if		(button[0].getText().equalsIgnoreCase("X") && 
					button[3].getText().equalsIgnoreCase("X") &&
					button[6].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			if		(button[0].getText().equalsIgnoreCase("X") && 
					button[4].getText().equalsIgnoreCase("X") &&
					button[8].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			if		(button[1].getText().equalsIgnoreCase("X") && 
					button[4].getText().equalsIgnoreCase("X") &&
					button[7].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			if		(button[2].getText().equalsIgnoreCase("X") && 
					button[5].getText().equalsIgnoreCase("X") &&
					button[8].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			if		(button[2].getText().equalsIgnoreCase("X") && 
					button[4].getText().equalsIgnoreCase("X") &&
					button[6].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			if		(button[3].getText().equalsIgnoreCase("X") && 
					button[4].getText().equalsIgnoreCase("X") &&
					button[5].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			if		(button[6].getText().equalsIgnoreCase("X") && 
					button[7].getText().equalsIgnoreCase("X") &&
					button[8].getText().equalsIgnoreCase("X"))	{
						winner = "(X)";
						return true;	}
			
			
			return false;	}}
	
	
	public static void main(String[] args) {
		new tictactoe(); 					}
	
}