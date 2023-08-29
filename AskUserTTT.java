package com.pranil.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTacToe2{
	static void showBoard(char board[][]) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	static void insert(int pos,char board[][],char sym) {
		switch(pos) {
		case 1:board[1][1] = sym;
		break;
		case 2:board[1][3] = sym;
		break;
		case 3:board[1][5] = sym;
		break;
		case 4:board[3][1] = sym;
		break;
		case 5:board[3][3] = sym;
		break;
		case 6:board[3][5] = sym;
		break;
		case 7:board[5][1] = sym;
		break;
		case 8:board[5][3] = sym;
		break;
		case 9:board[5][5] = sym;
		break;
		default:System.out.println("Invalid Position!");		      
		}

		if(sym=='X') {
			AskUserTTT.allp1pos.add(pos);
		}
		else if(sym=='O') {
			AskUserTTT.allp2pos.add(pos);
		}
	}
	static void winner(ArrayList allp1pos,ArrayList allp2pos) {
		List toprow = Arrays.asList(1,2,3);
		List midrow = Arrays.asList(4,5,6);
		List botrow = Arrays.asList(7,8,9);
		List leftcol = Arrays.asList(1,4,7);
		List midcol = Arrays.asList(2,5,8);
		List rightcol = Arrays.asList(3,6,9);
		List diag1 = Arrays.asList(1,5,9);
		List diag2 = Arrays.asList(3,5,7);

		if(allp1pos.containsAll(toprow)|| allp1pos.containsAll(midrow)||allp1pos.containsAll(botrow)||
				allp1pos.containsAll(leftcol)||allp1pos.containsAll(midcol)||allp1pos.containsAll(rightcol)||
				allp1pos.containsAll(diag1)||allp1pos.containsAll(diag2)) {
			System.out.println("Player 1 Winner");
			System.exit(0);
		}
		else if(allp2pos.containsAll(toprow)|| allp2pos.containsAll(midrow)||allp2pos.containsAll(botrow)||
				allp2pos.containsAll(leftcol)||allp2pos.containsAll(midcol)||allp2pos.containsAll(rightcol)||
				allp2pos.containsAll(diag1)||allp2pos.containsAll(diag2)) {
			System.out.println("Player 1 Winner");
			System.exit(0);
		}
		else if((allp1pos.size()+allp2pos.size())==9) {
			System.out.println("Game Draw");
			System.exit(0);
		}


	}

}

public class AskUserTTT {

	static ArrayList allp1pos = new ArrayList();
	static ArrayList allp2pos = new ArrayList();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();

		System.out.println("If you want to play single player then press 'Y' ");
		char askUser = sc.nextLine().toUpperCase().charAt(0);
		
        if(askUser=='Y') {
        	int playerPos1,playerPos2;
    		System.out.println("Enter Name of Player1");
    		System.out.print("Player1: ");
    		String p1 = sc.nextLine();

    		System.out.print("Player2: CPU");
    		String p2 = "CPU";

    		char board[][] = {
    				{'_','_','_','_','_','_','_'},
    				{'|',' ','|',' ','|',' ','|'},
    				{'|','-','+','-','+','-','|'},
    				{'|',' ','|',' ','|',' ','|'},
    				{'|','-','+','-','+','-','|'},
    				{'|',' ','|',' ','|',' ','|'},
    				{'-','-','-','-','-','-','-'}};
    		TicTacToe2.showBoard(board);

    		while(true) {
    			System.out.println(p1+"Enter position for X in 0-9");
    			playerPos1 = sc.nextInt();
    			while(allp1pos.contains(playerPos1) || allp2pos.contains(playerPos1) || playerPos1>9) {
    				System.out.println("Position allready Occupied, Re-Enter");
    				playerPos1 = sc.nextInt();
    			}
    			TicTacToe2.insert(playerPos1, board,'X');
    			TicTacToe2.showBoard(board);
    			TicTacToe2.winner(allp1pos, allp2pos);
    			System.out.println("All p1 pos are"+allp1pos);

    			System.out.println(p2+"Enter position for O in 0-9");
    			playerPos2 = rnd.nextInt(9)+1;
    			while(allp1pos.contains(playerPos2)|| allp2pos.contains(playerPos2) || playerPos2>9) {
    				System.out.println("Position allready Occupied, Re-Enter");
    				playerPos2 = rnd.nextInt(9)+1;
    			}
    			TicTacToe2.insert(playerPos2, board,'O');
    			TicTacToe2.showBoard(board);
    			TicTacToe2.winner(allp1pos, allp2pos);
    			System.out.println("All p2 pos are"+allp2pos);
    		}
        }
        else {
        	int playerPos1,playerPos2;
    		System.out.println("Enter Name of Player1");
    		System.out.print("Player1: ");
    		String p1 = sc.nextLine();

    		System.out.print("Player2: ");
    		String p2 = sc.nextLine();

    		char board[][] = {
    				{'_','_','_','_','_','_','_'},
    				{'|',' ','|',' ','|',' ','|'},
    				{'|','-','+','-','+','-','|'},
    				{'|',' ','|',' ','|',' ','|'},
    				{'|','-','+','-','+','-','|'},
    				{'|',' ','|',' ','|',' ','|'},
    				{'-','-','-','-','-','-','-'}};
    		TicTacToe.showBoard(board);

    		while(true) {
    			System.out.println(p1+"Enter position for X in 0-9");
    			playerPos1 = sc.nextInt();
    			while(allp1pos.contains(playerPos1) || allp2pos.contains(playerPos1) || playerPos1>9) {
    				System.out.println("Position allready Occupied, Re-Enter");
    				playerPos1 = sc.nextInt();
    			}
    			TicTacToe2.insert(playerPos1, board,'X');
    			TicTacToe2.showBoard(board);
    			TicTacToe2.winner(allp1pos, allp2pos);
    			System.out.println("All p1 pos are"+allp1pos);

    			System.out.println(p2+"Enter position for O in 0-9");
    			playerPos2 = sc.nextInt();
    			while(allp1pos.contains(playerPos2)|| allp2pos.contains(playerPos2) || playerPos2>9) {
    				System.out.println("Position allready Occupied, Re-Enter");
    				playerPos2 = sc.nextInt();
    			}
    			TicTacToe2.insert(playerPos2, board,'O');
    			TicTacToe2.showBoard(board);
    			TicTacToe2.winner(allp1pos, allp2pos);
    			System.out.println("All p2 pos are"+allp2pos);
    		}
        }
		
		

	}

}
