package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Attachment;

@Repository
public class AttachmentDao extends BaseDao<Attachment, Integer> {
	
	@Override
	protected Class<Attachment> getEntityClass() {
		return Attachment.class;
	}
}
