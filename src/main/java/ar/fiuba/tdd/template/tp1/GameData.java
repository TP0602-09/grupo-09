package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucía on 16/10/2016.
 */
public class GameData {
    private String name;
    private Integer rows;
    private Integer columns;
    private String elementType;
    private String inputType;
    private String unionType;
    private List<Sector> sectors;
    private List<Rule> rules;

    public GameData() {
        this.name = "";
        this.sectors = new ArrayList<Sector>();
        this.rules = new ArrayList<Rule>();
    }

    public String getName() {
        return name;
    }

    public void setName(String nam) {
        name = nam;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer row) {
        rows = row;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer column) {
        columns = column;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sector) {
        sectors = sector;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementTyp) {
        elementType = elementTyp;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getUnionType() {
        return unionType;
    }

    public void setUnionType(String unionTyp) {
        unionType = unionTyp;
    }
}
