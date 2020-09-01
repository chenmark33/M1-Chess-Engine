public class Engine {

    MoveInterface console;
    BitBoard board;
    Evaluator evaluator;

    public Engine() {
        this.console = new MoveInterface();
        this.board = new BitBoard();
        this.evaluator = new Evaluator();
    }

    public void run() {
        console.start();
    }

}
