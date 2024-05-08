package ch07.sec01.exam04;

class Chess {
	enum ChessPlayer {
		WHITE, BLACK
	}
	
	final ChessPlayer getFitstPlayer() {
		return ChessPlayer.WHITE;
	}
}

class WorldChess extends Chess {
//	@Override
//	ChessPlayer getFChessPlayer() {}
}

public class FinalMethodDemo {

	public static void main(String[] args) {
//		new NumberOne();

	}

}
