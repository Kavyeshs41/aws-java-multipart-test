package com.example;

import junit.framework.TestCase;

import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
          
public class S3MultipartUploadTest extends TestCase {
    public void test() {
        // EndpointConfiguration configuration = new EndpointConfiguration("s3.ap-southeast-1.amazonaws.com", "ap-southeast-1");
        EndpointConfiguration configuration = new EndpointConfiguration("http://localhost:4566", "us-east-1");
        AmazonS3 client = AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(configuration)
            .withPathStyleAccessEnabled(true)
            .build();
        
        // String bucket = "stackbydev";
        String bucket = "test";
        String key = "test.txt";
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(100000);
        metadata.setContentMD5("asdhjasdjhashdghasgdhsa");
        metadata.setContentType("text/plain");
        InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(bucket, key, metadata);
        client.initiateMultipartUpload(request);
    }
}