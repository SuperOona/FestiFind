function loadList(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/dashboard", option)
        .then(response => response.json())
        .then(myJson => {
            const listHtml = document.querySelector("#list");
/*
            myJson.
*/
    }).catch(error => {
        console.log(error)
    })
}
document.addEventListener("load", loadList)


function not() {
    const lst = document.querySelector("#list")
    const item = document.createElement("")

}