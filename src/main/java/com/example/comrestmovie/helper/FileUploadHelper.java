package com.example.comrestmovie.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper
{
   // public final String UPLOAD_DIR="/Users//aaryaverma/Downloads/comrestmovie/src/main/resources/static/image";
   public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
   public FileUploadHelper() throws IOException
   {

   }
    public boolean uploadFile(MultipartFile mpfile)
    {

        boolean checkupload=false;
        try{
            /*InputStream is=mpfile.getInputStream();
            byte data[]=new byte[is.available()];
            is.read(data);
            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+ File.separator+mpfile.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            checkupload=true;*/

            Files.copy(mpfile.getInputStream(),Paths.get(UPLOAD_DIR+ File.separator+mpfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            checkupload=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return checkupload;
    }

}
