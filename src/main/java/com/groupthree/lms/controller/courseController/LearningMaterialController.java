package com.groupthree.lms.controller.courseController;



import com.groupthree.lms.service.courseService.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/learning-materials")
public class LearningMaterialController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = s3Service.uploadFile(file);
            // Here you would typically save the file information to your database
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }

    @DeleteMapping("/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        try {
            s3Service.deleteFile(fileName);
            // Here you would typically remove the file information from your database
            return ResponseEntity.ok("File deleted successfully: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete file: " + e.getMessage());
        }
    }
}
