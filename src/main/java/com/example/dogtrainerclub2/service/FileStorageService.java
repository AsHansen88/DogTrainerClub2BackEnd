package com.example.dogtrainerclub2.service;

import com.example.dogtrainerclub2.model.FileDB;
import com.example.dogtrainerclub2.repository.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }

  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
  // Delete file

  public boolean delete(String fileName) {
    try {
      boolean found = fileDBRepository.existsById(fileName);

      fileDBRepository.deleteById(fileName);

      found = fileDBRepository.existsById(fileName);
      if (!found)
      {
        return true;
      }
      else
      {
        return false;
      }

    } catch (Exception e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }
}

