<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<head>
    <title>Login</title>
    <%@ include file="title.jsp" %>
    <div class="container">
        <%@ include file="header.jsp" %>
        <div id="dForm">
            <form id="lForm" action="ProcessingStudent" method="post">
                <input type="hidden" name="operation" value="SEARCH">
                <h1 class="hForm">Faça o Login</h1><br>
                <p id="pRegistration">
                    <label for="registration">Matrícula</label><br>
                    <input type="number" name="registration" id="registration" placeholder="00000000" required="required"/>
                </p><br>
                <p class="pPassword">
                    <label for="password">Senha</label><br>
                    <input type="password" name="password" id="password" placeholder="******"/> <br>
                    <span>Esqueceu sua senha?</span>
                </p><br>
                <p class="submit">
                    <input type="submit" value="Login"/>
                    <a href="register.jsp">Cadastre-se</a>
                </p>
            </form>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
    </body>
    </html>
