package com.example.qwirkle;

import java.util.List;

public class Player {
    private String name;
    private int points;
    private List<Tile> inHandTiles;
    private List<Tile> newOnBoardTiles;
    private List<Integer> positionOfNewOnBoardTiles;
    private List<Integer> positionOfinHandTiles;
    private Boolean isReplace=false;
    private Boolean isTilePlacement=false;
    boolean isturn=false;
    private String id="";


    public Player(String name, int points, List<Tile> inHandTiles, List<Tile> newOnBoardTiles,List<Integer> positionOfNewOnBoardTiles,List<Integer> positionOfinHandTiles) {
        this.name = name;
        this.points = points;
        this.inHandTiles = inHandTiles;
        this.newOnBoardTiles =newOnBoardTiles;
        this.positionOfNewOnBoardTiles=positionOfNewOnBoardTiles;
        this.positionOfinHandTiles=positionOfinHandTiles;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public List<Tile> getInHandTiles() {
        return inHandTiles;
    }

    public List<Tile> getNewOnBoardTiles() {
        return newOnBoardTiles;
    }

    public List<Integer> getPositionOfNewOnBoardTiles() {
        return positionOfNewOnBoardTiles;
    }

    public List<Integer> getPositionOfinHandTiles() {
        return positionOfinHandTiles;
    }

    public Boolean getReplace() {
        return isReplace;
    }

    public void setReplace(Boolean replace) {
        isReplace = replace;
    }

    public Boolean getTilePlacement() {
        return isTilePlacement;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTilePlacement(Boolean tilePlacement) {
        isTilePlacement = tilePlacement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
