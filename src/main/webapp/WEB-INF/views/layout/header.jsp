<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="contents"/>
<tiles:importAttribute name="menu"/>
	<script>
		// 쪽지 창
		function win_memo(url){
			if (!url)
				url = g4_path + "/" + g4_bbs + "/memo.php";
			win_open(url, "winMemo", "left=50,top=50,width=620,height=460,scrollbars=1");
		}
		function win_open(url, name, option){
			var popup = window.open(url, name, option);
			popup.focus();
		}
	</script>
	<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Cdol Site</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
				<c:forEach items="${contents}" var="entry">
					<c:choose>
					<c:when test="${entry.m_cnt == 0 }">
					<li><a href="${entry.s_url}">${entry.s_title}</a></li>
					</c:when>
					<c:when test="${entry.m_cnt == 1 }"> <!-- 세부 메뉴가 1개일 경우 -->
						<c:forEach items="${menu}" var="entry2">
							<c:if test="${entry2.s_no == entry.s_no}">
							<li><a href="${entry2.m_url}">${entry.s_title}</a></li>
							</c:if>
						</c:forEach>
					</c:when>
					<c:otherwise>	<!-- 세부 메뉴가 있을경우(드롭박스) -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle js-activated" data-toggle="dropdown" role="button" aria-expanded="false">${entry.s_title}</a>
						<ul class="dropdown-menu">
						<c:forEach items="${menu}" var="entry2">
							<c:if test="${entry2.s_no == entry.s_no}">
								<li><a href="${entry2.m_url}">${entry2.m_title}</a></li>
							</c:if>
						</c:forEach>
						</ul>
					</li>
					</c:otherwise>
					</c:choose>

				</c:forEach>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:choose>
					<c:when test="${not empty sessionScope.user}">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.user.name} <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<a href="/user/profile"><i class="fa fa-fw fa-user"></i> Profile</a>
								</li>
							<li>
								<a href="javascript:win_memo('/memo');"><i class="fa fa-fw fa-envelope"></i> Inbox (<?=$meno_cnt?>)</a>
							</li>
							<c:if test="${sessionScope.user.level >= 4}">
							<li>
								<a href="/adm/main"><i class="fa fa-fw fa-gear"></i> Administrator</a>
							</li>
							</c:if>
							<li class="divider"></li>
							<li>
								<a href="/user/logout"><i class="fa fa-fw fa-sign-out"></i> Log Out</a>
							</li>
						</ul>
					</li>
					</c:when>
					<c:otherwise>
					<li><a href="/user/login"><i class="fa fa-fw fa-sign-in"></i> Sign in</a></li>
					</c:otherwise>
					</c:choose>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">