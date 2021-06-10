import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 11. Паттерн Memento. Реализовать алгоритм игры «крестики-нолики». Реализовать возможность «взять назад ход».

public class Main {

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		Scanner input = new Scanner(System.in);
		
		game.intro();
		
		while (!game.isFieldFull()) {
			System.out.println("Ход игрока №" + game.getPlayerNumber() + ": ");
			ArrayList<String> command = new ArrayList<>(Arrays.asList(input.nextLine().split(" ")));
			if (command.size() == 0) {
				continue;
			}
			if (command.size() == 3 && command.get(0).equals("move")) {
				try {
					int x = Integer.parseInt(command.get(1));
					int y = Integer.parseInt(command.get(2));
					game.move(x, y);
				} catch (NumberFormatException e) {
					System.out.println("Неверные аргументы move");
					continue;
				}
			}
			if (command.size() == 1 && command.get(0).equals("undo")) {
				game.undo();
			}
			if (game.whoWon() != 0)
				break;
		}
		
		int winner = game.whoWon();
		switch (winner) {
		case 0:
			System.out.println("Победила ничья");
			break;
		case 1:
			System.out.println("Победил игрок №1");
			break;
		case 2:
			System.out.println("Победил игрок №2");
			break;
		}
		
		input.close();
	}

}
