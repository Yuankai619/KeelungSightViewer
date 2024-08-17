
# Keelung sithgt viewer

A responsive website about the Keelung city famous tourist spot.

Use a web crawler to scrape [TravelKing](https://www.travelking.com.tw/tourguide/taiwan/keelungcity/) as a source of content.

## Demo

https://keelung-sight-viewer.yuankai.org/



## Tech Stack

**Client :** `Html` `TailwindCSS` `javascript`

**Server :** `Java` `Spring boot` `Jsoup`

**Database :** `MonogoDB(Atlas)`

**Deploy :** `Docker`
## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`DB_PASSWORD` : the database password in Atlas

`DB_NAME` : the database name in Atlas

`PORT` : the port to run


## Run Locally

Clone the project

```bash
  git clone https://github.com/Yuankai619/KeelungSightViewer.git
```

Go to the project directory

```bash
  cd KeelungSightViewer
```

Install backend dependencies

```bash
  gradle clean build
```

Install frontend pakage

```bash
  cd src/main/frontend
  npm install
  npm run build watch
```




## Run on Docker

**To run this project with docker, you can pull my docker image from docker hub**

Docker Pull Command

```bash
  docker pull yuankai619/keelungsightviewer
```

Run with docker container

```bash
  docker container run -d -p:8080:8080 -e DB_PASSWORD={your_password} DB_NAME={your_name} PORT=8080 --name {your container name}
```


## Deployment

To deploy this project on [KEROKU](https://www.heroku.com/), I use Github Action and convient tool : https://github.com/AkhileshNS/heroku-deploy



## API Reference

#### Get sights by zone

```http
  GET /SightAPI?{zone}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `zone` | `string` | **Required**. the zone about sights |

#### Get sights by category

```http
  GET /SightCategoryAPI?{category}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `category`      | `string` | **Required**. the category about sights |

#### Insert one default Sight in Database

```http
  POST /InsertTestSight
```

#### clear all default Sight in Database

```http
  Delete /ClearTestSight
```
