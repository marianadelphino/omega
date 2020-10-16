<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edição de Despesa</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="logo.jsp" %>
<%@ include file="menu.jsp" %>
<div class="container">
<h3>Edição de Despesa</h3>
<c:if test="${not empty erro }">
<div class="alert alert-danger">
${erro}
</div>
</c:if>

<form action="DespesaServlet" method="post">
<input type="hidden" name="acao" value="editar">

<div class="row">
<div class="form-group col-md-4">
<label for="idDespesa">Despesa</label>

<select disabled id="idDespesa" name="tipodespesa" class="form-control">
<option>Selecione</option>
<c:forEach items="${tipodespesa}" var="tipodespesa">
<option value="${tipodespesa.cd_tipo_despesa}">${tipodespesa.ds_tipo_despesa}</option>
</c:forEach>
</select>
</div>
</div>


<div class="row">
<div class="form-group col-md-4">
<label for="idData">Número do Processo</label>
<input type="text" name="Nnrprocesso" class="form-control" id="idProcesso" placeholder="Número do Processo" onblur="validarProcesso()" disabled>
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
<label for="idValor">Valor</label>
<input type="text" name="Nvalor" class="form-control" id="idValor" placeholder="Valor">
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