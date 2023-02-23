pipeline {
    agent any

    stages {
         stage('Clone FrontEnd') {
            steps {
                
                echo 'Clonning...'
                
             
                sh "pwd"

                git branch: 'main', url: 'https://github.com/Chavez102/Portfolio_FrontEnd.git'
                sh "ls"
             
                
            }
        }

        stage('Build') {
            steps {
                
                echo 'Building...'
                
                dir("Portfolio_BackEnd") {
                    sh "pwd"

                    sh 'sh ./mvnw clean package -DskipTests'
                }
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..' 
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'

                sh 'docker build -t portfolio_c .'

                sh 'docker stop port_cont || true && docker rm port_cont ||true'

                sh 'docker run --name port_cont -d -p 8081:8081 portfolio_c'
 
            }
        }
    }
}
