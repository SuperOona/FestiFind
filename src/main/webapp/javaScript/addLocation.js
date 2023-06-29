function loadGroups() {
    const option = {
        method: 'GET',
        headers:{
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        }
    }
    fetch("restservices/dashboard", option)
        .then(response => response.json())
        .then(myJson => {
            const listHtml = document.querySelector("#groups");
            myJson.forEach(group => {
                const groupContainer = document.createElement('div');
                groupContainer.id = "container";

                const inputElement = document.createElement('input');
                inputElement.type = "checkbox";
                inputElement.id = "groupName"
                inputElement.value = group.groupName
                groupContainer.appendChild(inputElement);

                const labelElement = document.createElement('label');
                labelElement.htmlFor = "groupName"
                labelElement.textContent = group.groupName;
                groupContainer.appendChild(labelElement);

                listHtml.appendChild(groupContainer);
            })
        }).catch(error => {
        console.log(error)
    })

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
        groups: JSON.stringify(selectedGroups)
    }
    const option = {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
        },
        body: JSON.stringify(body)
    }

    fetch("/re")


}
document.addEventListener("DOMContentLoaded", function() {
    loadGroups()
    document.querySelector("#search").addEventListener("click", addLocation);
});