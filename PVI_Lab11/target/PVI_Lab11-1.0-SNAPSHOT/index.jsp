<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-11</title>
</head>
<body>
<h1>PVI-11</h1>
<br/>

<h1>Task #1</h1>
<div>
        <input id="x" type="number" placeholder="Enter first number"> <br />
        <input id="y" type="number" placeholder="Enter second number"> <br />
        <input type="button" value="Sum" onclick="sum(true)"> <br /> <br />
        <input id="z" type="number" readonly="readonly">
</div>
<br /> <br />


<h1>Tasks #2-4</h1>
<div>
    <form action="sss-xml" method="POST">
        <input name="n" id="n" type="number" placeholder="Enter integer number"> <br />
        xml: <div id="xmlOutput"></div>
        json: <div id="jsonOutput"></div>
        <input type="button" value="Get using XML" onclick="getXML(this.form.n.value, true)">
        <input type="button" value="Get using JSON" onclick="getJSON(this.form.n.value, true)">
    </form>
</div>
<div>
    <div>
        <input type="button" value="Get both Sync" onclick="getSync()">
        <input type="button" value="Get both Async" onclick="getAsync()">
    </div>
</div>
<br /> <br />


<script>
    let url = "/PVI_Lab11_war_exploded/";

    function sum(async) {
        console.log(async);
        const xhr = new XMLHttpRequest();
        xhr.open("GET", url + "sss-header", async);
        xhr.setRequestHeader("value-x", document.getElementById("x").value);
        xhr.setRequestHeader("value-y", document.getElementById("y").value);
        xhr.send();
        if (async) {
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200)
                    document.getElementById("z").value = xhr.getResponseHeader("value-z");
            };
        } else
            document.getElementById("z").value = xhr.getResponseHeader("value-z");
    }

    function getXML(n, async) {
        console.log(async);
        const xhr = new XMLHttpRequest();
        xhr.open("GET", url + "sss-xml", async);
        xhr.setRequestHeader("XRand-N", n);
        xhr.send();
        if (async) {
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("xmlOutput").innerHTML = stringifyXML(xhr);
                }
            };
        } else
            document.getElementById("xmlOutput").innerHTML = stringifyXML(xhr);
    }

    function getJSON(n, async) {
        console.log(async);
        const xhr = new XMLHttpRequest();
        xhr.open("GET", url + "sss-json", async);
        xhr.setRequestHeader("XRand-N", n);
        xhr.send();
        if (async) {
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("jsonOutput").innerHTML = stringifyJSON(xhr);
                }
            };
        } else {
            document.getElementById("jsonOutput").innerHTML = stringifyJSON(xhr);
        }
    }

    function stringifyXML(req){
        const xmlDoc = req.responseXML;
        const arr = Array.from(xmlDoc.getElementsByTagName("num"));
        return arr.map(number => number.innerHTML).join(" ");
    }

    function stringifyJSON(req){
        const arr = JSON.parse(req.responseText);
        return arr.join(" ");
    }

    function getAsync() {
        sum(true);
        //sum2(document.getElementById("x2").value,document.getElementById("y2").value,document.getElementById("z2").value,true);
        getXML(document.getElementById("n").value, true);
        getJSON(document.getElementById("n").value, true);
    }

    function getSync() {
        sum(false);
        //sum2(document.getElementById("x2").value,document.getElementById("y2").value,document.getElementById("z2").value,false);
        getXML(document.getElementById("n").value, false);
        getJSON(document.getElementById("n").value, false);
    }

</script>

</body>
</html>