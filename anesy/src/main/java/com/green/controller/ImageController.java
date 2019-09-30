package com.green.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.util.ApplicationConfig;

@Controller
@RequestMapping("/image")
public class ImageController {
	private String IMAGE_DIR;

	@Autowired
	ServletContext context;


	@PostConstruct
	public void init() {
		IMAGE_DIR = ApplicationConfig.getConfig("image.dir");
		File filesDir = new File(IMAGE_DIR);
		if (!filesDir.exists()) {
			filesDir.mkdirs();
		}

	}
	
	@RequestMapping(value = "/{target}", method = RequestMethod.GET)
	public void download(HttpServletResponse response, @PathVariable(name = "target") String target) throws IOException {
		download(response, target, "none");
	}

	@RequestMapping(value = "/{target}/{targetId}", method = RequestMethod.GET)
	public void download(HttpServletResponse response,
			@PathVariable(name = "target") String target,
			@PathVariable(name = "targetId") String targetId) throws IOException {

		String fileName = getFilePath(target, targetId);

		File file = new File(fileName);
		// nếu không tồn tại thì lấy hình đại diện mặc định
		if (!file.exists()) {
			if (target.equals("profile")) {
				file = new File(context.getRealPath("resources/image/avatar.png"));
			} else {
				file = new File(context.getRealPath("resources/image/none.svg"));
			}
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

	@RequestMapping(value = "/{target}/{targetId}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ResponseBody
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, 
			@PathVariable(name = "target") String target,
			@PathVariable(name = "targetId") String targetId) 
			throws ServletException, IOException {

		if (file.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String filePath = getFilePath(target);
			File dir = new File(filePath);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(filePath + File.separator + targetId);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			
			return ResponseEntity.ok().body(targetId);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{target}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ResponseBody
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, @PathVariable(name = "target") String target) 
			throws ServletException, IOException {

		String targetId = UUID.randomUUID().toString();
		
		return upload(file, target, targetId);
	}

	private String getFilePath(String target, String targetId) {
		return IMAGE_DIR + File.separator + target + File.separator + targetId;
	}
	
	private String getFilePath(String target) {
		return IMAGE_DIR + File.separator + target;
	}
}
