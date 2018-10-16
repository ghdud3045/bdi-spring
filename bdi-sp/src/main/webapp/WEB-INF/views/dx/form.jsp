<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>스프링테스트</title>
</head>
<script>
	var dxFrom, dxWin;

	var loginFormData = [ {
		type : 'fieldset',
		name : 'login',
		label : 'login',
		inputWidth : 'auto',
		list : [ {type : 'input',name : 'id',label : 'ID',validate:'ValidAplhaNumeric',required:true}, 
		{type : 'password',name : 'pwd',label : 'PWD',validate:'ValidAplhaNumeric',required:true}, 
		{type : 'button',name : 'loginbtn',value : 'LOGIN'} 
		]
	} ];

	function doInit() {
		var froms = [ {type : 'button',value : '버튼',name : 'Btn'}, 
			{type : 'button',value : '오픈',name : 'open'} ]

		var dxForm = new dhtmlXForm('dxForm', froms);

		dxForm.attachEvent('onButtonClick', function(name) {
			if (name == 'Btn') {
				alert(name);
			} else if (name == 'open') {
				if (!dxWin) {
					dxWin = new dhtmlXWindows();
					dxWin.createWindow('w1', 0, 0, 220, 250);
					dxWin.window('w1').centerOnScreen();
					var loginForm = new dhtmlXForm('loginForm', loginFormData);
					dxWin.window('w1').attachObject('loginForm');
					loginForm.attachEvent('onButtonClick', function(name) {
						if (name == 'loginbtn') {
							if(loginForm.validate()){
							var id = loginForm.getItemValue('id');
							var pwd = loginForm.getItemValue('pwd');
							var conf = {
								url : '/login',
								method : 'POST',
								param : JSON.stringify({id : id,pwd : pwd}),
								success : function(res) {
									res = JSON.parse(res);
									alert(res.msg);
									}
								}
							au.send(conf);
							}
						}
					})
				}
			}
		})
	}
	window.addEventListener('load', doInit);
</script>
<body>
	<div id="dxForm" style="height: 100px;"></div>
	<div id="loginForm" style="width: 200px; height: 200px;"></div>
</body>
</html>