function validarNome(){
var validacao1 = new RegExp ("[a-z]+", "i"); 
var validacao2 = new RegExp ("[0-9]+"); 
var nomeValido = idNome.value;

if (!validacao1.test(nomeValido) || validacao2.test(nomeValido)){
document.getElementById("idNome").style.border = "1px solid #a94442";
erroNome.innerHTML = "Nome invalido!";}


else if(validacao1.test(nomeValido)){
document.getElementById("idNome").style.border = "";
erroNome.innerHTML = "";}}


function validarData(){
	var validacao = new RegExp("[0-9]{2}$\\/\\[0-9]{2}$\\/\\[0-9]{4}$")
	var dataValida = idData.value; 

	if ((!validacao.test(dataValida)) || isNaN(dataValida)){
		document.getElementById("idData").style.border = "1px solid #a94442";
		erroData.innerHTML = "Formato de data incorreto!";}

	else if (validacao.test(dataValida)){
		document.getElementById("idData").style.border = "";
		erroData.innerHTML = "";}}



function validarProcesso(){
	var validacao = new RegExp ("\\d+"); 
	var processoValido = idProcesso.value;

	if ((!validacao.test(processoValido)) || isNaN(processoValido)){
	document.getElementById("idProcesso").style.border = "1px solid #a94442";
	erroProcesso.innerHTML = "Numero de processo invalido!";}

	else if (validacao.test(processoValido)){
	document.getElementById("idProcesso").style.border = "";
	erroProcesso.innerHTML = "";}}


