<%-- 
    Document   : cadastro
    Created on : 04/11/2015, 17:50:22
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Cadastro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <h1>Cadastro de Usuário</h1>
        <form action="usuarios/adicionar" method="POST">
            <div>Nome:<input type ="text" name="nome">
            </div>
            
            <div>Email:<input type ="email" name="email">
            </div>
            
            <div><input type="submit" value="Enviar">
            </div>
                
        </form>
    
    </body>
</html>
