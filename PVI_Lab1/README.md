# Как создать и задеплоить в Tomcat WAR-архив
1. В верхней панели: `File -> Project Structure -> Artifacts`
2. Добавить в артефакты `Web Application: Archive -> For "PVI_Lab1: war exploded"`
3. В верхней панели: `Build -> Build artifacts`
4. В папке target появится файл `PVI_Lab1-1.0-SNAPSHOT.war`
5. Переименовать war-архив в `AS_XXXX` (цифра по варианту)
6. Скопировать архив в папку `Tomcat 10.0\webapps` (скорее всего, лежит в C:\Program Files\Apache Software Foundation)
7. Запустить скрипт `Tomcat 10.0\bin\startup.bat` (убедитесь, что порт для Tomcat не занят, например, работающим приложением в IntelliJ IDEA, по умолчанию порт 8080 или 8081)
8. В папке webapps появится папка `AS_XXXX`, туда деплоится приложение
9. Задеплоинный war-архив доступен по адресу http://localhost:8081/AS_XXXX