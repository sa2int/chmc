//package io.bigtreelab.rndbox.api.utils;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClientBuilder;
//import com.aliyun.oss.internal.OSSConstants;
//import com.aliyun.oss.model.CompleteMultipartUploadRequest;
//import com.aliyun.oss.model.CompleteMultipartUploadResult;
//import com.aliyun.oss.model.InitiateMultipartUploadRequest;
//import com.aliyun.oss.model.InitiateMultipartUploadResult;
//import com.aliyun.oss.model.ObjectMetadata;
//import com.aliyun.oss.model.PartETag;
//import com.aliyun.oss.model.UploadPartRequest;
//import com.aliyun.oss.model.UploadPartResult;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class FileUploadUtil {
//
//    @Value("${aliyun.oss.endPoint}")
//    private String ALIYUN_OSS_ENDPOINT;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String ALIYUN_OSS_ACCESSKEYID;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String ALIYUN_OSS_ACCESSKEYSECRET;
//    @Value("${aliyun.oss.bucketName}")
//    private String ALIYUN_OSS_BUCKETNAME;
//
//    // multiPartFile을 File로 변환
//    public File multiPartToFile(MultipartFile mFile) throws IllegalStateException, IOException {
//
//        File ConFile = new File(mFile.getOriginalFilename());
//        ConFile.createNewFile();
//        FileOutputStream fos = new FileOutputStream(ConFile);
//        fos.write(mFile.getBytes());
//        fos.close();
//        return ConFile;
//    }
//
//    public String fileUpload(String fileName, MultipartFile imgURL, String directory, String contentType)
//            throws IOException {
//        String objectName = directory + "/" + fileName; // prizebox/B0001/B0001_E.png
//
//        // ossClient 인스턴스 생성
//        OSS ossClient = new OSSClientBuilder().build(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID,
//                ALIYUN_OSS_ACCESSKEYSECRET);
//        InitiateMultipartUploadRequest uploadRequest = new InitiateMultipartUploadRequest(ALIYUN_OSS_BUCKETNAME,
//                objectName);
//
//        // 如果需要在初始化分片时设置请求头，请参考以下示例代码。
//        ObjectMetadata metadata = new ObjectMetadata();
//        // 컨텐트 타입 설정
//        metadata.setContentType(contentType);
//        // 캐시 설정
//        metadata.setCacheControl("no-cache");
//        // 다운되었을때 이름을 지정한다.
////        metadata.setContentDisposition("attachment;filename=testtest.txt");
//        // 인코딩 설정
//        metadata.setContentEncoding(OSSConstants.DEFAULT_CHARSET_NAME);
//        // 덮어쓰기 설정
////        metadata.setHeader("x-oss-forbid-overwrite", "true");
////        boolean found = ossClient.doesObjectExist(ALIYUN_OSS_BUCKETNAME, objectName);
//
//        uploadRequest.setObjectMetadata(metadata);
//
//        InitiateMultipartUploadResult uploadResult = ossClient.initiateMultipartUpload(uploadRequest);
//        // 고유 식별자 반환
//        String uploadId = uploadResult.getUploadId();
//        List<PartETag> partETags = new ArrayList<>();
//        // 멀티파트를 파일로 변화
//        File file = multiPartToFile(imgURL);
//
//        final long partSize = 1 * 1024 * 1024L;
//        long fileLength = file.length();
//        int partCount = (int) (fileLength / partSize);
//
//        if (fileLength % partSize != 0) {
//            partCount++;
//        }
//
//        for (int i = 0; i < partCount; i++) {
//            long startPos = i * partSize;
//            long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
//            InputStream inputStream = new FileInputStream(file);
//            inputStream.skip(startPos);
//            UploadPartRequest uploadPartRequest = new UploadPartRequest();
//            uploadPartRequest.setBucketName(ALIYUN_OSS_BUCKETNAME);
//            uploadPartRequest.setKey(objectName);
//            uploadPartRequest.setUploadId(uploadId);
//            uploadPartRequest.setInputStream(inputStream);
//            uploadPartRequest.setPartSize(curPartSize);
//            // 파일을 부분으로 나누었을때 몇개로 되어 있는지 넣는 부분, 파일을 나누지 않았기 때문에 1을 넣는다.
//            uploadPartRequest.setPartNumber(i + 1);
//            // 부분으로 나누어진 파일을 정렬하는것
//            UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
//            // 정렬한 결과를 partETags에 저장하는 것
//            partETags.add(uploadPartResult.getPartETag());
//        }
//
//        // 부분 업로드 작업 완료 시 유효한 모든 partETags를 제공해야 한다. OSS는 제출된 partETags를 수신한 후 유효성을 하나씩
//        // 확인. 모든 데이터 조각이 확인된 후 OSS는 이러한 조각을 완전한 파일로 결합
//        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(
//                ALIYUN_OSS_BUCKETNAME, objectName, uploadId, partETags);
////        completeMultipartUploadRequest.addHeader("x-oss-forbid-overwrite", "true");
//        // 멀티파트 업로드 완료
//        CompleteMultipartUploadResult completeMultipartUploadResult = ossClient
//                .completeMultipartUpload(completeMultipartUploadRequest);
//        log.info(directory, " success upload");
//
//        return objectName;
//    }
//
//    // 이미지를 db에 저장할때 path뒤에 시간을 붙여 저장한다.
//    // (ex:http://product.xingmanghe.com/prizebox/B0061/1080x1080.png?20220527044930)
//    public String getDate() {
//        SimpleDateFormat bb = new SimpleDateFormat("yyyyMMddHHmmss");
//        Date date = new Date();
//        String dateToStr = bb.format(date);
//        return dateToStr;
//    }
//
//}
