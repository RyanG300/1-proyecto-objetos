package inicioDeSesión;


import java.util.ArrayList;
import java.util.List;
import casillaObjetos.Character;

public class User {
    private String userName;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private float performance;
    private List<Character> characters;


    public User(String userName) {
        this.userName = userName;
        this.matchesPlayed = 0;
        this.matchesWon = 0;
        this.matchesLost = 0;
        this.characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void incrementMatchesPlayed() {
        matchesPlayed++;
    }

    public void incrementMatchesWon() {
        matchesWon++;
    }

    public void incrementMatchesLost() {
        matchesLost++;
    }

    public int getTotalDeaths(){
        return characters.stream().mapToInt(Character::getDeaths).sum();
    }

    public int getTotalTowerKills(){
        return characters.stream().mapToInt(Character::getTowerKills).sum();
    }

    public double getTotalKills(){
        return characters.stream().mapToInt(Character::getKills).sum();
    }

    public double getPerformance() {
        return matchesPlayed > 0 ? (double) matchesWon / matchesPlayed * 100 : 0;
    }

    public String getUserName() {
        return userName;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }
}
