package com.electronic.until;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
	private final Path root = Paths.get("src/main/resources/static/uploads");

	@Override
	public void saveone(MultipartFile file) {
		try {
		Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch (IOException ioe) {
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error " + e.getMessage());
		}
	}

	@Override
	public void savelist(MultipartFile[] files) {

		for (MultipartFile fileData : files) {
			String name = fileData.getOriginalFilename();
			if (name != null && name.length() > 0) {
				try {
					Files.copy(fileData.getInputStream(), this.root.resolve(fileData.getOriginalFilename()));
				} catch (IOException ioe) {
					ioe.printStackTrace();;
				} catch (Exception e) {
					throw new RuntimeException("Could not store the file. Error " + e.getMessage());
				}
			}
		}
	}

}
