docker stop postgres-charity

docker rm postgres-charity

docker run -d --name postgres-charity -p 10432:5432 postgres:12.0

docker start postgres-charity