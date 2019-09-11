package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.AttachmentDao;
import com.green.entity.Attachment;;
@Service
public class AttachmentService {
	@Autowired
private AttachmentDao attachmentDao;
	
	
	public List<Attachment> findAll(){
		return attachmentDao.findAll();
	}
	
	public void insert(Attachment attachment){
		attachmentDao.save(attachment);
	}
	
	public void delete(Attachment attachment){
		attachmentDao.delete(attachment);
		
	}
	
	public void update(Attachment attachment){
		attachmentDao.update(attachment);
	}
	
	public Attachment findByid(int id){
		return attachmentDao.find(id);
	}
}
