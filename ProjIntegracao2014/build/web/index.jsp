<%-- 
    Document   : index
    Created on : 07/06/2014, 16:25:36
    Author     : eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String pushStatus = "";
        Object pushStatusObj = request.getAttribute("pushStatus");

        if (pushStatusObj != null) {
            pushStatus = pushStatusObj.toString();
        }
    %>
    <link rel="stylesheet" href="style.css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto Integração 2014 - GCM Server</title>
    </head>
    <body>
        <h1>Google Cloud Messaging Server</h1>
        <form action="GCMNotification" method="post">

            <div>
                <textarea rows="2" name="mensagem" cols="23"
                          placeholder="Escreva a mensagem da notificação aqui..."></textarea>
            </div>
            <div>
                <input id="botao" type="submit" value="Enviar Notificação via GCM" />
            </div>
        </form>
        <div id="result">
            <h3>
                <%=pushStatus%>
            </h3>
        <div>
        <div id="copyright">
            Criado por Eric Kriger - 2014
        </div>
</body>
</html>
