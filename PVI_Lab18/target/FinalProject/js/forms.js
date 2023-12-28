function updateForm(id) {
    var form = document.getElementById(`updForm${id}`);
    if (form.style.display === 'none') {
        form.style.display = 'block';
    } else {
        form.style.display = 'none';
    }
}

function commentForm(id) {
    var form = document.getElementById(`commentForm${id}`);
    if (form.style.display === 'none') {
        form.style.display = 'block';
    } else {
        form.style.display = 'none';
    }
}

function submitUpdForm(event, wsRefId) {
    event.preventDefault();

    var form = document.getElementById("updForm" + wsRefId);
    var formData = new FormData(form);

    var xhr = new XMLHttpRequest();
    var params = "updURL=" + encodeURIComponent(formData.get("updURL")) + "&updDescription=" + encodeURIComponent(formData.get("updDescription"));

    xhr.open("POST", form.getAttribute("action"), true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhr.onload = function () {
        if (xhr.status === 200) {
            location.reload();
        } else {
            console.error('Error: ' + xhr.status);
        }
    };

    xhr.send(params);
}