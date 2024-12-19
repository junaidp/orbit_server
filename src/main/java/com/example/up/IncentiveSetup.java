package com.example.up;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "incentives")
@Data
public class IncentiveSetup {
    @Id
    private String id;
    private String campaignName;
    private String startDate;
    private String endDate;
    private String targetType; // General or Targeted
    private boolean targetCompany;
    private boolean targetPerson;
    private boolean targetSectorIndustry;
    private String targetName;
    private String incentiveType; // Fixed fee or Percentage
    private String incentiveAmount;
    private String conditions;
    private String buyerIncentive;
}
