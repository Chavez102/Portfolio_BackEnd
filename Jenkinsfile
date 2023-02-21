pipeline {
    agent any

    stages {
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
                sh 'java -jar ./Portfolio_BackEnd/target/*.jar'
            }
        }
    }
}
