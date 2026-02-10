package com.wipro.book.dao;
import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthorDAO {
	public AuthorBean getAuthor(int authorCode) {
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT * FROM AUTHOR_TBL WHERE AUTHOR_CODE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,authorCode);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				AuthorBean authorBean = new AuthorBean();
				authorBean.setAuthorCode(rs.getInt(1));
				authorBean.setAuthorName(rs.getString(2));
				authorBean.setContactNo(rs.getLong(3));
				return authorBean;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public AuthorBean getAuthor(String authorName) {
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT * FROM AUTHOR_TBL WHERE AUTHOR_NAME = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,authorName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				AuthorBean authorBean = new AuthorBean();
				authorBean.setAuthorCode(rs.getInt(1));
				authorBean.setAuthorName(rs.getString(2));
				authorBean.setContactNo(rs.getLong(3));
				return authorBean;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
