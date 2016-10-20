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
    private List<Sector> sectors = new ArrayList<Sector>();
    private List<Rule> everyPlayRules = new ArrayList<Rule>();
    private List<Rule> finalRules = new ArrayList<Rule>();

    public GameData() {}

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

    public List<Rule> getEveryPlayRules() {
        return everyPlayRules;
    }

    public void setEveryPlayRules(List<Rule> everyPlayRules) {
        this.everyPlayRules = everyPlayRules;
    }

    public List<Rule> getFinalRules() {
        return finalRules;
    }

    public void setFinalRules(List<Rule> finalRules) {
        this.finalRules = finalRules;
    }
}
