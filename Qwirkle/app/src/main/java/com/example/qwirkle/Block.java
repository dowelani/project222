package com.example.qwirkle;

public class Block {
    private Boolean isValidPlacement;
    private Boolean hasTile;
    private Tile tile;

    public Block() {
        isValidPlacement = true;
        hasTile=false;
        tile=null;
    }

    public Boolean getValidPlacement() {
        return isValidPlacement;
    }

    public void setValidPlacement(Boolean validPlacement) {
        isValidPlacement = validPlacement;
    }

    public Boolean getHasTile() {
        return hasTile;
    }

    public void setHasTile(Boolean hasTile) {
        this.hasTile = hasTile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
