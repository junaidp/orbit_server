package com.example.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/referrals")
public class ReferralFormController {
    @Autowired
    private ReferralFormService referralFormService;

    @PostMapping
    public ReferralForm createReferral(@RequestBody ReferralForm referralForm) {
        return referralFormService.createReferral(referralForm);
    }

    @GetMapping
    public List<ReferralForm> getAllReferrals() {
        return referralFormService.getAllReferrals();
    }
    
    @GetMapping("/{id}")
    public ReferralForm getReferralById(@PathVariable String id) {
        return referralFormService.getReferralById(id);
    }

    @PutMapping("/{id}")
    public ReferralForm updateReferral(@PathVariable String id, @RequestBody ReferralForm referralForm) {
        return referralFormService.updateReferral(id, referralForm);
    }

    @DeleteMapping("/{id}")
    public void deleteReferral(@PathVariable String id) {
        referralFormService.deleteReferral(id);
    }
}
