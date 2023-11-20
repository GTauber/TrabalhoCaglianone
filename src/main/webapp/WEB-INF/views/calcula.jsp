<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculadora</title>
</head>
<body>
    <h2>Calculadora</h2>
    <form action="/Calcule" method="post">
        Valor 1: <input type="text" name="valor1" /> <br/>
        Valor 2: <input type="text" name="valor2" /> <br/>
        Operação:
        <select name="operacao">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <br/>
        <input type="submit" value="Calcular" />
    </form>
    <a>${resultado}</a>
    <%
        String erro1 = (String) request.getAttribute("erroValor1");
        String erro2 = (String) request.getAttribute("erroValor2");
        String erroDiv = (String) request.getAttribute("erroDivisao");
        String resultado = (String) request.getAttribute("resultado");

        if (erro1 != null) out.println("<p>" + erro1 + "</p>");
        if (erro2 != null) out.println("<p>" + erro2 + "</p>");
        if (erroDiv != null) out.println("<p>" + erroDiv + "</p>");
        if (resultado != null) out.println("<p>Resultado: " + resultado + "</p>");
    %>
</body>
</html>
