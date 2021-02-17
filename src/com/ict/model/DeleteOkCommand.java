package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;

public class DeleteOkCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");

		// 댓글이 없으면 삭제 가능, 댓글이 있으면 오류 발생
		// 방법 1)
		/*
		 try {
			int result = DAO.getDelete(b_idx);
		} catch (Exception e) {
			return "view/error.jsp";
		}
		return "MyController?cmd=list&Page="+cPage;
		 */
		
		// 방법 2)
		// 원글에 관련된 댓글 먼저 삭제하고 원글 삭제 하자
		int result = DAO.getC_AllDelete(b_idx);
		try {
			result = DAO.getDelete(b_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "MyController?cmd=list&cPage="+cPage;
		
	}

}
