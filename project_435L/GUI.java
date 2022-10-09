package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class GUI extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel welcome;
	private JPanel level;
	private JPanel level_2;
	private JPanel level_3;
	private Timer timer;
	private JLabel expression;
	private JTextField answer;
	private Integer speed;
	private boolean success;
	Thread game;

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
		
		welcome = new JPanel();
		layeredPane.add(welcome, "name_191376728969100");
		welcome.setLayout(null);
		
		JLabel title = new JLabel("Welcome");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		title.setBounds(191, 10, 127, 39);
		welcome.add(title);
		
		//JButton btnLevelOne = createLevelButton()
		JButton btnLevelOne = new JButton("Level 1");
		btnLevelOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelOne.setBounds(212, 140, 85, 21);
		welcome.add(btnLevelOne);
		btnLevelOne.addActionListener(e -> goToPage(level, 1));
		
		JButton btnLevelTwo = new JButton("Level 2");
		btnLevelTwo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLevelTwo.setBounds(212, 184, 85, 21);
		welcome.add(btnLevelTwo);
		btnLevelTwo.addActionListener(e -> goToPage(level, 2));
		
//		JButton btnLevelThree = new JButton("Level 3");
//		btnLevelThree.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnLevelThree.setBounds(212, 226, 85, 21);
//		welcome.add(btnLevelThree);
//		btnLevelThree.addActionListener(e -> goToPage(level_3));
		
		level = new JPanel();
		layeredPane.add(level, "name_191379713788000");
		level.setLayout(null);
		
		JLabel title_1 = new JLabel("Level 1");
		title_1.setHorizontalAlignment(SwingConstants.CENTER);
		title_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		title_1.setBounds(373, 10, 127, 39);
		level.add(title_1);

		JButton btnWelcomeOne = new JButton("Home");
		btnWelcomeOne.setBounds(10, 10, 65, 21);
		btnWelcomeOne.addActionListener(e -> goToWelcome());
		level.add(btnWelcomeOne);
		
		expression = new JLabel("1+1");
		expression.setFont(new Font("Tahoma", Font.PLAIN, 16));
		expression.setHorizontalAlignment(SwingConstants.CENTER);
		expression.setBounds(176, 12, 138, 39);
		level.add(expression);
		
		
		answer = new JTextField();
		answer.setBounds(202, 304, 96, 19);
		level.add(answer);
		answer.setColumns(10);
		
		Integer correct = 3;//don't forget to remove that
//		answer.addActionListener(e -> checkAnswer(Integer.parseInt(answer.getText()),correct));

		
		timer = new Timer(5, e -> randomDrop(expression));
           
                 
            
		
	}

	private void checkAnswer(Integer expected, Integer actual) {
//		try {
			if(actual.equals(expected)) {
				System.out.println("SUccessssssssssssssssssssssssssss");
				success = true;
			}
//		}finally {
		
		this.answer.setText("");
//		}
		
	}

	private void randomDrop(JLabel label) {
		label.setLocation(label.getLocation().x, label.getLocation().y+speed); 
		
	}
	
	private void resetToTop(JLabel label) {
		Random random = new Random();
		label.setLocation(random.nextInt(300), 0); 
		
	}
	
	

	private void goToPage(JPanel page) {
		layeredPane.removeAll();
		layeredPane.add(page);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	private void goToPage(JPanel page, Integer speed) {
		layeredPane.removeAll();
		layeredPane.add(page);
		layeredPane.repaint();
		layeredPane.revalidate();
		this.speed = speed;
		game = new Thread(() -> {
			startGame();
		});
		game.start();
		
	}
	
	private void goToWelcome() {
		System.out.println("deded");
		game.stop();
		layeredPane.removeAll();
		layeredPane.add(welcome);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private void startGame() { //Integer levelNumber) {
		System.out.println("in");
		Integer score = 0;
		timer.start();
		Calculator calc = new Calculator(1);
		calc.GenerateExpressionList(10);
		Map<String,Integer> testMap = calc.getExpMap();
		
		for (Map.Entry<String,Integer> entry : testMap.entrySet())  {
			success = false;
			answer.addActionListener(e -> checkAnswer(Integer.parseInt(answer.getText()),entry.getValue()));
			System.out.println("in for loop");
			this.expression.setText(entry.getKey());
			int i = 0;
			while(expression.getLocation().y <= 320) {
				//System.out.println(success);
				if(success) {
					//System.out.print("################");
					score++;
					break;
				}
			}
			resetToTop(expression);
            
			System.out.println("reset");
		}
		timer.stop();
		System.out.println(score);
		
	}
}
