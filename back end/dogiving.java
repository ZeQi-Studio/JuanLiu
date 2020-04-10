package Servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class dogiving
 */
@WebServlet("/dogiving")
public class dogiving extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public dogiving() {
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
    @SuppressWarnings({ "unused" })
    protected @ResponseWrapper void doPost(HttpServletRequest request, HttpServletResponse response,List student) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            ArrayList<Student> student1=new ArrayList<Student>();
            Class.forName("com.mysql.jdbc.Driver");
            String URL="jdbc:mysql://127.0.0.1:3306/zhangxiao?useSSL=true&?useUnicode=true&characterEncoding=utf-8";
            String USER = "root";
            String PASS = "991212";
            PrintWriter out=response.getWriter();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            conn=DriverManager.getConnection(URL,USER,PASS);
            @SuppressWarnings("unused")
            String sql = "SELECT * from test1";
            Student s=null;
            while(rs.next()) {
                s.setUserName(rs.getString("username"));
                s.setName(rs.getString("actName"));
                s.setThing(rs.getString("thing"));
                s.setNumber(rs.getInt("number"));

            }
            rs.close();

            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray1 = JSONArray.fromObject(student1);//将集合转换为json格式
            String jsonString=jsonArray1.toString();//将jisn转换为字符串
            response.getWriter().print(jsonString);
            out.print(jsonArray1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
