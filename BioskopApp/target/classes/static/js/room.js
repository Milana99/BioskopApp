function cinema(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/bioskop");
}
function schedule(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/projekcije");
}

function addRoom(bioskop_id){

	var id=sessionStorage.getItem("id");
    let kapacitet=document.getElementById("kapacitet").value;
    let oznaka=document.getElementById("oznaka").value;
    var formData = JSON.stringify({
        "oznaka_sale": oznaka,
        "kapacitet": kapacitet,
        "bioskop_id":bioskop_id
    });
    $.ajax({
        url: '/add-sala',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/bioskop");
			}
		  }
    });
    
}
function deleteRoom(sala_id,bioskop_id){

	var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/delete_sala/'+bioskop_id+'/sala/'+sala_id,
        dataType: 'json',
        type: 'delete',
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/bioskop");
			}
		  }
    });
    
}
function editRoom(sala_id){

	var id=sessionStorage.getItem("id");
    let kapacitet=document.getElementById("kapacitet").value;
    let oznaka=document.getElementById("oznaka").value;
    var formData = JSON.stringify({
        "id":sala_id,
        "oznaka_sale": oznaka,
        "kapacitet": kapacitet,
    });
    $.ajax({
        url: '/edit-sala',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/bioskop");
			}
		  }
    });
    
}
function edit(sala_id){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/bioskop/sala/"+sala_id);
}