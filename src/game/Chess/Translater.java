package game.Chess;

public class Translater {
	int[] StringToCode(String Input){
		int IntfromX;
		int IntfromY;
		int InttoX;
		int InttoY;
		int[] output= new int[4];
                    //split the input to array 
		String[] parts = Input.split(" ");
		String part1 = parts[0];
		String part2 = parts[1];
		String[] out1 = part1.split("/");
		String[] out2 = part2.split("/");
		String fromX = out1[0];
		String fromY= out1[1];
		String toX = out2[0];
		String toY = out2[1];
                    IntfromY = 0;
		InttoY = 0;
		
                    //translate from String abcd to int
                String[] out = {" ","a","b","c","d","e","f","g","h"};
		while(IntfromY <9){
                    IntfromY++;
                    if(fromY.equals(out[IntfromY].toString())){
                        break;
                    }
		}
                while(InttoY <9){
			InttoY++;
			if(toY.equals(out[InttoY].toString())){
                            break;
			}
		}
		/*IntfromX = Integer.parseInt(fromX);
		InttoX = Integer.parseInt(toX);
		IntfromX = IntfromX -1;
		IntfromY = IntfromY -1;
		InttoX = InttoX -1;
		InttoY = InttoY -1;
		*/
                
                    //put the result into the array
                IntfromX = Integer.parseInt(fromX);
        		InttoX = Integer.parseInt(toX);
        		output[0] = IntfromX -1;
        		output[1] = IntfromY -1;
        		output[2] = InttoX -1;
        		output[3] = InttoY -1;
        		
		return output;
	}
}
