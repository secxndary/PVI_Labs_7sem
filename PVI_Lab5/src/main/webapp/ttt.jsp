<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="smw" uri="/WEB-INF/descriptor.tld" %>
<html>
<head>
    <title>Ttt</title>
</head>
<body>

    <smw:dossier action="ttt-servlet">
        <label>Surname</label> <br />
        <smw:surname /> <br />
        <label>Lastname</label> <br />
        <smw:lastname /> <br />
        <smw:sex value="M" />
        <smw:sex value="F" /> <br /> <br />
        <smw:submit />
    </smw:dossier>

</body>
</html>
