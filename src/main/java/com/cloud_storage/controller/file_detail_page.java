package com.cloud_storage.controller;

import com.cloud_storage.service_inter.file_service_inter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by dell on 1/26/2017.
 */
@Controller
public class file_detail_page {
    @Autowired
    private file_service_inter file_service;


    @RequestMapping("/download_file/{file_id}")
    public ResponseEntity<byte[]> download(@PathVariable("file_id")String file_id) throws IOException {
        com.cloud_storage.entity.File f=file_service.getFileById(Integer.parseInt(file_id));
        String path=f.getFile_path();
        File file=new File(path);
        HttpHeaders headers = new HttpHeaders();
        String fileName=new String(f.getFilename().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/file_rename/{file_id}",method = RequestMethod.POST)
    public String rename(@PathVariable("file_id")String file_id,String new_name,HttpSession session){
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            if(file_service.rename_file(Integer.parseInt(file_id),user_id,new_name)){
                return "redirect:/file_detail/"+file_id;
            }
        }

        return "error_page";
    }
    @RequestMapping(value = "/delete_file/{file_id}")
    public String delete(@PathVariable("file_id")String file_id, HttpSession session){
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            if(file_service.delete_entry(Integer.parseInt(file_id),user_id)){
                return "redirect:/homepage/"+session.getAttribute("USERID");
            }
        }

        return "error_page";
    }
    @RequestMapping(value = "/share_file",method = RequestMethod.GET)
    public String share(com.cloud_storage.entity.File_share file_share){
        file_share.setIs_valid(1);
        file_share.setDate(new Date().toString());
        if(file_service.share_file(file_share)){
            return "redirect:/file_detail/"+file_share.getFile_id();
        }
        return "error_page";
    }

    @RequestMapping(value = "/set_file_auth",method = RequestMethod.GET)
    public String set_auth(String file_id,String auth,HttpSession session){
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            if(file_service.change_file_auth(Integer.parseInt(file_id),user_id,Integer.parseInt(auth))){
                return "redirect:/file_detail/"+file_id;
            }
        }
        return "error_page";
    }
}
