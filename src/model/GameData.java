package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucía on 5/10/2016.
 */
public class GameData {

    private String name;
    private Integer rows;
    private Integer columns;
    private List<Cell> boardCells;
    private List<Sector> sectors;
    private List<Rule> rules;

    public GameData() {
        this.name = "";
        this.boardCells = new ArrayList<Cell>();
        this.sectors = new ArrayList<Sector>();
        this.rules = new ArrayList<Rule>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public List<Cell> getBoardCells() {
        return boardCells;
    }

    public void setBoardCells(List<Cell> boardCells) {
        this.boardCells = boardCells;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
