package com.green.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.config.Alert;
import com.green.config.MessageBox;
import com.green.entity.Account;
import com.green.util.ApplicationConfig;

@Controller
public class ImageController {
	private static final long serialVersionUID = 1L;

	private String PROFILE_IMAGE_DIR;

	@Autowired
	ServletContext context;
	
	@Autowired
	private MessageBox messageBox;

	@PostConstruct
	public void init() {
		PROFILE_IMAGE_DIR = ApplicationConfig.getConfig("image.dir");
		File filesDir = new File(PROFILE_IMAGE_DIR);
		if (!filesDir.exists()) {
			filesDir.mkdirs();
		}

	}

	@RequestMapping(value = "/image/{target}/{targetId}", method = RequestMethod.GET)
	public void Upload(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(name = "target") String target, @PathVariable(name = "targetId") String targetId)
			throws ServletException, IOException {
		// lấy thông tin user đang đăng nhập
		HttpSession session = request.getSession();

		String fileName = PROFILE_IMAGE_DIR + File.separator + target + File.separator + targetId;

		File file = new File(fileName);
		// nếu không tồn tại thì lấy hình đại diện mặc định
		if (!file.exists()) {
			file = new File(context.getRealPath("resources/image/naruto.png"));
		}

		InputStream fis = new FileInputStream(file);
		String mimeType = context.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "inline");

		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read = 0;
		while ((read = fis.read(bufferData)) != -1) {
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
	}

	@RequestMapping(value = "/image/{target}/{targetId}", method = RequestMethod.POST)
	public void Download(@RequestParam("file") MultipartFile file,
			@PathVariable(name = "target") String target, @PathVariable(name = "targetId") String targetId)
			throws ServletException, IOException {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = PROFILE_IMAGE_DIR;
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + target + targetId);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
			} catch (Exception e) {
				messageBox.setMessage("Upload that bai!");
			}
		} else {
			messageBox.setMessage("File khong ton tai!");
		}
	}

}
