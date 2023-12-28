CREATE DATABASE wsr;
USE wsr;
GO

CREATE TABLE WSREF
(
    id          INT IDENTITY(1,1) PRIMARY KEY,
    url         VARCHAR(70) NOT NULL,
    description VARCHAR(70) NOT NULL,
    minus       INT NOT NULL,
    plus        INT NOT NULL
);
GO

INSERT INTO WSREF(url, description, minus, plus) VALUES
('https://github.com/secxndary', 'Github Secxndary', 12, 72),
('https://www.linkedin.com/feed/', 'LinkedIn', 4, 82),
('https://www.uuidgenerator.net/', 'UUIDv4 Generator', 17, 39);
GO

SELECT * FROM WSREF;
GO

CREATE TABLE WSREFCOMMENT
(
    id			INT IDENTITY(1,1) PRIMARY KEY,
    wsref_id    INT NOT NULL,
    session_id	VARCHAR(70) DEFAULT NULL,
    stamp		DATE DEFAULT NULL,
    comtext		VARCHAR(70) DEFAULT NULL
);
GO

INSERT INTO WSREFCOMMENT(wsref_id, session_id, stamp, comtext)