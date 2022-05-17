import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest {

    @Test
    void player1WinABall_shouldReturnScoreIncreasedByOne() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player1WinABall();
        assertEquals(1, testTennisGame.getPlayer1Score());
        testTennisGame.player1WinABall();
        assertEquals(2, testTennisGame.getPlayer1Score());
    }


    @Test
    void player2WinABall_shouldReturnScoreIncreasedByOne() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        assertEquals(1, testTennisGame.getPlayer2Score());
        testTennisGame.player2WinABall();
        assertEquals(2, testTennisGame.getPlayer2Score());
    }

    @Test
    void isDeuce_shouldReturnTrue_whenPlayer1AndPlayer2ScoreIsEqualAndMoreThan2() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        assertTrue(testTennisGame.isDeuce());
    }

    @Test
    void isDeuce_shouldReturnFalse_whenPlayer1AndPlayer2ScoreIsNotEqual() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        assertFalse(testTennisGame.isDeuce());
    }

    @Test
    void player1HasAdvantages_shouldReturnTrue_whenIsDeuceAndPlayer1WinABall() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        assertTrue(testTennisGame.isPlayer1HasAdvantages());
    }

    @Test
    void player2HasAdvantages_shouldReturnTrue_whenIsDeuceAndPlayer2WinABall() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        assertTrue(testTennisGame.isPlayer2HasAdvantages());
    }

    @Test
    void player1Win_shouldReturnTrue_whenPlayer1HasMoreThan3ScoresAndHas2ScoresMoreThanPlayer2() {
        TennisGame testTennisGame = new TennisGame();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        assertTrue(testTennisGame.isPlayer1Win());
    }

    @Test
    void player2Win_shouldReturnTrue_whenPlayer2HasMoreThan3PointsAndHas2PointsMoreThanPlayer2() {
        TennisGame testTennisGame = new TennisGame();

        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        assertTrue(testTennisGame.isPlayer2Win());
    }
    @Test
    void convertScoresToPoints_shouldReturnAString_whenScoreIsLowerThan4(){
        assertEquals("love",new TennisGame().convertScoresLessThan4ToPoints(0));
        assertEquals("fifteen",new TennisGame().convertScoresLessThan4ToPoints(1));
        assertEquals("thirty",new TennisGame().convertScoresLessThan4ToPoints(2));
        assertEquals("forty",new TennisGame().convertScoresLessThan4ToPoints(3));
    }
    @Test
    void convertScoresToPoints_shouldThrowException_whenScoreIsGreatThan3OrLessThan0(){
        assertThrows(IllegalArgumentException.class,() -> {
            new TennisGame().convertScoresLessThan4ToPoints(7);
        });
        assertThrows(IllegalArgumentException.class,() -> {
            new TennisGame().convertScoresLessThan4ToPoints(-1);
        });
    }
//    @Test
//    void showResult_shouldReturnLoveLove_whenTheGameStarts(){
//        TennisGame testTennisGame = new TennisGame();
//        assertEquals("love-love", testTennisGame.showResult());
//    }
    @Test
    void showResult_shouldReturnAWinner_whenPlayer1Win(){
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        assertEquals("Player 1 has won!",testTennisGame.showResult());
    }
    @Test
    void showResult_shouldReturnAWinner_whenPlayer2Win(){
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        assertEquals("Player 2 has won!",testTennisGame.showResult());
    }

    @Test
    void showResults_shouldReturnAdvantage_whenPlayer1HasAdvantage() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();

        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        assertEquals("Player 1 has advantage!",testTennisGame.showResult());
    }

    @Test
    void showResults_shouldReturnAdvantage_whenPlayer2HasAdvantage() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();

        assertEquals("Player 2 has advantage!",testTennisGame.showResult());
    }

    @Test
    void showResults_shouldReturnDeuce_whenTwoPlayersScoreEqual() {
        TennisGame testTennisGame = new TennisGame();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();
        testTennisGame.player2WinABall();

        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();
        testTennisGame.player1WinABall();

        assertEquals("Deuce!",testTennisGame.showResult());
    }

    @Test
    void showResults_shouldReturnStringPoints_whenTwoPlayersScoreLessThanFour() {
        TennisGame testTennisGame = new TennisGame();
        assertEquals("love-love", testTennisGame.showResult());
        testTennisGame.player1WinABall();
        assertEquals("fifteen-love", testTennisGame.showResult());
        testTennisGame.player2WinABall();
        assertEquals("fifteen-fifteen",testTennisGame.showResult());
    }
}