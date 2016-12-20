<!-- el tag es una 'variable' que en este caso guarda valores (de tipo lista)
y lo que contiene esta variable se usa para pintar una tabla en la apgina HTML (con el modelo MVC)-->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/sjtl/core" %> <!-- dependencias -->
<%@attribute name="user" required="true" type="java.util.ArrayList" %> <!-- si no se especifica el type hace de tipo String -->

<table>
    <tr>
        <th>HOST</th>
        <th>USER</th>
    </tr>

     <!-- s'ha d'autogenerar sa resta de ses cel·les amb l'array list on esta guardat s'informacio de sa resposta
     de sa connexio a sa base de dades -->





</table>