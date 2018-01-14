<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.data {
	 	width:5%;
	}
	.te{
		width:5%;
	}
	.ce{
		width:5%;
	}
	.de{
		width:3%;
	}
</style>
<script type="text/javascript">
	function confirmDelete(newId){
		if(confirm("是否删除当前数据")){
			window.location="DeleteNewsServlet?newid="+newId;
			
		}
	}
	
	
</script>
</head>
<body>
		<form action="NewsServlet" method="get">
			<input type="text" name="content" value="${content}">
			<input type="submit" value="搜索">
		</form>
	<div>
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0" border=1>
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>新闻编号</td>
					<td>新闻标题</td>
					<td>新闻内容</td>
					<td>新闻创建时间</td>
					<td>操作</td>
				</tr>
			</thead >
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach var="tmp" items="${requestScope.newsList.data}">
					<tr align="center" >
						<td class="data">${pageScope.tmp.newid}</td>
						<td class="te">${pageScope.tmp.title}</td>
						<td class="ct">${pageScope.tmp.content}</td>
						<td class="ce">${pageScope.tmp.createtime}</td>
						<td class="de">
							<a href="javascript:confirmDelete(${pageScope.tmp.newid})" class="FunctionButton">删除</a>				
						</td>
					</tr>
				</c:forEach>
				<tr>
        		<td colspan="4">
        			<a href="${pageContext.request.contextPath}/NewsServlet?curPage=1">首页</a>
				<a href="${pageContext.request.contextPath}/NewsServlet?curPage=${requestScope.newsList.prePage}">上一页</a>
				<c:forEach var="i" begin="1" end="${requestScope.newsList.totalPage}" step="1">
					<a href="${pageContext.request.contextPath}/NewsServlet?curPage=${pageScope.i}">${pageScope.i}</a>
				</c:forEach> 
				<a href="${pageContext.request.contextPath}/NewsServlet?curPage=${requestScope.newsList.nextPage}">下一页</a>
				<a href="${pageContext.request.contextPath}/NewsServlet?curPage=${requestScope.newsList.totalPage}">尾页</a>
        		</td>
        	</tr>
        
			</tbody>
		</table>
		<a href="add.jsp"><input type="button" value=" 添加新闻 "></a>
	</div>
</body>
</html>