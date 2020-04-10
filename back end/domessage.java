package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class domessage
 */
@WebServlet("/domessage")
public class domessage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public domessage() {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        String URL="jdbc:mysql://127.0.0.1:3306/zhangxiao?useSSL=true&?useUnicode=true&characterEncoding=utf-8";
        String USER = "root";
        String PASS = "991212";
        String id="";
        String code="";
        try{




            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String thing="";
            String actName="";
            request.setCharacterEncoding("utf-8");
            actName=request.getParameter("actName");
            thing=request.getParameter("thing");
            String number=request.getParameter("number");
            int num = 0;
            num = Integer.valueOf(number);
            String telnumber=request.getParameter("telnumber");
            int telNumber=Integer.valueOf(telnumber);
            String picture=request.getParameter("picture");
            String address=request.getParameter("address");
            String QQ=request.getParameter("QQ");
            String name=request.getParameter("name");
            String sex=request.getParameter("sex");
            String Age=request.getParameter("age");
            int age=0;
            age=Integer.valueOf(Age);

            //number=request.getParameter("number");
            String username=(String)request.getAttribute("username");
            String sql = "INSERT INTO imooc_goddess(username,actName,thing,number,picture,address,QQ,name,sex,age)"
                    +"values(?,?,?)";
            PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);

            ptmt.setString(1, username);
            ptmt.setString(2, thing);
            ptmt.setInt(3, num);

        } catch (ClassNotFoundException e) {
            /*System.out.println("Sorry,can`t find the Driver!");*/
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
