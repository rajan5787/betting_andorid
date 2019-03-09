package rajan5787.tikuraja.bettingapp;

/**
 * Created by rajanpipaliya on 08/03/19.
 */

public class race_model {

    private String race_name;
    private String race_id;
    private String startTime;
    private String endTime;
    private String race_player;
    private String totalPlayer;

    public race_model() {
    }

    public race_model( String race_id,String race_name, String startTime,String endTime,String totalPlayer) {
        this.race_name = race_name;
        this.race_id = race_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalPlayer = totalPlayer;

    }

    public String getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(String totalPlayer) {
        this.totalPlayer = totalPlayer;
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }

    public String getRace_id() {
        return race_id;
    }

    public void setRace_id(String race_id) {
        this.race_id = race_id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRace_player() {
        return race_player;
    }

    public void setRace_player(String race_player) {
        this.race_player = race_player;
    }
}
