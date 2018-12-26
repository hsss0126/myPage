<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<div class="row">
	<div class="col-lg-4"></div>
	<div class="col-lg-4 borderPanel">
		<form action="login_processing" method="post">
			<div class="form-group centerLabel"><h4>로그인</h4></div>
			<div class="form-group">
				<input type="text" placeholder="아이디"  name="loginId" 
					class="form-control" maxlength="30" />
			</div>
			<div class="form-group">
				<input type="password" placeholder="비밀번호" name="password" 
					class="form-control" maxlength="20"/>
			</div>
			<input type="submit" class="btn btn-dark btn-block" value="로그인" id="loginBtn" />
		</form>
		<div class="row">
			<div class="col-md-5">
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label fs15" for="exampleCheck1">자동 로그인</label>
				</div>
			</div>
			<div class="col-md-7" id="sublogin">
				<a href="#">비밀번호 찾기</a> | 
				<a href="join">회원가입</a>
			</div>
		</div>
		<c:if test="${ param.error != null }">
			<div class="mt5" style="color:red;">접속에 실패했습니다.</div>
		</c:if>
		<c:if test="${ param.joinSuccess != null }">
			<script>
				alert("회원가입에 성공했습니다. \n이메일 인증 후에 로그인 할 수 있습니다.");
			</script>
		</c:if>
		<c:if test="${ param.certifySuccess != null }">
			<script>
				alert("인증에 성공했습니다.");
			</script>
		</c:if>
	</div>
	<div class="col-lg-4"></div>
</div>
