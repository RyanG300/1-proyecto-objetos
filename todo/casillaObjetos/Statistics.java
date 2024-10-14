package casillaObjetos;

public class Statistics {
    private int gamesPlayed;
    private int wonGames;
    private int lostGames;
    private int characterDeaths;
    private int towerDeaths;
    private int deathsCaused;

    public Statistics() {
        this.gamesPlayed = 0;
        this.wonGames = 0;
        this.lostGames = 0;
        this.characterDeaths = 0;
        this.towerDeaths = 0;
        this.deathsCaused = 0;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public void incrementWonGames() {
        this.wonGames++;
    }

    public void incrementLostGames() {
        this.lostGames++;
    }

    public void incrementCharacterDeaths() {
        this.characterDeaths++;
    }

    public void incrementTowerDeaths() {
        this.towerDeaths++;
    }

    public void incrementDeathsCaused() {
        this.deathsCaused++;
    }

    public double calculatePerformance(){
        if(gamesPlayed == 0) {
            return 0.0;
        }
        return (double) wonGames / gamesPlayed * 100;
    }
}

