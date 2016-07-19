<% 
String dni = (String)request.getAttribute("dni");
%>
<!DOCTYPE html >

<html>
    <head>
         <title> REVO SPORT </title>
        <meta charset="UTF-8">
        <meta charset="viewport" content="width=devise-width, user-scalable=no, initial-scale=1,maximum-scale=1, minimum-scale=1">
        <link rel="stylesheet" type="text/css" href="estilos/crear.css">
        <link rel="stylesheet" type="text/css" href="estilos/estilosportada.css">
         <link rel="stylesheet" type="text/css" href="estilos/menu.css">
<style type="text/css">
.caja{
    background: rgba(238,238,234,0.9);
    padding: 10px 10px;
    width: 50%;
    
}
</style>
          

    </head>
    
<body>
        <br>
        <center><div class="caja">
            <h2>Visitante <%= dni %> registrado correctamente</h2>
        </div>
        </center>
        <br>
        <br>

</body>
</html>
