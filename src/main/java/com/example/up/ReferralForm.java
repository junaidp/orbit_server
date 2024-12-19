package com.example.up;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "referrals")
@Data
public class ReferralForm {
    @Id
    private String id;
    private String companyName;
    private String sector;
    private String opportunityDetails;
    private String possibleValue;
    private String contactName;
    private String contactPosition;
    private String contactEmail;
    private String contactPhone;
    private String accountName;
    private String sortCode;
    private String accountNumber;
}

