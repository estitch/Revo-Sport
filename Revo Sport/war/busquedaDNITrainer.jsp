<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="beans.*" %>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%> 
<% 
List<Trainer> trainer = (List<Trainer>)request.getAttribute("trainer");
%>
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
<link rel="stylesheet" type="text/css" href="estilos/estilosportada.css">
<style type="text/css">
.caja {
	background: rgba(238, 238, 234, 0.5);
	padding: 10px 10px;
	width: 60%;
}
</style>

    </head>
    
<body>


      
    <center>
                
        <div class="caja">
        <li class="cliente"><h2>Trainers encontrados por DNI</h2></li>
        <hr>
        <br>
        <table id="t01" class= "table">
        
            <tr>
                <th>Nombres y Apellidos</th>
                <th>DNI</th>
                <th>Direccion</th>
                <th>Celular</th>
                <th>Email</th>
                <th>Fecha de Registro</th>
            </tr>
            
            <%for (int i = 0; i < trainer.size(); i++) {
    Trainer h = (Trainer)trainer.get(i);%>
            
            <tr>
                <td><%= h.getApellidop()+" "+h.getApellidom()+" "+h.getNombre() %>  </td>
                <td><%= h.getdni() %></td>
                <td><%= h.getDireccion() %></td>
                <td><%= h.getTelefono() %></td>
                <td><%= h.getEmail() %></td>
                <td><%= sdf.format(h.getFecha()) %></td>
            </tr>
            <%}%>
            
        </table>

                <br> <br>
            

    
        <br>
        <br>

</body>
</html>

