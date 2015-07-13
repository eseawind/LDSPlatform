<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
    String id=request.getParameter("id");
    
    String result = ""; // 查询结果字符串

    String sql = "select * from DROID_OQC_RESOURCE where DOCUMENT_HEADER_ID = '"+id+"'"; // SQL 字符串

    // 连接字符串，格式： "jdbc:数据库驱动名称:连接模式:@数据库服务器ip:端口号:数据库SID"
//    String url = "jdbc:oracle:thin:@192.168.0.88:1521:DB2";
//    String username = "adm_mes"; // 用户名
//    String password = "tsdl28"; //密码
    
    String url = "jdbc:oracle:thin:@192.168.0.61:1521:DB1";
    String username = "adm_mes"; // 用户名
    String password = "amycall"; //密码

    // 创建oracle数据库驱动实例
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

    // 获得与数据库的连接 
    Connection conn = DriverManager.getConnection(url, username, password); 
    // 创建执行语句对象
    Statement  stmt = conn.createStatement();
    // 执行sql语句，返回结果集
    ResultSet  rs   = stmt.executeQuery(sql);

    while ( rs.next() ) 
    {
//        result += "/n 第一个字段内容：" + rs.getString(1) + "<BR>";
//        result += "<img src='http://172.16.13.149:8081/LDSPlatform-war/rest/resources/"+rs.getString(1)+"' style='margin:0 auto;display:block;width:50%;height:50%'/><BR>"; 
//        result += "<img src='http://192.168.0.88:8081/LDSPlatform-war/rest/resources/"+rs.getString(1)+"' style='margin:0 auto;display:block;width:50%;height:50%'/><BR>";
        result += "<img src='http://192.168.0.64:8080/LDSPlatform-war/rest/resources/"+rs.getString(1)+"' style='margin:0 auto;display:block;width:50%;height:50%'/><BR>";
        
    }

    rs.close(); // 关闭结果集
    stmt.close(); // 关闭执行语句对象
    conn.close(); // 关闭与数据库的连接
%> 

<HTML>
<BODY>
  <%=result%>
</BODY>
</HTML>
