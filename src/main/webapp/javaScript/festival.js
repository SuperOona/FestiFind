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
                    console.log(date)
                    festivalE.textContent = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
                })

                groupContainer.appendChild(festivalE);

                const link = document.createElement('a');
                link.href = `rest/festival/delete/${group.festId}`;
                link.textContent = 'Delete festival';
                groupContainer.appendChild(link);

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

document.addEventListener("DOMContentLoaded", function() {
    // Your code here, including the event listener
    document.querySelector("#add").addEventListener("click", loadAddFestPage);
});