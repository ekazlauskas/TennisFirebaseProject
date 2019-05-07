package css.tennisfirebaseproject;

import java.io.Serializable;

/**
 * Identifies all values needed for the AddMatch activity. Sets values as Strings
 */
public class TennisMatch implements Serializable {

    private String key;
    private String opponentPlayed;
    private String matchPlacement;
    private String playerPlayed;
    private String matchScore;
    private String datePlayed;

    /**
     * Identifies all values as current objects for TennisMatch method.
     * @param key
     * @param opponentPlayed
     * @param matchPlacement
     * @param playerPlayed
     * @param matchScore
     * @param datePlayed
     */
    public TennisMatch(String key, String opponentPlayed, String matchPlacement, String playerPlayed, String matchScore, String datePlayed) {
        this.key = key;
        this.opponentPlayed = opponentPlayed;
        this.matchPlacement = matchPlacement;
        this.playerPlayed = playerPlayed;
        this.matchScore = matchScore;
        this.datePlayed = datePlayed;
    }

    /**
     * Black constructor for creating listview element when adding TennisMatch values within
     * AddMatchActivity.
     */
    public TennisMatch(){

    }

    /**
     * gets the String key and returns value and returns key value to Google Firebase.
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets key value as the current key value for current String set.
     * @param key
     */
    public void setKey(String key){
        this.key = key;
    }

    /**
     * gets the String opponentPlayed value and returns value to Google Firebase and listview
     * Method.
     * @return
     */
    public String getOpponentPlayed() {
        return opponentPlayed;
    }

    /**
     * sets the opponentPlayed value to the current String value.
     * @param opponentPlayed
     */
    public void setOpponentPlayed(String opponentPlayed) {
        this.opponentPlayed = opponentPlayed;
    }

    /**
     * gets MatchPlacement String value and returns the value to the Google Firebase and listview
     * Method.
     * @return
     */
    public String getMatchPlacement() {
        return matchPlacement;
    }

    /**
     * sets the MatchPlacement value to the current String value.
     * @param matchPlacement
     */
    public void setMatchPlacement(String matchPlacement) {
        this.matchPlacement = matchPlacement;
    }

    /**
     * gets playerPlayed String value and returns the value to the Google Firebase and listview
     * Method.
     * @return
     */
    public String getPlayerPlayed() {
        return playerPlayed;
    }

    /**
     * sets the playerPlayed value to the current String value.
     * @param playerPlayed
     */
    public void setPlayerPlayed(String playerPlayed) {
        this.playerPlayed = playerPlayed;
    }

    /**
     * gets MatchScore String value and returns the value to the Google Firebase and listview
     * Method.
     * @return
     */
    public String getMatchScore() {
        return matchScore;
    }

    /**
     * sets the MatchScore value to the current String value.
     * @param matchScore
     */
    public void setMatchScore(String matchScore) {
        this.matchScore = matchScore;
    }

    /**
     * gets DatePlayed String value and returns the value to the Google Firebase and listview
     * Method.
     * @return
     */
    public String getDatePlayed() {
        return datePlayed;
    }

    /**
     * sets the DatePlayed value to the current String value.
     * @param datePlayed
     */
    public void setDatePlayed(String datePlayed) {
        this.datePlayed = datePlayed;
    }

    /**
     * Returns String representation of all objects used within the TennisMatch Method.
     * @return
     */
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
