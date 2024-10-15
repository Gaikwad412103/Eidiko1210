package com.springBootApi.SpringBootApi.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploderHelper {
    //Static path
    //public final String UPLOADER_DTR="C:\\Users\\Sreenivas Bandaru\\Desktop\\Eidiko1210\\JavaWork\\SpringBootApi\\src\\main\\resources\\static\\images";
    //Dynamic path
    public final String UPLOADER_DTR=new ClassPathResource("static\\images").getFile().getAbsolutePath();

    public FileUploderHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartFile){
        boolean flag=false;
        try{
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOADER_DTR+"\\"+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }
}
