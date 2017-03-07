package com.cannawellness.chris.cwbeta;

/**
 * Created by chris on 2/22/2017.
 */
public class QuestionaireAnswers {
    private String patient;
    private int id;
    private int relationshipStatus;
    private int numChildren;
    private String familyDoctor;
    private int lastTestDate;
    private int alcConsumption;
    private int smokeConsumption;
    private boolean employed;
    private boolean militaryResponder;
    private String familyHistory;
    private int concussion;
    private String canabisUsage;
    private String otherTreatments;
    private String concerns;

    public QuestionaireAnswers(){}

    public QuestionaireAnswers(String patient, int id, int relationshipStatus, int numChildren, String familyDoctor,
                               int lastTestDate, int alcConsumption, int smokeConsumption, boolean employed, boolean militaryResponder,
                               String familyHistory, int concussion, String canabisUsage, String otherTreatments, String concerns){

        this.patient = patient;
        this.id = id;
        this.relationshipStatus = relationshipStatus;
        this.numChildren = numChildren;
        this.familyDoctor = familyDoctor;
        this.lastTestDate = lastTestDate;
        this.alcConsumption = alcConsumption;
        this.smokeConsumption = smokeConsumption;
        this.employed = employed;
        this.militaryResponder = militaryResponder;
        this.familyHistory = familyHistory;
        this.concussion = concussion;
        this.canabisUsage = canabisUsage;
        this.otherTreatments = otherTreatments;
        this.concerns = concerns;
    }

    //Set Methods
    public void setPatient(String patient) {
        this.patient = patient;
    }
    public void setId(int id) { this.id = id;}
    public void setRelationshipStatus(int relationshipStatus){ this.relationshipStatus = relationshipStatus;}
    public void setAlcConsumption(int alcConsumption){ this.alcConsumption = alcConsumption;}
    public void setSmokeConsumption(int smokeConsumption){ this.smokeConsumption = smokeConsumption;}
    public void setEmployed(boolean employed){ this.employed = employed;}
    public void setMilitaryResponder(boolean militaryResponder){ this.militaryResponder = militaryResponder;}
    public void setFamilyHistpory(String familyHistory){this.familyHistory = familyHistory;}
    public void setConcussion(int concussion){this.concussion = concussion;}
    public void setCanabisUsage(String canabisUsage){this.canabisUsage = canabisUsage;}
    public void setOtherTreatments(String otherTreatments){this.otherTreatments = otherTreatments;}
    public void setConcerns(String concerns){this.concerns = concerns;}

    //Get Methods
    public String getPatient(){ return this.patient;}
    public int getId(){ return this.id;}
    public int getRelationshipStatus(){ return this.relationshipStatus;}
    public int getNumChildren(){ return this.numChildren;}
    public String getFamilyDoctor(){ return this.familyDoctor;}
    public int getLastTestDate(){ return this.lastTestDate;}
    public int getAlcConsumption(){ return this.alcConsumption;}
    public int getSmokeConsumption(){ return this.smokeConsumption;}
    public boolean getEmployed(){ return this.employed;}
    public boolean getMilitaryResponder() {return this.militaryResponder;}
    public String getFamilyHistory() {return this.familyHistory;}
    public int getConcussion() {return this.concussion;}
    public String getCanabisUsage() {return this.canabisUsage;}
    public String getOtherTreatments() {return this.otherTreatments;}
    public String getConcerns() {return this.concerns;}

}
