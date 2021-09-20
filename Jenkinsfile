pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t=\"adrianfilip/selenium-docker\" ."
            }
        }
        stage('Start Selenium Grid'){
            steps{
                bat "docker-compose up -d hub chrome firefox"
            }
        }
        stage('Run Test'){
            steps{
                bat "docker-compose up search-module-firefox book-flight-module-chrome"
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
            archiveArtifacts artifacts: 'test-results/**'
            bat "docker-compose down"
        }
    }
}