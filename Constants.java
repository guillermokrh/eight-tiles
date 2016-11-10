

/**
 * Created by guillermo on 11/5/16.
 */
public final class Constants {
    //stores what the final board configuration should be
    public static final int BOARD_SIZE = 9;
    public static final int[][] FINISHED_STATE = {{2, 2}, {0, 0}, {0, 1},
                                                    {0, 2}, {1, 0}, {1, 1},
                                                    {1, 2}, {2, 0}, {2, 1}};
    public static final int[][] POSSIBLE_MOVES = { {1, 3}, {0, 2, 4}, {1, 5},
                                                    {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8},
                                                    {3, 7}, {4, 6, 8}, {5, 7}};
}
