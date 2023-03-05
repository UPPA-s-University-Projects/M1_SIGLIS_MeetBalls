<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Créer un compte utilisateur</title>
    </head>

    <body>
        <h1>Créer un compte utilisateur</h1>
        <form action="createUser.jsp" method="post">
            <label for="name">Nom :</label>
            <input type="text" name="name" id="name"><br><br>
            <label for="fname">Prénom :</label>
            <input type="text" name="fname" id="fname"><br><br>
            <label for="handle">Nom d'utilisateur :</label>
            <input type="text" name="handle" id="handle"><br><br>
            <label for="age">Âge :</label>
            <input type="number" name="age" id="age"><br><br>
            <label for="gender">Genre :</label>
            <input type="radio" name="gender" id="gender" value="true"> Homme
            <input type="radio" name="gender" id="gender" value="false"> Femme<br><br>
            <label for="email">Email :</label>
            <input type="email" name="email" id="email"><br><br>
            <label for="bio">Biographie :</label>
            <textarea name="bio" id="bio"></textarea><br><br>
            <label for="loc">Emplacement :</label>
            <textarea name="loc" id="loc"></textarea><br><br>
            <label for="perimeter">Périmètre :</label>
            <input type="number" name="perimeter" id="perimeter"><br><br>
            <label for="desert">Désert :</label>
            <input type="checkbox" name="desert" id="desert" value="true"><br><br>
            <input type="submit" value="Créer un compte">
        </form>
    </body>

    </html>