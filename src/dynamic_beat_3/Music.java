package dynamic_beat_3;

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
	
	//현재 실행되는 음악의 실행위치를 알려줌
	public int getTime(){
		if (player == null){
			return 0;}else{
		return player.getPosition();
			}
	}
	
	//음악을 종료핤 수 있도록 해주는 함수
	public void close(){
		isLoop = false;
		player.close();
		
		//해당 쓰레드를 준비상태로 해줌
		this.interrupt();
	
		}
	
	@Override
	public void run(){
		try{
			do{
			//곡을 실행시킴
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
