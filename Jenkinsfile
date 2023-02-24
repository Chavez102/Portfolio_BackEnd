pipeline {
    agent any

    // tools {nodejs "nodejs"}

    stages {
         stage('Clone FrontEnd') {
            steps {
                
               
                sh "pwd"
              
                sh "ls" 

            
                

                sh "if [ -d Portfolio ]; then rm -Rf Portfolio; fi"
                sh "if [ -d Portfolio@tmp ]; then rm -Rf Portfolio@tmp; fi"
                sh "if [ -d Portfolio_FrontEnd ]; then rm -Rf Portfolio_FrontEnd; fi"
               


                
                echo 'Before Clonning...'
                sh "ls" 

                git branch: 'main', url: 'https://github.com/Chavez102/Portfolio_FrontEnd.git'


                echo 'After clonning FrontEnd...'
                sh "pwd" 
                sh "ls" 
                dir("Portfolio") {
                    sh "pwd"
                    

                    // sh "ls"
                    // sh 'npm cache clear --force'

                    sh "ls"

                    nodejs('nodejs'){
                        sh 'npm install --verbose'
                    }
                    





                    sh "ls"

                    

                    // sh 'npm update --verbose'

                    nodejs('nodejs'){
                         sh 'npm run build --verbose'
                    }

                    
                    

                    // sh 'ng build --verbose --configuration production'
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
