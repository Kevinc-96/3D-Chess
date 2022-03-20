public class Player {

    private Side side;
    private String name;
    private Graveyard graveyard;

    public Player(Side side, Graveyard graveyard, String name) {
        this.side = side;
        this.graveyard = graveyard;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Side getPlayerSide() {
        return side;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }
    
}
