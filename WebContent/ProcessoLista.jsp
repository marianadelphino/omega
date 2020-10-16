<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Processos Cadastrados (Ativos)</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="logo.jsp" %>
<%@ include file="menu.jsp" %>



<div class="container">
<c:if test="${not empty msg}">
<div class="alert alert-success fade in">
<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
<center>${msg}</center>
</div>
</c:if>

<h3>Lista de Processos Cadastrados (Ativos)</h3>

<form class="form-inline" action="ProcessoServlet" method="get">
<input type="hidden" value="listarFiltro" name="acao"/>
<label for="processo">Filtrar por</label>
<h6>Se não souber o número do processo, digite zero.</h6>
<div class="row">
<h5>Número do processo</h5>
<input type="text" name="Nprocesso" class="form-control" id="idProcesso" placeholder="Número do Processo">
</div>

<div class="row">
<h5>Nome do cliente</h5>
<input type="text" name="Ncliente" class="form-control" id="idCliente" placeholder="Nome do Cliente">
</div>

<div class="row">
<h5>Período</h5>
<input type="text" name="Ninicial" class="form-control" id="idInicial" placeholder="Data Inicial">
<input type="text" name="Nfinal" class="form-control" id="idFinal" placeholder="Data Final">
<input type="submit" value="Filtrar" class="btn btn-success"/>
</div>
</form>
<BR><BR>



<table class="table table-striped">

<thead>
<tr>
<th># Número</th>
<th>Descrição</th>
<th>Razão Social</th>
<th>Listar</th>
</tr>
</thead>


<tbody>
<c:forEach items="${lista}" var="processo">
<tr>
<td>${processo.nr_processo}</td> 
<td>${processo.ds_processo}</td>
<td>${processo.cliente.ds_razao_social}<td>


<c:url value="DespesaServlet" var="link2">
<c:param name="acao" value="listarPorProcesso"/>
<c:param name="Nprocesso" value="${processo.nr_processo}"/>
</c:url>
<a href="${link2}" class="btn btn-info" name="botao">Despesas</a>



<c:url value="HonorarioServlet" var="link1">
<c:param name="acao" value="listarPorProcesso"/>
<c:param name="Nprocesso" value="${processo.nr_processo}"/>
</c:url>
<a href="${link1}" class="btn btn-info" name="botao">Honorários</a>

</td>

</tr>
</c:forEach>
</tbody>
</table>


</div>


<%@ include file="footer.jsp" %>
</body>
</html>