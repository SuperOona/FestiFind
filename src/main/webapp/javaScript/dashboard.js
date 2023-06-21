function loadList(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/dashboard", option)
        .then(response => response.json())
        .then(myJson => {
            const listHtml = document.querySelector("#list");
            /*myJson.location.forEach(location => {
                const liHtml = document.createElement("li");
                liHtml.textContent = location;
                listHtml.appendChild(liHtml);
            })*/
            myJson.forEach(location => {
                console.log(location)
                const liHtml = document.createElement("li");
                liHtml.textContent = location.stage;
                listHtml.appendChild(liHtml);
            })
    }).catch(error => {
        console.log(error)
    })
}
document.addEventListener("DOMContentLoaded", loadList);