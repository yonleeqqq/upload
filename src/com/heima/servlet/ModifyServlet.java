package com.heima.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.heima.bean.Product;
import com.heima.service.ProductService;
import com.heima.utils.PathUtils;

public class ModifyServlet extends HttpServlet {
	private ProductService ps = new ProductService();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product p = new Product();
		Map<String,String[]> parameterMap = new HashMap<String,String[]>();
		//get factory
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//get parser
		ServletFileUpload upload = new ServletFileUpload(factory);
		//parse request
		List<FileItem> list=null;
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new RuntimeException("Äú²Ù×÷ÓÐÎó");
		}
		//traverse FileItem
		if(list!=null){
			for(FileItem item:list){
				if(!item.isFormField()&&item.getSize()>0){
					//file upload
						//get file folder
					String uploadPath = getServletContext().getRealPath("/images");
						//generate date folder
					String datePath = PathUtils.getDatePath(uploadPath);
						//generate filename
					String fileName = UUID.randomUUID().toString();
						//save file
					InputStream is = item.getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPath+datePath+fileName);
					IOUtils.copy(is,fos);
						//put filePath to Product
					p.setImgurl("/images"+datePath+fileName);
					//delete temp
					is.close();
					fos.close();
					item.delete();
					System.out.println(p.getImgurl());
				}else{
					//normal form
					//get form key-value 
					String key = item.getFieldName();
					String value = item.getString("UTF-8");
					//put key-value to Map
					parameterMap.put(key, new String[]{value});
					
				}
			}
		}
		//use BeanUtils to package
		try {
			BeanUtils.populate(p,parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//check not Null
		//use ProductService to update Product
		ps.update(p);
		//redirect
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
