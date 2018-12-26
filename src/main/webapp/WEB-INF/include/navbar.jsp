<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="index">
			 <img src="../res/img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">Home
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample04">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<a class="nav-link" href="#">PageInfo <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Board</a>
				</li>
				<sec:authorize access="authenticated">
					<li class="nav-item">
						<a class="nav-link" href="mypage">MyPage</a>
					</li>
				</sec:authorize>
				<!-- <li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
						<a class="dropdown-item" href="#">Action</a>
						<a class="dropdown-item" href="#">Another action</a>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				</li> -->
			</ul>
			<sec:authorize access="not authenticated">
				<ul class="navbar-nav mr-sm-3">
					<li class="nav-item">
						<a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="join">Join</a>
					</li>
				</ul>
			</sec:authorize>
			<sec:authorize access="authenticated">
				<ul class="navbar-nav mr-sm-3">
					<li class="nav-item active">
						<a class="nav-link" href="mypage"><sec:authentication property="user.nickName" /><span>님 접속</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="logout?id=<sec:authentication property="user.id" />">Logout</a>
					</li>
				</ul>
			</sec:authorize>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</div>
 </nav>