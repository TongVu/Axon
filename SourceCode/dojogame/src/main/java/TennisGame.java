public class TennisGame {
    private Player player1;
    private Player player2;
    private int player1Score;
    private int player2Score;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public TennisGame() {
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getPlayer1Score() {
        return player1Score;
    }


    public int getPlayer2Score() {
        return player2Score;
    }

    public void player1WinABall() {
        this.player1Score++;
    }

    public void player2WinABall() {
        this.player2Score++;
    }

    public boolean isDeuce() {
        return player1Score >= 3 && player1Score == player2Score;
    }

    public boolean isPlayer1HasAdvantages() {
        return player1Score >= 3 &&
                player2Score >= 3 &&
                player1Score - player2Score == 1;
    }

    public boolean isPlayer2HasAdvantages() {
        return player1Score >= 3 &&
                player2Score >= 3 &&
                player2Score - player1Score == 1;
    }


    public boolean isPlayer1Win() {
        return player1Score >= 4 &&
                player1Score - player2Score >= 2;

    }

    public boolean isPlayer2Win() {
        return player2Score >= 4 &&
                player2Score - player1Score >= 2;

    }

    public String convertScoresLessThan4ToPoints(int score) {
        switch (score) {
            case 0:
                return "love";
            case 1:
                return "fifteen";
            case 2:
                return "thirty";
            case 3:
                return "forty";
            default:
                throw new IllegalArgumentException();
        }
    }

    public String showResult() {
        if (isPlayer1Win()) {
            return "Player 1 has won!";
        }if (isPlayer2Win()){
            return "Player 2 has won!";
        }
        if (isPlayer1HasAdvantages())
            return "Player 1 has advantage!";

        if (isPlayer2HasAdvantages())
            return "Player 2 has advantage!";

        if (isDeuce())
            return "Deuce!";

        return convertScoresLessThan4ToPoints(player1Score) + "-" + convertScoresLessThan4ToPoints(player2Score);

    }


}
