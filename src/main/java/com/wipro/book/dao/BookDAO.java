package com.wipro.book.dao;

import com.wipro.book.bean.BookBean;
import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    public int createBook(BookBean bookBean) {

        int result = 0;
        Connection con = DBUtil.getDBConnection();

        String query =
        		"INSERT INTO BOOK_TBL (ISBN, BOOK_TITLE, BOOK_TYPE, AUTHOR_CODE, BOOK_COST) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookBean.getIsbn());
            ps.setString(2, bookBean.getBookName());
            ps.setString(3, String.valueOf(bookBean.getBookType()));
            ps.setInt(4, bookBean.getAuthor().getAuthorCode());
            ps.setFloat(5, bookBean.getCost());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public BookBean fetchBook(String isbn) {

        BookBean bookBean = null;
        Connection con = DBUtil.getDBConnection();

        String query = "SELECT * FROM BOOK_TBL WHERE ISBN = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bookBean = new BookBean();
                bookBean.setIsbn(rs.getString(1));
                bookBean.setBookName(rs.getString(2));
                bookBean.setBookType(rs.getString(3).charAt(0));
                bookBean.setCost(rs.getFloat(5));

                int authorCode = rs.getInt(4);
                AuthorBean author = new AuthorDAO().getAuthor(authorCode);
                bookBean.setAuthor(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookBean;
    }
}
