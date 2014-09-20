package game.Chess;

public class Check {
	//checking if king die or not and defind who win
    int checkKing(){
        int Break=0;
        boolean black=false;
        boolean white=false;        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((Board.board[i][j].characteristic[3]==6)&&(Board.board[i][j].characteristic[2]==1)){
                    black=true;
                    break;
                }                
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((Board.board[i][j].characteristic[3]==6)&&(Board.board[i][j].characteristic[2]==0)){
                    white=true;
                    break;
                }                
            }
        }
        if(black==false){
            System.out.println("White win");
            Break=1;
        }
        if(white==false){
            System.out.println("Black win");
            Break=1;
        }
        return Break;
    }
}
