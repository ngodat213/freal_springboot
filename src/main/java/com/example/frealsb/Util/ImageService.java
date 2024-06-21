package com.example.frealsb.Util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Util.Model.ImageStorage;
import com.example.frealsb.Util.Model.ImageStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ImageService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ImageStorageRepository pImageRepository;

    public List<ImageStorage> uploadPostImages(MultipartFile[] images, Post post){
        List<ImageStorage> imagesList = new ArrayList<>();
        for(MultipartFile image: images){
            Map uploadResult = uploadImageToCloudinary(image);
            ImageStorage pImage =  pImageRepository.save(
                    new ImageStorage(
                            uploadResult.get("url").toString(),
                            uploadResult.get("asset_id").toString(),
                            uploadResult.get("public_id").toString(), post)
            );
            imagesList.add(pImage);
        }
        return imagesList;
    }

    public ImageStorage uploadImage(MultipartFile image){
        Map uploadResult = uploadImageToCloudinary(image);
        return  pImageRepository.save(
                new ImageStorage(
                        uploadResult.get("url").toString(),
                        uploadResult.get("asset_id").toString(),
                        uploadResult.get("public_id").toString())
        );
    }
    
    private Map uploadImageToCloudinary(MultipartFile image){
        if(!image.isEmpty() && isImage(image)){
            byte[] imageBytes = getResizedAndFormattedImageBytes(image);
            try{
                return cloudinary.uploader()
                        .upload(imageBytes, ObjectUtils.emptyMap());

            }catch (IOException ex) {}
        }
        else
            throw new RuntimeException("Unsupported file format");
        return null;
    }
    private boolean isImage(MultipartFile file) {
        return file.getContentType() != null && file.getContentType().startsWith("image");
    }
    private byte[] getResizedAndFormattedImageBytes(MultipartFile image){
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        try{
            Thumbnails.of(new ByteArrayInputStream(image.getBytes()))
                    .size(300, 300)
                    .outputFormat("jpg")
                    .outputQuality(0.9)
                    .toOutputStream(resultStream);
        }catch (IOException ex){}
        return resultStream.toByteArray();
    }

    public void deleteProductImage(String publicId) {
        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}