public class BitBoard {

    /**
     * Initial Black and White Pieces
     */
    private static final long INITIAL_BLACK_PIECES = 0xFFFF000000000000L;
    private static final long INITIAL_WHITE_PIECES = 0xFFFFL;

    /**
    * Initial Black Pieces
    */
    private static final long INITIAL_BLACK_PAWNS = 0xFF000000000000L;
    private static final long INITIAL_BLACK_KNIGHTS = 0x4200000000000000L;
    private static final long INITIAL_BLACK_BISHOPS = 0x2400000000000000L;
    private static final long INITIAL_BLACK_ROOKS = 0x8100000000000000L;
    private static final long INITIAL_BLACK_QUEEN = 0x800000000000000L;
    private static final long INITIAL_BLACK_KING = 0x1000000000000000L;

    /**
     * Initial White Pieces
     */
    private static final long INITIAL_WHITE_PAWNS = 0xFF00L;
    private static final long INITIAL_WHITE_KNIGHTS = 0x42L;
    private static final long INITIAL_WHITE_BISHOPS = 0x24L;
    private static final long INITIAL_WHITE_ROOKS = 0x81L;
    private static final long INITIAL_WHITE_QUEEN = 0x8L;
    private static final long INITIAL_WHITE_KING = 0x10L;

    /**
     * Dynamic Black and White Pieces
     */
    private long black_pieces;
    private long white_pieces;

    /**
     * Dynamic Black Pieces
     */
    private long blackPawns;
    private long blackKnights;
    private long blackBishops;
    private long blackRooks;
    private long blackQueen;
    private long blackKing;

    /**
     * Dynamic White Pieces
     */
    private long whitePawns;
    private long whiteKnights;
    private long whiteBishops;
    private long whiteRooks;
    private long whiteQueen;
    private long whiteKing;

    /**
     * Knight Moves Lookup Table
     */
    private static final long[] KNIGHT_LOOKUP = generateKnightLookupTable();

    /**
     * Constructor for the BitBoard class
     */
    public BitBoard() {
        this.black_pieces = INITIAL_BLACK_PIECES;
        this.white_pieces = INITIAL_WHITE_PIECES;

        this.blackPawns = INITIAL_BLACK_PAWNS;
        this.blackKnights = INITIAL_BLACK_KNIGHTS;
        this.blackBishops = INITIAL_BLACK_BISHOPS;
        this.blackRooks = INITIAL_BLACK_ROOKS;
        this.blackQueen = INITIAL_BLACK_QUEEN;
        this.blackKing = INITIAL_BLACK_KING;

        this.whitePawns = INITIAL_WHITE_PAWNS;
        this.whiteKnights = INITIAL_WHITE_KNIGHTS;
        this.whiteBishops = INITIAL_WHITE_BISHOPS;
        this.whiteRooks = INITIAL_WHITE_ROOKS;
        this.whiteQueen = INITIAL_WHITE_QUEEN;
        this.whiteKing = INITIAL_WHITE_KING;
    }

    /**
     * Overloaded constructor for the BitBoard class
     *
     * @param blackPawns
     * @param blackKnights
     * @param blackBishops
     * @param blackRooks
     * @param blackQueen
     * @param blackKing
     * @param whitePawns
     * @param whiteKnights
     * @param whiteBishops
     * @param whiteRooks
     * @param whiteQueen
     * @param whiteKing
     */
    public BitBoard(long blackPawns,
                    long blackKnights,
                    long blackBishops,
                    long blackRooks,
                    long blackQueen,
                    long blackKing,
                    long whitePawns,
                    long whiteKnights,
                    long whiteBishops,
                    long whiteRooks,
                    long whiteQueen,
                    long whiteKing) {
        this.black_pieces = blackPawns | blackKnights | blackBishops | blackRooks | blackQueen | blackKing;
        this.white_pieces = whitePawns | whiteKnights | whiteBishops | whiteRooks | whiteQueen | whiteKing;
        this.blackPawns = blackPawns;
        this.blackKnights = blackKnights;
        this.blackBishops = blackBishops;
        this.blackRooks = blackRooks;
        this.blackQueen = blackQueen;
        this.blackKing = blackKing;
        this.whitePawns = whitePawns;
        this.whiteKnights = whiteKnights;
        this.whiteBishops = whiteBishops;
        this.whiteRooks = whiteRooks;
        this.whiteQueen = whiteQueen;
        this.whiteKing = whiteKing;
    }

    /**
     * Generates all valid moves for any knight in all 64 possible squares on a standard chessboard.
     *
     * @return A list of long numbers, denoting for each index a list of valid knight moves starting from that
     * corresponding index, each one being represented as a 64-bit long binary string.
     */
    private static long[] generateKnightLookupTable() {
        int rows = 8, columns = 8;
        final long[] knightLookupTable = new long[rows * columns];

        int[][] moves = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int oppositeRow = rows - i - 1;
                int index = oppositeRow * rows + j;
//                System.out.print("knightLookup[" + index + "] = ");

                long validMoves = 0L;
                for (int k = 0; k < moves.length; k++) {
                    int[] move = moves[k];
                    int newRow = oppositeRow + move[0];
                    int newColumn = j + move[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                        int shiftBy = newRow * rows + newColumn;
//                        System.out.print("1L << " + shiftBy + ((k == moves.length - 1) ? "L" : "L | "));
                        validMoves |= shiftBy;
                    }
                }

//                System.out.println();
                knightLookupTable[index] = validMoves;
            }
        }
        return knightLookupTable;
    }
}