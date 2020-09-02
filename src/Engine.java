public class Engine {

    MoveInterface console;
    BitBoard board;
    MoveGenerator generator;
    Evaluator evaluator;

    public Engine() {
        this.console = new MoveInterface();
        this.board = new BitBoard();
        this.generator = new MoveGenerator();
        this.evaluator = new Evaluator();
    }

    public void run() {
        console.start();
        startGame();
    }

    public void startGame() {
        System.out.println("Game starting");
    }
}
