<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>게시판 글 수정</title>
	<style type="text/css">
		div {border: 0.1px solid black;}
		div.divHeader {top: 0; width: 100%; display: inline-block;}
		div.divBody	{float:left; width: 800px; height: 500px;}
		div.divFooter {float:left; bottom: 0; width: 100%;}
		div.divIdTitle {float: left;}
		div.divId {float: left;}
		div.divTitle {float: left;}
		div.divNameDate {float: right; right: 0;}
		div.divName {float: left;}
		div.divDate {float: left;}
		div.divFooterMainpage {float: left;}
		div.divFooterAlign {float: right; right: 0;}
		div.divFooterEdit	{float: left;}
		div.divFooterDelete {float: left;}
	</style>
</head>
<body>
	<div align="center">
		<h1>게시판 글 수정</h1>
		<form action="<c:url value="/edit"/>" method="post">
			<div>
				<table border="1" width="800px">
					<tr>
						<td>
							<div class="divBoard">
								<div class="divHeader">
									<div class="divIdTitle">
<!-- 										<div class="divId"> -->
<%-- 											<strong>No : </strong>${boardVo.id} --%>
<!-- 										</div> -->
										<div class="divTitle">
											<strong> 제목 : </strong> <input value="${boardVo.title}" name="title">
										</div>
									</div>
									<div class="divNameDate">
										<div class="divName">
											<strong> 작성자 : </strong> <input value="${boardVo.name}" name="name">
										</div>
										<div class="divDate">
											<strong> 작성일 : </strong> <input value="${boardVo.regDate}" name="regDate">
										</div>
									</div>
								</div>
								<div class="divBody">									
									<textarea style="width:799px; height: 500px;" name="content">${boardVo.content}</textarea>
								</div>
								<div class="divFooter">
									<div class="divFooterMainpage">
										<a href="<c:url value="/"/>"><input type="button" value="목록으로"></a>
									</div>
									<div class="divFooterAlign">
										<div class="divFooterEdit">
											<input name="id" type="hidden" value="${id}">
											<input type="submit" value="게시글 등록">
										</div>
										<div class="divFooterDelete">
											<input type="reset" value="게시글 리셋">
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
