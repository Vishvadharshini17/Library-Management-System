package com.wipro.book.servlet;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.AuthorDAO;
import com.wipro.book.service.Administrator;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if ("AddBook".equals(operation)) {

            String result = addBook(request);

            if ("SUCCESS".equals(result)) {
                response.sendRedirect("Menu.html");
            } else if ("INVALID".equals(result)) {
                response.sendRedirect("Invalid.html");
            } else {
                response.sendRedirect("Failure.html");
            }

        } else if ("Search".equals(operation)) {

            String isbn = request.getParameter("isbn");
            BookBean bookBean = viewBook(isbn);

            if (bookBean == null) {
                response.sendRedirect("Invalid.html");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("book", bookBean);

                RequestDispatcher rd = request.getRequestDispatcher("ViewServlet");
                rd.forward(request, response);
            }
        }
    }

    private String addBook(HttpServletRequest request) {

        String isbn = request.getParameter("isbn");
        String bookName = request.getParameter("bookName");
        String bookType = request.getParameter("bookType");
        String authorName = request.getParameter("authorName");
        String cost = request.getParameter("cost");

        BookBean bookBean = new BookBean();
        bookBean.setIsbn(isbn);
        bookBean.setBookName(bookName);
        bookBean.setBookType(bookType.charAt(0));
        bookBean.setCost(Float.parseFloat(cost));
        bookBean.setAuthor(new AuthorDAO().getAuthor(authorName));

        Administrator admin = new Administrator();
        return admin.addBook(bookBean);
    }

    private BookBean viewBook(String isbn) {
        return new Administrator().viewBook(isbn);
    }
}
