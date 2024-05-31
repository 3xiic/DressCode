function get() {
	var url  = 'http://localhost:8081/parameters';
		var xhr  = new XMLHttpRequest()
		xhr.open('GET', url, true)
		xhr.onload = function () {
			var users = JSON.parse(xhr.responseText);
			if (xhr.readyState == 4 && xhr.status == '200') {
				console.table(users);
			} else {
				console.error(users);
			}
		}
		xhr.send(null);
}

function add(form) {
	var url = "http://localhost:8081/parameters/new";
	var data = {};
	data.nit = form.nit.value;
	data.type = form.tipo.value;
	data.name = form.nombre.value;
	data.city = form.ciudad.value;
	data.iva = form.iva.value;
	data.interest_rate = form.interes.value;
	data.bank = form.banco.value;
	data.account = form.numcuenta.value;
	data.manager_name = form.gerente.value;
	var json = JSON.stringify(data)

	console.log(data.nit);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", url, true);
	xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
	xhr.onload = function () {
		var users = xhr.responseText;
		if (xhr.readyState == 4 && xhr.status == "201") {
			console.log(users);
		} else {
			console.log(users);
		}
	}
	xhr.send(json);
}