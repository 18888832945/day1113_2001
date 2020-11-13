<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/6
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <div id="vuediv">
    <form action="/teacher/saveTestMark.do" method="post" enctype="multipart/form-data">
        <table border="1" rules="all">
            <tr align="center">
                <td>
                    考试名称：
                </td>
                <td>
                    <input type="text" name="testname" onblur="checktestname()"/>
                </td>
            </tr>
            <tr>
                <td>
                    导入试题：
                </td>
                <td>
                    <input type="file" name="filename"/>
                    <input type="button" value="上传" @click="fileupload()"/>
                </td>
            </tr>
            <tr>
                <td>
                    总分
                </td>
                <td>
                    <input type="text" name="totalscore" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>
                    通关分
                </td>
                <td>
                    <input type="text" name="passscore"/>
                </td>
            </tr>
            <%--<tr>
                <td>
                    开始时间
                </td>
                <td>
                    <input type="datetime-local" name="starttime"/>
                </td>
            </tr>
            <tr>
                <td>
                    结束时间
                </td>
                <td>
                    <input type="datetime-local" name="endtime"/>
                </td>
            </tr>--%>
            <tr>
                <td>
                    考试时长
                </td>
                <td>
                    <input type="number" name="testtime"/>
                </td>
            </tr>
            <tr>
                <td>考试班级</td>
                <td>
                    <c:forEach var="g" items="${list}">
                        <input type="checkbox" name="gids" value="${g.gid}"/>${g.gname}<br>
                    </c:forEach>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="保存"/>
                    <input type="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
        </div>
    </center>
</body>
<script type="text/javascript" src="../../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../../vuejs/vuejs-2.5.16.js"></script>
<script type="text/javascript" src="../../vuejs/axios-0.18.0.js"></script>
<script type="text/javascript" src="../../vuejs/test_mark.js"></script>
<script>
    function aa() {
        var formData = new window.FormData();
        formData.append('file', document.querySelector('input[type=file]').files[0]);
        $.ajax({
            url: "/teacher/fileUpload.do",
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false,
            dataType:"json",
            success : function(data) {
               alert(data);
            }
        });

    }
</script>
</html>
