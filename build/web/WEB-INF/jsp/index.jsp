<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8"/>
        <link rel="icon" href="<c:url value="/img/01.ico"/>" >

        <title>Index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        
    </head>


    <body>
    <nav class="navbar navbar-expand-md navbar-light bg-light border-4 border-bottom border-info">
        <div class="container-fluid">
            <a href="#" class="navbar-brand">Campus El Informático</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#menunav">
                <span class="navbar-toggler-icon"></span>
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
    <div class="container-fluid">
        <br>
        <div class="container">
            <div class="row">
              
                <h1 class="text-info"> Ejercicio JDBC Template</h1>
                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success">
                        <ion-icon name="create-sharp"></ion-icon>
                        Agregar</a> 

                </p>

                <table class="table table-bordered table-hover table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>E-mail</th>
                            <th>Teléfono</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.nombre}"/></td>
                                <td><c:out value="${dato.correo}"/></td>
                                <td><c:out value="${dato.telefono}"/></td>
                                <td>
                                    <a href="<c:url value="del.htm?id=${dato.id}"/>" class="btn btn-danger">
                                        <ion-icon <ion-icon name="trash"></ion-icon></ion-icon></a>
                                    <a href="<c:url value="edit.htm?id=${dato.id}"/>" class="btn btn-warning">
                                        <ion-icon name="pencil"></ion-icon></a>
                                </td>
                            </tr> 
                        </c:forEach>  
                    </tbody>
                </table>

            </div>
        </div>

    </div>
</body>
</html>
