Initial implementation consists of:
* Simple java web server using Jetty that returns static content on a get request
* Maven packaging into a zip with dependencies and classpath baked into jar (using maven assembly and jar plugins)
* Docker file to create image with JDK and above code.
* k8 config to load container into k8 cluster.

Steps to do the above:
* Maven 'clean install' to generate zip
* Docker build with tag 'giraffe:latest'
* Push to local container repo:
    * docker image tag giraffe docker-vm:5000/giraffe
    * docker push docker-vm:5000/giraffe
* Install on local k8 cluster:
    * Install new deployment:
        * kubectl apply -f C:\GitHub\giraffe\poc1\k8-deployment.yaml
    * Update to new image:
        * kubectl rollout restart deployment poc1-deployment
* Forward the port from the host:
    * kubectl -n default port-forward poc1-deployment-9cc67f5cc-rlkm9 8090:8090 --address 0.0.0.0

Local k8 cluster info
* Dashboard: k8s-vm:8443
    * Portforward:
        * kubectl -n kubernetes-dashboard port-forward kubernetes-dashboard-798dd48467-bb527 8443:8443 --address 0.0.0.0
* To get dashboard token:
    * kubectl describe secret -n kube-system microk8s-dashboard-token

