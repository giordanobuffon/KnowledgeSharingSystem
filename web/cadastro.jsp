<%@page contentType="text/html" pageEncoding="UTF-8" %>

<head>
    <title>Cadastro</title>
    <%@ include file="title.jsp" %>
    <div class="container">
        <%@ include file="cabecalho.jsp" %>
        <div id="dForm">
            <form id="cForm" action="ProcessingStudent" method="post">
                <input type="hidden" name="operation" value="INSERT">
                <h1 class="hForm">Faça seu Cadastro</h1><br>
                <p id="pName">
                    <label for="name">Nome</label><br>
                    <input type="text" name="name" id="name" placeholder="Chiquinho da Silva" required="required"/>
                </p>
                <br>
                <p id="pEmail">
                    <label for="email">E-mail</label><br>
                    <input type="email" name="email" id="email" placeholder="cdsilva@restinga.ifrs.edu.br" required="required"/>
                </p>
                <br>
                <p id="pCourse">
                    <label for="course">Curso</label><br>
                    <input type="text" name="course" id="course" placeholder="Análise e Desenvolvimento de Sistemas" required="required"/>
                </p>
                <br>
                <p id="pSemester">
                    <label for="semester">Semestre de ingresso</label><br>
                    <input type="text" name="semester" id="semester" placeholder="2017/1" required="required"/>
                </p>
                <br>
                <p id="pRegistration">
                    <label for="registration">Matrícula</label><br>
                    <input type="number" name="registration" id="registration" placeholder="00000000" required="required"/>
                </p>
                <br>
                <p class="pPassword">
                    <label for="password">Senha</label><br>
                    <input type="password" name="password" id="password" placeholder="******"/>
                </p>
                <br>
                <p class="pPassword">
                    <label for="passwordC">Confirmação de Senha</label><br>
                    <input type="password" name="passwordC" id="passwordC" placeholder="******"/>
                    <%--TODO validate password--%>
                </p>
                <br>
                <p class="submit">
                    <input type="submit" value="Cadastre-se"/>
                    <a href="login.jsp">Login</a>
                </p>
                <br>
            </form>
        </div>
        <%@ include file="rodape.jsp" %>
    </div>
    </body>
    </html>
