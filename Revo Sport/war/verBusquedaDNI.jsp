<%@page import="unsa.*" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="beans.*" %>
<% List<Admi> admis = (List<Admi>)request.getAttribute("admi");%>
<%
TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
SimpleDateFormat sdf = new SimpleDateFormat();
%>

<!DOCTYPE html >

<html>
    <head>
        <title>REVO SPORT</title>
<meta charset="UTF-8">
<meta charset="viewport"
	content="width=devise-width, user-scalable=no, initial-scale=1,maximum-scale=1, minimum-scale=1">
<link rel="stylesheet" type="text/css" href="estilos/crear.css">
<style type="text/css">
.caja {
	background: rgba(238, 238, 234, 0.5);
	padding: 10px 10px;
	width: 80%;
}
</style>

    </head>
    
<body>
       
<center>
        <div class="caja">
                <li class="cliente">
                    <h2>LISTA DEL ADMINISTRADOR POR DNI</h2>
                </li>
                <hr>
            <table id="t01" class= "table">
                <tr>
                    <th>Nro:</th>
                    <th>Apellidos y nombres</th>
                    <th>DNI</th>
                    <th>Direccion</th>
                    <th>Celular</th>
                    <th>Email</th>
                    <th>Fecha de registro</th>
                </tr>
            
                <%for (int i = 0; i < admis.size(); i++) {
                    Admi admi = (Admi)admis.get(i);%>
                <tr>
                    <td><%= admi.getId() %></td>
                    <td><%= admi.getApellidop() %> <%= admi.getApellidom() %>, <%= admi.getNombre() %></td>
                    <td><%= admi.getDni() %></td>
                    <td><%= admi.getDireccion() %></td>
                    <td><%= admi.getTelefono() %></td>
                    <td><%= admi.getEmail() %></td>
                    <td><%= sdf.format(admi.getFecha()) %></td>
                </tr>
            <%}%>
            
        </table>
        </div>
                <br> <br>

</body>
</html>






