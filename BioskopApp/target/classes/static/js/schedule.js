function AddProjection(bioskop_id){
    var id=sessionStorage.getItem("id");
    let film=document.getElementById("film").value;
    let sala=document.getElementById("sala").value;
    let datum=document.getElementById("datum").value;
    let vreme=document.getElementById("vreme").value;
    let cena=document.getElementById("cena").value;
    var formData = JSON.stringify({
        "dan": datum,
        "vreme": vreme,
        "cena":cena,
        "film_id":film,
        "sala_id":sala,
        "bioskop_id":bioskop_id
    });
    $.ajax({
        url: '/add-projekcija',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/projekcije");
			}
		  }
    });
}