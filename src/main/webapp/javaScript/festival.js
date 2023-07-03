function loadFestivals(){
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("rest/festival", option)
        .then(response => response.json())
        .then(myJson => {
            const listHtml = document.querySelector("#list");
            myJson.forEach(group => {
                const groupContainer = document.createElement('div');

                const groupNameE = document.createElement('p');
                groupNameE.textContent = group.name;
                groupContainer.appendChild(groupNameE);

                const festivalE = document.createElement('p');
                let stamp = group.date;
                stamp.forEach(time =>{
                    let date = new Date(time);
                    festivalE.textContent = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
                })
                groupContainer.appendChild(festivalE);


                const butt = document.createElement("input");
                butt.type = "button"
                butt.value = "Delete"
                butt.id = "delete"
                butt.addEventListener("click", () =>{
                    deleteFest(group.festId);
                })
                groupContainer.appendChild(butt)
                listHtml.appendChild(groupContainer);
            })
        }).catch(error => {
        console.log(error)
    })
}

document.addEventListener("DOMContentLoaded", loadFestivals);


function loadAddFestPage(){
    window.location.href = "addFestival.html";
}
function deleteFest(festId){
    const option = {
        method: 'DELETE',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch(`rest/festival/delete/${festId}`, option)
        .then(response => {
            if (response.ok){
                document.location.href = "/festival.html"
            }
        })
        .catch(error => {
            console.log(error)
        })
}

document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#logout").addEventListener("click", (ev) =>{
        window.sessionStorage.removeItem("myJWT");
        window.location.href = "/index.html";
    });
    document.querySelector("#add").addEventListener("click", loadAddFestPage);
});