package com.bk.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public  class Tool {
	public  static boolean upload(File saveFile,MultipartFile file) {
    	try {
			FileOutputStream fos=new FileOutputStream(saveFile);
			FileInputStream fs= (FileInputStream) file.getInputStream();// 上传没用呢，有问题
			byte[] buffer=new byte[1024];  
			int len=0;  
			while((len=fs.read(buffer))!=-1){  
			    fos.write(buffer, 0, len);  
			}  
			fos.close();  
			fs.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}  

	}
}
