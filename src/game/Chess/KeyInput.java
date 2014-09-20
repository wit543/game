package game.Chess;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyInput implements KeyListener{
	//input from keyboard and return to string
    String keyboardInString() throws IOException{
	
     BufferedReader stdin =
             new BufferedReader (new
                 InputStreamReader(System.in));
	return stdin.readLine();
	
    }
    //input from keyboard and return to double
    double keyboardInInt() throws IOException{
	
    	BufferedReader stdin =
             new BufferedReader (new
                 InputStreamReader(System.in));	     
     return Double.parseDouble(stdin.readLine());
	
    }
	
	public void keyPressed(KeyEvent e) {
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}
}
