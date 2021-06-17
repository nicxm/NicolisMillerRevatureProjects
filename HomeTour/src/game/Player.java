package game;

import fixtures.Room;

public class Player {
	Room currentRoom;
	
	//Gets and sets
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}