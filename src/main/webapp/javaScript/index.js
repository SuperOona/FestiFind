document.querySelector("#login").addEventListener("click", login)
function login(){
    let formData = new FormData(document.querySelector("#loginform"))
    let jsonBody = {}
    formData.forEach((key, value) => jsonBody[key] = value);
    fetch("/authentication", {method: "POST", body: jsonBody})
        .then(function (response) {
            if (response.ok){
                return response.json();
            }
            throw "Wrong email/password";
        })
        .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
        .catch(error => console.log(error));
}