package Servlet;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class dologin
 */
@WebServlet("/dologin")
public class dologin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public dologin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unused")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("erzi");
        request.setCharacterEncoding("utf-8");
        String URL="jdbc:mysql://127.0.0.1:3306/zhangxiao?useSSL=true&?useUnicode=true&characterEncoding=utf-8";
        String USER = "root";
        String PASS = "991212";
        String id="";
        String code="";
        try{
            System.out.println("success");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "SELECT id,code FROM test1";
            ResultSet rs = stmt.executeQuery(sql);


            request.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //JSONObject json=JSONObject.fromObject(message);
            //String username=json.getString("username");
            // password=json.getString("password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            System.out.println(username);
            while(rs.next()){
                id=rs.getString("id");
                code=rs.getString("code");
                if(id.equals(username)&&code.equals(password))
                {
                    System.out.println("sussess");
                    response.setContentType("text/html;charset=utf-8");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("type", true);
                    String jsonString=jsonObject.toString();
                    response.getWriter().print(jsonString);
                    return;
                }
                else
                {
                    System.out.println("sussess");
                    response.setContentType("text/html;charset=utf-8");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("type", false);
                    String jsonString=jsonObject.toString();
                    response.getWriter().print(jsonString);


                    return;
                }
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

