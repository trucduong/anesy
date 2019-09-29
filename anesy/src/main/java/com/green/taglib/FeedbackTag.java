package com.green.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.green.dao.FeedbackDao;
import com.green.entity.FeedbackTarget;
import com.green.entity.FeedbackType;
import com.green.util.MyFormater;
import com.green.util.SpringContextUtil;

public class FeedbackTag extends BaseTag {

	private FeedbackTarget target;
	private int targetId;
	private FeedbackType type;

	private FeedbackDao dao;

	public FeedbackTag() {
		dao = SpringContextUtil.getBean(FeedbackDao.class);
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		long count = dao.getFeedback(target, targetId, type);
		out.print(MyFormater.number(count));
	}

	public FeedbackTarget getTarget() {
		return target;
	}

	public void setTarget(FeedbackTarget target) {
		this.target = target;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public FeedbackType getType() {
		return type;
	}

	public void setType(FeedbackType type) {
		this.type = type;
	}

}
