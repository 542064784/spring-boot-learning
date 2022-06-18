# 工程简介
Spring boot 整合 Servlet + JSP

添加依赖来支持JSP
    
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>

在main目录下创建webapp目录，在webapp下面创建自己的目录在
project structure中点击web然后将webapp目录加到
Web Resource Directory中

配置文件中写：

    spring:
      mvc:
        view:
          prefix: /WEB-INF/jsp/
          suffix: .jsp
          
 创建servlet类继承HttpServlet添加@WebServlet注解，
 在urlPatterns属性中填写访问的url
 
    @WebServlet(name = "UserServlet", urlPatterns = "/user.action")
    public class UserServlet extends HttpServlet {
    
然后实现doGet和doPost方法
    
    String name = req.getParameter("name"); 接收参数
    req.setAttribute("users", users); 设置参数
    req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);将参数返回到jsp页面
    
页面使用 ${} 方式来接收后端的数据
    
        <h3>添加用户</h3>
        <form action="user.action" method="post">
            name: <input type = "text" name = "name"/>
            age:  <input type="text" name="age"/>
            sex:  <input type="text" name="sex"/>
                  <input type="submit" value="add"/>
        </form>
        <hr/>
        <a href="user.action?filter=true&name=zhangsan">查询</a>
        <c:if test="${not empty users}">
            <h3>展示用户</h3>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.sex}</td>
                </tr>
            </c:forEach>
        </c:if>

创建一个controller来辅助访问jsp页面

    @Controller
    public class IndexController {
    
        @GetMapping("/")
        public String index() {
            return "user";
        }
    }
    
如果报404，就将启动类Enviroment设置里的
Work Directory改成项目的全路径