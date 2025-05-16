### 1. FROM 
  1. FROM baseimage
eg:  
  * FROM ubuntu:2.04
  * FROM nginx
  * FROM httpd

### 2. RUN
  2. RUN execute commands
eg:
  * RUN touch file1
  * RUN echo "today" > /tmp/file2
  * RUN echo "evening" > file3
  
### 3. CMD
  3. CMD 
eg: 
  * CMD ["echo","hello"]
  * CMD echo you are running on cont && echo today is sunny
  [note: Multiple CMD instructions should not be used in the same stage because only the last one will be used]

### 4.COPY
  4. COPY -copy files from local machine to container file1
eg: 
  * COPY index.html /file6 
  * COPY file3 /tmp/file2
  
### 5. ADD
  5.ADD-add tar,zip files from local machine to container machine after unzipping 
eg: 
 * ADD file5.tar.gz /tmp/file1
 * ADD file5.tar.gz /file6

### 6. WORKDIR
  6. WORKDIR - sets work directory
eg:
 * WORKDIR /root
 ![alt text](<c:\Users\Kruthika MS\Pictures\Screenshots\Screenshot 2025-05-15 114158.png>)
 * WORKDIR /tmp
   c:\Users\Kruthika MS\Pictures\Screenshots\Screenshot 2025-05-15 114448.png 
   
### 7.    