package com.example.InventoryManagementSystem.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    private final String uploadDir = "uploads/thuong-hieu/";

    public String saveFile(MultipartFile file) throws IOException {
        // Tạo thư mục nếu chưa tồn tại
        Files.createDirectories(Paths.get(uploadDir));

        // Tạo tên file duy nhất bằng cách thêm timestamp
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");

        // Lưu file vào thư mục
        Path filePath = Paths.get(uploadDir + fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName; // Trả về tên file đã lưu
    }
}
