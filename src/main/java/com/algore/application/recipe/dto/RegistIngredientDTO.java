package com.algore.application.recipe.dto;

public class RegistIngredientDTO {

    private int ingName;
    private int weigh;
    private int riUnitNum;

    public RegistIngredientDTO() {
    }

    public RegistIngredientDTO(int ingName, int weigh, int riUnitNum) {
        this.ingName = ingName;
        this.weigh = weigh;
        this.riUnitNum = riUnitNum;
    }

    public int getIngName() {
        return ingName;
    }

    public void setIngName(int ingName) {
        this.ingName = ingName;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    public int getRiUnitNum() {
        return riUnitNum;
    }

    public void setRiUnitNum(int riUnitNum) {
        this.riUnitNum = riUnitNum;
    }

    @Override
    public String toString() {
        return "RegistIngredientDTO{" +
                "ingName=" + ingName +
                ", weigh=" + weigh +
                ", riUnitNum=" + riUnitNum +
                '}';
    }
}
