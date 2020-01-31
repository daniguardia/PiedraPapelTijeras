import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA","TORITO","SEPIA"};
    private static final String[] validCommands = {"SALIR", "AYUDA"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);

	    if (first_i == second_i) return EMPATE;
	    /*Añado sentencia para que cada ID gane al siguiente y la tercera siguiente teniendo en cuenta 
	     * que son en total 5 posiciones
	     * ejemplo:
	     * 0 gana a 1 y 3
	     * 1 gana a 2 y 4
	     * 2 gana a 3 y 0
	     * 3 gana a 4 y 1
	     * 4 gana a 0 y 2
	     */
	    return (( (first_i +1) % validMoves.length ) == second_i  || ( (first_i +3) % validMoves.length == second_i) ) ? GANA: PIERDE;
	}
	
} 
