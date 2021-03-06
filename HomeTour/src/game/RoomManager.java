package game;

import fixtures.Room;

public class RoomManager {

	public Room startingRoom;
	public Room[] rooms;

	public RoomManager(int roomCount) {
		rooms = new Room[roomCount];
	}
	
//INITialization
	public void init() {
	    Room foyer = new Room(
			"The Foyer",
			"A small foyer",
			"The small entryway of a house. A kitchen is open to the NORTH, where a large counter can be seen." + "\n"
			+ "The hardwood floor leads WEST into the Bedroom." + "\n"
			+ "To the SOUTH is to the outside, where you entered the house from.");
			this.rooms[0] = foyer;
	        this.startingRoom = foyer;
	        
	    Room bedroom = new Room(
	    	"The Bedroom",
	    	"A quiet little bedroom",
	    	"A quiet little bedroom with a door to the EAST to go back into the Foyer");
	    	this.rooms[1] = bedroom;
	    Room kitchen = new Room(
	    	"The Kitchen",
	    	"A nice, clean kitchen",
	    	"A nice, clean kitchen with a backdoor to the NORTH leading to the backyard,\n behind you to the SOUTH is the foyer.");
	    	this.rooms[2] = kitchen;
	    Room backyard = new Room(
	    	"The Backyard",
	    	"A sunny backyard",
	    	"A sunny backyard with a fence surrounding it, behind you to the SOUTH leads back into the kitchen");
	    	this.rooms[3] = backyard;
	    Room frontyard = new Room(
	    	 "The Frontyard",
	    	 "A recently mowed front lawn",
	    	 "A recently mowed front yard that leads NORTH into the front door.");
	    	 this.rooms[4] = frontyard;
	    	 
	}

	//gets and sets
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public Room[] getRooms() {
		return this.rooms;
	}
	
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
}
