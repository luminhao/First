package com.bk;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bk.dao.BkMapper;
import com.bk.service.ReplyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BkQianTaiApplicationTests {
	@Autowired 
	BkMapper Service;
	@Test
	public void contextLoads() {
		//System.out.println("还记得书法家肯定会反馈"+Service.replys(45));
		
	}

}
