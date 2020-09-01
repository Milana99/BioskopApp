function addCinema() {
    let email = document.getElementById('email').value;
    let ime = document.getElementById('ime').value;
    let telefon = document.getElementById('telefon').value;
    let adresa = document.getElementById('adresa').value;
    var formData = JSON.stringify({
        "naziv": naziv,
        "adresa": adresa,
        "broj_telefona_centrale":telefon,
        "email":email
    });
    console.log(formData);
    $.ajax({
        url: '/dodaj-bioskop,
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(){
        	console.log("success");
            window.location.replace("/bioskopi");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
                }
        }
    });
}
function deleteCinema(id) {

    $.ajax({
        url: '/bioskopi/'+id,
        type: 'delete',
        success: function(){
        	console.log("success");
            window.location.replace("/bioskopi");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
                }
        }
    });
}
function edit(bioskop_id){
    window.location.replace("/bioskop/"+bioskop_id);
}
function editCinema(bioskop_id){

    let naziv=document.getElementById("naziv").value;
    let adresa=document.getElementById("adresa").value;
    let broj_telefona_centrale=document.getElementById("broj_telefona_centrale").value;
    let email=document.getElementById("email").value;
    var formData = JSON.stringify({
        "id":biosko_id,
        "naziv": naziv,
        "adresa": adresa,
        "broj_telefona_centrale": broj_telefona_centrale,
        "email":email,
        "menadzeri":null,
        "sale":null,
        "projekcije":null        
    });
    $.ajax({
        url: '/edit-bioskop',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/bioskopi");
			}
		  }
    });
    
}

$(document).ready(function(){
	$.ajax({
		type: "GET",
		url: '/bioskopi'
		dataType: "json",
		success: function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row = "<tr>";
				
				row+="<td>" + data[i]['naziv']+"</td>";
				row+="<td>" + data[i]['adresa']+"</td>";
				row+="<td>" + data[i]['broj_telefona_centrale']+"</td>";
				row+="<td>" + data[i]['email']+"</td>";
				
				$('#tabela').append(row);
			}
		},
		error:function(data){
			console.log("ERROR:", data)
		}
			
	});
}