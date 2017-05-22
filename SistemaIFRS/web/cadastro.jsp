

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
        <title>Cadastro</title>
<%@include file = "title.jsp" %>
<div class="container">
<%@ include file = "cabecalho.jsp" %>


<div id="dForm">
            
            <form id="cForm">
                
                <h1 class="hForm">Faça seu Cadastro</h1><br>

        <p id="pNome">
            <label for="nome">Nome</label><br>
            <input type="text" id="nomeId" placeholder="Chiquinho da Silva" required="required" name="nome" />
        </p>
<br>
        <p id="pEmail">
            <label for="email">E-mail</label><br>
            <input type="email" id="emailId" placeholder="cdsilva@restinga.ifrs.edu.br" required="required" name="email" />
        </p>
                <br>
        <p id="pMatricula">
            <label for="matricula">Matrícula</label><br>
            <input type="number" id="matriculaId" placeholder="00000000" required="required" name="matricula" />
        </p>
        <br>
        <p class="pSenha">
            <label for="senha">Senha</label><br>
            <input type="password" id="senhaId" placeholder="******" name="senha" /> 
        </p>
        <br>
        <p class="pSenha">
            <label for="senha">Confirmação de Senha</label><br>
            <input type="password" id="senhaId" placeholder="******" name="senha" /> 
        </p>
        <br>
        <p class="submit">
            <input type="submit" value="Cadastrar-se" />
            <a href="login.jsp">Login</a>
        </p>
        <br>
            </form>
            
        </div>


<%@ include file = "rodape.jsp" %>
</div>
  </body>
</html>
