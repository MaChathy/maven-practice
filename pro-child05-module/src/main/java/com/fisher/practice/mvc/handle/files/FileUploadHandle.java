package com.fisher.practice.mvc.handle.files;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * 文件上传处理类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 14:58
 */
@Controller
public class FileUploadHandle {

    @RequestMapping(value = "/portal-upload")
    public String portal(){
        return "portal";
    }

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public String doUpload(
            @RequestParam("nickName") String nickName,
            @RequestParam("picture") MultipartFile picture,
            HttpSession session,
            Model model
    ) throws IOException {

        model.addAttribute("nickName", nickName);

        String pictureName = picture.getName();
        model.addAttribute("picName",pictureName);

        String originalFilename = picture.getOriginalFilename();
        model.addAttribute("originalName", originalFilename);

        String contentType = picture.getContentType();
        model.addAttribute("contentType", contentType);

        boolean empty = picture.isEmpty();
        model.addAttribute("empty", empty);

        long size = picture.getSize();
        model.addAttribute("size", size);

        byte[] pictureBytes = picture.getBytes();
        model.addAttribute("pictureBytes", Arrays.asList(pictureBytes));

        InputStream inputStream = picture.getInputStream();
        model.addAttribute("inputStream", inputStream);

        Resource resource = picture.getResource();
        model.addAttribute("resource", resource);

        String destFileFolderVirtualPath = "/head-picture";

        String realPath = session.getServletContext().getRealPath(destFileFolderVirtualPath);

        String generateFileName = UUID.randomUUID().toString().replace("-", "");

        String fileExtName = originalFilename != null ? (originalFilename).substring(originalFilename.lastIndexOf(".")) : null;

        String destFileName = generateFileName + "" + fileExtName;

        String destFilePath = realPath + "/" + destFileName;

        File destFile = new File(destFilePath);

        picture.transferTo(destFile);

        return "target";
    }

}
