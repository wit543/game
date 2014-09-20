package game.Chess;

import java.io.IOException;

public class Input extends KeyInput{
	public String humanInput(){
		String input = "invalid";
		input = GameLoop.input;
		return input;
	}
    public String aiInput(){
		String input = "invalid";
		try {
			 input =keyboardInString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("invalid");
		}
		return input;
	}
}
