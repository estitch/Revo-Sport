<%@page import="java.util.*"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="beans.*" %>
<%
    TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
    SimpleDateFormat sdf = new SimpleDateFormat();
    String date = sdf.format(new Date());
%>
<% List<Disciplina> disciplinas = (List<Disciplina>)request.getAttribute("disciplinas");%>


<!DOCTYPE html >

<html>
    <head>
       <title>REVO SPORT</title>
<meta charset="UTF-8">
<meta charset="viewport"
	content="width=devise-width, user-scalable=no, initial-scale=1,maximum-scale=1, minimum-scale=1">
<link rel="stylesheet" type="text/css" href="estilos/crear.css">
<link rel="stylesheet" type="text/css" href="estilos/estilosportada.css">
<link rel="stylesheet" type="text/css" href="estilos/menu.css">
<style type="text/css">
.caja {
	background: rgba(238, 238, 234, 0.9);
	padding: 10px 10px;
	width: 50%;
}
</style>

    </head>
    
<body>

<!--menu-->
      <header>
		<nav class="menu">
			<ul>

				<li><a>CREAR USUARIOS</a>
					<ul>
						<li><a href="registrarAdmi?action=red" class="design-name">CREAR
								ADMINISTRADOR</a></li>
						<li><a href="registrarSecretaria?action=red"
							class="design-name">CREAR RECEPCIONISTA</a></li>
						<li><a href="nuevoMedico?action=red" class="design-name">CREAR
								MEDICO </a></li>
						<li><a href="registrarTrainer?action=red" class="design-name">CREAR
								TRAINER</a></li>
						<li><a href="registrarCliente?action=red" class="design-name">CREAR
								CLIENTE</a></li>
						<li><a href="nuevaDisciplina?action=red" class="design-name">CREAR
								DISCIPLINA</a></li>
					</ul></li>
				<li><a>VER USUARIOS</a>
					<ul>
						<li><a href="registrarAdmi?action=show" class="design-name">VER
								ADMINISTRADOR</a></li>
						<li><a href="registrarSecretaria?action=show"
							class="design-name">VER RECEPCIONISTA</a></li>
						<li><a href="nuevoMedico?action=show" class="design-name">VER
								MEDICO</a></li>
						<li><a href="registrarTrainer?action=show"
							class="design-name">VER TRAINER</a></li>
						<li><a href="registrarCliente?action=show"
							class="design-name">VER CLIENTE</a></li>
						<li><a href="nuevaDisciplina?action=show" class="design-name">VER
								DISCIPLINA</a></li>
					</ul></li>

				<li><a>ELIMINAR USUARIOS</a>
					<ul>
						<li><a href="registrarAdmi?action=borrar" class="design-name">ELIMINAR
								ADMINISTRADOR</a></li>
						<li><a href="registrarSecretaria?action=borrar"
							class="design-name">ELIMINAR RECEPCIONISTA</a></li>
						<li><a href="nuevoMedico?action=borrar" class="design-name">ELIMINAR
								MEDICO</a></li>
						<li><a href="registrarTrainer?action=borrar"
							class="design-name">ELIMINAR TRAINER</a></li>
						<li><a href="registrarCliente?action=borrar"
							class="design-name">ELIMINAR CLIENTE</a></li>
						<li><a href="nuevaDisciplina?action=borrar"
							class="design-name">ELIMINAR DISCIPLINA</a></li>
					</ul></li>
				<li><a>BUSCAR USUARIOS</a>
					<ul>
						<li><a href="busquedaAdministrador.jsp" class="design-name">BUSCAR
								ADMINISTRADOR</a></li>
						<li><a href="busquedaSecretaria.jsp" class="design-name">BUSCAR
								RECEPCIONISTA</a></li>
						<li><a href="busquedaMedico.jsp" class="design-name">BUSCAR
								MEDICO </a></li>
						<li><a href="registrarTrainer?action=buscar"
							class="design-name">BUSCAR TRAINER</a></li>
						<li><a href="busquedaCliente.jsp" class="design-name">BUSCAR
								CLIENTE</a></li>
						<li><a href="busquedaDisciplina.jsp" class="design-name">BUSCAR
								DISCIPLINA</a></li>
					</ul></li>
                     <li>
                        <a href="registrarVisitante.html" class="design-name">REGISTRAR VISITANTE</a>
                    </li>

			</ul>

		</nav>


	</header>
<!-- logo del menu-->

<!---inicio sesion-->

<div class="sesion">
    <a href="/cerrar">CERRAR SESION</a>

</div>

<img class="fondo" src="imagenes/fondocrear.jpg">
<!-- fin de sesion-->

        <div class="revo1">
            REVO
        </div>

        <div class="hombre1">
            <img src="imagenes/hombre.png"  width="40" height="40">
        </div>

        <div class="sport1"> SPORT
        </div>
<!-- fin de logo del menu-->

<!-- video : fondo de pantalla-->
        <!-- <video src="" autoplay loop muted poster="imagendeespera.jpg"></video>-->

        <br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="trans">
		<section class="intro" id="zen-intro">
			<div class="summary" id="zen-summary" role="article">
				<p>Recuerde llenar los campos obligatorios(*) antes de enviar el
					formulario</p>
			</div>

		</section>
	</div>

        <center>
        <div class="caja">
            <form class="contact_form" action="nuevoMedico" method=get>
                <li class="cliente">
                    <h2>REGISTRO PARA CREAR UN NUEVO MEDICO</h2>
                </li>
                <div id='izquierda'>
                    <ul>


                        <li><label >nombre*</label> <input
                            type="text" name="nombre" required  id="codigo" placeholder="Jose"></li>
                        <li><label >Apellido Paterno*</label> <input
                            type="text" name="apellidoP" required pattern="([a-zA-Z�����]+[\s]*[a-zA-Z�����]*)" title="Ingrese solo letras" id="pat" placeholder="Perez"></li>

                        <li><label >Apellido Materno*</label> <input
                            type="text" name="apellidoM" required pattern="([a-zA-Z�����]+[\s]*[a-zA-Z�����]*)" title="Ingrese solo letras" id="mat" placeholder="Aguilar"></li>

                        <li><label >DNI*</label> <input 
                        type="text" name="documento" maxlength="8" required pattern="[0-9]{8}" title="Ingrese solo numeros" id="dni" placeholder="12345678"></li>

                        <li><label>Fecha Nacimiento*</label> 
                            dia: <input  type='number' min="1" max="31" placeholder="dd" required title="Ingrese solo numeros" class='fecha' name='dia' id='dia' /> 
                            mes: <input type='number' min="1" max="12" placeholder="mm" required title="Ingrese solo numeros" class='fecha' name='mes' id='mes' /> 
                            anio: <input type='number' min="1900" max="2016" placeholder="aaaa" required title="Ingrese solo numeros" class="fecha" name='anio' id='alo' />
                        </li>
                        
                        <li><label for="especialidad">Especialidad*</label> 
                        <select required name= "especialidad">
                                <option>              </option>
                                <%for (int i = 0; i < disciplinas.size(); i++) {
                                    Disciplina disciplina = (Disciplina)disciplinas.get(i);%>
                                <option value="<%=disciplina.getNombre() %>"><%=disciplina.getNombre() %></option>
                                <%}%>
                        </select></li>
                    </ul>
                </div>
                
                <div id='derecha'>
                    <ul>
                        <li><label>Sexo*:</label>
                        Femenino <input type="radio" class="anio" required name='sexo' value='femenino' id='dia' /> 
                        Masculino <input type='radio' class="anio" name='sexo' value='masculino' id='dia' />
                        </li>

                        <br>
                        <br>
                        <li><label for="codigo">Direccion</label> <input type="text"
                            name="direccion" id="codigo"></li>
                        <li>Distrito<input type='text' class="anio" name='distrito' id='dia' /> 
                            Provincia<input type='text' class="anio" name='provincia' id='mes' /> 
                            Departamento <input type='text' class="anio" name='departamento' id='alo' /></li>
                        </li>

                        <li><label>numero celular:</label> <input type="text"
                            class="numero" name="celular" id="nombre"></li>
                        <li><label>Telefono Fijo:</label> <input type="text"
                            class="numero" name="telefono" id="nombre"></li>

                        <li><label for="codigo">Correo Electronico*</label> <input type="text"
                            name=email placeholder="ejemplo@ejemplo.com" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Ingrese un email correcto" id="dni" ></li>
                        <li><label for="codigo">Fecha de creacion:</label>
                            <input readonly type="text" name="fecha" value="<%=date%>" /></li>  
                    </ul>
                </div>

                <br><br>
                <input type="reset" value="Cancelar">
                <input type="hidden" name="action" value="create" />
                <input type="submit" id="boton1" value="ENVIAR">

            </form>

        </div>
        <br>
        <br>

		<br>

</body>
</html>
