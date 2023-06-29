function createUser(){
    let form = document.querySelector('#createForm');
    let data = {
        email: form.email.value,
        password: form.password.value,
        username: form.username.value
    }
    const option = {
        method: 'POST',
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    }
    fetch("restservices/users/create", option)
        .then(function (resp){
            resp.json();
        }).then(function (result){
            console.log(result);
            window.location.href = "/index.html"
    })
}
document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#create").addEventListener("click", createUser);
});