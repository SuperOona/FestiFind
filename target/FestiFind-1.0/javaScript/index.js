function login(){
    let formData = document.querySelector("#loginform")
    let jsonBody = {
        email: formData.email.value,
        password: formData.password.value
    }

    const option = {
        method: 'POST',
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(jsonBody)
    }
    fetch("/rest/authentication", option)
        .then(function (response) {
            if (response.ok){
                return response.json();
            }
            throw new Error("Wrong email/password");
        })
        .then(myJson => {
            console.log(formData.email.value)
            window.sessionStorage.setItem("myJWT", myJson.JWT);
            if (formData.email.value === 'admin@festifind.nl'){
                window.location.href = "/festival.html"
            } else {
                window.location.href = "/locations.html"
            }

        })
        .catch(error => console.log(error));
}
document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#login").addEventListener("click", login);
});
