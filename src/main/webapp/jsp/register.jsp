<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css"/>

<style>
	body{
		margin-top:20px;
		margin:0 auto;
	}
	.carousel-inner .item img{
		width:100%;
		height:300px;
	}
	.container .row div{
		/* position:relative;
        float:left; */
	}

	font {
		color: #3164af;
		font-size: 18px;
		font-weight: normal;
		padding: 0 10px;
	}
</style>
</head>
<body>





<!--
    描述：导航条
-->
<%@include file="/jsp/header.jsp"%>





<div class="container" style="width:100%;background:url('img/regist_bg.jpg');">
	<div class="row">

		<div class="col-md-2"></div>




		<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
			<font>会员注册</font>USER REGISTER
			<form class="form-horizontal" style="margin-top:5px;" action="UserServlet?method=registUsers" method="post">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" name="password" id="inputPassword" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" name="password2" id="confirmpwd" placeholder="请输入确认密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-6">
						<input type="email" class="form-control" name="email" id="inputEmail3" placeholder="Email">
					</div>
				</div>

				<div class="form-group">
					<label for="usercaption" class="col-sm-2 control-label">姓名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="name" id="usercaption" placeholder="请输入姓名">
					</div>
				</div>

				<div class="form-group">
					<label for="usercaption" class="col-sm-2 control-label">电话</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="telephone" id="telephone2" placeholder="请输入手机号">
					</div>
				</div>

				<div class="form-group opt">
					<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-6">
						<label class="radio-inline">
							<input type="radio" name="sex" id="inlineRadio1" value="男"> 男
						</label>
						<label class="radio-inline">
							<input type="radio" name="sex" id="inlineRadio2" value="女"> 女
						</label>
					</div>
				</div>
				<div class="form-group">
					<label for="date" class="col-sm-2 control-label">出生日期</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" name="birthday" id="chushengriqi" >
					</div>
				</div>

				<div class="form-group">
					<label for="date" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name=""  >

					</div>
					<div class="col-sm-2">
						<img src="checkCode" onclick="changeCheckCode(this)"/>
					</div>

				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit"  width="100" value="注册" name="submit" border="0"
							   style="background: url('img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
									   height:35px;width:100px;color:white;">
					</div>
				</div>
			</form>
		</div>

		<div class="col-md-2"></div>

	</div>
</div>



<%@include file="/jsp/footer.jsp"%>

</body>
<script type="text/javascript">
    //验证用户注册信息最低是8位
    function checkUserName(){
        var username = $("#username").val();
        //var reg_username = /^[a-zA-Z\d]\w{2,10}[a-zA-Z\d]$/;
        var reg_username = /^\w{8,20}$/;
        var flag = reg_username.test(username);
        if(flag){
            $("#username").css("border","1px solid blue")
        }else {
            alert("用户名非法最低8位")
        }
    }

    //验证用户输入密码
    function CheckPassword(){
        var password = $("#inputPassword").val();
        var reg_password = /^\w{8,20}$/;
        var flag = reg_password.test(password);
        if (flag){
            $("#inputPassword").css("border","1px,solid blue")
        } else {
            alert("密码错误最低8位")
        }
    }

    //验证用户确认密码
    function CheckPassword2(){
        var password2 = $("#confirmpwd").val();
        var password = $("#inputPassword").val();
        var reg_password2 = /^\w{8,20}$/;
        var flag = reg_password2.test(password2);
        if (flag){
            if (password2==password){
                $("#confirmpwd").css("border","1px,solid blue");
            }else {
                alert("两次输入的密码不对")
            }
        } else{
            alert("密码错误最低8位")
        }
    }


    //验证用户输入邮箱
    function checkEmail(){
        var email = $("#inputEmail3").val();
        var reg_Email = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        var flag = reg_Email.test(email);
        if (flag) {
            $("#inputEmail3").css("border","1px solid blue");
        }else{
            alert("邮箱非法，重新输入")
        }

    }
    //验证用户输入姓名
    function checkName(){
        var name = $("#usercaption").val();
        var reg_Name = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
        var flag = reg_Name.test(name);
        if (flag){
            $("#usercaption").css("border","1px,solid blue")
        }else{
            alert("名字非法")
        }
    }

    //验证用户输入电话
    function checkTelePhone(){
        var teletPhone = $("#telephone2").val();
        var reg_Phone = /^1[34578]\d{9}$/;
        var flag = reg_Phone.test(teletPhone);
        if (flag){
            $("#telephone2").css("border","1px,solid blue")
        } else {
            alert("手机号格式不对")
        }
    }

    //验证用户输入出生日期
    function checkDate(){
        var brthDay = $("#chushengriqi").val();
        var reg_Birthday =  /\S/;
        var flag = reg_Birthday.test(brthDay);
        if (flag){
            $("#chushengriqi").css("border","1px,solid blue");
        } else {
            alert("出生日期不能为空")
        }

    }


    //产出验证码
    function changeCheckCode(img) {
        img.src="checkCode?"+new Date().getTime();

    }





    //验证用户输入验证码
    function checkCode(){
        var code1 = $("#servletCode").val();
        var inputCode = $("#code").val();
        var reg_Birthday =  /\S/;
        var flag = reg_Birthday.test(inputCode);
        if (flag){
            $("#code").css("border","1px solid blue")
        }
        else{
            alert("验证码不能为空")
        }
    }

    $(function () {
        //表单提交，调用验证方法
        //当一个组件失去焦点的时候，调用对应的校验方法
        $("#username").blur(checkUserName);
        $("#inputPassword").blur(CheckPassword);
        $("#confirmpwd").blur(CheckPassword2);
        $("#inputEmail3").blur(checkEmail);
        $("#usercaption").blur(checkName);
        $("#telephone2").blur(checkTelePhone);
        $("#chushengriqi").blur(checkDate);
        $("#code").blur(checkCode);
    });
</script>
</html>




