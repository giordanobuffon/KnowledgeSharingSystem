<%@page contentType="text/html" pageEncoding="UTF-8" %>

<head>
    <title>Faça uma pergunta</title>
    <%@include file="title.jsp" %>
    <div class="container">
        <%@ include file="cabecalho.jsp" %>


        <div id="dForm">

            <form id="pForm">

                <h1 class="hForm">Faça uma pergunta</h1><br>

                <p id="pTitulo">
                    <label for="textId">Título:</label><br>
                    <input type="text" id="textId" placeholder="Como declarar uma variável?" required="required"
                           name="titulo"/>
                </p><br>

                <p class="pDescricao">
                    <label for="descricaoId">Descrição:</label><br>
                    <textarea id="descricaoId" placeholder="Descreva sua pergunta..." name="descricao" rows="7" cols="100"></textarea>
                    <br>
                </p><br>

                <p class="submit">
                    <input type="submit" value="Perguntar"/>
                </p>

            </form>

        </div>


        <%@ include file="rodape.jsp" %>
    </div>
    </body>
    </html>
