<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 

<div class="container mt50">
	
	<nav>
	  <div class="nav nav-tabs" id="nav-tab" role="tablist">
	    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="true">내 정보</a>
	    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-update" role="tab" aria-controls="nav-update" aria-selected="false">정보 수정</a>
	    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-message" role="tab" aria-controls="nav-message" aria-selected="false">메시지 수신함</a>
	    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-secede" role="tab" aria-controls="nav-secede" aria-selected="false">계정 탈퇴</a>
	  </div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
	  <div class="tab-pane fade show active" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
			<table class="table table-striped table-bordered" id="profileTable">
				<tbody>
					<tr>
						<th scope="row">이름</th>
						<td><sec:authentication property="user.name" /></td>
					</tr>
					<tr>
						<th scope="row">ID</th>
						<td><sec:authentication property="user.loginEmail" /></td>
					</tr>
					<tr>
						<th scope="row">닉네임</th>
						<td><sec:authentication property="user.nickName" /></td>
					</tr>
					<tr>
						<th scope="row">계정생성일자</th>
						<td><sec:authentication property="user.makeTime" /></td>
					</tr>
					<tr>
						<th scope="row">최종접속시간</th>
						<td><sec:authentication property="user.latelyTime" /></td>
					</tr>
					<tr>
						<th scope="row">접속횟수</th>
						<td><sec:authentication property="user.accessCount" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	  <div class="tab-pane fade" id="nav-update" role="tabpanel" aria-labelledby="nav-update-tab">정보수정</div>
	  <div class="tab-pane fade" id="nav-message" role="tabpanel" aria-labelledby="nav-message-tab">메시지 수신함</div>
	  <div class="tab-pane fade" id="nav-secede" role="tabpanel" aria-labelledby="nav-secede-tab">
	  	<div class="mt50">
		  	정말 계정을 탈퇴하시겠습니까?
	  	</div>
	  </div>
	</div>
	
</div>
