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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    </head>
    <body>
        <div class ="jumbotron">
		<div class="container">
		<h1>
                    
                    <img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xft1/v/t1.0-9/12003400_936932979713426_3567761451346119838_n.jpg?oh=380e68704e85621f3be3fd34410311d6&oe=56B596FA&__gda__=1454298480_f3fa51eefff386d822c81514d83013dd" 
                         alt = "Delicious" class="img-thumbnail img-responsive">
                </h1>
                    </div>
                    
		
                </div>
                    </div>
    <div class="container">
		<form action="usuarios/adicionar"method="POST">
		<fieldset>
		<legend>Dados pessoais</legend>
		<div class="form-group">
		<label for="nome">Nome Completo</label>
		<input type="text" class="form-control" id="nome"name="nome">
                <label for="endereco">Endereço</label>
		<input type="text" class="form-control" id="endereco"name="endereco">
                <label for="telefone">Telefone</label>
		<input type="text" class="form-control" id="telefone"name="telefone">
                <label for="cpf">CPF</label>
		<input type="text" class="form-control" id="cpf"name="cpf">
                <label for="email">Email</label>
		<input type="email" class="form-control" id="email"name="email">
                <label for="senha">Senha</label>
		<input type="text" class="form-control" id="senha"name="senha">
                </div>
		<button type="submit" class="btn btn-primary">
		<span class ="glyphicon glyphicon-thumbs-up">
		Confirmar Cadastro
		</button>
                </fieldset>        
                </form>
     </div>
    </div>
    </body>
</html>
