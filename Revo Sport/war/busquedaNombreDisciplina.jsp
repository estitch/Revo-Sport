<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="beans.*" %>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%> 
<% 
List<Disciplina> disciplinas = (List<Disciplina>)request.getAttribute("disciplinas");
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
                <li class="title">
                    <h2>LISTA DE TODAS LAS DISCIPLINAS</h2>
                </li>
            <table id="t01" class= "table">
            <tr>
                <th>N�</th>
                <th>nombres</th>
                <th>dia</th>
                <th>hora</th>
                <th>Fecha de registro</th>
            </tr>
            
                <%for (int i = 0; i < disciplinas.size(); i++) {
                    Disciplina disciplina = (Disciplina)disciplinas.get(i);%>
            <tr>
                <td><%= disciplina.getId() %></td>
                <td><%= disciplina.getNombre() %></td>
                <td><%= disciplina.getDia() %></td>
                <td><%= disciplina.getHora() %></td>
                <td><%= sdf.format(disciplina.getFecha()) %></td>
            </tr>
        <%}%>
            
        </table>
        </div>
</body>
</html>

