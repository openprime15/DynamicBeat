package dynamic_beat_6;

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

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	//���ʿ����ʹ�ư
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));	
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));	
	
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Mighthy Love Start Image.jpg")).getImage();
		//���ȭ��
	private Image background = new ImageIcon(Main.class.getResource("../images/IntroBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));		

	

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	//���ʿ����� ��ư
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);	
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;

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
			
			// ���콺�� �ö󰡸� �̹��������� �ٲ���
			@Override
			public void mouseEntered(MouseEvent e){
				exitButton.setIcon(exitButtonEnteredImage);
				//������ ������ �հ���������� �ٲ�� ����
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				exitButton.setIcon(exitButtonBasicImage);
				//�������� �հ��� Ŀ�� ����
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
				
				//�ý��� ����
				System.exit(0);
			}		
		});

		add(exitButton);
		
		//startbutton �κ�
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			
			// ���콺�� �ö󰡸� �̹��������� �ٲ���
			@Override
			public void mouseEntered(MouseEvent e){
				startButton.setIcon(startButtonEnteredImage);
				//������ ������ �հ���������� �ٲ�� ����
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				startButton.setIcon(startButtonBasicImage);
				//�������� �հ��� Ŀ�� ����
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music ButtonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				ButtonEnteredMusic.start();
				 // ���� ���� �̺�Ʈ
				startButton.setVisible(false);
				quitButton.setVisible(false);
				//���� ������ ��ư ���̱�
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}		
		});

		add(startButton);
		
		//quitbutton �κ�
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			
			// ���콺�� �ö󰡸� �̹��������� �ٲ���
			@Override
			public void mouseEntered(MouseEvent e){
				quitButton.setIcon(quitButtonEnteredImage);
				//������ ������ �հ���������� �ٲ�� ����
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				quitButton.setIcon(quitButtonBasicImage);
				//�������� �հ��� Ŀ�� ����
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
				
				//�ý��� ����
				System.exit(0);
			}		
		});

		add(quitButton);
		
		//left��ư �κ�
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			
			// ���콺�� �ö󰡸� �̹��������� �ٲ���
			@Override
			public void mouseEntered(MouseEvent e){
				leftButton.setIcon(leftButtonEnteredImage);
				//������ ������ �հ���������� �ٲ�� ����
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				leftButton.setIcon(leftButtonBasicImage);
				//�������� �հ��� Ŀ�� ����
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music ButtonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				ButtonEnteredMusic.start();
				//���� ��ư �̺�Ʈ
			}		
		});

		add(leftButton);
		
		//right��ư �κ�
		rightButton.setBounds(140, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			
			// ���콺�� �ö󰡸� �̹��������� �ٲ���
			@Override
			public void mouseEntered(MouseEvent e){
				rightButton.setIcon(rightButtonEnteredImage);
				//������ ������ �հ���������� �ٲ�� ����
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				ButtonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				rightButton.setIcon(rightButtonBasicImage);
				//�������� �հ��� Ŀ�� ����
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music ButtonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				ButtonEnteredMusic.start();
				//������ ��ư �̺�Ʈ
			}		
		});

		add(rightButton);
		
		
		
		// ��ư���� �޴��ٰ� �Ʒ��� �־�� ��ư�� ������ ����
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		//�޴��ٸ� ��� �̵���ų�� �ְ� ��
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e){
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
				
		//��Ʈ�ι��� ����
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
		g.drawImage(background, 0, 0, null);
		if(isMainScreen){
			g.drawImage(selectedImage, 340, 100, null);
		}
		
		paintComponents(g);
		this.repaint();
		
	}
	
}