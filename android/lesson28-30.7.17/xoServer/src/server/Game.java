package server;

/**
 * Created by hackeru on 30/07/2017.
 */
public class Game {

    private String firstPlayerToken;
    private String secondPlayerToken;
    private int connectedPlayers;

    public Game(){

    }


    public String getFirstPlayerToken() {
        return firstPlayerToken;
    }

    public void setFirstPlayerToken(String firstPlayerToken) {
        connectedPlayers++;
        this.firstPlayerToken = firstPlayerToken;
    }

    public String getSecondPlayerToken() {
        return secondPlayerToken;
    }

    public void setSecondPlayerToken(String secondPlayerToken) {
        connectedPlayers++;
        this.secondPlayerToken = secondPlayerToken;
    }

    public int getConnectedPlayers() {
        return connectedPlayers;
    }
}
