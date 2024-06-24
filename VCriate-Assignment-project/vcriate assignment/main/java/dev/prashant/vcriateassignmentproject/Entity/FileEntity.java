package dev.prashant.vcriateassignmentproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class FileEntity {
    private Long id;
    private String filename;
    private String filePath;
    private Long userId;
    private  Integer version;
    private boolean shared;


    public void setFilepath(String filepath) {
    }
}
