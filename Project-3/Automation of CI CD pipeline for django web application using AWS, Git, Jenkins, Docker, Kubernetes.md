### 1. Create 3 EC-2 Instances with t2.medium instance size
* Master node
* Slave node-1
* Slave node-2
![alt text](<Screenshot 2025-04-27 193831.png>)
* Connect to terminal with root user

### 2. Install jenkins on master node
[Install jenkins link](https://phoenixnap.com/kb/install-jenkins-ubuntu)

### 3. Establish the connection between master and slaves
[MASTER NODE]
 * ls -a
 * cd .ssh/
 * ls
 * ssh-keygen  (type) (enter 5 times)
 * ls
 * cat id_rsa.pub (COPY)

 [SLAVE NODE]
 * ls -a
 * cd .ssh/
 * vi authorized_keys
 * (Press O goes to new line and paste here) save

 # Check the connection established
 
 * ssh root@<public ip of slave>
 * yes

### 4. Open Jenkins of master node
 * <public ip of master node>:8080
 * login to jenkins console
 * Manage jenkins --> Nodes --> New Node --> Node name --> Type - Permanent agent --> Create
   ![alt text](<Screenshot 2025-04-27 200729.png>)
 * Name --> Node-1
 * Number of executors --> 1 (Paralel jobs execute(acts as multi threading tasks))
 * Remote root directory --> (paste) [/root/jenkins]
   (want 1 directory in slave node where every jenkins related stuff should load here)
   * Install java-17  (slave node)
   * Create directory (mkdir <name>)
   * realpath jenkins/  (copy)
   * Labels -->Production
   * Usage --> use this as much as possible  [change after 1 build]
   * Launch Method --> Launch agents via SSH
   * Host --> slave public ip
   * Credentials -->
     * Add --> [Domain --> global credentials, kind --> username with private key, Scope-->global, ID,desc--> Prod1, username-->root(root user), Private key-->Paste (cat id_rsa in master) ,Host Key Verification Strategy--> non verfiying verification statregy, Availability-->keep this agent online as much as possible ] 
     ![alt text](<Screenshot 2025-04-27 211309.png>)
     ![alt text](<Screenshot 2025-04-27 211326.png>)

     * Go inside node -->log (agent successfull connection)
       ![alt text](<Screenshot 2025-04-27 211614.png>)

### 5. Trigger job 

 * Jenkins--> new item ,Name--> job1 , item style --> free style
       ![alt text](<Screenshot 2025-04-27 212148.png>)
 * Restrict where this project can be run (tick this)
 * Label Expression --> Production
 * Build Steps --> Execute shell 
   " #!/bin/bash
     echo "This is production server"
     hostname
     hostname -I "    
 * Save
 * Build now
   ![alt text](<Screenshot 2025-04-27 213100.png>) 
   ![alt text](<Screenshot 2025-04-27 220617.png>)
   ![alt text](<Screenshot 2025-04-27 222012.png>)
   





