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

document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#addFriends").addEventListener("click", search);

    document.querySelector("#addGroup").addEventListener("click", addGroup);
});

function search() {
    fetch()

}
function addGroup() {

}