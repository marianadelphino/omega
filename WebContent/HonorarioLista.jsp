<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Honorários Cadastrados</title>
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


<c:if test="${not empty msg2}">
<div class="alert alert-danger fade in">
<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
<center>${msg2}</center>
</div>
</c:if>

<h3>Lista de Honorários Cadastrados</h3>

<form class="form-inline" action="HonorarioServlet" method="get">
<input type="hidden" value="listarPorProcesso" name="acao"/>
<label for="processo">Filtrar por</label>
<input type="text" name="Nprocesso" class="form-control" id="idProcesso" placeholder="Número do Processo" onblur="validarNome()">
<input type="submit" value="Filtrar" class="btn btn-success"/>
</form>
<BR><BR>


<table class="table table-striped">

<thead>
<tr>
<th># Lançamento</th>
<th># Processo</th>
<th>Descrição</th>
<th>Tipo</th>
<th>Horas</th>
<th>Opções</th>
</tr>
</thead>


<tbody>
<c:forEach items="${lista}" var="honorario">
<tr>
<td>${honorario.cd_lancamento}</td>
<td>${honorario.processo.nr_processo}</td>
<td>${honorario.processo.ds_processo}</td>
<td>${honorario.tipoTarefa.ds_tipo_tarefa}</td>
<td>${honorario.qt_hora}</td>

<td>
<c:url value="HonorarioServlet" var="link4">
<c:param name="acao" value="exibir"/>
<c:param name="cdLancamentoE" value="${honorario.cd_lancamento}"/>
</c:url>
<a href="${link4}" class="btn btn-info" name="botao">Editar</a>



<c:url value="HonorarioServlet" var="link2">
<c:param name="acao" value="remover"/>
<c:param name="cdLancamento" value="${honorario.cd_lancamento}"/>
</c:url>
<a href="${link2}" class="btn btn-danger" name="botao">Excluir</a>
</td>

</tr>
</c:forEach>
</tbody>
</table>


</div>


<%@ include file="footer.jsp" %>
</body>
</html>