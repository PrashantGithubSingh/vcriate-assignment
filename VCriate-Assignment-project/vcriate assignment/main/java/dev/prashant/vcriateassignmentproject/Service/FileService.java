package dev.prashant.vcriateassignmentproject.Service;

import dev.prashant.vcriateassignmentproject.Entity.FileEntity;
import dev.prashant.vcriateassignmentproject.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(MultipartFile file, Long userId) throws IOException {
        // Implement logic to save file to disk and save metadata to DB
        // Increment version if file with same name exists for user
        String filename = file.getOriginalFilename();
        String filepath = "/files/" + filename;
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFilename(filename);
        fileEntity.setFilepath(filepath);
        fileEntity.setUserId(userId);
        fileEntity.setVersion(getNextVersion(filename, userId));
        fileEntity.setShared(false);
        fileRepository.save(fileEntity);
        // Save file to disk
        Files.copy(file.getInputStream(), Paths.get(filepath), StandardCopyOption.REPLACE_EXISTING);
        return fileEntity;
    }

    private Integer getNextVersion(String filename, Long userId) {
        List<FileEntity> files = fileRepository.findByFilenameAndUserId(filename, userId);
        return files.size() + 1;
    }
}
