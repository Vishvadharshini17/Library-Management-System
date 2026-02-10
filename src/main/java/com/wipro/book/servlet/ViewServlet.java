package com.wipro.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.book.bean.BookBean;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        BookBean bookBean = (BookBean) session.getAttribute("book");

        out.println("<html><body>");
        out.println("<h3>Book Details</h3>");
        out.println("Book Title: " + bookBean.getBookName() + "<br>");
        out.println("Author Name: " + bookBean.getAuthor().getAuthorName() + "<br>");
        out.println("Author Contact: " + bookBean.getAuthor().getContactNo() + "<br>");
        out.println("Book Price: " + bookBean.getCost() + "<br>");
        out.println("Book ISBN: " + bookBean.getIsbn());
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
