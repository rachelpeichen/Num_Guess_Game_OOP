package java335_ntu_lab;

import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		int N = 10000;
		simulation(new AIPlayer(), N);
		simulation(new BinarySearch(), N);
		simulation(new SuperAI(), N);
		
	}
	public static void simulation (Player p, int N) {
		int wins = 0;
		
		for (int i = 1; i <= N; i++) {
			Game curr_game = new Game(p);
			curr_game.run();
			if (curr_game.hasWon()) wins++;
		}
		
		System.out.printf("%18s (%.4f)\n", p, (double) wins / N);
	}

}

class Game {
	private int ans;
	private int low = 0, high = 99;
	private boolean win_flag = false;
	private Player player;
	
	boolean hasWon() {
		return win_flag;
	}
	
	Game(Player player) {
		this.player = player;
		this.ans = (int) (Math.random() * 100);
	}
	
	void run () {
		
		while (true) {
			
			int g = player.next(low, high);
			
			if (g == ans) {
				win_flag = true;
				break;
			} else if (g > ans) {
				high = g - 1;
			} else {
				low = g + 1;
			}

			if (low == high) {
				break;
			}
		}
	}
	
}

abstract class Player {
	abstract int next(int low, int high);
}

class HumanPlayer extends Player {
	
	private Scanner input = new Scanner(System.in);

	int next(int low, int high) {
		return input.nextInt();
	}

	@Override
	public String toString() {
		return "Human Player: ";
	}
}

class AIPlayer extends Player {

	public int next(int low, int high) {
		return (int) (Math.random() * (high - low + 1) + low);
	}

	@Override
	public String toString() {
		return "Naive AI";
	}
}

class BinarySearch extends AIPlayer {
	
	@Override
	public int next(int low, int high) {
		return (int) (low + high) / 2;
	}

	@Override
	public String toString() {
		return "Binary Search AI";
	}
}

class SuperAI extends AIPlayer {
	
	@Override
	public int next(int low, int high) {
		return low;
	}

	@Override
	public String toString() {
		return "Super AI";
	}
}




