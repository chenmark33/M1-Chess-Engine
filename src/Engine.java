public class Engine {

    MoveInterface console;
//    BitBoard board;
    MoveGenerator generator;
    Evaluator evaluator;

    /**
     * Constructor for the Engine class
     */
    public Engine() {
        this.console = new MoveInterface();
//        this.board = new BitBoard();
        this.generator = new MoveGenerator();
        this.evaluator = new Evaluator();
    }

    /**
     * Calls {@link MoveInterface#start()} on {@link Engine#console}
     */
    public void run() {
        console.start();
        startGame();
    }

    /**
     * Starts the game
     */
    public void startGame() {
        System.out.println("Game starting");
    }
}