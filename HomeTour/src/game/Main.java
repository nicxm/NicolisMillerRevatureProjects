/*
 * Main.java
 * I should have separated some of the input into a separate class
 * but for now I think this works well and is fairly simple.
 */


package game;
import java.util.Scanner;


public class Main extends RoomManager {

	public Main(int roomCount) {
		super(roomCount);
	}

	private static RoomManager manager = new RoomManager(5);
	static int gameRunning = 1;
	
	public static void main(String[] args) {
		//Initialization
		manager.init();
		Player player = new Player();
		player.setCurrentRoom(manager.startingRoom);
		//Initialization
		
		while (gameRunning == 1) {
			// GAME LOOP
			Main.printRoom(player);
			String[] input = Main.collectInput();
			Main.parse(input, player);
			// GAME LOOP
		}
		//Ends the game with a message
		if (gameRunning == 0) {
			System.out.println("Thanks for Playing!");
		}
	}


	private static void printRoom(Player player) {
	player.getCurrentRoom();
	//Prints out the current room name and descriptions
	System.out.println(player.currentRoom.getName() + "\n");
	System.out.println(player.currentRoom.getLongDescription() + "\n");
	}

	private static String[] collectInput() {
			//Collects input and splits the sentence into an array of words.
		 	Scanner scanner = new Scanner(System.in);
	        System.out.println("\nPlease type in a Command and a Location\nex:\"Go North\"");

	        String input = scanner.nextLine();
	        String[] strArr = input.split(" "); 

	        //Closes the scanner when the game is quit.
	        if (gameRunning == 0) {
				scanner.close();
			}
	        return strArr;
	}
	
		
	public static void parse(String[] input, Player player ) {
		if (input[0].equals("Quit")) {
			gameRunning = 0;
			}
		//MOVEMENT
		switch (input[0]) {
		case "Go" :
			Main.movement(input, player);
			break;
		case "Move" :
			Main.movement(input, player);
			break;
		case "G" :
			Main.movement(input, player);
			break;
		case "M" :
			Main.movement(input, player);
			break;
		default:
			System.out.println("\nOops!\nYou may have misspelled an action!\n");
			break;
		}
	}
	
	public static void movement(String[] input, Player player ) {
		if(player.currentRoom.equals(manager.rooms[0])) {
			switch (input[1]) {
			case "North":
				System.out.println("You walk into the Kitchen\n");
				player.setCurrentRoom(manager.rooms[2]);
				break;
			case "West":
				System.out.println("You walk into the Bedroom\n");
				player.setCurrentRoom(manager.rooms[1]);
				break;
			case "East":
				System.out.println("You try to walk east, but end up hitting the wall thats in that direction.\n");
				break;
			case "South":
				System.out.println("You turn around and walk back outside.\n");
				player.setCurrentRoom(manager.rooms[4]);
				break;
			default:
				System.out.println("\nOops!\nYou may have misspelled an Direction!\n");
				break;
			}
			
		} else if (player.currentRoom.equals(manager.rooms[1])) {
		
			switch (input[1]) {
			case "North":
				System.out.println("You try to walk north, but end up hitting the wall thats in that direction.\n");
				break;
			case "West":
				System.out.println("You try to walk west, but end up hitting the wall thats in that direction.\n");
				break;
			case "East":
				System.out.println("You walk back into the foyer\n");
				player.setCurrentRoom(manager.rooms[0]);
				break;
			case "South":
				System.out.println("You try to walk south, but end up hitting the wall thats in that direction.\n");
				break;
			default:
				System.out.println("\nOops!\nYou may have misspelled an Direction!\n");
				break;
			}
		} else if(player.currentRoom.equals(manager.rooms[2])) {
		
			switch (input[1]) {
			case "North":
				System.out.println("You walk out into the backyard\n");
				player.setCurrentRoom(manager.rooms[3]);
				break;
			case "West":
				System.out.println("You try to walk west, but end up hitting the wall thats in that direction.\n");
				break;
			case "East":
				System.out.println("You try to walk east, but end up hitting the wall thats in that direction.\n");
				break;
			case "South":
				System.out.println("You turn around and walk back into the foyer.\n");
				player.setCurrentRoom(manager.rooms[0]);
				break;
			default:
				System.out.println("\nOops!\nYou may have misspelled an Direction!\n");
				break;
			}
		} else if(player.currentRoom.equals(manager.rooms[3])) {
		
			switch (input[1]) {
			case "North":
				System.out.println("You try to walk north, but end up hitting the fence of the backyard.\n");
				break;
			case "West":
				System.out.println("You try to walk west, but you don't want to end up in a different yard.\n");
				break;
			case "East":
				System.out.println("You try to walk east, but you don't want to end up in a different yard.\n");
				break;
			case "South":
				System.out.println("You enter the house again.\n");
				player.setCurrentRoom(manager.rooms[2]);
				break;
			default:
				System.out.println("\nOops!\nYou may have misspelled an Direction!\n");
				break;
			}
		} else if(player.currentRoom.equals(manager.rooms[4])) {
		
			switch (input[1]) {
			case "North":
				System.out.println("You enter the house again.\n");
				player.setCurrentRoom(manager.rooms[0]);
				break;
			case "West":
				System.out.println("You try to walk west, but you don't want to end up in a different yard.\n");
				break;
			case "East":
				System.out.println("You try to walk east, but you don't want to end up in a different yard.\n");
				break;
			case "South":
				System.out.println("You shouldn't walk into the road.\n");
				break;
			default:
				System.out.println("\nOops!\nYou may have misspelled an Direction!\n");
				break;
			}
		}
	}
	
}
