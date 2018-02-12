<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
			<!-- Custom styles for this template -->
	<link href="/resources/css/signin.css" rel="stylesheet">
	<script>
		$(document).ready(function() {
			$('form#feedInput').submit(function(e) {
				e.preventDefault();
				var form = $(this);

				$.ajax({
					url: '/user/authentication',
					data: form.serialize(),
					dataType: 'json',
					type: 'post',
					success: function (result) {
						$('#myModal').addClass("in");
						if(result != null){
							$('#myModal').find('#modalMessage').html("Good");
							$('#myModal').on('hide.bs.modal', function(e){
								// 이전페이지로
								window.location.href = result.returnURL;
							});
						} else {
							$('#myModal').find('#modalMessage').html("asd");
							return false;
						}
					},
					error: function (request,status,error){
						alert(error);
						$("#debug").html("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				});
			});
		});
	</script>

	<div class="container">

		<form class="form-signin" id="feedInput" name="feedInput">
		<!-- action="/user/authentication<?=empty($returnURL) ? '' : '?returnURL='.rawurlencode($returnURL) ?>" method="POST"> -->
			<input type="hidden" name="returnURL" id="returnURL" value="${returnURL}"/>
			<h2 class="form-signin-heading">Please sign in</h2>

			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="text" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>

			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>

			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me" id="remember" name="remember"> Remember me
				</label>
			</div>
			<div>
				<a href="/user/loginHelp"><h6>Forgot your email or password?</h6></a>
			</div>
			<input class="btn btn-lg btn-primary btn-block" type="submit" data-toggle="modal" data-target="#myModal" value="Sign in"/>
			<div>
				<a href="/user/signup"><h4>Sign up</h4></a>
			</div>
		</form>

		<!-- Modal popUp -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">Login</h4>
					</div>
					<div class="modal-body"><span id="modalMessage"></span></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

	</div> <!-- /container -->

