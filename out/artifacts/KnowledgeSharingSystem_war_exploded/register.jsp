<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>GrêmioMania</title>
    <meta name="keywords" content="grêmio, futebol, rei, copa">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <script src="javaScript/validations.js" type="text/javascript"></script>
</head>
<body>
<div class="global">
    <form action="" method="post" onsubmit="return requiredField()">
        <label for="name">Nome</label>
        <input type="text" name="name" id="name" maxlength="45" onchange="nameValidation()">
        <br><br>
        <label for="registration">Matrícula</label>
        <input type="text" name="registration" id="registration" maxlength="8" onchange="">
        <br><br>
        <label for="email">E-mail</label>
        <input type="email" name="email" id="email" onchange="">
        <br><br>
        <label for="password">Senha</label>
        <input type="password" name="password" id="password" onchange="">
        <br><br>
        <label for="passwordConfirm">Confirmação da Senha</label>
        <input type="password" name="password" id="passwordConfirm" onchange="">
        <br><br>
        <input class="button" type="submit" value="Cadastrar" style="margin-left: 21%">
        <input class="button" type="reset" value="Limpar" style="margin-left: 20px">
    </form>
</div>
</body>
</html>
