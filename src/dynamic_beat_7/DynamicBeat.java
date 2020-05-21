package dynamic_beat_7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	//�� ���� �κ� ���� ����
	private Image titleImage; 
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
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
		
		//��Ʈ�ι��� ����
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		//Ʈ�� ����Ʈ �߰�
		trackList.add(new Track("Mighty Love Title Image.png", "Mighty Love Start Image.png", 
				"Mighty Love Game Image.jpg", "Mighty Love Selected.mp3", "Joakim Karud - Mighty Love.mp3"));
		trackList.add(new Track("Wild Flower Title Image.png", "Wild Flower Start Image.png", 
				"Wild Flower Game Image.jpg", "Wild Flower Selected.mp3", "Joakim Karud - Wild Flower.mp3"));
		trackList.add(new Track("Energy Title Image.png", "Energy Start Image.png", 
				"Energy Game Image.png", "Energy Selected.mp3", "Bensound - Energy.mp3"));
		
		
		
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
				introMusic.close();
				//���� �ʱ�ȭ
				selectTrack(0);
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
		leftButton.setVisible(false);
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
				selectLeft();
			}		
		});

		add(leftButton);
		
		//right��ư �κ�
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
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
				selectRight();
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
			g.drawImage(titleImage, 340, 70, null);
		}
		
		paintComponents(g);
		this.repaint();
		
	}
	
	public void selectTrack(int nowSelected){
		 if(selectedMusic != null)
			 selectedMusic.close();
		 titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		 selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		 selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		 selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0){
			nowSelected = trackList.size() - 1;
		} else{
			nowSelected--;
			selectTrack(nowSelected);
		}
		
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() -1){
			nowSelected = 0;
		} else{
			nowSelected++;
			selectTrack(nowSelected);
		}
		
	}
	
}
