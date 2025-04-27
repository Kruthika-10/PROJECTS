pipeline {
    agent any
    tools{
        jdk 'java-11'
        maven 'maven'
    }
    stages {
        stage ("cloning") {
            steps {
                echo "Clonning the code"
                git branch: 'main', url: 'https://github.com/Kruthika-10/Assignment.git'
            }
        }
        stage ("checkout") {
            steps {
              echo "checking the application"   
            }
        }
        stage ("Build") {
            steps {
              echo "Building the application"   
            }
        }
        stage ("Test") {
            steps {
              echo "Testing the application"   
            }
        }
        stage ("Deploy") {
            steps {
              echo "Deploying the application"   
            }
        }
    }
    post {
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed"
        }
    }
}
