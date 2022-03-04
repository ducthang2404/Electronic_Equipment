package com.electronic.until;


import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

	public void saveone(MultipartFile file);
	
	public void savelist(MultipartFile[] files);
}
