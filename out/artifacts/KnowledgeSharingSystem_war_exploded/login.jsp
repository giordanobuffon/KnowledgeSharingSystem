<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<head>
    <title>Login</title>
    <%@ include file="title.jsp" %>
    <div class="container">
        <%@ include file="cabecalho.jsp" %>
        <div id="dForm">
            <form id="lForm">
                <h1 class="hForm">Faça o Login</h1><br>
                <p id="pMatricula">
                    <label for="registration">Matrícula</label><br>
                    <input type="number" id="registration" placeholder="00000000" required="required" name="matricula"/>
                </p><br>
                <p class="pSenha">
                    <label for="password">Senha</label><br>
                    <input type="password" id="password" placeholder="******" name="senha"/> <br>
                    <span>Esqueceu sua senha?</span>
                </p><br>
                <p class="submit">
                    <input type="submit" value="Login"/>
                    <a href="cadastro.jsp">Cadastre-se</a>
                </p>
            </form>
        </div>
        <%@ include file="rodape.jsp" %>
    </div>
    </body>
    </html>
