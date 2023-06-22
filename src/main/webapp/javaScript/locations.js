function loadLocations(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/dashboard/locations", option)
        .then(response => response.json())
        .then(myJson => {
            const listHtml = document.querySelector("#list");
            myJson.forEach(location => {
                console.log(location)
                const userP = document.querySelector("#user");
                userP.textContent = location.account;
                listHtml.appendChild(userP);
                const stageP = document.querySelector("#stage");
                stageP.textContent = location.stage;
                listHtml.appendChild(stageP);
                const placingP = document.querySelector("#placing");
                placingP.textContent = location.placing;
                listHtml.appendChild(placingP);


            })
        }).catch(error => {
        console.log(error)
    })
}
document.addEventListener("DOMContentLoaded", loadLocations);