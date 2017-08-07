package com.jxnm.market.portal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/info")
public class InfoController {
	
	@RequestMapping("/searchInfo")
	@ResponseBody
	public String searchFile() {
//		return "File is here.";
		return "index";
	} 
	
	@RequestMapping("/toindex")
	 public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
             HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mv = new ModelAndView();
		//封装要显示到视图的数据
		mv.addObject("msg","hello myfirst mvc");
		//视图名
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping( value="/upload",method = { RequestMethod.POST })  
	public ModelAndView upload(@RequestParam(value = "file", required = false) 
	MultipartFile file,HttpServletRequest request) {
	  System.out.println("成功进入控制层");//这里输出的文字  是为了可以在后台看到是否进入了这个方法  方便查错  
	  String path = "E:/";//上传的目录  简单点 这里是E盘根目录  根据自己的需求改  想把上传的文件放在哪里  路径就写到哪里  
	  String fileName = file.getOriginalFilename();//获取上传的文件名字 日后可以根据文件名做相应的需改 例如自定义文件名 分析文件后缀名等等  
	  System.out.println(path);//后台输出你要存放文件的路径名  方便查错  
	  File targetFile = new File(path, fileName); // /新建文件  
	  if (!targetFile.exists()) { //判断文件的路径是否存在  
	    targetFile.mkdirs(); //如果文件不存在  在目录中创建文件夹   这里要注意mkdir()和mkdirs()的区别  
	  }
	  // 保存
	  try {
	    file.transferTo(targetFile); //传送  失败就抛异常  
	  } catch (Exception e) {
	    e.printStackTrace();  
	  }
	  return new ModelAndView("index"); //看情况返回参数就OK了  
	} 
	@RequestMapping( value="/getImage",method = { RequestMethod.POST ,RequestMethod.GET})  
	public void getImage( HttpServletRequest request,HttpServletResponse response) {
		System.out.println("成功进入控制层");//这里输出的文字  是为了可以在后台看到是否进入了这个方法  方便查错  
		String path = "E:/";//上传的目录  简单点 这里是E盘根目录  根据自己的需求改  想把上传的文件放在哪里  路径就写到哪里  
		String fileName = "IMG_5524.JPG";//获取上传的文件名字 日后可以根据文件名做相应的需改 例如自定义文件名 分析文件后缀名等等  
		FileInputStream input=null;
		try {
			
			System.out.println(path);//后台输出你要存放文件的路径名  方便查错  
			File targetFile = new File(path, fileName); // /新建文件  
			OutputStream output=response.getOutputStream();
			input =new FileInputStream(targetFile);
			byte[] b=new byte[input.available()];
			input.read(b);output.write(b);
			output.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(input !=null) {
				try {
					input.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	} 
}
