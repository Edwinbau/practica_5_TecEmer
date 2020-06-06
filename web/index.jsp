<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{text-align: center;}
            td{border: px solid #ddd;text-align: left;}
            th{border: px solid #ddd;text-align: center;border: 1px solid black;}
            table{border-collapse: collapse;width: 60%;}             
            th, td{padding: 9px;}
        </style>
    </head>
    <body>
        <h1>Productos</h1>
        <div style="text-align: center;">            
            <table style="margin: 0 auto;">                
                <tr>
                    <td><a href="inicio?action=add">Nuevo producto</a></td>
                </tr>
            </table>
            <table style="margin: 0 auto;">
                <tr>
                    <th>Id</th>
                    <th>Descripcion</th>
                    <th>Stock</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${proveedores}">
                    <tr>
                        <td style="border: 1px solid black;">${item.id}</td>
                        <td style="border: 1px solid black;">${item.descrip}</td>
                        <td style="border: 1px solid black;">${item.stock}</td>
                        <td style="border: 1px solid black;"><a href="inicio?action=edit&id=${item.id}">Editar</a></td>
                        <td style="border: 1px solid black;"><a href="inicio?action=delete&id=${item.id}" onclick="return (confirm('Esta seguro'))">Eliminar</a></td>
                    </tr>
                </c:forEach>       
            </table>
        </div>
    </body>
</html>
