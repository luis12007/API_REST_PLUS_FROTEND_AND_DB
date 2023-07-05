Comandos para iniciar con Docker

- descargar imagen de postgres
docker pull postgres

- comendo de Docker
docker run --name postgres-ticketsya -e POSTGRES_USER=ticketgod 
-e POSTGRES_PASSWORD=ticket321yA1! -e POSTGRES_DB=ticketyaDB 
-p 5432:5432 -d postgres

- ver si esta correctamente 
docker ps -a    

- comandos
parar: docker stop {name}
borrar: docker rm {name}