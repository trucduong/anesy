package com.green.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.green.entity.Feedback;
import com.green.entity.FeedbackTarget;
import com.green.entity.FeedbackType;

@Repository
public class FeedbackDao extends BaseDao<Feedback, Integer> {

	@Override
	protected Class<Feedback> getEntityClass() {
		return Feedback.class;
	}
	
	public long getFeedback(FeedbackTarget target, int targetId, FeedbackType type) {
		String hql = "select count(f) from Feedback f where f.target = :target and f.targetId = :targetId and feedbackType = :type";
		
		Query query = getFactory().openSession().createQuery(hql);
		query.setParameter("target", target);
		query.setParameter("targetId", targetId);
		query.setParameter("type", type);
		
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
}
