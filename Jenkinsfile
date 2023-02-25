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
                // sh "if [ -d Portfolio_BackEnd ]; then rm -Rf Portfolio_BackEnd; fi"
               


                
                echo 'Before Clonning...'


                dir("Portfolio_FrontEnd") {
                    
                    git branch: 'main', url: 'https://github.com/Chavez102/Portfolio_FrontEnd.git'
                }
              


                


                echo 'After clonning FrontEnd...'
                sh "pwd" 
                sh "ls" 
                dir("Portfolio_FrontEnd/Portfolio") {
                    sh "pwd" 
                    // sh "ls"
                    // sh 'npm cache clear --force'
                    sh "pwd"
                    sh "ls"

                    nodejs('nodejs'){ 
                        sh 'npm install '
                    }
                     
                    sh "pwd"
                    sh "ls"

                    nodejs('nodejs'){
                        //  sh 'npm run build '

                        sh 'ng build --verbose --configuration production'
                    } 
                    
                }
 
                
                sh "pwd"
                sh "ls"

                sh "if [ -d Portfolio_FrontEnd/Portfolio/src/main/resources/public ]; then rm -Rf Portfolio/src/main/resources/public; fi"


               
                echo 'Copying angular App...'

                sh 'cp -R Portfolio_FrontEnd/Portfolio/dist/portfolio Portfolio_BackEnd/src/main/resources'
                


                
                sh "pwd"
                sh "ls"

                sh 'mv Portfolio_BackEnd/src/main/resources/portfolio/ Portfolio_BackEnd/src/main/resources/public'
                
             
                
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
