package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.SubjectsDao;
import com.green.entity.Subjects;
import com.green.model.Page;

@Service
public class SubjectsService {
	@Autowired
	private SubjectsDao subjectsDao;

	public List<Subjects> findAll() {
		return subjectsDao.findAll();

	}

	public Subjects findById(int id) {
		return subjectsDao.find(id);
	}

	public void insert(Subjects subjects) {
		subjectsDao.save(subjects);
	}

	public void delete(Subjects subjects) {
		subjectsDao.delete(subjects);
	}

	public void update(Subjects subjects) {
		subjectsDao.update(subjects);
	}
	public Page<Subjects> findSubject(String filter, int page) {
		Page<Subjects> result = new Page<>();
		long totalRows = subjectsDao.count(filter);
		if (totalRows <= 0) {
			return result;
		}
		
		List<Subjects> list = subjectsDao.search(filter, page);
		
		result.setCurrent(page);
		result.setList(list);
		result.setTotalRows(totalRows);
		return result;
	}

}
