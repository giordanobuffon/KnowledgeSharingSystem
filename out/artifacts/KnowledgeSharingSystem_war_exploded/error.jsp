<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Erro</title>
    <script src="JavaScript/validations.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="global">
<h1>Cadastro de Cidades</h1>
<hr>
<h1 style="color: red;"> Falha ao Processar os Dados </h1>
<hr>
<p>Verifique a mensagem abaixo e tente novamente mais tarde:</p>

<%
    String msg = (String) request.getAttribute("msg");
%>
<p style="color: red"><%= msg%>
</p>

<a href="javascript:window.history.go(-1)">Voltar</a>
</div>
</body>
</html>
