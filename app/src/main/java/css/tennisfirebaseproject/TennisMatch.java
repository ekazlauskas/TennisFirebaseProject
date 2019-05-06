package css.tennisfirebaseproject;

import java.io.Serializable;

public class TennisMatch implements Serializable {

    private String key;
    private String opponentPlayed;
    private String matchPlacement;
    private String playerPlayed;
    private String matchScore;
    private String datePlayed;

    public TennisMatch(String key, String opponentPlayed, String matchPlacement, String playerPlayed, String matchScore, String datePlayed) {
        this.key = key;
        this.opponentPlayed = opponentPlayed;
        this.matchPlacement = matchPlacement;
        this.playerPlayed = playerPlayed;
        this.matchScore = matchScore;
        this.datePlayed = datePlayed;
    }

    public TennisMatch(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getOpponentPlayed() {
        return opponentPlayed;
    }

    public void setOpponentPlayed(String opponentPlayed) {
        this.opponentPlayed = opponentPlayed;
    }

    public String getMatchPlacement() {
        return matchPlacement;
    }

    public void setMatchPlacement(String matchPlacement) {
        this.matchPlacement = matchPlacement;
    }

    public String getPlayerPlayed() {
        return playerPlayed;
    }

    public void setPlayerPlayed(String playerPlayed) {
        this.playerPlayed = playerPlayed;
    }

    public String getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(String matchScore) {
        this.matchScore = matchScore;
    }

    public String getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(String datePlayed) {
        this.datePlayed = datePlayed;
    }

    @Override
    public String toString() {
        return "TennisMatch(" +
                "opponentPlayed" + opponentPlayed + '\'' +
                ", matchPlacement" + matchPlacement + '\'' +
                ", playerPlayed" + playerPlayed + '\'' +
                ", matchScore" + matchScore + '\'' +
                ", datePlayed" + datePlayed + '\'' + ")";
    }
}
