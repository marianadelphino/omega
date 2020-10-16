<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page errorPage="erro.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Processo</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="logo.jsp" %>
<%@ include file="menu.jsp" %>
<div class="container">
<h3>Cadastro de Processo</h3>
<c:if test="${not empty erro }">
<div class="alert alert-danger">
${erro }
</div>
</c:if>

<form action="ForumServlet" method="post">
<input type="hidden" name="acao" value="cadastrar">
<div class="row">
<div class="form-group col-md-6">
<label for="nome">Nome</label>
<input type="text" name="Nnome" class="form-control" id="idNome" placeholder="Nome do Fórum" onblur="validarNome()">
<span class="erro" id="erroNome"></span>
</div>

<div class="form-group col-md-6">
<label for="idDescricao">Descricção</label>
<input type="text" name="Ndescricao" class="form-control" id="idDescricao" placeholder="Descrição">
</div>
</div>


<div class="row">
<div class="form-group">
<input type="submit" value="Salvar" class="btn btn-success" name="botao">
</div>
</div>
</div> 
</form>

<%@ include file="footer.jsp" %>
</body>
</html>