package com.example.up;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "companies")
public class Company {

    @Id
    private String id;
    private String companyId;
    private String companyName;
    private String linkedinUrl;
    private String primaryContactName;
    private String primaryContactEmail;
    private String primaryContactPhoneWhatsapp;
    private String primaryContactLinkedinProfileUrl;
    private String introductoryAgreement;
    private List<String> inclusions;
    private List<String> exclusionsPeopleAndRoleType;
    private List<String> exclusionsCompetitors;
    private List<String> exclusionsExistingClients;
    private List<ClientTestimonial> clientTestimonials;
    private ReferralPaymentHistory referralPaymentHistory;
    private String howItWorks;
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public String getPrimaryContactEmail() {
        return primaryContactEmail;
    }

    public void setPrimaryContactEmail(String primaryContactEmail) {
        this.primaryContactEmail = primaryContactEmail;
    }

    public String getPrimaryContactPhoneWhatsapp() {
        return primaryContactPhoneWhatsapp;
    }

    public void setPrimaryContactPhoneWhatsapp(String primaryContactPhoneWhatsapp) {
        this.primaryContactPhoneWhatsapp = primaryContactPhoneWhatsapp;
    }

    public String getPrimaryContactLinkedinProfileUrl() {
        return primaryContactLinkedinProfileUrl;
    }

    public void setPrimaryContactLinkedinProfileUrl(String primaryContactLinkedinProfileUrl) {
        this.primaryContactLinkedinProfileUrl = primaryContactLinkedinProfileUrl;
    }

    public String getIntroductoryAgreement() {
        return introductoryAgreement;
    }

    public void setIntroductoryAgreement(String introductoryAgreement) {
        this.introductoryAgreement = introductoryAgreement;
    }

    public List<String> getInclusions() {
        return inclusions;
    }

    public void setInclusions(List<String> inclusions) {
        this.inclusions = inclusions;
    }

    public List<String> getExclusionsPeopleAndRoleType() {
        return exclusionsPeopleAndRoleType;
    }

    public void setExclusionsPeopleAndRoleType(List<String> exclusionsPeopleAndRoleType) {
        this.exclusionsPeopleAndRoleType = exclusionsPeopleAndRoleType;
    }

    public List<String> getExclusionsCompetitors() {
        return exclusionsCompetitors;
    }

    public void setExclusionsCompetitors(List<String> exclusionsCompetitors) {
        this.exclusionsCompetitors = exclusionsCompetitors;
    }

    public List<String> getExclusionsExistingClients() {
        return exclusionsExistingClients;
    }

    public void setExclusionsExistingClients(List<String> exclusionsExistingClients) {
        this.exclusionsExistingClients = exclusionsExistingClients;
    }

    public List<ClientTestimonial> getClientTestimonials() {
        return clientTestimonials;
    }

    public void setClientTestimonials(List<ClientTestimonial> clientTestimonials) {
        this.clientTestimonials = clientTestimonials;
    }

    public ReferralPaymentHistory getReferralPaymentHistory() {
        return referralPaymentHistory;
    }

    public void setReferralPaymentHistory(ReferralPaymentHistory referralPaymentHistory) {
        this.referralPaymentHistory = referralPaymentHistory;
    }

    public String getHowItWorks() {
        return howItWorks;
    }

    public void setHowItWorks(String howItWorks) {
        this.howItWorks = howItWorks;
    }
}

class ClientTestimonial {
    private String name;
    private String company;
    private String position;
    private String logoUpload;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogoUpload() {
        return logoUpload;
    }

    public void setLogoUpload(String logoUpload) {
        this.logoUpload = logoUpload;
    }
}

class ReferralPaymentHistory {
    private int numberOfSuccessfulReferrals;
    private double averageIncentivePaid;

    // Getters and Setters
    public int getNumberOfSuccessfulReferrals() {
        return numberOfSuccessfulReferrals;
    }

    public void setNumberOfSuccessfulReferrals(int numberOfSuccessfulReferrals) {
        this.numberOfSuccessfulReferrals = numberOfSuccessfulReferrals;
    }

    public double getAverageIncentivePaid() {
        return averageIncentivePaid;
    }

    public void setAverageIncentivePaid(double averageIncentivePaid) {
        this.averageIncentivePaid = averageIncentivePaid;
    }
}
