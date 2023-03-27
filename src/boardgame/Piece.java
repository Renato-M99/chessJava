package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	
	//método sem implementação(abstract) que vai definir quais movimentos CADA peça pode fazer!
	//na subclasse será definida a lógica para retornar no array os movimentos possíveis!
	//por padrão, se não definidos, todos serão falsos, já que uma boolean não definida dá false.
	public abstract boolean[][] possibleMoves();
	
	/*	método, que vai depender do método possibleMoves() de cada subclasse, que vai retornar se
	 * 	o movimento na casa da posição no tabuleiro(array[linha][coluna]) almejada é possível ou não. 
	 */
	public boolean possibleMove(Position position){
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//este método vai mostrar se existe movimentos possíveis. Dependendo do que as duas classes retornarão.
	public boolean isThereAnyPossibleMove() {
		//array booleano auxiliar para copiar os valores (true ou false) retornados do met abstrato possibleMoves()
		boolean [][] mat = possibleMoves();
		//percorrer o array auxiliar e verificar: se houver movimentos - true, senão - false.
		for(int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
