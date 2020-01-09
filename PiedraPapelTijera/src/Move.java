/**
 * Class that stores a move
 */
 
public class Move{

    private String move;

    public Move(){
    	this.move = null;
    }

    public Move(String move){
    	this.move = move;
    }

    public String getMove(){
	    return move;
    }

    public boolean isUnknown(){
	    return (move == null);
    }

    public int beats(Move other){
	    return MoveWords.checkWinner(this.move, other.getMove());
    }  
}

