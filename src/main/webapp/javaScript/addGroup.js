document.addEventListener("DOMContentLoaded", loadGroupPage);

function loadGroupPage() {
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/festival", option)
        .then(response => response.json())
        .then(myJson => {
            const selector = document.querySelector("#festival");
            myJson.forEach(festival => {
                const optionElement = document.createElement('option');
                optionElement.textContent = festival.name;
                optionElement.value = festival.name;

                selector.appendChild(optionElement);
            })
        }).catch(error => {
        console.log(error)
    })


}

function search() {
    let form = document.querySelector("#groupform")
    let searchterm = {
        username: form.friend.value
    }
    const option = {
        method: 'GET',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/users/getFriend", option)
        .then(function (response) {
            if (response.ok){
                return response.json();
            }
            throw new Error("Friend not found");
        })
        .then(myJson => {
            const friendContainer = document.querySelector('#added');

            const friends = Object.values(myJson);

            friends.forEach(friend => {
                 if(friend === searchterm.username){
                    const paragraphElement = document.createElement('p');
                    paragraphElement.textContent =  friend;
                    friendContainer.appendChild(paragraphElement);
                }
            });


        })
        .catch(error => console.log(error));

}
function addGroup() {

}

document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#search").addEventListener("click", search);
});
document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#addGroup").addEventListener("click", addGroup);
});