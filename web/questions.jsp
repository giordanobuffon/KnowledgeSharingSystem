<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="global">
    <form action="" method="post" onsubmit="">
        <label for="title">Título</label>
        <input type="text" name="title" id="title" maxlength="45" placeholder="Qual sua pergunta? Seja específico" onchange="">
        <br><br>
        <textarea id="question" name="question" cols="50" rows="15" style="opacity: 1; height: 54px;"></textarea>
        <br><br>
        <input class="button" type="submit" value="Publicar sua Pergunta" style="margin-left: 21%">
        <input class="button" type="reset" value="Limpar" style="margin-left: 20px">
    </form>
</div>

<%@include file="footer.jsp"%>
