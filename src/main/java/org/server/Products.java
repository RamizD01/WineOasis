package org.server;

public class Products {

    private float fixedAcidity;
    private float volatileAcidity;
    private float citricAcid;
    private float residualSugar;


    private float chlorides;
    private float freeSulfurDioxide;
    private float totalSulfurDioxide;
    private float density;
    private float pH;
    private float sulphates;
    private float alcohol;
    private String quality;
    private String color;
    int id;


    public Products(float fixedAcidity, float volatileAcidity, float citricAcid, float residualSugar, float chlorides, float freeSulfurDioxide, float totalSulfurDioxide, float density, float pH, float sulphates, float alcohol, String quality, String color) {
        this.fixedAcidity = fixedAcidity;
        this.volatileAcidity = volatileAcidity;
        this.citricAcid = citricAcid;
        this.residualSugar = residualSugar;
        this.chlorides = chlorides;
        this.freeSulfurDioxide = freeSulfurDioxide;
        this.totalSulfurDioxide = totalSulfurDioxide;
        this.density = density;
        this.pH = pH;
        this.sulphates = sulphates;
        this.alcohol = alcohol;
        this.quality = quality;
        this.color = color;
    }


    @Override
    public String toString() {
        return String.format(
                "Fixed Acidity: %.2f, Volatile Acidity: %.2f, Citric Acid: %.2f, Residual Sugar: %.2f, " +
                        "Chlorides: %.2f, freeSulfurDioxide: %.2f, totalSulfurDioxide: %.2f, Density: %.4f, pH: %.2f, " +
                        "Sulphates: %.2f, Alcohol: %.2f, Quality: %s, Color: %s",
                fixedAcidity, volatileAcidity, citricAcid, residualSugar, chlorides,
                freeSulfurDioxide, totalSulfurDioxide, density, pH, sulphates, alcohol, quality, color
        );
    }
}
