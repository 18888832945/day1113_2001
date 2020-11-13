<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/6
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <table align="center" border="1" rules="all">
            <tr bgcolor="#00ffff" align="center">
                <th>编号</th>
                <th>名称</th>
                <th>总分</th>
                <th>通关分</th>
                <th>时长</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>更新时间</th>
                <th>发布人</th>
                <th>操作<a href="/teacher/toMarkTest.do">发布试题</a>
                </th>
            </tr>
            <c:forEach var="t" items="${list}">
                <tr>
                    <td>${t.testid}</td>
                    <td>${t.testname}</td>
                    <td>${t.totalscore}</td>
                    <td>${t.passscore}</td>
                    <td>${t.testtime}</td>
                    <td>
                        <fmt:formatDate value="${t.starttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <fmt:formatDate value="${t.endtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <fmt:formatDate value="${t.updatetime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>${t.testauthor}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
