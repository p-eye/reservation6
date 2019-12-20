package kr.or.connect.reservation.dto;

import java.time.LocalDateTime;

public class FileInfo {

	private int id;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private boolean deleteFlag;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public FileInfo() {
		deleteFlag = false;
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public FileInfo(int id, String fileName, String saveFileName, String contentType, boolean deleteFlag,
			LocalDateTime createDate, LocalDateTime modifyDate) {
		this.id = id;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "FileInfo [id=" + id + ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", contentType="
				+ contentType + ", deleteFlag=" + deleteFlag + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}

}
