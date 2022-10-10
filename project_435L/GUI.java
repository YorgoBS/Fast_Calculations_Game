package project_435L;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Map;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import java.awt.Color;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel welcome;
	private JPanel level;
	private Timer timer;
	private JLabel expression;
	private JTextField answerField;
	private Integer speed;
	private boolean success;
	private Thread game;
	private boolean home;
	private Integer score;
	private JSlider slider;
	private Integer numberOfExpressions;
	private JSpinner numberOfExpressionsSpinner;
	private JLabel levelName;
	private JLabel scoreLabel;
	private String answer;
	
	class MyChangeListener implements ChangeListener {
	    MyChangeListener() {
	    }

	    public synchronized void stateChanged(ChangeEvent e) {
	      speed = slider.getValue();
	    }
	  }
	
	class SpinnerChangeListener implements ChangeListener {
		SpinnerChangeListener() {
	    }

	    public synchronized void stateChanged(ChangeEvent e) {
	    	
	    	numberOfExpressions = (int)numberOfExpressionsSpinner.getValue() <= 0 ? 0 : (int)numberOfExpressionsSpinner.getValue();
	      
	      
	    }
	  }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_190521186693300");
		layeredPane.setLayout(new CardLayout(0, 0));
		
		
		//Welcome Page
		welcome = new JPanel();
		welcome.setBackground(new Color(224, 255, 255));
		layeredPane.add(welcome, "name_191376728969100");
		welcome.setLayout(null);
		
		JLabel title = new JLabel("Welcome to QuikMafs");
		title.setForeground(new Color(70, 130, 180));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 16));
		title.setBounds(99, 10, 303, 39);
		welcome.add(title);
		
		//Level Buttons
		JButton btnLevelOne = new JButton("Level 1");
		btnLevelOne.setForeground(new Color(240, 248, 255));
		btnLevelOne.setBackground(new Color(100, 149, 237));
		btnLevelOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelOne.setBounds(158, 100, 183, 46);
		welcome.add(btnLevelOne);
		btnLevelOne.addActionListener(e -> goToLevel(1));
		
		JButton btnLevelTwo = new JButton("Level 2");
		btnLevelTwo.setForeground(new Color(240, 255, 240));
		btnLevelTwo.setBackground(new Color(102, 205, 170));
		btnLevelTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelTwo.setBounds(158, 168, 183, 48);
		welcome.add(btnLevelTwo);
		btnLevelTwo.addActionListener(e -> goToLevel(2));
		
		JButton btnLevelThree = new JButton("Level 3");
		btnLevelThree.setForeground(new Color(248, 248, 255));
		btnLevelThree.setBackground(new Color(220, 20, 60));
		btnLevelThree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelThree.setBounds(158, 237, 183, 48);
		welcome.add(btnLevelThree);
		btnLevelThree.addActionListener(e -> goToLevel(3));
		
		//speed slider
		JLabel lblNewLabel = new JLabel("Speed: ");
		lblNewLabel.setBounds(395, 168, 58, 13);
		welcome.add(lblNewLabel);
		slider = new JSlider(SwingConstants.HORIZONTAL,1, 5, 1);
		slider.setBackground(new Color(224, 255, 255));
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
	    slider.setMajorTickSpacing(5);
		slider.setBounds(395, 184, 77, 39);
		welcome.add(slider);
		speed = 1; //shou l wade3
		MyChangeListener lst = new MyChangeListener();
	    slider.addChangeListener(lst);
		int min = 1;
		int max = 20;
		int step = 1;
		int i = 1;
		SpinnerModel value = new SpinnerNumberModel(i, min, max, step);
		numberOfExpressionsSpinner = new JSpinner(value);
		numberOfExpressionsSpinner.setBounds(395, 265, 77, 20);
		welcome.add(numberOfExpressionsSpinner);
		
		JLabel lblNewLabel_1 = new JLabel("Number of");
		lblNewLabel_1.setBounds(395, 237, 77, 13);
		welcome.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Expressions");
		lblNewLabel_2.setBounds(395, 250, 77, 13);
		welcome.add(lblNewLabel_2);
		numberOfExpressions = 1;
		SpinnerChangeListener spn = new SpinnerChangeListener();
		numberOfExpressionsSpinner.addChangeListener(spn);
		
		
		
		
		//Level Page
		level = new JPanel();
		level.setBackground(new Color(224, 255, 255));
		layeredPane.add(level, "name_191379713788000");
		level.setLayout(null);
		
		//Page Title
		levelName = new JLabel("Level");   //Add a level number
		levelName.setHorizontalAlignment(SwingConstants.LEFT);
		levelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		levelName.setBounds(417, 10, 83, 39);
		level.add(levelName);
		
		//Score Label
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scoreLabel.setBounds(417, 59, 83, 13);
		level.add(scoreLabel);

		//Quit Game Button
		JButton btnWelcome = new JButton("Quit Game");
		btnWelcome.setBackground(new Color(240, 128, 128));
		btnWelcome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnWelcome.setBounds(10, 10, 97, 32);
		level.add(btnWelcome);
		btnWelcome.addActionListener(e -> goToWelcome());
		
//		//Quit Game Button
//		JButton start = new JButton("start");
//		start.setBounds(10, 40, 120, 21);
//		level.add( start);
//		start.addActionListener(e -> startGame(1));
//		
		//Falling Expression
		expression = new JLabel();
		expression.setForeground(new Color(139, 0, 139));
		expression.setFont(new Font("Tahoma", Font.BOLD, 16));
		expression.setHorizontalAlignment(SwingConstants.LEFT);
		expression.setBounds(160, 44, 189, 39);
		level.add(expression);
		
		//Answer input box
		answerField = new JTextField();
		answerField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		answerField.setBounds(186, 14, 138, 23);
		level.add(answerField);
		answerField.setColumns(10);

		//Timer for dropping objects
		timer = new Timer(5, e -> randomDrop(expression));
           
                 
            
		
	}

	//checks if input  equals expected answer
	private boolean checkAnswer(Integer actual) {
		try {
		if(answer == null || answer.equals("")) {
			return false;
		}
		else if(actual.equals(Integer.parseInt(answer))) {
			System.out.print("success");
				return true;
		}
		return false;
		}catch(Exception e) {
			
			return false;
		}
		
		
	}

	//Function executed by timer
	private void randomDrop(JLabel label) {
		label.setLocation(label.getLocation().x, label.getLocation().y+speed); 
		
	}
	
	//Return expression to random location at the top
	private void resetToTop(JLabel label) {
		Random random = new Random();
		label.setLocation(random.nextInt(300), 30); 
		
	}
	
	
	//takes to page
	private void goToPage(JPanel page) {
		layeredPane.removeAll();
		layeredPane.add(page);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	//Takes to level page
	private void goToLevel(Integer levelNumber) {
		home = false;
		goToPage(this.level);
		levelName.setText("Level " + levelNumber);
		game = new Thread(() -> {
			startGame(levelNumber);
		});
		game.start();
		
	}
	
	private void goToWelcome() {
//		try {
//			game.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		home = true;
		goToPage(welcome);
		//game.stop();
		
	}
	
	//Starts the game
	private void startGame(Integer level) { 
		score = 0;
		
		Calculator calc = new Calculator(level);
		calc.GenerateExpressionList(numberOfExpressions);
		Map<String,Integer> testMap = calc.getExpMap();
		scoreLabel.setText("Score: " + score + "/" + numberOfExpressions);
		resetToTop(expression);
		timer.start();
		for (Map.Entry<String,Integer> entry : testMap.entrySet())  {
			success = false;
			answerField.addActionListener(e -> updateAnswer(answerField.getText()));
			this.expression.setText(entry.getKey());
			while(expression.getLocation().y <= 320) {
				if(home) {
					timer.stop();
					score = 0;
					break;
				}
				if(checkAnswer(entry.getValue())) {
					score++;
					scoreLabel.setText("Score: " + score + "/" + numberOfExpressions);
					break;
				}
				
			}
			resetToTop(expression);
			if(home) {
				timer.stop();
				break;
			}
		}
		timer.stop();
		displayScore();
		return;
	}

	private void updateAnswer(String text) {
		answer = text;
		this.answerField.setText(null);
	}


	//displays score at the end of the game
	private void displayScore() {
		expression.setLocation(181, 39);
		expression.setText("Your score is: " + score + "/" + numberOfExpressions);
		
	}
}
