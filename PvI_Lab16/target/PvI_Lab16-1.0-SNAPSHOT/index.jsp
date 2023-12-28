<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-16</title>
</head>
<body>
<h1>PVI-16</h1>
<br/>

<button onclick="connect()">START</button>
<button onclick="disconnect();">STOP</button>
<div id="outdiv"></div>
</body>

<script type="text/javascript">
    let ws = null;

    function connect() {
        ws = new WebSocket("ws://127.0.0.1:8081/PvI_Lab16_war_exploded//websockets");

        ws.onmessage = function (event) {
            document.getElementById('outdiv').innerHTML += event.data + "<br/>";
        };
    }

    function disconnect(){
        ws.close();
    }
</script>

</html>