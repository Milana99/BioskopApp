function init(){
	let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        
    } else {
        
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="none";
    }
}

function initAcc(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let gledalac=document.getElementsByClassName("gledalac");
    let admin=document.getElementsByClassName("admin");
    let menadzer=document.getElementsByClassName("menadzer");
    
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < gledalac.length; i++) {
            gledalac[i].style.display = "none";
        }
        for (let i = 0; i < admin.length; i++) {
            admin[i].style.display = "none";
        }
        for (let i = 0; i < menadzer.length; i++) {
            menadzer[i].style.display = "none";
        }
        alert("You have to be logged in to view your profile!");
        window.location.replace("/");
        
    } else {
        let uloga=sessionStorage.getItem("uloga");
        if (uloga == "GLEDALAC") {
    		for (let i = 0; i < gledalac.length; i++) {
                gledalac[i].style.display = "";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < menadzer.length; i++) {
                menadzer[i].style.display = "none";
            }
    	} else if(uloga=="ADMINISTRATOR"){
    		for (let i = 0; i < gledalac.length; i++) {
                gledalac[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "";
            }
            for (let i = 0; i < menadzer.length; i++) {
                menadzer[i].style.display = "none";
            }
        }else{
            for (let i = 0; i < gledalac.length; i++) {
                gledalac[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < menadzer.length; i++) {
                menadzer[i].style.display = "";
            }
        }

        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}

function initMovie(){

    let id = sessionStorage.getItem("id");
    let uloga = sessionStorage.getItem("uloga");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    
    if (id == null || uloga!="GLEDALAC") {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        alert("You have to be logged in as a viewer to be able to reserve a ticket!");
        window.location.replace("/");
    } else {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
function initMovies(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let gledalac=document.getElementsByClassName("gledalac");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < gledalac.length; i++) {
        	gledalac[i].style.display = "none";
        }
        
    } else {
        let uloga=sessionStorage.getItem("uloga");
        if (uloga == "GLEDALAC") {
            for (let i = 0; i < gledalac.length; i++) {
            	gledalac[i].style.display = "";
            }
            
    	} else {
            for (let i = 0; i < gledalac.length; i++) {
            	gledalac[i].style.display = "none";
            }

    	}
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}

function initCinema () {
	
    let id = sessionStorage.getItem("id");
    let uloga = sessionStorage.getItem("uloga");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let admin = document.getElementsByClassName("admin");
    
    if (id == null) {
    	for (let i = 0; i < admin.length; i++) {
    		admin[i].style.display = "none";
    	}
    	 for (let i = 0; i < online.length; i++) {
             online[i].style.display = "none";
         }
         offline.style.display="block";
    } else {
    	if (uloga == "ADMINISTRATOR") {
    		for (let i = 0; i < admin.length; i++) {
    			admin[i].style.display = "";
    		}
    	} else {
    		for (let i = 0; i < admin.length; i++) {
    			admin[i].style.display = "none";
    		}
    	}
    	 for (let i = 0; i < online.length; i++) {
             online[i].style.display = "none";
         }
         offline.style.display="none";
    }
}
