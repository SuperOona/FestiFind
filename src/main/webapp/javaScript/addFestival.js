const dates = []
const stage = []
function addDate(){
    let form = document.querySelector("#festivalForm")
    let d = form.date.value

    const dateContainer = document.querySelector('#addedDates');
    const paragraphElement = document.createElement('p');
    paragraphElement.textContent =  d;
    dates.push(d)
    dateContainer.appendChild(paragraphElement);

}

function addStage(){
    let form = document.querySelector("#festivalForm")
    let s = form.stage.value

    const stageContainer = document.querySelector('#addedStage');
    const paragraphElement = document.createElement('p');
    stage.push(s)
    paragraphElement.textContent =  s;
    stageContainer.appendChild(paragraphElement);
}
function addFestival(){
    const form = document.querySelector("#festivalForm");
    const body = {
        name: form.name.value,
        dates: dates,
        stage: stage
    }
    console.log(body);
    const option = {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        },
        body: JSON.stringify(body)
    }
    fetch("/rest/festival/add", option)
        .then(response =>
            console.log(response.json()))
        .then(myJson => {
            console.log(myJson)
            window.location.href = "/festival.html"
        })
        .catch(error => {
            console.log(error);
        });

}
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("date").addEventListener("change", addDate);
    document.getElementById("stage").addEventListener("change", addStage);

    document.querySelector("#addFest").addEventListener("click", addFestival);
});