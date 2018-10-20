package com.zyt.blog.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	@RequestMapping(value = "/fileUpload")
	public Map fileUpload(MultipartFile imgFile) {
		try {
			String rootPath = "/upload";

			// 文件的完整名称,如spring.jpeg
			String filename = imgFile.getOriginalFilename();
			// 文件名,如spring
			String name = filename.substring(0, filename.indexOf("."));
			// 文件后缀,如.jpeg
			String suffix = filename.substring(filename.lastIndexOf("."));
			// 创建年月文件夹
			Calendar date = Calendar.getInstance();
			File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1));
			// 目标文件
			System.out.println(rootPath + File.separator + dateDirs + File.separator + filename);
			File descFile = new File(rootPath + File.separator + dateDirs + File.separator + filename);
			int i = 1;
			// 若文件存在重命名
			String newFilename = filename;
			while (descFile.exists()) {
				newFilename = name + "(" + i + ")" + suffix;
				String parentPath = descFile.getParent();
				descFile = new File(parentPath + File.separator + newFilename);
				i++;
			}
			// 判断目标文件所在的目录是否存在
			if (!descFile.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建父目录
				descFile.getParentFile().mkdirs();
			}
			//将内存中的数据写入磁盘
			imgFile.transferTo(descFile);
			//完整的url
			//String fileUrl =  "/uploads/"+dateDirs+ "/"+newFilename;
			String fileUrl =  "/upload/"+dateDirs+ "/"+newFilename;
			
			Map map = new HashMap<>();
			map.put("error", 0);
			map.put("url", fileUrl);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			Map map = new HashMap<>();
			map.put("error", 1);
			map.put("message", "图片上传失败");
			return map;
		} 
	}
}