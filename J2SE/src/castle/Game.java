package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private Room currentRoom;
	private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

	public Game() {
		createRooms();
		handlers.put("bye", new HandlerBye(this));
		handlers.put("help", new HandlerHelp(this));
		handlers.put("go", new HandlerGo(this));
	}

	private void createRooms() {
		Room outside, lobby, pub, study, bedroom;

		// 制造房间
		outside = new Room("城堡外");
		lobby = new Room("大堂");
		pub = new Room("小酒吧");
		study = new Room("书房");
		bedroom = new Room("卧室");

		// 初始化房间的出口
		outside.setExit("east", pub);
		pub.setExit("west", outside);
		outside.setExit("west", lobby);
		lobby.setExit("east", outside);
		outside.setExit("south", study);
		study.setExit("north", outside);
		study.setExit("west", bedroom);
		bedroom.setExit("east", study);

		currentRoom = outside; // 从城堡门外开始
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("欢迎来到城堡！");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入 'help' 。");

		System.out.println();
		showRoomInfo();
	}

	// 去哪个方向
	protected void goRoom(String direction) {
		Room nextRoom = currentRoom.getNextRoom(direction);
		if (nextRoom == null) {
			System.out.println("那里没有门！");
		} else {
			currentRoom = nextRoom;
			showRoomInfo();
		}
	}

	// 显示当前房间内出口信息
	public void showRoomInfo() {
		System.out.println("你在" + currentRoom);
		System.out.print("出口有: ");
		currentRoom.getExit();
		System.out.println();
	}

	public void play() {
		Scanner in = new Scanner(System.in);
		while (true) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			String value = "";

			Handler handler = handlers.get(words[0]);
			if (handler != null) {
				if (words.length > 1) {
					value = words[1];
				}
				handler.doCMD(value);
				if (handler.isBye()) {
					
					break;
				}
			}

		}
		in.close();
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.printWelcome();
		game.play();
		

	}

}
