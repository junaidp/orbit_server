package com.example.up;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private static final String UPLOAD_DIR = "D:\\Storage"; // Change this path as needed

    public String saveFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filePath = UPLOAD_DIR + File.separator + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return "File uploaded successfully: " + file.getOriginalFilename();
    }
}

/*package com.example.up;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private static final String UPLOAD_DIR = "D:\\Storage";

    public String saveFile(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filePath = UPLOAD_DIR + File.separator + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return "File uploaded successfully: " + file.getOriginalFilename();
    }
}*/


/*package com.example.up;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.management.openmbean.SimpleType.STRING;

@Service
public class FileStorageService {
    private static final Object NUMERIC = 0;

    // Method to handle Excel file upload
    public ResponseObject uploadExcel(MultipartFile file, HttpServletRequest httpServletRequest, ResponseObject responseObject) {
        Object requesterDetail;
        requesterDetail.requesterLog(httpServletRequest, null, null, FileStorageService.class, "uploadExcel");
        List<Employee> employeeList = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Employee employee = new Employee();
                if (row.getRowNum() == 0) { // Skip header row
                    continue;
                }
                try {
                    employee.setLinkedin_id(getCellStringValue(row.getCell(0)));
                    employee.setName(getCellStringValue(row.getCell(1)));
                    employee.setCountry_code(getCellStringValue(row.getCell(2)));
                    employee.setPosition(getCellStringValue(row.getCell(3)));
                    employee.setCity(getCellStringValue(row.getCell(4)));
                    employee.setCurrent_company(getCellStringValue(row.getCell(5)));
                    employee.setAbout(getCellStringValue(row.getCell(6)));
                    employee.setPosts(getCellStringValue(row.getCell(7)));
                    employee.setExperience(getCellStringValue(row.getCell(8)));
                    employee.setUrl(getCellStringValue(row.getCell(9)));
                    // Add other fields in sequence
                    employee.setPeople_also_viewed(getCellStringValue(row.getCell(10)));
                    employee.setEducation_details(getCellStringValue(row.getCell(11)));
                    employee.setEducation(getCellStringValue(row.getCell(12)));
                    employee.setRecommendations_count(getCellStringValue(row.getCell(13)));
                    employee.setAvatar(getCellStringValue(row.getCell(14)));
                    employee.setLanguages(getCellStringValue(row.getCell(15)));
                    employee.setCertifications(getCellStringValue(row.getCell(16)));
                    employee.setRecommendations(getCellStringValue(row.getCell(17)));
                    employee.setVolunteer_experience(getCellStringValue(row.getCell(18)));
                    employee.setCourses(getCellStringValue(row.getCell(19)));
                    employee.setFollowers(getCellStringValue(row.getCell(20)));
                    employee.setConnections(getCellStringValue(row.getCell(21)));
                    employee.setCurrent_company_company_id(getCellStringValue(row.getCell(22)));
                    employee.setCurrent_company_name(getCellStringValue(row.getCell(23)));
                    employee.setPublications(getCellStringValue(row.getCell(24)));
                    employee.setPatents(getCellStringValue(row.getCell(25)));
                    employee.setProjects(getCellStringValue(row.getCell(26)));
                    employee.setOrganizations(getCellStringValue(row.getCell(27)));
                    employee.setInput_url(getCellStringValue(row.getCell(28)));
                    employee.setId(getCellStringValue(row.getCell(29)));
                    employee.setActivity(getCellStringValue(row.getCell(30)));
                    employee.setLinkedin_num_id(getCellStringValue(row.getCell(31)));
                    employee.setBanner_image(getCellStringValue(row.getCell(32)));
                    employee.setTimestamp(getCellStringValue(row.getCell(33)));

                    employees.add(employee);
                }
                            return employees;
            }


            SimpleJpaRepository employeeRepository;
            employeeRepository.saveAll(employeeList);
            workbook.close();
            responseObject.setCode("200");
            responseObject.setStatus(true);
            responseObject.setData(null);
            responseObject.setMessage("Excel file uploaded and data saved successfully");
            return responseObject;

        } catch (Exception e) {
            responseObject.setCode("500");
            responseObject.setStatus(false);
            responseObject.setData(null);
            responseObject.setMessage("Failed to upload previous observations");
            return responseObject;

        }

    }

    private String getCellStringValue(Cell cell) {
        return null;
    }

    public ResponseObject uploadCSV(MultipartFile file, HttpServletRequest httpServletRequest, ResponseObject responseObject) {
        Object  RequestDetail requesterDetail;
        requesterDetail.requesterLog(httpServletRequest, null, null, FileStorageService.class, "uploadCSV");
        List<employee> employeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] line;
            boolean isFirstLine = true;
            while ((line = csvReader.readNext()) != null) {
                if (isFirstLine) { // Skip header row
                    isFirstLine = false;
                    continue;
                }
                Employee employee = new Employee();
                if (row.getRowNum() == 0) continue;  // Skip the header row

                employee.setLinkedin_id(getCellStringValue(row.getCell(0)));
                employee.setName(getCellStringValue(row.getCell(1)));
                employee.setCountry_code(getCellStringValue(row.getCell(2)));
                employee.setPosition(getCellStringValue(row.getCell(3)));
                employee.setCity(getCellStringValue(row.getCell(4)));
                employee.setCurrent_company(getCellStringValue(row.getCell(5)));
                employee.setAbout(getCellStringValue(row.getCell(6)));
                employee.setPosts(getCellStringValue(row.getCell(7)));
                employee.setExperience(getCellStringValue(row.getCell(8)));
                employee.setUrl(getCellStringValue(row.getCell(9)));
                // Add other fields in sequence
                employee.setPeople_also_viewed(getCellStringValue(row.getCell(10)));
                employee.setEducation_details(getCellStringValue(row.getCell(11)));
                employee.setEducation(getCellStringValue(row.getCell(12)));
                employee.setRecommendations_count(getCellStringValue(row.getCell(13)));
                employee.setAvatar(getCellStringValue(row.getCell(14)));
                employee.setLanguages(getCellStringValue(row.getCell(15)));
                employee.setCertifications(getCellStringValue(row.getCell(16)));
                employee.setRecommendations(getCellStringValue(row.getCell(17)));
                employee.setVolunteer_experience(getCellStringValue(row.getCell(18)));
                employee.setCourses(getCellStringValue(row.getCell(19)));
                employee.setFollowers(getCellStringValue(row.getCell(20)));
                employee.setConnections(getCellStringValue(row.getCell(21)));
                employee.setCurrent_company_company_id(getCellStringValue(row.getCell(22)));
                employee.setCurrent_company_name(getCellStringValue(row.getCell(23)));
                employee.setPublications(getCellStringValue(row.getCell(24)));
                employee.setPatents(getCellStringValue(row.getCell(25)));
                employee.setProjects(getCellStringValue(row.getCell(26)));
                employee.setOrganizations(getCellStringValue(row.getCell(27)));
                employee.setInput_url(getCellStringValue(row.getCell(28)));
                employee.setId(getCellStringValue(row.getCell(29)));
                employee.setActivity(getCellStringValue(row.getCell(30)));
                employee.setLinkedin_num_id(getCellStringValue(row.getCell(31)));
                employee.setBanner_image(getCellStringValue(row.getCell(32)));
                employee.setTimestamp(getCellStringValue(row.getCell(33)));
            }

            employeeRepository.saveAll(employeeList);
            responseObject.setCode("200");
            responseObject.setStatus(true);
            responseObject.setData(null);
            responseObject.setMessage("CSV file uploaded and data saved successfully");
            return responseObject;

        } catch (Exception e) {

            sl4J.writeLog(LogLevel4j.ERROR, FileStorageService.class, "uploadCSV", e.toString());
            responseObject.setCode("500");
            responseObject.setStatus(false);
            responseObject.setData(null);
            responseObject.setMessage("Failed to upload previous observations");
            return responseObject;

        }


    }

}*/
/*package com.example.up;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private static final String UPLOAD_DIR = "D:\\Storage"; // Change as needed

    public String saveFile(MultipartFile file) throws IOException {
        // Ensure the directory exists
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save the file
        String filePath = UPLOAD_DIR + File.separator + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return filePath;
    }
}

*/

/*package com.example.up;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FileStorageService {

    private static final Logger log = Logger.getLogger(FileStorageService.class.getName());

    public ResponseObject uploadExcel(MultipartFile file, long companyId, HttpServletRequest httpServletRequest, ResponseObject responseObject) {
        List<PreviousObservations> observationsList = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                PreviousObservations observation = new PreviousObservations();
                observation.setObservation(row.getCell(0).getStringCellValue());
                observation.setManagementComments(row.getCell(1).getStringCellValue());
                observation.setCompanyId(companyId);
                observationsList.add(observation);
            }
            responseObject.setStatus(true);
            responseObject.setMessage("Excel file processed successfully.");
        } catch (Exception e) {
            responseObject.setStatus(false);
            responseObject.setMessage("Failed to process Excel: " + e.getMessage());
        }
        return responseObject;
    }

    public ResponseObject uploadCSV(MultipartFile file, long companyId, HttpServletRequest httpServletRequest, ResponseObject responseObject) {
        List<PreviousObservations> observationsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] line;
            boolean isFirstLine = true;
            while ((line = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip header
                }
                PreviousObservations observation = new PreviousObservations();
                observation.setObservation(line[0]);
                observation.setManagementComments(line[1]);
                observation.setCompanyId(companyId);
                observationsList.add(observation);
            }
            responseObject.setStatus(true);
            responseObject.setMessage("CSV file processed successfully.");
        } catch (Exception e) {
            responseObject.setStatus(false);
            responseObject.setMessage("Failed to process CSV: " + e.getMessage());
        }
        return responseObject;
    }
}
*/


/*
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
@Service
public class FileStorageService {

    private static final String STORAGE_DIRECTORY = "D:\\Storage";

    public void saveFile(MultipartFile fileToSave) throws IOException {
        if (fileToSave == null || fileToSave.isEmpty()) {
            throw new IllegalArgumentException("No file provided or file is empty");
        }

        var targetFile = new File(STORAGE_DIRECTORY + File.separator + fileToSave.getOriginalFilename());

        // Validate that the file is saved within the intended directory
        if (!targetFile.getParent().equals(STORAGE_DIRECTORY)) {
            throw new SecurityException("Unsupported filename or directory traversal attempt");
        }

        // Log the file name and proceed with saving
        System.out.println("Saving file: " + fileToSave.getOriginalFilename());

        Files.copy(fileToSave.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
*/
/*
@Service
public class FileStorageService {

    private static final String STORAGE_DIRECTORY = "D:\\Storage";
    public void saveFile(MultipartFile fileToSave) throws IOException {
        if (fileToSave == null){
            throw new NullPointerException("fileToSave is null");
        }
        var targetFile = new File( STORAGE_DIRECTORY + File.separator + fileToSave.getOriginalFilename());
        if (!Objects.equals(targetFile.getParent(),STORAGE_DIRECTORY)){
            throw new SecurityException("Unsupported filename");
        }
        Files.copy(fileToSave.getInputStream(),targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}*/