package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3798756492486554276L;
	private Image screenImage;
	private Graphics screenGraphic;
	
		//배경화면
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));		

	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;

	public DynamicBeat(){
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			
			// 마우스가 올라가면 이미지파일을 바꿔줌
			@Override
			public void mouseEntered(MouseEvent e){
				exitButton.setIcon(exitButtonEnteredImage);
				//가까이 갔을때 손가락모양으로 바뀌도록 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				exitButton.setIcon(exitButtonBasicImage);
				//나왔을때 손가락 커서 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music ButtonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				ButtonEnteredMusic.start();
				try{
					Thread.sleep(1000);
				} catch(InterruptedException ex){
					ex.printStackTrace();
				}
				
				//시스템 꺼짐
				System.exit(0);
			}		
		});

		add(exitButton);
		
		// 버튼보다 메뉴바가 아래에 있어야 버튼이 덮히지 않음
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		//메뉴바를 잡고 이동시킬수 있게 함
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e){
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
				
		//인트로뮤직 실행
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	public void paint(Graphics g){
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage,  0, 0, null);
	}
	
	public void screenDraw(Graphics g ) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
		
	}
	
}
