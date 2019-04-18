<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js">
</script>
</head>
<body>
<div id="proj-aim-box">
<h3>工程目的：</h3><br/>
<ul>
    <li>用于异步消息一致性测试</li>
</ul>
</div>
<div id="proj-problem-box">
<h3>记工程建立出现的问题：</h3><br/>
<ul>
    <li>单独建立spring boot 工程，使用bootstrap.properties配置会导致工程无法获取到配置数据，需改为使用application.properties；若必须使用bootstrap.properties，需引入spring cloud context依赖。</li>
    <li>idea下application.properties文件中提示不认识某配置参数，或配置文件图标异常，是因为idea没有识别到该工程是spring工程，需要在idea->file->project structure->对应工程->配置工程为spring工程<br/></li>
</ul>
</div>
</body>
</html>