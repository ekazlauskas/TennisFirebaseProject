package css.tennisfirebaseproject;

import java.io.Serializable;

public class TennisMatch implements Serializable {

    private String opponentPlayed;
    private String matchPlacement;
    private String playerPlayed;
    private String matchScore;
    private String datePlayed;

    public TennisMatch(String opponentPlayed, String matchPlacement, String playerPlayed, String matchScore, String datePlayed){
        this.opponentPlayed = opponentPlayed;
        this.matchPlacement = matchPlacement;
        this.playerPlayed = playerPlayed;
        this.matchScore = matchScore;
        this.datePlayed = datePlayed;
    }

    public String getOpponentPlayed() {return opponentPlayed;}
    public void getOpponentPlayed(String opponentPlayed) {this.opponentPlayed = opponentPlayed;}

    public String getMatchPlacement() {return matchPlacement;}
    public void getMatchPlacement(String matchPlacement) {this.matchPlacement = matchPlacement;}

    public String getPlayerPlayed() {return playerPlayed;}
    public void getPlayerPlayed(String playerPlayed) {this.playerPlayed = playerPlayed;}

    public String getMatchScore() {return matchScore;}
    public void getMatchScore(String matchScore) {this.matchScore = matchScore;}

    public String getDatePlayed() {return datePlayed;}
    public void getDatePlayed(String datePlayed) {this.datePlayed = datePlayed;}

    //@Override
    //public String toString(){
        //return "TennisMatch(" +
               // "opponentPlayed" + opponentPlayed + '\'' +
               // ", matchPlacement" + matchPlacement + '\'' +
              //  ", playerPlayed" + playerPlayed + '\'' +
              //  ", matchScore" + matchScore + '\'' +
              //  ", datePlayed" + datePlayed + '\'' + ")";
    }
