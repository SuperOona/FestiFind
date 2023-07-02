
function loadPage() {
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("rest/festival", option)
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

function loadStages() {
    const selectedFestival = document.querySelector("#festival").value;

    // Make a request to get the stages based on the selected festival
    const option = {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    };

    fetch("rest/festival/" + selectedFestival, option)
        .then(response => response.json())
        .then(myJson => {
            const selector = document.querySelector("#stage");
            myJson.forEach(stage => {
                console.log(stage)
                const optionElement = document.createElement('option');
                optionElement.textContent = stage.stageName;
                optionElement.value = stage.stageName;

                selector.appendChild(optionElement);
            })
        })
        .catch(error => {
            console.log(error);
        });
}

function addLocation() {
    const form = document.querySelector("#locationform");
    const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    checkboxes.forEach(function(checkbox) {
        selectedGroups.push(checkbox.value);
    });

    const body = {
        stage: form.stage.value,
        placing: form.placing.value,
    }
    const option = {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        },
        body: JSON.stringify(body)
    }

}

document.addEventListener("DOMContentLoaded", function() {
    loadPage();
    document.getElementById("festival").addEventListener("change", loadStages);
    document.querySelector("#addLocation").addEventListener("click", addLocation);
});

