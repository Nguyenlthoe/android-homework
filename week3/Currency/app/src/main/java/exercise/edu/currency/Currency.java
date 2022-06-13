package exercise.edu.currency;

public class Currency {
    private int weight;
    private String unitCurrency;
    private String symbolCurrency;

    public Currency(int weight, String unitCurrency, String symbolCurrency) {
        this.weight = weight;
        this.unitCurrency = unitCurrency;
        this.symbolCurrency = symbolCurrency;
    }

    public int getWeight() {
        return weight;
    }

    public String getUnitCurrency() {
        return unitCurrency;
    }

    public String getSymbolCurrency() {
        return symbolCurrency;
    }
    @Override
    public String toString(){
        return this.getUnitCurrency() + " - (" + this.getSymbolCurrency()+")";
    }
}
