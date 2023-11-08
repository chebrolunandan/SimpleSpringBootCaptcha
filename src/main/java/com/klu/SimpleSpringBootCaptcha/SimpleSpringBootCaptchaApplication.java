package com.klu.SimpleSpringBootCaptcha;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.apiclub.captcha.Captcha;

@SpringBootApplication
public class SimpleSpringBootCaptchaApplication 
{
	public static Captcha createCaptcha(int width, int height)
	{
		Captcha cap=new Captcha.Builder(width, height)
		.addBackground()
		.addText()
		.addNoise()
		.build();
		return cap;
	}
	public static void createImage(Captcha captcha)
	{
		try
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), "png", baos);
			FileOutputStream fos=new FileOutputStream("D:\\3rd year\\5th sem\\jfsd_pbl-3\\a.png");
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SimpleSpringBootCaptchaApplication.class, args);
		Captcha a=createCaptcha(200,80);
		createImage(a);
	}

}
