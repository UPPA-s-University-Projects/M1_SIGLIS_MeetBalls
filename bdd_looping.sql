CREATE TABLE Usr(
   id INT,
   name VARCHAR(50) NOT NULL,
   fname VARCHAR(50) NOT NULL,
   handle VARCHAR(50),
   age INT NOT NULL,
   gender LOGICAL NOT NULL,
   email VARCHAR(50),
   bio VARCHAR(255),
   loc TEXT NOT NULL,
   perimeter DECIMAL(15,2) NOT NULL,
   desert LOGICAL NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Diet(
   id INT,
   designation VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Dish(
   id INT,
   name VARCHAR(50) NOT NULL,
   description VARCHAR(50),
   picture VARCHAR(50) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE SimpleMsg(
   id INT,
   msg_timestamp DATETIME NOT NULL,
   msg VARCHAR(255) NOT NULL,
   discussion INT NOT NULL,
   sender INT NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Discussion(
   id INT,
   person1 INT NOT NULL,
   person2 INT NOT NULL,
   id_1 INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_1) REFERENCES SimpleMsg(id)
);

CREATE TABLE Restaurant(
   id INT,
   name VARCHAR(50),
   address TEXT,
   PRIMARY KEY(id)
);

CREATE TABLE CookType(
   id INT,
   designation VARCHAR(255) NOT NULL,
   id_1 INT NOT NULL,
   id_2 INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_1) REFERENCES Restaurant(id),
   FOREIGN KEY(id_2) REFERENCES Dish(id)
);

CREATE TABLE LikedUsr(
   id INT,
   id_1 INT,
   idUsr VARCHAR(50) NOT NULL,
   idLikedUsr VARCHAR(50) NOT NULL,
   PRIMARY KEY(id, id_1),
   UNIQUE(idUsr),
   UNIQUE(idLikedUsr),
   FOREIGN KEY(id) REFERENCES Usr(id),
   FOREIGN KEY(id_1) REFERENCES Usr(id)
);

CREATE TABLE UsrDiet(
   id INT,
   id_1 INT,
   id_usr INT NOT NULL,
   id_regime INT NOT NULL,
   PRIMARY KEY(id, id_1),
   FOREIGN KEY(id) REFERENCES Usr(id),
   FOREIGN KEY(id_1) REFERENCES Diet(id)
);

CREATE TABLE FavDish(
   id INT,
   id_1 INT,
   id_usr INT,
   id_plat INT,
   PRIMARY KEY(id, id_1),
   FOREIGN KEY(id) REFERENCES Diet(id),
   FOREIGN KEY(id_1) REFERENCES Dish(id)
);

CREATE TABLE usrFavCookType(
   id INT,
   id_1 INT,
   id_usr INT,
   id_type INT NOT NULL,
   PRIMARY KEY(id, id_1),
   FOREIGN KEY(id) REFERENCES Usr(id),
   FOREIGN KEY(id_1) REFERENCES CookType(id)
);

CREATE TABLE MatchedUsr(
   id INT,
   id_1 INT,
   id_usr INT NOT NULL,
   id_matched_usr INT NOT NULL,
   PRIMARY KEY(id, id_1),
   FOREIGN KEY(id) REFERENCES Usr(id),
   FOREIGN KEY(id_1) REFERENCES Usr(id)
);

CREATE TABLE Participant(
   id INT,
   id_1 INT,
   PRIMARY KEY(id, id_1),
   FOREIGN KEY(id) REFERENCES Usr(id),
   FOREIGN KEY(id_1) REFERENCES Discussion(id)
);

CREATE TABLE RestaurantsDishes(
   id INT,
   id_1 INT,
   PRIMARY KEY(id, id_1),
   FOREIGN KEY(id) REFERENCES Dish(id),
   FOREIGN KEY(id_1) REFERENCES Restaurant(id)
);
