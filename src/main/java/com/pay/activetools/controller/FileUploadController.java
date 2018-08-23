package com.pay.activetools.controller;

import com.pay.activetools.bean.JsonResultView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/imgUpload")
    @ResponseBody
    public JsonResultView imgUpload(HttpServletRequest httpRequest, @RequestParam MultipartFile file){
        logger.info("图片上传开始");
        JsonResultView view = new JsonResultView();
        Long size = 0L;
        if (file != null){
            size = file.getSize();
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("path","http://10.10.129.47:8083/upload/919e8cfba28a4d89b9db76ff9923ac3e.jpg");
        view.setObject(map);
        return view;
    }
}
