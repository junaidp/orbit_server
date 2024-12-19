package com.example.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncentiveSetupService {
    @Autowired
    private IncentiveSetupRepository incentiveSetupRepository;

    public IncentiveSetup createIncentive(IncentiveSetup incentiveSetup) {
        return incentiveSetupRepository.save(incentiveSetup);
    }

    public List<IncentiveSetup> getAllIncentives() {
        return incentiveSetupRepository.findAll();
    }

    public IncentiveSetup getIncentiveById(String id) {
        return incentiveSetupRepository.findById(id).orElse(null);
    }

    public IncentiveSetup updateIncentive(String id, IncentiveSetup incentiveSetup) {
        incentiveSetup.setId(id);
        return incentiveSetupRepository.save(incentiveSetup);
    }

    public void deleteIncentive(String id) {
        incentiveSetupRepository.deleteById(id);
    }
}
