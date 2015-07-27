import java.util.Scanner;

public class CoffeeMaker {

	private Player _player = null;
	private House _house = null;
	
	public CoffeeMaker(Player p, House h){
		_player=p;
		_house=h;
	}
	
	public static int runArgs(String arg) {
		System.out.println("Instructions for Coffee Maker Quest - ");
		System.out.println("You are a brave student trying to study for finals, but you need caffeine.");
		System.out.println("The goal of the game is to collect sugar, coffee, and cream so that you can study.");
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("Coffee Maker Quest 1.0");
		int returnValue = 0;		
		if (args.length == 0) {
			Player p = new Player();
			House h = new House(6);
			CoffeeMaker cm = new CoffeeMaker(p,h);
			int toReturn = cm.run();
		} else {
			
			returnValue = runArgs(args[0]);
		}		
		System.out.println("Exiting with error code " + returnValue);
	}
	
	public int doSomething(String move) {
		int toReturn = 0;
		if (move.equalsIgnoreCase("N")) {
			_house.moveNorth();
		} else if (move.equalsIgnoreCase("S")) {
			_house.moveSouth();
		} else if (move.equalsIgnoreCase("L")) {
			_house.look(_player, null);
		} else if (move.equalsIgnoreCase("I")) {
			_player.showInventory();
		} else if (move.equalsIgnoreCase("D")) {
			boolean finalStatus = _player.drink();
			if (finalStatus) {
				toReturn = 1;
			} else {
				toReturn = -1;
			}
		}else if (move.equalsIgnoreCase("H")) { 
			System.out.println("Enter N, moving north\n"
					+ "Enter S, moving south\n"
					+ "Enter L, look up items in rooms\n"
					+ "Enter I, check your inventory\n"
					+ "Enter N, drink what you have\n"
					+ "Enter H for help");
			
		}else {
			System.out.println("What?");
		}
		return toReturn;
	}
	
	public int run() {
		int toReturn = 0;
		
		Scanner in = new Scanner(System.in);
		String move = null;
		
		boolean gameOver = false;
		boolean win = false;
		
		while (!gameOver) {
			System.out.println(_house.getCurrentRoomInfo());
			System.out.println(" INSTRUCTIONS (N,S,L,I,D,H) > ");
			move = in.nextLine();
			int status = doSomething(move);
			if (status == 1) {
				gameOver = true;
				win = true;
			} else if (status == -1) {
				gameOver = true;
				win = false;
			}
		}
		
		if (win) {
			System.out.println("You win!");
			toReturn = 0;
		} else {
			System.out.println("You lose!");
			toReturn = 1;
		}
		
		return toReturn;
	}

}
