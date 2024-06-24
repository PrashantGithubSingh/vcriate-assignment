package dev.prashant.vcriateassignmentproject.Repository;

import dev.prashant.vcriateassignmentproject.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByUserId(Long userId);

    List<FileEntity> findByFilenameAndUserId(String filename, Long userId);
}
