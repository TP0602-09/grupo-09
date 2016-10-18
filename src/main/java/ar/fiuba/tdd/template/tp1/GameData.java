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

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
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

    public void setUnionType(String unionType) {
        this.unionType = unionType;
    }
}
