package com.istad.projectthymeleaf.service;

import com.istad.projectthymeleaf.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
