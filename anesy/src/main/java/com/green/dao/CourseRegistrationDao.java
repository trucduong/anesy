package com.green.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.entity.CourseRegistration;
import com.green.entity.CourseSubjects;
import com.green.entity.Profile;
import com.green.entity.Progress;

@Repository
public class CourseRegistrationDao extends BaseDao<CourseRegistration, Integer> {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	protected Class<CourseRegistration> getEntityClass() {
		return CourseRegistration.class;
	}
	
	public List<CourseRegistration> findByStudent(Profile profile) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseRegistration where student = :_student");
		query.setParameter("_student", profile);
		return query.getResultList();
		
	}


	/**
	 * from CourseRegistration where student.id = :_student and course.id = :_course and (1 = 2 or status = NEW or status = IN-PROGRESS)
	 * 
	 * @param accountId
	 * @param courseId
	 * @param status
	 * @return
	 */
	public CourseRegistration find(int accountId, int courseId, Progress[] status) {
		Session session = sessionFactory.openSession();
		String q = "from CourseRegistration"
				+ " where student.id = :_student"
				+ " and course.id = :_course";
		
		if (status != null && status.length > 0) {
			q += " and ( 1 = 2";
			
			for (Progress progress : status) {
				q += " or status = '" + progress + "'";
			}
			
 			q += ")";
		}
		
		
		Query<CourseRegistration> query = session.createQuery(q, CourseRegistration.class);
		query.setParameter("_student", accountId);
		query.setParameter("_course", courseId);
		
		List<CourseRegistration> list = query.getResultList();
		if(list.size() == 0 ) {
			return null;
		}
		return list.get(0);
		
	}
}
