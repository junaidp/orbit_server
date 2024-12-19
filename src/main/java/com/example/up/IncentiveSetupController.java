package com.example.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incentives")
public class IncentiveSetupController {
    @Autowired
    private IncentiveSetupService incentiveSetupService;

    @PostMapping
    public IncentiveSetup createIncentive(@RequestBody IncentiveSetup incentiveSetup) {
        return incentiveSetupService.createIncentive(incentiveSetup);
    }

    @GetMapping
    public List<IncentiveSetup> getAllIncentives() {
        return incentiveSetupService.getAllIncentives();
    }

    @GetMapping("/{id}")
    public IncentiveSetup getIncentiveById(@PathVariable String id) {
        return incentiveSetupService.getIncentiveById(id);
    }

    @PutMapping("/{id}")
    public IncentiveSetup updateIncentive(@PathVariable String id, @RequestBody IncentiveSetup incentiveSetup) {
        return incentiveSetupService.updateIncentive(id, incentiveSetup);
    }

    @DeleteMapping("/{id}")
    public void deleteIncentive(@PathVariable String id) {
        incentiveSetupService.deleteIncentive(id);
    }
}
