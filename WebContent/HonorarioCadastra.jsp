<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lançamento de Honorário</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="logo.jsp" %>
<%@ include file="menu.jsp" %>
<div class="container">
<h3>Lançamento de Honorário</h3>
<c:if test="${not empty erro }">
<div class="alert alert-danger">
${erro}
</div>
</c:if>

<form action="HonorarioServlet" method="post">
<input type="hidden" name="acao" value="cadastrar">

<div class="row">
<div class="form-group col-md-4">
<label for="idHonorario">Honorário</label>

<select id="idHonorario" name="tipotarefa" class="form-control">
<option>Selecione</option>
<c:forEach items="${tipotarefa}" var="tipotarefa">
<option value="${tipotarefa.cd_tipo_tarefa}">${tipotarefa.ds_tipo_tarefa}</option>
</c:forEach>
</select>
</div>
</div>


<div class="row">
<div class="form-group col-md-4">
<label for="idData">Número do Processo</label>
<input type="text" name="Nnrprocesso" class="form-control" id="idProcesso" placeholder="Número do Processo">
<span class="erro" id="erroProcesso"></span>
</div>
</div>


<div class="row">
<div class="form-group col-md-4">
<label for="idData">Data</label>
<input type="text" name="Ndata" class="form-control" id="idData" placeholder="Data">
</div>
</div>

<div class="row">
<div class="form-group col-md-4">
<label for="idHora">Quantiadade de Horas</label>
<input type="text" name="Nhora" class="form-control" id="idHora" placeholder="Hora">
</div>
</div>


<div class="row">
<div class="form-group col-md-4">
<label for="idObservacoes">Observações</label>
<textarea type="text" class="form-control" rows="5" id="idObservacao" name="Nobservacao"></textarea>
</div>
</div>


<div class="row">
<div class="form-group">
<input type="submit" value="Salvar" class="btn btn-success" name="botao">
</div>
</div>
</form>
</div> 



<%@ include file="footer.jsp" %>
</body>
</html>