package org.example.school;

public class HighSchool extends School{
    private Boolean hasGraduation;
    public HighSchool(String schoolName, String schoolAddress, String schoolEmail, String schoolPhone, float balance,boolean hasGraduation){
        super(schoolName,schoolAddress,schoolEmail,schoolPhone,balance);
        this.hasGraduation = hasGraduation;
    }
    public Boolean getHasGraduation() {
        return hasGraduation;
    }
}
