package com.example.frealsb.Modules.Cloudinary.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface ICloudinaryService {
    String uploadFile(MultipartFile file);
    File convertMultiPartToFile(MultipartFile file) throws IOException;
    void delete(String publicId);
}
