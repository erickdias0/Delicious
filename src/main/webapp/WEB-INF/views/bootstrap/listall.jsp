/* global json */

<%-- 
    Document   : listall
    Created on : 10/11/2015, 22:44:01
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Lista de Usuários</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified JavaScript -->
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/s/dt/dt-1.10.10/datatables.min.css"/>
 
        <script type="text/javascript" src="https://cdn.datatables.net/s/dt/dt-1.10.10/datatables.min.js"></script>
    </head>
    <body>
        <!--
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Endereço</th>
                        <th>CPF</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <td id="nome"></td>
                <td id="email"></td>
                <td id="endereco"></td>
                <td id="cpf"></td>
                <td id="ativo"></td>
                </tbody>
            </table>
                
        </div>
        
        
        <script>
        var url ="http://localhost:8090/mavenproject1/delicious/usuarios/listar.json"; 
    $.getJSON(url,function (json){
        var x;
        var l = json.length;
        console.log(json.length);
        for(x = 0;x < l;x++){
        console.log("Nome: ",json[x].nome);
        
        $('#nome').text(json[x].nome);
        $('#email').text(json[x].email);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        $('#endereco').text(json[x].endereco);
        $('#cpf').text(json[x].cpf);
        if(json[x].ativo==true)
            $('#ativo').text("Ativo");
        else
            $('#ativo').text("Inativo");
        }
        
            
    });
        
        </script>
        -->
        <div class="table-responsive">
            <table class="table table-bordered"id="example">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Endereço</th>
                        <th>CPF</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <td id=""></td>
                <td id="nome"></td>
                <td id="endereco"></td>
                <td id="senha"></td>
                <td id="ativo"></td>
                </tbody>
            </table>
            
        </div>
        <script>
            
         $('#example').dataTable( {
      
        columns:[
            {data: 'nome'},
            {data:'email'},
            {data:'endereco'},
            {data:'senha'},
            {data:'ativo'}
        ],
                
        
        "ajax": {
        "url": "http://localhost:8090/mavenproject1/delicious/usuarios/listar.json",
        "dataSrc": function(json){
            for(var x=0;x<json.length;x++){
                if(json[x].ativo==true)
                    json[x].ativo="Ativo";
                    else
                        json[x].ativo="Inativo";
                
            }
            return json;
    }
        
        }
} );

    </script>    
    </body>
</html>
