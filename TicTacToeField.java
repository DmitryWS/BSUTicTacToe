
public class TicTacToeField {
	private char _field[][];
	private int playerNumber = 1;
	
	public TicTacToeField() {
		_field = new char[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				_field[i][j] = '.';
			}
		}
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	public void show() {
		System.out.println("+---+");
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(_field[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("+---+");
	}
	
	public boolean hasMove(int x, int y) {
		if (x > 3 || x < 1 || y > 3 || y < 1) {
			System.out.println("Невозможность совершить ход вне поля");
			return false;
		}
		if (_field[y - 1][x - 1] != '.') {
			System.out.println("Данная клетка уже занята");
			return false;
		}
		return true;
	}
	
	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (_field[i][j] == '.')
					return false;
			}
		}
		return true;
	}
	
	public void setChar(int x, int y) {
		if (x > 3 || x < 1 || y > 3 || y < 1)
			throw new IndexOutOfBoundsException();
		char c = playerNumber == 1 ? 'X' : 'O';
		System.out.println("Установлен '" + c + "' на (" + x + ", " + y + ")");
		_field[y - 1][x - 1] = c;
		playerNumber = playerNumber == 1 ? 2 : 1;
	}
	
	public char getChar(int x, int y) {
		if (x > 3 || x < 1 || y > 3 || y < 1)
			throw new IndexOutOfBoundsException();
		return _field[y - 1][x - 1];
	}
	
	public Memento createMemento() {
		Memento memento = new Memento();
		String res = "";
		for (int i = 0; i < 3; i++)
			res += new String(_field[i]);
		memento.setState(res);
		memento.setPlayerNumber(playerNumber);
		return memento;
	}
	
	public void setMemento(Memento memento) {
		String state = memento.getState();
		for (int i = 0; i < 9; i++) {
			_field[i / 3][i % 3] = state.charAt(i);
		}
		playerNumber = memento.getPlayerNumber();
	}
}
