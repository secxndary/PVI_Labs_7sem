function add() {
    var xhr = new XMLHttpRequest();

    var url = document.getElementById('url').value;
    var description = document.getElementById('description').value;

    xhr.open("GET", `./URL?action=add&url=${url}&description=${description}`, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                location.reload();
            } else {
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function del(id) {
    var xhr = new XMLHttpRequest();

    xhr.open("GET", `./URL?action=del&id=${id}`, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                location.reload();
            } else {
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function addLike(id) {
    var xhr = new XMLHttpRequest();

    xhr.open("GET", `./URL?action=addLike&id=${id}`, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                location.reload();
            } else {
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function addDisLike(id) {
    var xhr = new XMLHttpRequest();

    xhr.open("GET", `./URL?action=addDisLike&id=${id}`, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                location.reload();
            } else {
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function updComment(id) {
    var xhr = new XMLHttpRequest();

    var comtext = document.getElementById("comtext" + id).value;

    xhr.open("GET", `./URL?action=updComment&id=${id}&comtext=${comtext}`, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                location.reload();
            } else {
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function delComment(id) {
    var xhr = new XMLHttpRequest();

    xhr.open("GET", `./URL?action=delComment&id=${id}`, true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
                location.reload();
            } else {
                console.error('Error: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function commentAdd(event, wsRefId) {
    event.preventDefault();

    var form = document.getElementById("commentAddForm" + wsRefId);
    var formData = new FormData(form);

    var xhr = new XMLHttpRequest();

    var params = "comtext=" + encodeURIComponent(formData.get("comtextForm"));

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

function filterKey() {
    var form = document.getElementById(`filterForm`);
    if (form.style.display === 'none') {
        form.style.display = 'block';
    } else {
        form.style.display = 'none';
    }
}