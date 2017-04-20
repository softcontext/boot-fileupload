package com.example.web;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.UploadFile;

@Controller
public class FileUploadController {
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home() {
		return "redirect:upload";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.GET)
	public String form() {
		return "file-upload-form";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> upload(
			@RequestParam String etc,
			@RequestPart MultipartFile file, 
			@RequestHeader("host") String host) {
		System.out.println("etc = "+etc);
		
		if (file != null) {
			String fileName = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destFile;
			String destFileName;

			do {
				destFileName = RandomStringUtils.randomAlphanumeric(32) + "." + extension;
				destFile = new File("C:/spring-upload/" + destFileName);
			} while (destFile.exists());

			destFile.getParentFile().mkdirs();

			try {
				// save
				file.transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return null;
			}

			UploadFile response = new UploadFile();
			response.setFileName(file.getOriginalFilename());
			response.setFileSize(file.getSize());
			response.setFileContentType(file.getContentType());
			response.setAttachmentUrl("http://"+host+"/" + destFileName);

			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		return null;
	}

	@RequestMapping(value = { "/header-info" }, method = RequestMethod.GET)
	@ResponseBody
	public Object headerInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		
		return map;
	}
}
