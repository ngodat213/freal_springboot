package com.example.frealsb.Modules.Cloudinary.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Service class for handling operations with Cloudinary.
 */
@Service
public class CloudinaryService implements ICloudinaryService {

    @Autowired
    private Cloudinary cloudinaryConfig;
    private String link = "https://res.cloudinary.com/duhncgkpo/image/upload/v1717508494/";
    private String extensionImage = ".png";

    /**
     * Uploads a file to Cloudinary.
     *
     * @param file the file to be uploaded.
     * @return the URL of the uploaded file.
     * @throws RuntimeException if an error occurs during the upload process.
     */
    public String uploadFile(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrlByPublicId(String publicId) {
        return link + publicId + extensionImage;
    }

    /**
     * Deletes a file from Cloudinary by its public ID.
     *
     * @param publicId the public ID of the file to be deleted.
     * @throws RuntimeException if an error occurs during the deletion process.
     */
    public void delete(String publicId) {
        try {
            cloudinaryConfig.uploader().destroy(publicId, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a MultipartFile to a File.
     *
     * @param file the MultipartFile to be converted.
     * @return the converted File.
     * @throws IOException if an error occurs during the conversion process.
     */
    public File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
