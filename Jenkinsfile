pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                agent{
                    master{
                        image 'maven:3-alpine'
                        args '-v $HOME/.m2:/root/.m2'
                    }
                }

               sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t=\"adrianfilip/selenium-docker\" ."
            }
        }
        stage('Start Selenium Grid'){
            steps{
                sh "docker-compose up -d hub chrome firefox"
            }
        }
        stage('Run Test'){
            steps{
                sh "docker-compose up search-module-firefox book-flight-module-chrome"
            }
        }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
// 			        bat "docker login --username=${user} --password=${pass}"
// 			        bat "docker push adrianfilip/selenium-docker:latest"
// 			    }
//             }
        }
    post{
        always{
            archiveArtifacts artifacts: 'tests-results/**'
            sh "docker-compose down"
        }
    }
}