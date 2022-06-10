<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Crear nuevo usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light border-4 border-bottom border-info">
            <div class="container-fluid">
                <a href="#" class="navbar-brand">Campus El Informático</a>
                <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#menunav">
                </button>
                <div id="menunav" class="collapse navbar-collapse">
                    <ul class="navbar-nav ms-3">
                        <li class="nav-item">
                            <a class="nav-link " href="<c:url value="#"/>">Home

                            </a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="<c:url value="#"/>">Index</a>                           
                        </li>
                    </ul>
                </div> 
            </div>
        </nav>
        <div class="container" >
            <br>
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value="/index.htm"/>">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Agregar</li>
                </ol>
            </nav>

            <div class="">
                <div class="card text-dark mb-3">
                    <div class="card-header">
                        Formulario
                    </div>
                    <div class="card-body">
                        <form:form method="post" commandName="usuarios">
                            <h3 class="text-info">Complete el Formulario</h3>
                            <form:errors path="*" element="div" class="alert alert-danger" role="alert"></form:errors>
                                <p>
                                <form:label path="nombre">Nombre : </form:label>
                                <form:input path="nombre" cssClass="form-control"></form:input>
                                </p>
                                <p>
                                <form:label path="correo">E-mail : </form:label>
                                <form:input path="correo" cssClass="form-control"></form:input>
                                </p>
                                <p>
                                <form:label path="telefono">Telefono : </form:label>
                                <form:input path="telefono" cssClass="form-control"></form:input>
                                </p>
                                <hr>
                                <input type="submit" value="Enviar" class="btn btn-outline-danger"/>
                        </form:form>
                    </div>
                </div>

            </div>


        </div>
    </body>
</html>
