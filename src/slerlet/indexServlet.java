package slerlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.ClassPath;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo")
public class indexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求控制器");
        String name = req.getParameter("name");
        System.out.println(name);

        User user = new User("1","11","11");
        User user1 = new User("2","22","22");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(list);
        System.out.println(list);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(result);
        out.flush();
        out.close();


//        输出图片流
//        ServletOutputStream os = resp.getOutputStream();
//        InputStream is = new FileInputStream(new File(getServletContext().getRealPath("img"),"pf.png"));
//        int index = -1;
//        while ((index=is.read())!=-1){
//            os.write(index);
//        }

    }
}
