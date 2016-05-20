package com.heima.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PathUtils {
	//return /yyyy/MM/dd/
	public static String getDatePath(String uploadPath){
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String datePath = sdf.format(new Date());
		String wholePath = uploadPath +datePath;
		File f = new File(wholePath);
		if(!f.exists()){
			f.mkdirs();
		}
		return datePath;
		
	}
}
