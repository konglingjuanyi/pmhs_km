<%@ page language = "java" contentType = "text/html; charset=UTF-8 " pageEncoding = "UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>昆明市国家公共卫生服务管理系统</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/file-upload.css" />
    <script type="text/javascript" src="/js/ext/adapter/ext/ext-base.js"></script>

    <script type='text/javascript' src='/dwr/engine.js'></script> 	
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/dwr/interface/systemInformationUtils.js'></script>
	<script type="text/javascript" src="js/jquery.tools.min.js"></script>
    <script type="text/javascript" src="js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="/js/ext/ext-all.js"></script>
    <script type="text/javascript" src="../js/ext/ext-lang-zh_CN.js"></script>

    <script type="text/javascript" src="/js/ext/dwrproxy.js"></script>
    <script type="text/javascript" src="/js/jsLoader.js"></script>
    <script type="text/javascript" src="/js/FormSetValues.js"></script>
    <script type="text/javascript" src="/js/TabCloseMenu.js"></script>
    <script type="text/javascript" src="/js/tf.js"></script>
    <link rel="shortcut icon" href="resources/logo/pmhs_title.png" >
	<!-- 
    <style type="text/css">
        html, body {
	        font:normal 12px verdana;
	        margin:0;
	        padding:0;
	        border:0 none;
	        overflow:hidden;
	        height:100%;
	    }
		p {
		    margin:5px;
		}
	    .settings {
	        background-image:url(/shared/icons/fam/folder_wrench.png);
	    }
	    .nav {
	        background-image:url(/shared/icons/fam/folder_go.png);
	    }
	    .upload-icon {
            background: url('/resources/icons/fam/image_add.png') no-repeat 0 0 !important;
        }
       .login-img {
				  background-image:url('/image/login-bg.jpg');
				}
    </style> -->
    <!-- <script type="text/javascript" src="/login.js"></script> -->
    
    <link rel="stylesheet" href="css/login.css"  type="text/css"/>
    <script type="text/javascript" src="js/getDate.js"></script>
    <script type="text/javascript" src="js/valideCode.js"></script>
    <script type="text/javascript">
    	var lastUsername, lastExceptionMessage;
    	
	    <c:if test="${not empty param.login_error}">
    	lastUsername = '<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>';
    	lastExceptionMessage = '<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>';
    	</c:if>

    	//alert("lastUsername:"+lastUsername);
    	//alert("lastExceptionMessage:"+lastExceptionMessage);
    </script>
    
    
</head>
<body>

  <div id="west">
  </div>
  <div id="north">
    
  </div>
  <div id="center2">
  	
  	<form id="loginForm">
	  	<div class="login" id="props-panel">
			<table class="login_table">
				<tbody>
					<tr>
						<td><input type="text" id="j_username" name="j_username" class="login_input input_class"/></td>
					</tr>
					<tr>
						<td><input type="password" id="j_password" name="j_password" class="login_input_password input_class"/></td>
					</tr>
					<tr>
						<td>
							<input type="text" id="code" class="login_input_code input_class"/>
							<input  title="换一个" id="valideCode" class="valideCode input_class" readonly="readonly"></input>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td>
							<input type="hidden" id="spring-security-redirect" name="spring-security-redirect" value="/admin/"/>
							<input class="login_btn" id="login_sure" readonly="readonly" />
							<input class="login_btn" id="login_cancel" readonly="readonly" />
							<input type="hidden" id="submitbutton" name="myhiddenbutton" value="hiddenvalue"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</form>
  </div>
 </body>
</html>

