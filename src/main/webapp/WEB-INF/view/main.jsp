<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<frameset rows="89,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="page/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="200,*" frameborder="no" border="0" framespacing="0" id="oa_frame">
    <frame src="sys/getMenuJson.do" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="page/right.jsp" name="rightFrame" scrolling="yes" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
</html>
