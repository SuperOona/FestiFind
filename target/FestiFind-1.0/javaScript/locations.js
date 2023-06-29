function loadLocations(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    const urlP = new URLSearchParams(window.location.search);
    const id = urlP.get('groupID')
    fetch(`restservices/dashboard/locations/${id}`, option)
        .then(response => response.json())
        .then(myJson => {
            const listHtml = document.querySelector("#list");
            myJson.forEach(location => {
                const container = document.createElement('div');

                const userP = document.createElement("p");
                userP.textContent = location.account;
                container.appendChild(userP);
                const stageP = document.createElement("p");
                stageP.textContent = location.stage;
                container.appendChild(stageP);
                const placingP = document.createElement("p");
                placingP.textContent = location.placing;
                container.appendChild(placingP);

                listHtml.appendChild(container);

            })
        }).catch(error => {
        console.log(error)
    })
}
document.addEventListener("DOMContentLoaded", loadLocations);