<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
   	<table>
   		<tr>
    			<td colspan="111">当前${page.currentPage}/${page.pageCount}页,共${page.count}条记录-----
    				<button onclick="paging(1)">首页</button>
    				<button onclick="paging('${page.previousPage}')">上一页</button>
    				<button onclick="paging('${page.nextPage}')">下一页</button>
    				<button onclick="paging('${page.pageCount}')">尾页</button>
    				跳转到：<input type="text" size="1" id="tz" value="${page.currentPage}"/>页
    				<button onclick="paging('go')">go</button>
    			</td>
    		</tr>
   	</table>
  </body>
  <script type="text/javascript">
 	var yema;
 	function paging(obj){
 		if(obj=='go'){
 			yema = document.getElementById("tz").value;
 		}else{
 			yema = obj;
 		}
 		document.getElementsByName("yema")[0].value=yema;
 		document.forms[0].submit();
 	}
 </script>
</html>
