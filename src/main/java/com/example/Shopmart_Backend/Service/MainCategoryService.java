package com.example.Shopmart_Backend.Service;

import com.example.Shopmart_Backend.Entity.MainCategory;
import com.example.Shopmart_Backend.Repository.MainCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class MainCategoryService {

    @Autowired
    private MainCategoryRepository repository;

    public MainCategory save(String name, MultipartFile pic, Boolean status) throws Exception {

        File uploadFolder = new File(System.getProperty("user.dir"), "uploads");

        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String imageName = pic.getOriginalFilename();

        File destination = new File(uploadFolder, imageName);

        pic.transferTo(destination);

        // Save data into database
        MainCategory category = new MainCategory();

        category.setName(name);
        category.setPic(imageName);
        category.setStatus(status);

        return repository.save(category);
    }
    public List<MainCategory> getAll() {

        return repository.findAll();
    }
    // Delete
    public void delete(Long id) {

        repository.deleteById(id);
    }
    public MainCategory update(Long id, String name, MultipartFile pic, Boolean status) throws Exception {

        MainCategory category = repository.findById(id).orElseThrow();

        // Update name only if received
        if (name != null && !name.trim().isEmpty()) {
            category.setName(name);
        }
        String uploadPath = System.getProperty("user.dir") + File.separator + "uploads";
        File uploadFolder = new File(uploadPath);

        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }
        // If a new image is selected, save it
        if (pic != null && !pic.isEmpty()) {
            String imageName = pic.getOriginalFilename();
            File destination = new File(uploadFolder, imageName);
            pic.transferTo(destination);
            category.setPic(imageName);
        }
        // Update status only if received
        if (status != null) {
            category.setStatus(status);
        }
        return repository.save(category);
    }
}