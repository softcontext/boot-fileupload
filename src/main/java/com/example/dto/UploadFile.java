package com.example.dto;

public class UploadFile {
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private String attachmentUrl;

	public UploadFile() {
	}

	public UploadFile(String fileName, long fileSize, String fileContentType, String attachmentUrl) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileContentType = fileContentType;
		this.attachmentUrl = attachmentUrl;
	}

	@Override
	public String toString() {
		return "UploadFile [fileName=" + fileName + ", fileSize=" + fileSize + ", fileContentType=" + fileContentType
				+ ", attachmentUrl=" + attachmentUrl + "]";
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
}
