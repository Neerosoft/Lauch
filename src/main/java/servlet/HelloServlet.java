package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lauch.dblink.MSSQLConnection;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {
	
	private MSSQLConnection mysql;
	public Connection con;
	
	public HelloServlet() {
		this.mysql=new MSSQLConnection();
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        PrintStream s=new PrintStream(out);
        File f=new File(".");
        
        this.con=this.mysql.getConnection();
        this.mysql.close(this.con);
        
    
        s.println(f.getAbsolutePath()+"\n");
        s.println("hello heroku");
        out.flush();
        out.close();
    }
    
}
