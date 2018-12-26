<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<style> .error { color: red; }</style>
<div class="row">
	<div class="col-lg-4"></div>
	<div class="col-lg-4 borderPanel">
		<form:form method="post" modelAttribute="userJoinModel">
			<div class="form-group centerLabel"><h4>회원가입</h4></div>
			<div class="form-group">
				<label for="input_loginEmail">이메일</label>
  				<form:input type="text" id="input_loginEmail" path="loginEmail" name="loginEmail" placeholder="email@example.com" 
  					class="form-control" />
				<form:errors path="loginEmail" class="error" />
			</div>
			<div class="form-group">
				<label for="input_password">비밀번호</label>
				<form:input type="password" id="input_password" path="password" name="password" 
					class="form-control" maxlength="15"/>
				<form:errors path="password" class="error" />
			</div>
			<div class="form-group">
				<label for="input_rePassword">비밀번호 재입력</label>
				<form:input type="password" id="input_rePassword" path="rePassword" name="rePassword" 
					class="form-control" maxlength="15"/>
				<form:errors path="rePassword" class="error" />
			</div>
			<div class="form-group">
				<label for="input_name">이름</label>
				<form:input type="text" id="input_name" name="name" path="name" class="form-control" maxlength="20" />
				<form:errors path="name" class="error" />
			</div>
			<div class="form-group">
				<label for="input_nickName">닉네임</label>
				<form:input type="text" id="input_nickName" path="nickName" name="nickName" placeholder="미입력시 이름으로 대체됩니다." 
					class="form-control" maxlength="20"/>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-md-6 joinBtnleft">
						<button type="submit" class="btn btn-dark btn-block" >가입</button>
					</div>
					<div class="col-md-6 joinBtnright">
						<a class="btn btn-danger btn-block" href="index">돌아가기</a>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-lg-4"></div>
</div>