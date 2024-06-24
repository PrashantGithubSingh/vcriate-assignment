package dev.prashant.vcriateassignmentproject.Controller;

import dev.prashant.vcriateassignmentproject.Entity.FileEntity;
import dev.prashant.vcriateassignmentproject.Service.FileService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/api/files")
public class Controller {
    @Autowired
    private FileService fileservice;
    @PostMapping("/upload")
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file, Principal principal) throws IOException {
        Long userId = // Get user ID from principal
                 FileEntity FileService fileService = new FileService();
        FileEntity fileEntity  = fileService.saveFile(file, userId);
        return ResponseEntity.ok(fileEntity);
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        // Implement file download logic
    }
    @PostMapping("/share/{id}")
    public ResponseEntity<Void> shareFile(@PathVariable Long id) {
        // Implement file sharing logic
    }
}
//File Download:
//Implement logic in the FileService to read the file from disk and return as a Resource.
//File Sharing:
//Add logic to update the shared attribute of FileEntity.
//File Versioning:
//Adjust the saveFile method to handle file versioning appropriately.
