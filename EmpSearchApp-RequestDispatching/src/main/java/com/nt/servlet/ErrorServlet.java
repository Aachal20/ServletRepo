package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/errorurl")
public class ErrorServlet extends HttpServlet {
  @Override
public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  pw.println("<h1> Internal Problem</h1>");
  pw.close();
}
}
