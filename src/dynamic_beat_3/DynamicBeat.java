package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -589647124256813842L;
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;

	public DynamicBeat(){
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setVisible(true);
		
		
		//배경화면
		introBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground.jpg")).getImage();
		
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
		this.repaint();
		
	}
	
}
