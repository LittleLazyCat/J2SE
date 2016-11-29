package castle;

import java.util.HashMap;
import java.util.Map;

public class Room {
	private String description;

	private Map<String, Room> roomMap = new HashMap<String, Room>();

	public Room(String description) {
		this.description = description;
	}

	public void setExit(String desc, Room r) {
		roomMap.put(desc, r);
	}

	public void getExit() {
		StringBuffer sb = new StringBuffer();
		for (String desc : roomMap.keySet()) {
			sb.append(desc);
			sb.append(' ');
		}
		
		System.out.print(sb.toString());
	}

	public Room getNextRoom(String direction) {
		
		return roomMap.get(direction);
	}

	@Override
	public String toString() {
		return description;
	}
}
