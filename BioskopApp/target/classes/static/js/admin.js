function managers(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/menadzeri");
}
function createManager(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/registruj-men");
}

function deleteManager(menadzer_id){
    let id=sessionStorage.getItem("id");
    $.ajax({
        url: '/ukloni-menadzera/'+menadzer_id,
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/account/"+id+"/menadzeri");
        },
        error: function(){
            window.location.replace("/account/"+id+"/menadzeri");
        }
    });
}

function registerManager() {
    let email = document.getElementById("email").value;
    let ime = document.getElementById('ime').value;
    let prezime = document.getElementById('prezime').value;
    let telefon = document.getElementById('telefon').value;
    let lozinka = document.getElementById('lozinka').value;
    let lozinka1 = document.getElementById('lozinka1').value;
    let username = document.getElementById('username').value;
    let datum_rodjenja=document.getElementById('datum_rodjenja').value;
    let bioskop=document.getElementById('bioskop').value;
    let id=sessionStorage.getItem("id");
    if(lozinka1==lozinka){
        var formData = JSON.stringify({
        	"username":username,
        	"lozinka":lozinka,
        	"ime": ime,
        	"prezime":prezime,
        	"telefon":telefon,
            "email": email,
            "datum_rodjenja":datum_rodjenja,
            "uloga":0,
            "aktivan":true,
            "bioskop_id":bioskop
        });
        $.ajax({
            url: '/reg-menadzer',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: formData,
            success: function(data){
                window.location.replace("/account/"+id+"/menadzeri");
            },
            error: function( jqXhr, textStatus, errorThrown ){
                window.location.replace("/account/"+id+"/menadzeri");
            }
        });
    }else{
        alert("Passwords do not match!");
    }
}
