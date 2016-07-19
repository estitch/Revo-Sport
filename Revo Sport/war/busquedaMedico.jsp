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
    background: rgba(238, 238, 234, 0.5);
    padding: 10px 10px;
    width: 60%;
}
</style>
<script src="/jquery-1.12.4.min.js"> 
</script>
<script> 
 
$(document).ready(function() { 
$('#submit').click(function(event) { 
var dniVar = $('#dni').val();
var buscarVar = $('#action').val();
// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get 
$.post('buscarMedico', { 

dni: dniVar,
action:buscarVar 
 
}, function(responseText) { 
$('#tabla').html(responseText); 
}); 
}); 
}); 
</script> 
</head>
    
<body>

<!--menu-->
<img class="fondo" src="imagenes/buscar.jpg" height="100%" width="100%">
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

        <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br><br>
      
        
    <center>
        <div class="caja">
            <h2>Buscar Medico</h2>
            <hr>
            <form  method="post">

                <fieldset>
                    <legend>1) POR DNI</legend>
                    <table>
                        <tr>
                            <td>Ingrese numero de DNI:</td>
                            <td><input type="text" name="dni" id="dni" maxlength="8"
                                pattern="[0-9]{8}" title="Ingrese solo numeros">
                            <input type="hidden" id="action" name="action" value="buscarDNI" />
                            <input type="button" id="submit" value="buscarDNI"></td>
                        </tr>
                    </table>
                </fieldset>

                <br> <br>

            </form>
        </div>
        <br> <br>
 <div id="tabla"></div> 
        
        <br>
        <br>

</body>
</html>