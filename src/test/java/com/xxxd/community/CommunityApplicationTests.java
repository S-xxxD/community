package com.xxxd.community;

import com.xxxd.community.dao.AlphaDao;
import com.xxxd.community.dao.AlphaDaoHibernatelmpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)

public class CommunityApplicationTests implements ApplicationContextAware{
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao = applicationContext.getBean(AlphaDaoHibernatelmpl.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired //代替applicationContext.getBean()方法，直接进行依赖注入
	@Qualifier("Hibernatelmpl") //使用别名，注入别名的依赖
	private AlphaDao alphaDao;


}

