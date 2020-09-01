/**
 * 
 */
function registracija(){
	let ime = document.getElementById('ime').value;
	let prezime = document.getElementById('prezime').value;
	let username = document.getElementById('username').value;
	let lozinka = document.getElementById('lozinka').value;
	let lozinka1 = document.getElementById('lozinka1').value;
	let telefon = document.getElementById('telefon').value;
	let datum_rodjenja = document.getElementById('datum_rodjenja').value;
	let email = document.getElementById('email').value;
	
	if(lozinka1!=lozinka){
		alert("Lozinke se ne poklapaju");
		return;
	}
	else{
		var forData = JSON.stringify({
			"ime": ime, 
			"prezime": prezime,
			"username": username, 
			"lozinka": lozinka, 
			"telefon": telefon, 
			"datum_rodjenja": datum_rodjenja, 
			"email": email, 
			"uloga": 0,
			"aktivan", false
		}); 
		console.log(formData); 
		$.ajax({
			url: '/reg-korisnik',
			dataType: 'json',
			type: 'post',
			contentType: 'application/json', 
			data: formData, 
			success: function(data){
				console.log("success"); 
				sessionStorage.setItem("id", data["id"]); 
				sessionStorage.setItem("role", data["role"]); 
				window.location.replace("/account/" + data["id"]);
			}, 
			error: function(jqXhr, textStatus, errorThrown){
				if(jqXhr.status == 409){
					alert("Something went wrong!");
					return;
				}
			}
		});
	}
}