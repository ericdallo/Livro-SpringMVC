package com.livrospring.config;

import org.springframework.context.annotation.Bean;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;

public class AWSConfiguration {

	private static final String AWS_ACCESS_KEY = "AKIAIOSFODNN7EXAMPLE";
	private static final String AWS_SECRET_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
	private static final String S3_NINJA_ENDPOINT = "http://localhost:9444/s3";

	@Bean
	public AmazonS3Client s3Ninja(){
		AWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
		
		AmazonS3Client s3client = new AmazonS3Client(credentials,new ClientConfiguration());
		s3client.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
		s3client.setEndpoint(S3_NINJA_ENDPOINT);
		
		return s3client;
	}
}
