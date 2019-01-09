package com.bk.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bk.dao.BkMapper;
import com.bk.dao.UserMapper;
import com.bk.entity.users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BkQianTaiApplicationTests {
	@Autowired
	UserMapper usermap;
	@Autowired
	BkMapper bkmapper;
	@Test
	public void contextLoads() {	
/*		Map<String, String> user=new HashMap<>();
		user.put("username", "hmy");
		user.put("password", "hmy");
		System.out.println(usermap.login(user));*/
		bkmapper.selectFenlei();
	}
	@Test
	public void test() {
		/*System.out.println(bkmapper.selectFenlei().get(1).getArticles().get(0).getAtitle());*/
			File file =new File("C:\\Users\\Administrator\\微信图片_201808231812.jpg");
			
/*            String saveFileName = file.getOriginalFilename();
            file.get
            File saveFile = new File("static/images/" + saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }*/
            try {
            	FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\微信图片.jpg"));
            	         FileInputStream fs= new FileInputStream(file);//(FileInputStream) file.getInputStream();  
            	         byte[] buffer=new byte[1024];  
            	         int len=0;  
            	         while((len=fs.read(buffer))!=-1){  
            	             fos.write(buffer, 0, len);  
            	         }  
            	         fos.close();  
            	         fs.close();
            	         System.out.println("上传成功");
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("上传失败");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("上传失败");
            }
         
	}
}
