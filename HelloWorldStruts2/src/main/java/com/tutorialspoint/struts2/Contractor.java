package com.tutorialspoint.struts2;

/**
 * Contractor class. 
 * 
 */

public class Contractor{

    private int contractorPrimaryKey;
    private int userForeignKey;

    public int getContractorPrimaryKey(){
        return contractorPrimaryKey;
    }
    public void setContractorPrimaryKey(int contractorPrimaryKey){
        this.contractorPrimaryKey = contractorPrimaryKey;
        return;
    }
    public int getUserForeignKey(){
        return UserForeignKey;
    }
    public void setUserForeignKey(int userForeignKey){
    //TODO: see note in setUserForeignKey() in Client.java
        this.userForeignKey = userForeignKey;
        return;
    }
}
