function forgot(){
    let form = document.querySelector('#forgotform');
    let data = {
        email: form.email.value,
        newPassword: form.password.value,
    }
    const option = {
        method: 'POST',
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    }
    fetch("rest/users/forgot", option)
        .then(function (resp){
            resp.json();
            console.log(resp)
            window.location.href = "/index.html"
        })/*.then(function (result){
        console.log(result);

    })*/
}
document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#reset").addEventListener("click", forgot);
});