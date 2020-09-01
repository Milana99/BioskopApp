function login() {
	
    let username = document.getElementById('username').value;
    let lozinka = document.getElementById('lozinka').value;
    
    
    var formData = JSON.stringify({
        "k_ime": username,
        "lozinka": lozinka
    });
    
    console.log(formData);
    $.ajax({
        url: '/login',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("uloga",data["uloga"]);

            window.location.replace("/account/" + data["id"]);
        },
        
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Korisnik nije pronadjen!");
                return;
            } else if (jqXhr.status == 400) {
                alert("Pogresna lozinka!");
                return;
            } else if (jqXhr.status == 406) {
            	alert("Server error");
            	return;
            }
            alert("error")
        }
    });
}

function logOut() {
	sessionStorage.clear();
	window.location.replace("/");
}

function profile(){
	var id = sessionStorage.getItem("id");
	window.location.replace("/account/" + id);
}

function watched_movies(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/odgledani-filmovi");
}
function reservations(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/rezervacije");
}

function register() {
    let email = document.getElementById('email').value;
    let ime = document.getElementById('ime').value;
    let prezime = document.getElementById('prezime').value;
    let telefon = document.getElementById('telefon').value;
    let loznika = document.getElementById('lozinka').value;
    let lozinka1 = document.getElementById('lozinka1').value;
    let username = document.getElementById('username').value;
    let datum_rodjenja =document.getElementById('datum_rodjenja').value;
    
    if(lozinka1!=lozinka){
    	alert("Passwords do not match!");
    	return;
    }
    else{
    var formData = JSON.stringify({
    	"username":username,
    	"lozinka":lozinka,
    	"ime": ime,
    	"prezime":prezime,
    	"telefon":telefon,
        "email": email,
        "datum_rodjenja":datum_rodjenja,
        "uloga":0,
        "aktivan":false
    });
    console.log(formData);
    $.ajax({
        url: '/registrovan-korisnik',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
        	console.log("success");
        	sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("uloga",data["uloga"]);
            window.location.replace("/account/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
                }
        }
    });
    }
}