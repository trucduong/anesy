package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.AssignmentDao;
import com.green.entity.Assignment;

@Service
public class AssignmentService {

	@Autowired
	private AssignmentDao assignmentDao;

	public List<Assignment> findAll(){
		return assignmentDao.findAll();
	}
	
	public Assignment find(int id) {
		return assignmentDao.find(id);
	}

	public void insert(Assignment assignment) {
		assignmentDao.save(assignment);
	}

	public void delete(Assignment assignment) {
		assignmentDao.delete(assignment);
	}
	
	public void update(Assignment assignment){
		assignmentDao.update(assignment);
	}

}
