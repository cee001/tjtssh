
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'news.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/uicenterStyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>

	<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<script charset="utf-8" type="text/javascript" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" type="text/javascript" src="kindeditor/lang/zh_CN.js"></script>
		<script>
			KindEditor.ready(function(K) {
				var editor = K.editor({
					allowFileManager : true
				});
				K('#insertfile').click(function() {
					editor.loadPlugin('insertfile', function() {
						editor.plugin.fileDialog({
							fileUrl : K('#url').val(),
							clickFn : function(url, title) {
								K('#url').val(url);
								editor.hideDialog();
							}
						});
					});
				});
			});
		</script>
	</head>
	<body>
		<input type="text" id="url" value="" /> <input type="button" id="insertfile" value="选择文件" />
	</body>
</html>
