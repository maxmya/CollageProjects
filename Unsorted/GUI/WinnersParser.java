package GUI;

/**
 * Created by Maxmya on 11/08/2016.
 */
public class WinnersParser {

    private long[] winnersScore = new long[1000];
    private String[] winnersName = new String[1000];

    WinnersParser(long[] winnersScore, String[] winnersName) {

        setWinnersName(winnersName);
        setWinnersScore(winnersScore);
    }

    public void setWinnersName(String[] winnersName) {
        this.winnersName = winnersName;
    }

    public String[] getWinnersName() {
        return winnersName;
    }

    public void setWinnersScore(long[] winnersScore) {
        this.winnersScore = winnersScore;
    }

    public long[] getWinnersScore() {
        return winnersScore;
    }
}
