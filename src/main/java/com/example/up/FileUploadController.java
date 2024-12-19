package com.example.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload-excel")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            String message = fileStorageService.saveFile(file);
            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
        }
    }
}


/*package com.example.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ResponseEntityResult responseEntityResult;

    @Autowired
    private ResponseObject responseObject;

    @PostMapping("/upload-excel")
    public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty() || !file.getOriginalFilename().endsWith(".xlsx")) {
                responseObject.setCode("400");
                responseObject.setStatus(false);
                responseObject.setMessage("Invalid Excel file.");
                return responseEntityResult.createResponse(responseObject);
            }

            String message = fileStorageService.saveFile(file);
            responseObject.setCode("200");
            responseObject.setStatus(true);
            responseObject.setMessage(message);
            return responseEntityResult.createResponse(responseObject);

        } catch (IOException e) {
            responseObject.setCode("500");
            responseObject.setStatus(false);
            responseObject.setMessage("File upload failed: " + e.getMessage());
            return responseEntityResult.createResponse(responseObject);
        }
    }
}*/

/*
package com.example.up;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileUploadController {
    @Autowired
    private FileStorageService fileStorageService;
    private final ResponseObject responseObject; // Generic Response Object
    private final ResponseEntityResult responseEntityResult;

    public FileUploadController(ResponseObject responseObject, ResponseEntityResult responseEntityResult) {
        this.responseObject = responseObject;
        this.responseEntityResult = responseEntityResult;
    }


    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) {
        String filename = file.getOriginalFilename();
        if (filename == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file.");
        }

        String fileExtension = getFileExtension(filename);

        if ("xlsx".equalsIgnoreCase(fileExtension)) {
            return responseEntityResult.responseEntity(fileStorageService.uploadExcel(file,httpServletRequest,responseObject));
        } else if ("csv".equalsIgnoreCase(fileExtension)) {
            return responseEntityResult.responseEntity(fileStorageService.uploadCSV(file,httpServletRequest,responseObject));
        } else {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Unsupported file format.");
        }
    }

    private String getFileExtension(String filename) {
        int lastIndexOfDot = filename.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return ""; // No extension
        }
        return filename.substring(lastIndexOfDot + 1);
    }}
*/
/*package com.example.up;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload-excel")
    public ResponseEntity<FileUploadResponse> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty() || !file.getOriginalFilename().endsWith(".xlsx")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new FileUploadResponse("Please upload a valid Excel file.", null));
            }

            String filePath = fileStorageService.saveFile(file);
            return ResponseEntity.ok(new FileUploadResponse("File uploaded successfully", filePath));

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new FileUploadResponse("Failed to upload file: " + e.getMessage(), null));
        }
    }
}
*/