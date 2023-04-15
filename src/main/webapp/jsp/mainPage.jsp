<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../jspHead.jsp" %>
	<!--  分页样式  -->
	<style>
		.page{
			display:inline-block;			/*  内联对象  */
			border: 1px solid ;			/*  1像素边框  */
			font-size: 20px;				/*  文字大小20像素  */
			width: 30px;					/*  宽度30像素  */
			height: 30px;				/*  高度30像素  */
			background-color: #1faeff;	/*  设置背景色  */
			text-align: center;			/*  居中对齐  */
		}
		a,a:hover{ text-decoration:none; color:#333}
	</style>

</head>
<body>

<table class="table table-striped">
	<tr>
		<th width="70%"> <strong> 标题：</strong> </th>
		<th width="10%"> <strong> 作者</strong> </th>
		<th width="10%"> <strong> 回复/查看</strong> </th>
		<th width="10%"> <strong> 最后发表</strong> </th>
	</tr>
<%--	choose标签相当于java代码中的switch case语句--%>
	<c:choose>
<%--		when == switch中的case--%>
		<c:when test="${not empty main}">
			<c:forEach items="${main}" var="item" varStatus="vs">
				<tr>
					<td>
						<a href="/secondPageContent?mainId=${item.main_id}">
							<img src="../image/pin_1.gif" alt="" id="${item.main_title}img"/>
							[日月精华]&nbsp;&nbsp;
								<%--					获取标题--%>
								${item.main_title}
						</a>
					</td>
					<td>
						${item.main_creatuser}
					</td>
					<td>
						${item.info_replay}/${item.info_see}
					</td>
					<td>
						${item.info_lastuser}
					</td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
<%--	<tr>--%>
<%--		<td>--%>
<%--			<a href="#">--%>
<%--				<img src="../image/folder_new.gif" alt="">--%>
<%--				[最新帖子]&nbsp;&nbsp;欢迎光临Java EE板块专区--%>
<%--			</a>--%>
<%--		</td>--%>
<%--		<td>admin1</td>--%>
<%--		<td>0/0</td>--%>
<%--		<td>ccccccc</td>--%>
<%--	</tr>--%>
</table>

<div class="row">
	<div class="col-xs-7">

	</div>
	<div class="col-xs-5 text-nowrap">
		<!--  获取分页  -->
<%--		<span class="page">--%>
<%--			<a href="?page=1&mainType=javaee"><<</a>--%>
<%--		</span>--%>
<%--		<span class="page" style="width: 50px !important;">--%>
<%--			<a href="?page=1&mainType=javaee">start</a>--%>
<%--		</span>--%>
<%--		<span class="page">--%>
<%--			<a href="?page=1&mainType=javaee">1</a>--%>
<%--		</span>--%>
<%--		<span class="page" style="width: 40px !important;">--%>
<%--			<a href="?page=1&mainType=javaee">end</a>--%>
<%--		</span>--%>
<%--		<span class="page">--%>
<%--			<a href="?page=1&mainType=javaee">>></a>--%>
<%--		</span>--%>

		${pageHtml}
	</div>
</div>

<form action="saveUeditorContent" method="post">
	<label>
		帖子标题: <input type="text" name="mainTitle" placeholder="最大长度为80个汉字" style="width: 360px"/>
	</label>
	<button type="submit" class="btn btn-primary btn-xs text-right">发表帖子</button>
	<!-- 加载编辑器的容器 -->
	<div style="padding: 0px;margin: 0px;width: 100%;height: 100%;" >
		<script id="container" name="content" type="text/plain">

		</script>
	</div>


</form>

<!-- 配置文件 -->
<%--<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>--%>
<%--<!-- 编辑器源码文件 -->--%>
<%--<script type="text/javascript" src="../ueditor/ueditor.all.js"></script>--%>
<!-- 实例化编辑器 -->
<script type="text/javascript">
	var editor = UE.getEditor('container');
</script>
<!-- end富文本 -->
</body>
</html>