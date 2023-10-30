package oit.is.z2080.kaizi.janken.model;
import oit.is.z2080.kaizi.janken.model.Janken;

public class Match {
    private int id;
    private int user1;
    private int user2;
    private String user1Hand;
    private String user2Hand;

    private boolean isActive = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public String getUser1Hand() {
        return user1Hand;
    }

    public void setUser1Hand(String user1Hand) {
        this.user1Hand = user1Hand;
    }

    public String getUser2Hand() {
        return user2Hand;
    }

    public void setUser2Hand(String user2Hand) {
        this.user2Hand = user2Hand;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }   

    private String result;

    public JankenResult(Match match) {

        super.setId(match.getId());
        super.setUser1(match.getUser1());
        super.setUser2(match.getUser2());
        super.setUser1Hand(match.getUser1Hand());
        super.setUser2Hand(match.getUser2Hand());

        Janken game = new Janken(match.getUser1Hand(), match.getUser2Hand());
        if (game.getWinner() == null) {
            this.setResult("引き分け");
        } else {
            this.setResult(game.getWinner() + "の勝利");
        }
    }

    public void setResult(String result) { this.result = result; }

    public String getResult() { return this.result; }
}
}