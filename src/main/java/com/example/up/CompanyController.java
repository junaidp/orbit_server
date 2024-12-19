package com.example.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Save Company Data
    @PostMapping("/save")
    public Company saveCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    // Get All Companies
    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Get a Company by ID
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable String id) {
        return companyService.getCompanyById(id);
    }

    // Get a Company by CompanyId
    @GetMapping("/byCompanyId/{companyId}")
    public Company getCompanyByCompanyId(@PathVariable String companyId) {
        return companyService.getCompanyByCompanyId(companyId);
    }
}
