function loadLocations(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("/rest/dashboard/locations", option)
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
function loadAddLocationsPage(){
    window.location.href = "addLocations.html";
}
document.addEventListener("DOMContentLoaded", loadLocations)
document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#logout").addEventListener("click", (ev) =>{
        window.sessionStorage.removeItem("myJWT");
        window.location.href = "/index.html";
    });

    document.querySelector("#addLocation").addEventListener("click", loadAddLocationsPage);
});