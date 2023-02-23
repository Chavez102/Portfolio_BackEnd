pipeline {
    agent any

    tools {nodejs "nodejs"}

    stages {
         stage('Clone FrontEnd') {
            steps {
                
                echo 'Clonning...'
                
              

                git branch: 'main', url: 'https://github.com/Chavez102/Portfolio_FrontEnd.git'


                echo 'After clonning FrontEnd...'
                sh "ls" 
                dir("Portfolio") {
                    sh "pwd"
                    sh "npm --version"

                    // sh "ls"
                    // sh 'npm install'
                    sh 'npm install --timeout 300000'
                    sh "ls"

                    sh 'ng build --configuration production'
                }

                sh "pwd"
                sh "ls"

                sh 'rm -r Portfolio_BackEnd/src/main/resources/public'

                dir("Portfolio_FrontEnd/Portfolio") {
                    sh "pwd"
                    sh "ls"

                    sh 'cp -R dist/portfolio /var/lib/jenkins/workspace/BackEnd_Pipeline/Portfolio_BackEnd/Portfolio_BackEnd/src/main/resources'
                }


                dir("Portfolio_BackEnd") {
                    sh "pwd"
                    sh "ls"

                    sh 'mv Portfolio_BackEnd/src/main/resources/portfolio/ Portfolio_BackEnd/src/main/resources/public'
                }
             
                
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
