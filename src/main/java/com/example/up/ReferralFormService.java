package com.example.up;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReferralFormService {
    @Autowired
    private ReferralFormRepository referralFormRepository;

    public ReferralForm createReferral(ReferralForm referralForm) {
        return referralFormRepository.save(referralForm);
    }

    public List<ReferralForm> getAllReferrals() {
        return referralFormRepository.findAll();
    }

    public ReferralForm getReferralById(String id) {
        return referralFormRepository.findById(id).orElse(null);
    }

    public ReferralForm updateReferral(String id, ReferralForm referralForm) {
        referralForm.setId(id);
        return referralFormRepository.save(referralForm);
    }

    public void deleteReferral(String id) {
        referralFormRepository.deleteById(id);
    }
}

