
function filterData(filmoviDTO)
{
	var naziv=document.getElementById("naziv").value;
	var zanr=document.getElementById("zanr").value;
	var vreme=document.getElementById("trajanje_min").value;
	var ocena=document.getElementById("ocena").value;
	var opis=document.getElementById("opis").value;
	var cena=document.getElementById("cena").value;
	var filter=[];
	var filmovi=filmoviDTO.filmovi;
	for(let i=0;i<filmovi.length;i++)
	{
		document.getElementById(filmovi[i].id).style.display="";
	}
	if(naziv!="")
		filter["naziv"]=naziv;
		
	if(opis!="")
		filter["opis"]=opis;
		

	if(zanr!="")
		filter["zanr"]=zanr;
		
		
	if(trajanje_min!="")
		filter["trajanje_min"]=trajanje_min;
		
		
	if(cena!="")
		filter["cena"]=cena;
		
		
	if(ocena!="")
		filter["prosecna_ocena"]=ocena;;
	for (const [key, value] of Object.entries(filter)) {
		filterOne(filmovi,key,value);
	}
}

function filterOne(filmovi,key,value)
{
	for(let i=0;i<filmovi.length;i++)
	{
		finalFilter(filmovi[i],key,value);
	}
}

function finalFilter(film,key,value)
{
	if(document.getElementById(film.id).style.display=="none")
	{
		return;
	}
	let flag=false;
	if(key=="cena"){
		for(let i=0;i<film.lista_projekcija.length;i++){
			if(parseInt(value)>=film.lista_projekcija[i].price)
				flag=true;
		}
	}
	else if(key=="trajanje_min"){
		let help=value.split(":");
		for(let i=0;i<film.lista_projekcija.length;i++)
		{
			let arr=film.lista_projekcija[i].time.split(":");
			if(parseInt(help[0])>=parseInt(arr[0]))
			{
				if(parseInt(help[1])>=parseInt(arr[1]))
					flag=true;	
			}	
		}
	}
	else if(key=="ocena"){
		if(parseFloat(value)<=parseFloat(movie.rating))
			flag=true;
	}else if(key=="naziv"){
		if(movie.name.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="opis"){
		if(movie.description.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="zanr"){
		if(value!="zanr")
		{
			if(film.zanr==value)
				flag=true;
		}
		else
			flag=true;
	}
	
	if(flag){
		document.getElementById(film.id).style.display="";
	}
	else{
		document.getElementById(film.id).style.display="none";
	}
	
	
}

function getMovie(id) {
    $.ajax({
        url: '/film/'+id,
        type: 'get',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/film/"+id);
        },
        error: function(){
            	alert("Server error");
            	return;
        }
    });
}


$(document).ready(function(){
	$.ajax({
		type: "GET",
		url: '/filmovi'
		dataType: "json",
		success: function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row = "<tr>";
				
				row+="<td>" + data[i]['naziv']+"</td>";
				row+="<td>" + data[i]['zanr']+"</td>";
				row+="<td>" + data[i]['opis']+"</td>";
				row+="<td>" + data[i]['ocena']+"</td>";
				row+="<td>" + data[i]['trajanje_min']+"</td>";
				
				$('#tabela').append(row);
			}
		},
		error:function(data){
			console.log("ERROR:", data)
		}
			
	});
}
