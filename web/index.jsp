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
    <form action="" method="post" onsubmit="return validateLogin()">
        <label for="registration">Matrícula</label>
        <input type="text" name="registration" id="registration" maxlength="8" onchange="" required>
        <br><br>
        <label for="password">Senha</label>
        <input type="password" name="password" id="password" onchange="" required>
        <br><br>
        <input class="button" type="submit" value="Log In" style="margin-left: 21%">
    </form>
</div>
<div class="register">
    <p>Não possui uma conta? <a href="register.jsp" style="color: black">Registre-se</a></p>
</div>
</body>
</html>
