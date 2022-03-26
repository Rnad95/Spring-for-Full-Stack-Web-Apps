# Spring-for-Full-Stack-Web-Apps

## Introduction

---

We Create a relation between the table for example in this project we created relation between the songs and the album

**Notes**

- we can add a new album with considerate the value of the album  

- If the data was inserted is not match with type of the data in the database the website will be refresh without do any thing.  

- The Home page (url without route: `localhost8081/`) contains Only the **FORM** without a database if you need to see the database you have to go to `/allAlbum route`

## How To Run

---

The steps to run this code in your machine:  

1. Clone the the repo to your local machine.
2. Open the project in IntelliJ IDE
3. Then, create the configuration to the App (New Application) and Test (Junit) As the Figure below Show:
![Configuration setup](https://i.ibb.co/cJ6kNWs/Screenshot-from-2022-03-06-14-59-53.png)

4. Make sure the dependencies as Shown in figure below:
![Dependencies](https://i.ibb.co/9y3Wdzz/Screenshot-from-2022-03-26-22-40-16.png)

5. Run the project and test it in intelliJ environment  
 `OR`
Run the code in terminal:

> `renad@renad-HP-Notebook:~/Desktop/LTUCTraining/Advance/Spring-for-Full-Stack-Web-Apps/songr$` ./gradlew bootRun  

## Result

---

You have to get Result similar to the photos below:

## 1. The Test Integration inside IntelliJ

![run the Test](https://i.ibb.co/QmM8zyK/Screenshot-from-2022-03-26-22-43-23.png)

---

## 2. The output inside **website**

- We can click to the More to see the songs in album or to add the A new song

![Inside Album Page](https://i.ibb.co/y41c4Dr/Screenshot-from-2022-03-26-22-48-02.png)

---

## 3. The output of `/allSong` route in website

- We have all the songs in the website.

![all Song page](https://i.ibb.co/h2Pkrr9/Screenshot-from-2022-03-26-22-50-56.png)

---

## 4. The output of `/album/{id}/songs` route in website

- To see all song in certain album you need to click `More` in `AllAlbum` Page or reach the route above.

![Songs in album ](https://i.ibb.co/kD98tq9/Screenshot-from-2022-03-26-22-53-38.png)

### - The songs have been added inside the album using Insomnia Software
