
public class TicTacToe {
	private TicTacToeField _field = new TicTacToeField();
	private Caretaker caretaker;
	
	public void intro() {
		System.out.println("move <x> <y> - ход крестиком в точку (x, y)");
		System.out.println("undo - отмена одного хода");
		_field.show();
	}
	
	public int getPlayerNumber() {
		return _field.getPlayerNumber();
	}
	
	public void move(int x, int y) {
		if (!_field.hasMove(x, y)) {
			_field.show();
			return;
		}
		caretaker = new Caretaker(_field.createMemento());
		_field.setChar(x, y);
		_field.show();
	}
	
	public int whoWon() {
		for (int x = 1; x <= 3; x++) {
			if (_field.getChar(x, 1) == _field.getChar(x, 2) && _field.getChar(x, 2) == _field.getChar(x, 3)) {
				if (_field.getChar(x, 1) == 'X')
					return 1;
				else if (_field.getChar(x, 1) == 'O')
					return 2;
			}
		}
		for (int y = 1; y <= 3; y++) {
			if (_field.getChar(1, y) == _field.getChar(2, y) && _field.getChar(2, y) == _field.getChar(3, y)) {
				if (_field.getChar(1, y) == 'X')
					return 1;
				else if (_field.getChar(1, y) == 'O')
					return 2;
			}
		}
		if (_field.getChar(1, 1) == _field.getChar(2, 2) && _field.getChar(2, 2) == _field.getChar(3, 3)) {
			if (_field.getChar(1, 1) == 'X')
				return 1;
			else if (_field.getChar(1, 1) == 'O')
				return 2;
		}
		if (_field.getChar(1, 3) == _field.getChar(2, 2) && _field.getChar(2, 2) == _field.getChar(3, 1)) {
			if (_field.getChar(1, 3) == 'X')
				return 1;
			else if (_field.getChar(1, 3) == 'O')
				return 2;
		}
		return 0;
	}
	
	public boolean isFieldFull() {
		return _field.isFull();
	}
	
	public void undo() {
		if (caretaker == null) {
			System.out.println("Невозможно отменить ход");
			_field.show();
			return;
		}
		System.out.println("Ход отменён");
		_field.setMemento(caretaker.getMemento());
		_field.show();
		caretaker = null;
	}
}
