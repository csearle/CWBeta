package com.cannawellness.chris.cwbeta;
public class Strain {
    private int id; // Strain id
    private String lp_name; //Name given by the LP (Licensed Producer)
    private String strain_name; //Name of the strain
    private double price_per_gram; //The price of the strain per gram
    private double sativa_indica_ratio; // 0.00 to 1.00 Sativa index  - 60/40, 50/50, 75/25 etc
    private double thc_pct; //0.00 to 1.00 Percentage of THC
    private double cbd_pct; //0.00 to 1.00 Percentage of CBD
    private int lp_id; //Id of the Licensed Producer
    private String strain_type; //Sativa, indica, hybrid.
    private String lp; //Name of the LP that the strain belongs to

    public Strain()
    {

    }
    public Strain(int id, String lpName, String strain, double price, double ratio, double tpct, double cpct, int LPid, String type, String lp)
    {

        this.id=id;
        this.lp_name=lpName;
        this.strain_name=strain;
        this.price_per_gram = price;
        this.sativa_indica_ratio = ratio;
        this.thc_pct = tpct;
        this.cbd_pct = cpct;
        this.lp_id = LPid;
        this.strain_type = type;
        this.lp = lp;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLPName(String name) { this.lp_name = name;}
    public void setName(String name){ this.strain_name = name;}
    public void setPrice(double price){ this.price_per_gram = price;}
    public void setRatio(double ratio){ this.sativa_indica_ratio = ratio;}
    public void setTHC(double pct){ this.thc_pct = pct;}
    public void setCBD(double cbd){ this.cbd_pct = cbd;}
    public void setLPid(int id){this.lp_id = id;}
    public void setType(String type){this.strain_type = type;}
    public void setLP(String lp){ this.lp = lp;}

    // get the strain information
    public int getId() {return id;}
    public String getLPName(){ return lp_name;}
    public String getName(){ return strain_name;}
    public double getPrice(){ return price_per_gram;}
    public double getRatio(){ return sativa_indica_ratio;}
    public double getTHC(){ return thc_pct;}
    public double getCBD(){ return cbd_pct;}
    public int getLPid(){ return lp_id;}
    public String getType(){ return strain_type;}
    public String getLP(){ return lp;}

}