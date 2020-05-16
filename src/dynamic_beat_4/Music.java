package dynamic_beat_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop){
		try{
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" +name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
					
					
		} catch(Exception e){
				System.out.println(e.getMessage());
			  
		}
	}
	
	//���� ����Ǵ� ������ ������ġ�� �˷���
	public int getTime(){
		if (player == null){
			return 0;}else{
		return player.getPosition();
			}
	}
	
	//������ �����A �� �ֵ��� ���ִ� �Լ�
	public void close(){
		isLoop = false;
		player.close();
		
		//�ش� �����带 �غ���·� ����
		this.interrupt();
	
		}
	
	@Override
	public void run(){
		try{
			do{
			//���� �����Ŵ
			player.play();
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			} while (isLoop);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
}