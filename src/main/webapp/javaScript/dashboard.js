function loadList(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/dashboard", option)
        .then(response =>{

            return response.json()
        }).then(myJson => {

    })
}
document.addEventListener("load", loadList)


function not() {
    const lst = document.querySelector("#list")
    const item = document.createElement("")

}