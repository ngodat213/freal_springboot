package com.example.frealsb.Services.Interface;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {
    String uploadFile(MultipartFile file);
    File convertMultiPartToFile(MultipartFile file) throws IOException;
    void delete(String publicId);
}
