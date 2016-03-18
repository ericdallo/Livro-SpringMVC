package com.livrospring.upload;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class FileSaver {
	
	private static final String APP_PATH = "http://localhost:9444/s3/casadocodigo/";
	
	@Autowired
	private AmazonS3Client s3;

	public String write(String baseFolder, MultipartFile file) {
		
		try {
			s3.putObject("casadocodigo", file.getOriginalFilename(),file.getInputStream(),new ObjectMetadata());
		
			return APP_PATH + file.getOriginalFilename() + "?noAuth=true";
		}catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
