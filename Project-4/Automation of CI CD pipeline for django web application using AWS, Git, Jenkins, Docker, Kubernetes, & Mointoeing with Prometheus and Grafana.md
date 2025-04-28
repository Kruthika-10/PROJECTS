### 1. Create 2 EC-2 Instances with t2.medium with pem key
 * Master node
 * Worker node
 ![alt text](<Screenshot 2025-04-28 112512.png>)

### 2. Install Git, Jenkins, Docker, Kubernetes cluster
[Install jenkins](https://phoenixnap.com/kb/install-jenkins-ubuntu)
[Install Docker](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-22-04)

 * Give permission for jenkins & docker
   * usermode -aG docker jenkins
   * sudo reboot(connect once again)
   * git clone [https://github.com/Kruthika-10/Assignment.git] (clone developer code from github)  

### 3. Open Jenkins console and add code
  ![alt text](<Screenshot 2025-04-28 115009.png>) 
  ![alt text](<Screenshot 2025-04-28 131848.png>)
  ![alt text](<Screenshot 2025-04-28 131913.png>)

### 4. Pushing the buildcode to dockerhub with the help of pipiline(secure password for crendtials)
 * Manage jenkins --> Security --> credentials -->Global -->Add credentilas   
 * Kind --> username with password, username, passwords, ID credential-->dockerHub 
  ![alt text](<Screenshot 2025-04-28 123255.png>)

 * Login to dockerhub repo
 ![alt text](<Screenshot 2025-04-28 132036.png>)
 * Check repo should be present

 ### 5. Integrate Jenkins with kubernetes
  * Setup kubernetes cluster on both master and worker node
  * [install kubernetes](https://github.com/Kruthika-10/kubernetes-v1.30.2-cluster-using-kubeadm)
  * ls -a
  * cd .kube
  * cat config (copy and paste in text file as secret.txt)
  * Downloads some plugins in jenkins
    kubernetes client api, credentials, kubernetes, kubernetes cli
  * Add kubernetes credential in jenkins
    * manage jenkins --. credentials --> global --> add credentials
    * Kind--. secret file, upload file ,ID --> kubernetes ,create
    * Copy the code(deploy kubernetes) from (github cicd pipeline repo) paste to jenkins script
    ![alt text](<Screenshot 2025-04-28 140600.png>)
    * Pipeline syntax--> with kubeconfig:config k8s cli(kubectl)
    * cred --> secret.txt
    * Generate line--> copy and paste in jenkins code remove the line after dir and paste it.
    * Build now
    ![alt text](<Screenshot 2025-04-28 141456.png>)

  * kubectl get pods
  * kubectl get service
  * public id of master:Port number of nodeport
    ![alt text](<Screenshot 2025-04-28 141912.png>)  
    ![alt text](<Screenshot 2025-04-28 141953.png>)


### 6. Install Parometheus and Grafana 
[install prometheus & Grafana](https://www.fosstechnix.com/jenkins-monitoring-with-prometheus-and-grafana/)

*![alt text](<Screenshot 2025-04-28 143537.png>)
![alt text](<Screenshot 2025-04-28 143514.png>)

* IN GRAFANA
  * Data sources--> prometeus
  * Connection--> http://107.22.106.7:9090 (prometheus localhost)
  * Let’s add Dashboard for a better view in Grafana
  * Click On Dashboard → + symbol → Import Dashboard
  * Click on Import Dashboard paste this code 1860 and click on load
   ![alt text](<Screenshot 2025-04-28 144410.png>)
   ![alt text](<Screenshot 2025-04-28 144632.png>)
   
   ![alt text](<Screenshot 2025-04-28 144818.png>)

