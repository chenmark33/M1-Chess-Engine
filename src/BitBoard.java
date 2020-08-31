public class BitBoard {

    private static final long INITIAL_BLACK_PAWNS = 0x00FF000000000000L;
    private static final long INITIAL_BLACK_KNIGHTS = 0x4200000000000000L;
    private static final long INITIAL_BLACK_BISHOPS = 0x2400000000000000L;
    private static final long INITIAL_BLACK_ROOKS = 0x8100000000000000L;
    private static final long INITIAL_BLACK_QUEEN = 0x1000000000000000L;
    private static final long INITIAL_BLACK_KING = 0x0800000000000000L;

    private static final long INITIAL_WHITE_PAWNS = 0x000000000000FF00L;
    private static final long INITIAL_WHITE_KNIGHTS = 0x0000000000000042L;
    private static final long INITIAL_WHITE_BISHOPS = 0x0000000000000024L;
    private static final long INITIAL_WHITE_ROOKS = 0x0000000000000081L;
    private static final long INITIAL_WHITE_QUEEN = 0x0000000000000010L;
    private static final long INITIAL_WHITE_KING = 0x0000000000000008L;

    private final long blackPawns;
    private final long blackKnights;
    private final long blackBishops;
    private final long blackRooks;
    private final long blackQueen;
    private final long blackKing;

    private final long whitePawns;
    private final long whiteKnights;
    private final long whiteBishops;
    private final long whiteRooks;
    private final long whiteQueen;
    private final long whiteKing;

    public BitBoard() {
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


}
