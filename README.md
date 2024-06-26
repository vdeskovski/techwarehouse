# techWarehouse
DevOps Project, 213159

# Run in a Docker environment:
Navigate to the project's folder and run ```docker-compose up -d``` to orchestrate the application.
<br/>
To delete the container and its volume, run:  ```docker-compose down -v``` 

# Run in a Kubernetes environment:
Navigate to the ```k8s``` folder inside the project and run (assuming you already have a Kubernetes cluster created):    <br/>
    1. ```kubectl apply -f ns.yml``` apply the namespace <br/>
    2. ```kubectl apply -f db-statefulset.yml``` apply PostgreSQL statefulset <br/>
    3. ```kubectl apply -f app-deployment.yml``` apply the java spring boot deployment <br/>
    4. ```kubectl apply -f ingress.yml``` apply the ingress to expose the service to HTTP requests <br/>