function login(){
    let formData = new FormData(document.querySelector("#loginform"))
    let jsonBody = {}
    formData.forEach((value, key) => jsonBody[key] = value);
    const option = {
        method: 'POST',
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(jsonBody)
    }
    console.log(jsonBody)
    fetch("/rest/authentication", option)
        .then(function (response) {
            if (response.ok){
                return response.json();
            }
            throw new Error("Wrong email/password");
        })
        .then(myJson => {
            window.sessionStorage.setItem("myJWT", myJson.JWT);
            window.location.href = "/locations.html"
        })
        .catch(error => console.log(error));
}
document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#login").addEventListener("click", login);
});
