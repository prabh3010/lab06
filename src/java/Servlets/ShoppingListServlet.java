/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author prabh
 */
public class ShoppingListServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            session.invalidate();
            response.sendRedirect("ShoppingList");
            return;
        } 
        if (username == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else {
            request.setAttribute("username", username);
            List<String> items = (List<String>) session.getAttribute("item");
            request.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action != null && action.equals("register")){
            String username = request.getParameter("username");
            if (username == null || username.equals("")) getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            List<String> item = new ArrayList<>();
            session.setAttribute("username", username);
            session.setAttribute("item", item);
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }else if (action != null && action.equals("add")){
            String items = request.getParameter("Item");
            List<String> item = session.getAttribute("item") == null?new ArrayList<>(): (List<String>) session.getAttribute("item");
            item.add(items);
            session.setAttribute("item",item);
            request.setAttribute("list", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }else if (action != null && action.equals("delete")){
            String items = request.getParameter("item");
            List<String> item = (List<String>) session.getAttribute("item");
            item.removeIf(s -> s.equals(items));
            session.setAttribute("item", item);
            request.setAttribute("list", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
    }

}