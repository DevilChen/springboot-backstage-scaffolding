package com.backstage.scaffolding.controller;

import com.alibaba.excel.EasyExcel;
import com.backstage.scaffolding.mapper.UploadDAO;
import com.backstage.scaffolding.model.DownloadData;
import com.backstage.scaffolding.model.UploadData;
import com.backstage.scaffolding.util.UploadDataListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author DevilChen
 */
@RestController
public class FileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    private final UploadDAO uploadDAO;

    public FileController(UploadDAO uploadDAO) {
        this.uploadDAO = uploadDAO;
    }

    /**
     * 下载
     */
    @GetMapping(value = "download")
    public void download(HttpServletResponse response) throws IOException {
        LOGGER.info("======设置内容类型======");
        response.setContentType("application/vnd.ms-excel");
        LOGGER.info("======设置字符编码======");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", "UTF-8");
        LOGGER.info("======设置标头======");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        LOGGER.info("======EasyExcel开始写操作======");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
    }

    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<>();
        final int j = 10;
        for (int i = 0; i < j; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + 0);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    /**
     * 上传
     *
     * @return String
     */
    @PostMapping(value = "upload")
    public String upload(MultipartFile file) throws IOException {
        LOGGER.info("======EasyExcel开始读操作======");
        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
        return "success";
    }

}
