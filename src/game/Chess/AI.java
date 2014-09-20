package game.Chess;

import java.util.ArrayList;
import java.util.Random;

public class AI {
	int[] analyze(){
        return null;
    }
    //find all the ai pieces
    int[][] scan(int aiColor){
        int[][] list = new int[16][2];
        int count=0;
        for(int i = 0; i<8;i++){
            for(int j = 0; j<8;j++){
                if(Board.board[i][j].characteristic[2]==aiColor){
                    
                    list[count][0] =Board.board[i][j].characteristic[0];
                    list[count][1] =Board.board[i][j].characteristic[1];

                    count++;
                }
             }
        }
       

        return list;
    }
    //input fromX fromY intoX intoY
    int[][] simulation(int x, int y){
        Logic i = new Logic();
        
        int[] move = new int[4];
        int[][] pass = new int[64][4];
        int count = 0;
        
        move[0]=x;
        move[1]=y;
        for(int j=0;j<8;j++){
             for(int k=0;k<8;k++){
                 move[2]=j;
                 move[3]=k;
                 int[] answer=i.test(move);
                if(answer[4]==1){
                    pass[count][0]=x;
                    pass[count][1]=y;
                    pass[count][2]=j;
                    pass[count][3]=k;
                    count++;
                }
             }
        }
        return pass;
    }
    //find point of each piece
    int point(int x, int y){
        return Board.board[x][y].characteristic[4];
    }
    int[] ai(int aiColor){
        Random random = new Random();
        AI a = new AI();
        int[][] l = a.scan(aiColor);//find all ai pieces
        int[][][] p = new int[16][64][4];
        ArrayList<Integer> fromX = new ArrayList<>();
        ArrayList<Integer> fromY = new ArrayList<>();
        ArrayList<Integer> toX = new ArrayList<>();
        ArrayList<Integer> toY = new ArrayList<>();
        
        

        
        int count = 0;
        int countT = 0;
        int point = 0;
        int move[] = new int[5];
        
        //simulate the posible move
        for(int i = 0; i<16;i++){
                int[][] o=a.simulation(l[i][0], l[i][1]);
                for(int j = 0; j<o.length;j++){
                    p[count][j][0]=o[j][0];
                    p[count][j][1]=o[j][1];
                    p[count][j][2]=o[j][2];
                    p[count][j][3]=o[j][3];
                    
                    
                }
                count++;
        }
        //defind point for each move
        for(int i = 0;i <16;i++){
            for(int j = 0;j <64;j++){
                /*
                if(((p[i][j][0]!=0)||(p[i][j][1]!=0)&&(p[i][j][2]!=0)&&(p[i][j][3]!=0))){
                System.out.print(p[i][j][0]);
                System.out.print(p[i][j][1]);
                System.out.print(p[i][j][2]);
                System.out.print(p[i][j][3]);
                System.out.println();
                System.out.println(a.point(p[i][j][2],p[i][j][3]));
                }
                */
                if((a.point(p[i][j][2],p[i][j][3])>point)&&(p[i][j][0]==0&&p[i][j][1]==0&&p[i][j][2]==0&&p[i][j][3]==0)==false){
                /*
                System.out.print(p[i][j][2]);
                System.out.print(" ");
                System.out.println(p[i][j][3]);
                System.out.println(a.point(p[i][j][2],p[i][j][3]));*/
                move[0]=p[i][j][0];
                move[1]=p[i][j][1];
                move[2]=p[i][j][2];
                move[3]=p[i][j][3];
                move[4]=1;
                }
            }
            
        }
        // if the move is not eating any thing
        while(move[4]==0){
                    
                    for(int i = 0;i <16;i++){
                        for(int j = 0;j <64;j++){
                            if(p[i][j][0]!=0&&p[i][j][1]!=0&&p[i][j][2]!=0&&p[i][j][3]!=0){
                            fromX.add(p[i][j][0]);
                            fromY.add(p[i][j][1]);
                            toX.add(p[i][j][2]);
                            toY.add(p[i][j][3]);
                            countT++;
                            }
                        }
                    }
                    
                    int[][] compile = new int[fromX.size()][5];
                    for(int i = 0; i <fromY.size();i++){
                        compile[i][0]=fromX.get(i);
                        compile[i][1]=fromY.get(i);
                        compile[i][2]=toX.get(i);
                        compile[i][3]=toY.get(i);
                        /*
                        System.out.print(compile[i][0]);
                        System.out.print(" ");
                        System.out.print(compile[i][1]);
                        System.out.print(" ");
                        System.out.print(compile[i][2]);
                        System.out.print(" ");
                        System.out.print(compile[i][3]);
                        System.out.println();
                        */
                    }                  
                    int ran = random.nextInt(compile.length);
                    move[0]=compile[ran][0];
                    move[1]=compile[ran][1];
                    move[2]=compile[ran][2];
                    move[3]=compile[ran][3];
                    
                    //move = compile[random.nextInt(compile.length)];
                    move[4]=1;
                    
                    break;
                
                    }
            
        
         /*
         for(int i = 0;i <fromX.size();i++){
                System.out.print(fromX.get(i));
                System.out.print(" ");
                System.out.print(fromY.get(i));
                System.out.print(" ");
                System.out.print(toX.get(i));
                System.out.print(" ");
                System.out.println(toY.get(i));
         }
                System.out.print(move[0]);
                System.out.print(" ");
                System.out.print(move[1]);
                System.out.print(" ");
                System.out.print(move[2]);
                System.out.print(" ");
                System.out.print(move[3]);
                System.out.print(" ");
                System.out.println(move[4]);
        */
        /*
        for(int i = 0;i <15;i++){
            for(int j = 0;j <64;j++){
                System.out.print(p[i][j][0]);
                System.out.print(" ");
                System.out.print(p[i][j][1]);
                System.out.print(" ");
                System.out.print(p[i][j][2]);
                System.out.print(" ");
                System.out.println(p[i][j][3]);

            }
        }
                */ 
               return move;
    }
    int[] aiLevel(int aiColor,int level,int[] aiMove){
        AI a = new AI();

        int[][][] p = new int[16][64][4];
        ArrayList<Integer> fromX = new ArrayList<>();
        ArrayList<Integer> fromY = new ArrayList<>();
        ArrayList<Integer> toX = new ArrayList<>();
        ArrayList<Integer> toY = new ArrayList<>();
        
        

        
        int count = 0;
        int countT = 0;
        int point = 0;
        int move[] = new int[5];
        
        //simulate the posible move
        for(int i = 0; i<16;i++){
                int[][] o=a.simulation(aiMove[0], aiMove[1]);
                for(int j = 0; j<o.length;j++){
                    p[count][j][0]=o[j][0];
                    p[count][j][1]=o[j][1];
                    p[count][j][2]=o[j][2];
                    p[count][j][3]=o[j][3];
                    
                    
                }
                count++;
        }
        //defind point for each move
        for(int i = 0;i <16;i++){
            for(int j = 0;j <64;j++){
                /*
                if(((p[i][j][0]!=0)||(p[i][j][1]!=0)&&(p[i][j][2]!=0)&&(p[i][j][3]!=0))){
                System.out.print(p[i][j][0]);
                System.out.print(p[i][j][1]);
                System.out.print(p[i][j][2]);
                System.out.print(p[i][j][3]);
                System.out.println();
                System.out.println(a.point(p[i][j][2],p[i][j][3]));
                }
                */
                if((a.point(p[i][j][2],p[i][j][3])>point)&&(p[i][j][0]==0&&p[i][j][1]==0&&p[i][j][2]==0&&p[i][j][3]==0)==false){
                /*
                System.out.print(p[i][j][2]);
                System.out.print(" ");
                System.out.println(p[i][j][3]);
                System.out.println(a.point(p[i][j][2],p[i][j][3]));*/
                move[0]=p[i][j][0];
                move[1]=p[i][j][1];
                move[2]=p[i][j][2];
                move[3]=p[i][j][3];
                move[4]=1;
                
                }
                else{
                        
               }
            }
            
        }
       
                System.out.print(move[2]);
                System.out.print(" ");
                System.out.print(move[3]);
                System.out.print(" ");
                System.out.println(move[4]);
   
              
               return move;
        
        
    }
}
