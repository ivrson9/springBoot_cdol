<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
	<div class="col-sm-offset-3 col-md-offset-2 main">
		<script>
			window.onload = function() {
				var num = ${list_num};
				if(num == 1){
					document.getElementById("prev").setAttribute('class', 'disabled');
					document.getElementById("prev_link").setAttribute('href', 'javascript:;');
				}
				if(num == ${page_cnt}){
					document.getElementById("next").setAttribute('class', 'disabled');
					document.getElementById("next_link").setAttribute('href', 'javascript:;');
				}

				var type = '${search_type}';
				if(type != ''){
					for(var i=0 ; i < 3; i++){
						if(document.getElementById("search_type").options[i].value == type){
							document.getElementById("search_type").options[i].selected = true;
						}
					}
				}
				document.getElementById(num).setAttribute('class', 'active');
			}

			function list_view(list_num){
				var form = document.getElementById("list_form");
				var type = document.getElementById("search_type");
				var search = document.getElementById("search_cont");

				if(type.value == ''){
					form.action = "/cdol/board/lists/${boardName}/"+list_num;
					form.submit();
				}

			}
		</script>

		<h3><strong>${boardName}</strong></h3>
		<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<td align="center" width="50"><strong>No</strong></td>
					<td><strong>Title</strong></td>
					<td align="center" width="10"><strong>Name</strong></td>
					<td align="center" width="180"><strong>Date</strong></td>
					<td align="center" width="70"><strong>Hit</strong></td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="entry" items="${boardList}">
			<tr>
				<td align="center">${entry.b_no}</td>
				<td>
					<a href="/board/view/${boardName}?cnt=${list_num}&b_no=${entry.b_no}">${entry.b_title}&nbsp;</a>&nbsp;
					<c:if test="${entry.com_cnt != 0}">
					<span class="badge">${entry.com_cnt}</span>
					</c:if>
					<c:if test="${today == entry.b_date}">
					<span class='badge'>new</span>&nbsp;
					</c:if>
				</td>
				<td align="center">${entry.name}</td>
				<td align="center">${entry.b_date}</td>
				<td align="center">${entry.b_hit}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		<div class="row">
			<div class="col-md-12" style="text-align:right">
				<a href="/cdol/board/write/<?=$name?>" class="btn btn-default">Write</a>
			</div>
		</div>
		<!-- 페이징 처리 -->
		<div style="text-align:center">
			<ul class='pagination'>
			<c:set var="uri" value="/board/lists/${boardName}"/>
			<c:if test="${search_cont != ''}">
				<c:set var="addUri" value="&search_type=${search_type}&search_cont=${search_cont}"/>
			</c:if>
				<li id="prev">
					<a id="prev_link" href="${uri}?cnt=${list_num-1}${addUri}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				<fmt:parseNumber var="begin" integerOnly="true" value="${(list_num-1)/5}" />
				<c:set var="begin" value="${begin*5 + 1}"/>
				<c:set var="doneLoop" value="false"/>
				<c:forEach var="cnt" begin="${begin}" end="${page_cnt}" step="1" varStatus="status">
					<c:if test="${not doneLoop}">
					<li id="${cnt}">
						<a href="${uri}?cnt=${cnt}${addUri}">${cnt}</a>
					</li>
					<c:if test="${cnt%5 == 0}">
						<c:set var="doneLoop" value="true"/>
					</c:if>
					</c:if>
				</c:forEach>
				<li id="next">
					<a id="next_link" href="${uri}?cnt=${list_num+1}${addUri}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
			</ul>
		</div>

		<div class="row">
			<div class="col-md-12" style="text-align:center">
				<form class="navbar-form" role="search" action="/board/lists/${boardName}" method="GET">
					<select class="form-control" id="search_type" name="search_type">
						<option value="b_title">제목</option>
						<option value="b_content">내용</option>
						<option value="all">제목+내용</option>
						<option value="id">아이디</option>
					</select>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" id="search_cont" name="search_cont" value="${search_cont}"/>
					</div>
					<button class="btn btn-default" onclick="submit">Search</button>
				</form>
			</div>
		</div>
	</div>
