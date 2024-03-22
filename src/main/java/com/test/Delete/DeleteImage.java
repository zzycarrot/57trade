package com.test.Delete;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class DeleteImage {
    public void deleteImage(String filename) {
        String path = "/root/pic";
//        String path = "./imgFile";
        File file = new File(path + "/" + filename);
        if (file.exists()) {
            file.delete();
            log.info("删除图片成功");
        }else {
            log.info("图片不存在");
        }
    }
}
