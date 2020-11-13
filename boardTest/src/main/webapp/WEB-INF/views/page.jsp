<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>게시판</title>
	<style type="text/css">
		ul li {align-content:center; list-style-type: none; float: left; margin: 0px 5px;}
		div {border: 0.1px solid black;}
		div.divHeader {align-content: center; top: 0; width: 800px; height: 23.2px;}
		div.box {float: left; width: 100px; height: 23.2px;}
		div.divBody	{align-content: center;}
		div.divFooter {align-content: center;}
		div.divPageNo {width: 500px;height: 55px;}
		div.divWriter {float: right;}
		a { text-decoration: none; color: black;}
		a:hover {color: blue;}
		table.tableClass {width: 800px;}
		table.tableClass tr td {width:20px;}
		.tdA {text-align: center;}
		.tdB {display: block; width: 200px; height:25px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;}
		.tdC {display: block; width: 300px; height:25px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;}
	</style>
</head>
<body>
	<div align="center">
		<h1>게시판 목록</h1>
		<div class="homeBody">
			<div class="divHeader">
				<div class="box">
					<form:form modelAttribute="page">
						<form:select path="Criteria">
							<option value="5">5</option>
							<option value="10">10</option>
							<option value="20">20</option>
						</form:select>
					</form:form>
				</div>
			</div>
			<div class="divBody">
				<table border="1" class="tableClass">
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					<c:forEach items="${list}" var="vo">
						<tr>
							<td><a class="tdA" href="<c:url value="/info/${vo.id}"/>">${vo.id}</a></td>
							<td><a class="tdB" href="<c:url value="/info/${vo.id}"/>">${vo.title}</a></td>
							<td><a class="tdC" href="<c:url value="/info/${vo.id}"/>">${vo.content}</a></td>
							<td>${vo.name}</td>
							<td>${vo.regDate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="divFooter">
				<div class="divWriter">
					<a href="<c:url value="/write"/>"><input type="button" value="게시글 작성"></a>
				</div>
				<div class="divPageNo">
					<ul>
						<c:if test="${pageMaker.prev}">
							<li><a href="page?page=${pageMaker.startPage-1}">이전</a></li>
						</c:if>
						
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
							<li><a href="page?page=${num}">${num}</a></li>
						</c:forEach>
						
						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a href="page?page=${pageMaker.endPage+1}">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
